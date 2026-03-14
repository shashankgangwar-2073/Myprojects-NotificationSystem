package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.Queue.NotificationQueue;
import com.example.NotificationSystem.model.Event;

public class EmailWorker implements Worker, Runnable{

    private NotificationQueue emailQueue;

    public EmailWorker(NotificationQueue queue){
        emailQueue = queue;
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try{
                Event event = emailQueue.getEvent();
                processEvent(event);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    @Override
    public void processEvent(Event e){
        System.out.println("Processing email event "+ e.getEventId()+"  uid: "+e.getUid());
    }
}
