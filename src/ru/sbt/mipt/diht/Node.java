package ru.sbt.mipt.diht;

import ru.sbt.mipt.diht.Logic.MessageUtils;
import ru.sbt.mipt.diht.Logic.QueueBroker;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Node implements Runnable{
    private PrintWriter out;
    private QueueBroker inputMessage;
    public MessageUtils messageUtils;

    public Node() throws IOException {
            out = new PrintWriter(new FileWriter("/Users/a18397781/IdeaProjects/Home_work3/ff.txt"));
            inputMessage = new QueueBroker();
            messageUtils = new MessageUtils(inputMessage);
    }
    public void run() {
        while (true) {
            messageUtils.readIncomeMessage(out);
        }
    }

}
