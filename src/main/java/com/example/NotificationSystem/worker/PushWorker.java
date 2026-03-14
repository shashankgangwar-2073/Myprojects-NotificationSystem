package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.Queue.NotificationQueue;
import com.example.NotificationSystem.model.Event;

public class PushWorker implements Worker, Runnable {
    private NotificationQueue pushQueue;

    public PushWorker(NotificationQueue queue){
        pushQueue = queue;
    }

    public void run(){

        while(!Thread.currentThread().isInterrupted()){
            try{
                Event event = pushQueue.getEvent();
                processEvent(event);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void processEvent(Event e){
        System.out.println("Processing push event "+ e.getEventId()+"  uid: "+e.getUid());
    }

}
