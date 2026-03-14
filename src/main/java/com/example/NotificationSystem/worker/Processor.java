package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.model.Event;

public interface Processor {
    void processEvent(Event e);
}
