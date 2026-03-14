package com.example;

import com.example.NotificationSystem.NotificationController;
import com.example.NotificationSystem.Queue.NotificationQueueFactory;
import com.example.NotificationSystem.model.Channel;
import com.example.NotificationSystem.model.NotificationData;
import com.example.NotificationSystem.model.NotificationType;
import com.example.NotificationSystem.worker.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //Main function for notification system
    static void main() {

        WorkerManager manager = new WorkerManager();
        manager.startWorkers();

        NotificationData data1 = new NotificationData("uid1", Channel.SMS, NotificationType.ALERT);
        NotificationData data2 = new NotificationData("uid2", Channel.PUSH, NotificationType.ALERT);
        NotificationData data3 = new NotificationData("uid3", Channel.EMAIL, NotificationType.TRANSACTION);
        NotificationData data4 = new NotificationData("uid4", Channel.EMAIL, NotificationType.TRANSACTION);
        NotificationData data5 = new NotificationData("uid5", Channel.SMS, NotificationType.ALERT);
        NotificationData data6 = new NotificationData("uid6", Channel.EMAIL, NotificationType.PROMOTION);
        NotificationData data7 = new NotificationData("uid7", Channel.PUSH, NotificationType.PROMOTION);

        NotificationController controller = new NotificationController();

        controller.processNotification(data1);
        controller.processNotification(data2);
        controller.processNotification(data3);
        controller.processNotification(data4);
        controller.processNotification(data5);
        controller.processNotification(data6);
        controller.processNotification(data7);

    }
}
