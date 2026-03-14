package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.model.Event;

public interface Worker {
    void processEvent(Event e);
    void run();
}
