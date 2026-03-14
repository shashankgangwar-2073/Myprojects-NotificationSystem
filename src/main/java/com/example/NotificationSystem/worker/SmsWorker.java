package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.Queue.NotificationQueue;
import com.example.NotificationSystem.model.Event;

public class SmsWorker implements Worker, Runnable{

    private NotificationQueue smsQueue;

    public SmsWorker(NotificationQueue queue){
        smsQueue = queue;
    }

    @Override
    public void run(){

        while(!Thread.currentThread().isInterrupted()){
            try{
                Event event = smsQueue.getEvent();
                processEvent(event);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void processEvent(Event e){
        System.out.println("Processing sms event "+ e.getEventId()+"  uid: "+e.getUid());
    }
}
