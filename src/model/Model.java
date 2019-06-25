package model;

import event.Event;

import java.util.ArrayList;

public class Model {

    private ArrayList<Event> events;

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<Boolean> getData(){
        ArrayList<Boolean> data = new ArrayList<>();
        for(Event b: events){
            data.add(b.getStatus());
        }
        return data;
    }

}
