package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.model.Event;

public class SmsProcessor implements Processor {

    @Override
    public void processEvent(Event e){
        System.out.println("Processing sms event "+ e.getEventId()+"  uid: "+e.getUid());
    }
}
