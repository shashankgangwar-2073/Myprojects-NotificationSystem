package com.example.NotificationSystem.Queue;

import com.example.NotificationSystem.model.Event;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EmailQueue implements NotificationQueue {

    private BlockingQueue<Event> emailNotifQueue;
    private static final EmailQueue INSTANCE = new EmailQueue();

    private EmailQueue(){
        emailNotifQueue = new LinkedBlockingQueue<>();
    }

    public static EmailQueue getInstance(){
        return INSTANCE;
    }

    @Override
    public void addEvent(Event event){
        emailNotifQueue.offer(event);
    }

    @Override
    public Event getEvent() throws Exception {
        return emailNotifQueue.take();
    }
}
