package com.example.NotificationSystem.model;

import java.util.UUID;

public class NotificationData {
    String uid;
    Channel channel;
    NotificationType type;

    public NotificationData(String uid, Channel channel, NotificationType type){
        this.uid = uid;
        this.channel = channel;
        this.type = type;
    }

    public String getUid(){
        return uid;
    }

    public Channel getChannel(){
        return channel;
    }

    public NotificationType getType(){
        return type;
    }
}
