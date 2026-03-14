package com.example.NotificationSystem.Queue;

import com.example.NotificationSystem.model.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PushQueue implements NotificationQueue {

    private static final PushQueue INSTANCE = new PushQueue();
    private BlockingQueue<Event> pushNotifQueue;

    private PushQueue(){
        pushNotifQueue = new LinkedBlockingQueue<>();
    }

    public static PushQueue getInstance(){
        return INSTANCE;
    }

    @Override
    public void addEvent(Event e){
        pushNotifQueue.offer(e);
    }

    @Override
    public Event getEvent() throws Exception{
        return pushNotifQueue.take();
    }
}
