package event;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Event {

    protected long timeStart;
    protected long timeStop;
    protected long currentTime;
    protected long maxTime;
    protected boolean status;
    protected Timer timer;
    protected TimerTask timerTask;

    public Event(long tst, long tsp){
        timeStart = tst;
        timeStop = tsp;
        currentTime = 0;
        maxTime = timeStart;
    }

    public abstract void restart();
    public abstract void stop();
    public abstract boolean ready();

    public boolean getStatus(){return status;}

    public void changeMode(){
        currentTime = 0;
        if(!status){
            maxTime = timeStart;
        }else{
            maxTime = timeStop;
        }
    }


}
