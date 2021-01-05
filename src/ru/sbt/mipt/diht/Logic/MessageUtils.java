package ru.sbt.mipt.diht.Logic;

import ru.sbt.mipt.diht.Node;

import java.io.PrintWriter;

public class MessageUtils {
    private QueueBroker inputMessage;
    private Node nextNode;
    private long firstVisitTime = 0;

    public void sendMessage(Message message) {
        inputMessage.putMsg(message);
    }

    public void setConnection(Node next) {
        nextNode = next;
    }

    public void readIncomeMessage(PrintWriter out) {
        Message message = inputMessage.getMsg();

        if (message != null) {
            if (message.destination == 0) {
                if (firstVisitTime == 0) {
                    firstVisitTime = System.nanoTime();
                } else {
                    out.println("Noda: " + Thread.currentThread().getId() + " Full Circle Latency: " + (System.nanoTime() - firstVisitTime) + " ns. ");
                    firstVisitTime = System.nanoTime();
                }
            }

            if (message.destination == Thread.currentThread().getId()) {
                System.out.println("Message recieved: " + message.destination + " with text: " + message.messageBody);
            } else {
                sendMessage(message);
            }
        } else return;
    }

    public MessageUtils(QueueBroker inputMessage) {
        this.inputMessage = inputMessage;
    }
}
