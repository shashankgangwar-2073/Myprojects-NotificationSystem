# Notification System

A highly scalable and extensible Java-based notification system designed to process and dispatch notifications across multiple channels asynchronously.

## Architecture Overview

The system uses a producer-consumer architecture, decoupled via queues. 

### Key Components:

1. **Controller (`NotificationController`)**
   The main entry point for incoming notifications. It receives `NotificationData`, converts it into an internal `Event` representation, and delegates it to the appropriate queue based on the notification channel.

2. **Models (`model` package)**
   - `NotificationData`: The data transfer object containing notification details.
   - `Event`: Internal representation of a notification event, containing a unique `eventId`, `uid`, `channel`, and `type`.
   - `Channel`: Defines the delivery medium (e.g., SMS, Email, Push).
   - `NotificationType`: Classifies the type of notification.

3. **Queue System (`Queue` package)**
   - `NotificationQueue`: An interface defining standard queue operations.
   - `NotificationQueueImpl`: The concrete implementation of the queue.
   - `NotificationQueueFactory`: A factory pattern to provision and retrieve the correct queue instance based on the `Channel`.

4. **Workers and Processors (`worker` package)**
   - `Worker`: A `Runnable` consumer that continuously polls a specific `NotificationQueue` for new `Event`s and passes them to a designated processor.
   - `Processor`: An interface for processing and sending events.
   - `SmsProcessor`, `EmailProcessor`, `PushProcessor`: Concrete implementations tailored to dispatching events to their respective channels.
   - `ProcessorFactory`: Supplies the right processor implementation.
   - `WorkerManager`: Manages the lifecycle and thread pools for the worker instances.

## How It Works

1. A client submits `NotificationData` to the `NotificationController`.
2. The controller constructs an `Event` object from the request.
3. The controller asks the `NotificationQueueFactory` for the queue associated with the requested `Channel` (e.g., Email).
4. The `Event` is placed onto the corresponding `NotificationQueue`.
5. Background `Worker` threads continuously poll their assigned queues.
6. When a `Worker` picks up an `Event`, it delegates the actual delivery to the corresponding `Processor` (e.g., `EmailProcessor`).

## Extensibility

This system is designed with the Open/Closed Principle in mind. To add a new notification channel (e.g., Slack, WhatsApp):
- Add the new channel to the `Channel` enum.
- Implement a new `Processor` (e.g., `SlackProcessor`).
- Update the `NotificationQueueFactory` and `ProcessorFactory` to support the new channel.
- The `WorkerManager` can easily be configured to spin up workers for the new queue.