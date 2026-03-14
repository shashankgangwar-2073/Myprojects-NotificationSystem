package com.example.NotificationSystem.Queue;

import com.example.NotificationSystem.model.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationQueueFactory {

    private static final Map<Channel, NotificationQueue> map = new ConcurrentHashMap<>();

    static {
        for(Channel channel : Channel.values()){
            map.put(channel, new NotificationQueueImpl());
        }
    }

    public static NotificationQueue getNotificationQueueInstance(Channel channel){
        return map.get(channel);
    }
}
