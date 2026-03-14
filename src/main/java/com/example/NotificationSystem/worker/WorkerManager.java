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

        for(Channel channel : Channel.values()){
            Worker worker = new Worker(
                    NotificationQueueFactory.getNotificationQueueInstance(channel),
                    ProcessorFactory.getProcessor(channel)
            );

            executorService.submit((Runnable) worker);
        }
    }
}
