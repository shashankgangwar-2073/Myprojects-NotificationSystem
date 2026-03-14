package com.example.NotificationSystem.Queue;

import com.example.NotificationSystem.model.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NotificationQueueImpl implements NotificationQueue {

    private BlockingQueue<Event> notifQueue;

    public NotificationQueueImpl(){
        notifQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void addEvent(Event event){
        notifQueue.offer(event);
    }

    @Override
    public Event getEvent() throws Exception {
        return notifQueue.take();
    }
}
