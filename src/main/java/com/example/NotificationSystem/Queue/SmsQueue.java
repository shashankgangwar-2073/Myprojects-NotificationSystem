package com.example.NotificationSystem.Queue;

import com.example.NotificationSystem.model.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SmsQueue implements NotificationQueue {
    private static final SmsQueue INSTANCE = new SmsQueue();
    private BlockingQueue<Event> smsNotifQueue;

    private SmsQueue(){
        smsNotifQueue = new LinkedBlockingQueue<>();
    }

    public static SmsQueue getInstance(){
        return INSTANCE;
    }

    @Override
    public void addEvent(Event e){
        smsNotifQueue.offer(e);
    }

    @Override
    public Event getEvent() throws Exception{
        return smsNotifQueue.take();
    }
}
