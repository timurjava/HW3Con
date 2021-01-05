package ru.sbt.mipt.diht.Logic;



public class Message {
    public String messageBody;
    public long destination;
    public Message(long destinationId) {
        destination = destinationId;
    }



}
