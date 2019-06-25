package event;

import java.util.ArrayList;
public class EventController {

    private ArrayList<Event> events;

    public EventController(ArrayList<Event> e){
        events = e;
    }

    public EventController(){
        events = new ArrayList<>();
    }

    public void addEvent(Event e){
        events.add(e);
    }

    public void clearEvents(){
        for(Event e: events){
            e.stop();
        }
        events.clear();
    }

    public void start(){
        for(int i = 0;i<events.size();i++){
            events.get(i).restart();
            System.out.println(events.get(i).toString());
        }
    }

    public void step(){
        for(int i = 0;i<events.size();i++) {
            Event e = events.get(i);
            if (e.ready()) {
                e.changeMode();
                e.restart();
                System.out.println(e.toString());
            }
        }
    }

}
