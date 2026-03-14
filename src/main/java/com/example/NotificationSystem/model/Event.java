package com.example.NotificationSystem.model;

import java.util.UUID;

public class Event {
    UUID eventId;
    String uid;
    Channel channel;
    NotificationType type;

    public Event(String uid, Channel channel, NotificationType type){
        this.eventId = UUID.randomUUID();
        this.uid = uid;
        this.channel = channel;
        this.type = type;
    }

    public UUID getEventId(){
        return eventId;
    }

    public String getUid(){
        return uid;
    }
}
