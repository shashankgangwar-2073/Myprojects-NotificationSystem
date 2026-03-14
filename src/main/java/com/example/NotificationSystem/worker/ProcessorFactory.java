package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.model.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProcessorFactory {

    private static final Map<Channel, Processor> map = new ConcurrentHashMap<>();

    static {
        map.put(Channel.EMAIL, new EmailProcessor());
        map.put(Channel.SMS, new SmsProcessor());
        map.put(Channel.PUSH, new PushProcessor());
    }

    public static Processor getProcessor(Channel channel) {
        return map.get(channel);
    }

}
