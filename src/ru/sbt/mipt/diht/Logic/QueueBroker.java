package ru.sbt.mipt.diht.Logic;

import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueBroker {
    private ConcurrentLinkedQueue<Message> queueBuffer;

    public QueueBroker() {
        queueBuffer = new ConcurrentLinkedQueue<>();
    }

    public void putMsg(Message input) {
        queueBuffer.add(input);
    }

    public Message getMsg() {
        return queueBuffer.poll();
    }

    public void sendMessage(Message message, QueueBroker inputMessage) {
        inputMessage.putMsg(message);
    }
}
