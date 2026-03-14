package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.model.Event;

public class PushProcessor implements Processor {

    @Override
    public void processEvent(Event e){
        System.out.println("Processing push event "+ e.getEventId()+"  uid: "+e.getUid());
    }

}
