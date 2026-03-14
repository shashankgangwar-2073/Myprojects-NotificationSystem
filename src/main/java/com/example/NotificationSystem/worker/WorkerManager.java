package com.example.NotificationSystem.worker;


import com.example.NotificationSystem.Queue.NotificationQueueFactory;
import com.example.NotificationSystem.model.Channel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerManager {
    private ExecutorService executorService;

    public WorkerManager(){
        executorService = Executors.newFixedThreadPool(3);
    }

    public void startWorkers(){
        Worker emailWorker = new EmailWorker(NotificationQueueFactory.getNotificationQueueInstance(Channel.EMAIL));

        Worker smsWorker = new SmsWorker(NotificationQueueFactory.getNotificationQueueInstance(Channel.SMS));

        Worker pushWorker = new PushWorker(NotificationQueueFactory.getNotificationQueueInstance(Channel.PUSH));

        executorService.submit((Runnable) emailWorker);
        executorService.submit((Runnable) smsWorker);
        executorService.submit((Runnable) pushWorker);
    }
}
