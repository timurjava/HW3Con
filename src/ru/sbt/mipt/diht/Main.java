package ru.sbt.mipt.diht;

import ru.sbt.mipt.diht.Logic.Message;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static void tokenSetConnection(Node[] tokens){
        for (int i = 0; i < tokens.length; i++) {
            if (i + 1 != tokens.length ) {
                tokens[i].messageUtils.setConnection(tokens[i + 1]);
            } else {
                tokens[i].messageUtils.setConnection(tokens[0]);
            }
        }
    }

    private static void messageSender(Message[] messages, ru.sbt.mipt.diht.Node[] tokens){
        for(int i = 1; i < messages.length; i++) {
            messages[i] = new Message(14 + i);
            messages[i].messageBody = "messageBody: " + i;
            tokens[0].messageUtils.sendMessage(messages[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        int tokenNumber = Integer.parseInt(args[0]);
        int countOfMessages = Integer.parseInt(args[1]);

        ru.sbt.mipt.diht.Node[] tokens = new Node[tokenNumber];
        Arrays.fill(tokens, new Node());
        tokenSetConnection(tokens);

        Message[] messages = new Message[countOfMessages];
        messages[0] = new Message(0);
        tokens[0].messageUtils.sendMessage(messages[0]);
        messageSender(messages, tokens);

        for (Node nd: tokens) {
            Thread t = new Thread(nd);
            t.start();
        }
    }
}

