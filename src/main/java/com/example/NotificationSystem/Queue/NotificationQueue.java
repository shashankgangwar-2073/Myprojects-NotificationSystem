package com.example.NotificationSystem.Queue;

import com.example.NotificationSystem.model.Event;

public interface NotificationQueue {
    void addEvent(Event event);
    Event getEvent() throws Exception;
}
