package com.example.NotificationSystem.worker;

import com.example.NotificationSystem.Queue.NotificationQueue;
import com.example.NotificationSystem.model.Event;

public class Worker implements Runnable {

    private NotificationQueue queue;
    private Processor processor;

    public Worker(NotificationQueue queue, Processor processor) {
        this.queue = queue;
        this.processor = processor;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Event event = queue.getEvent();
                processor.processEvent(event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
