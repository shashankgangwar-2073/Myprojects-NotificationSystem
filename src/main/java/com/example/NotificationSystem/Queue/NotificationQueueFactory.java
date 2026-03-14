package com.example.NotificationSystem.Queue;

import com.example.NotificationSystem.model.Channel;

import java.util.HashMap;
import java.util.Map;

public class NotificationQueueFactory {

    private static Map<Channel, NotificationQueue> map = new HashMap<>();

    static {
        map.put(Channel.SMS, SmsQueue.getInstance());
        map.put(Channel.PUSH, PushQueue.getInstance());
        map.put(Channel.EMAIL, EmailQueue.getInstance());
    }

    public static NotificationQueue getNotificationQueueInstance(Channel channel){
        return map.get(channel);
    }
}
