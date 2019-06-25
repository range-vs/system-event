package sample;

import event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.WindowEvent;
import model.Model;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Controller extends View {

    private AtomicReference<Boolean> stop;
    private Model model;

    @FXML
    public void initialize(){
        model = new Model();
    }

    public void startWork() {
        stop = new AtomicReference<>(true);
        Thread thread = new Thread(() -> {
            try {
                EventController eventController = new EventController(model.getEvents());
                eventController.start();
                while (stop.get()) {
                    eventController.step();
                    changeStatus(model.getData());
                    Thread.sleep(1000);
                }
                eventController.clearEvents();
                System.out.println("Поток остановлен");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Поток остановлен аварийно");
            }
        });
        thread.start();
    }


    public void systemStop(ActionEvent actionEvent) {
        stop.set(false);
    }

    public void runA(ActionEvent actionEvent) {
        start(new ArrayList<>(
                Arrays.asList(
                        new EventThermostat(10000, 5000),
                        new EventLight(2000, 4000),
                        new EventWater(6000, 8000))
        ));
    }

    public void runB(ActionEvent actionEvent) {
        start(new ArrayList<>(
                Arrays.asList(
                        new EventThermostat(15000, 7000),
                        new EventLight(3000, 6000),
                        new EventWater(9000, 12000))
        ));
    }

    public void start(ArrayList<Event> ev){
        changeStatus();
        model.setEvents(ev);
        startWork();
    }


    public EventHandler<WindowEvent> getCloseEventHandler(){
        return event -> stop.set(false);
    }
}
