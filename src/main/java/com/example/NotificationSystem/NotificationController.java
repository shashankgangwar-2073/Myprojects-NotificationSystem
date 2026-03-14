package com.example.NotificationSystem;

import com.example.NotificationSystem.Queue.NotificationQueue;
import com.example.NotificationSystem.Queue.NotificationQueueFactory;
import com.example.NotificationSystem.model.Event;
import com.example.NotificationSystem.model.NotificationData;

public class NotificationController {

    public void processNotification(NotificationData notificationData){

        Event event = new Event(notificationData.getUid(), notificationData.getChannel(), notificationData.getType());

        NotificationQueue queue = NotificationQueueFactory.getNotificationQueueInstance(notificationData.getChannel());

        queue.addEvent(event);

    }
}