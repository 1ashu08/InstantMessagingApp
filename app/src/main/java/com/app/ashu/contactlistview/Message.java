package com.app.ashu.contactlistview;

public class Message {

    String message;
    String messageType;

    final static String TYPE_SENT="MESSAGE_SENT";
    final static String TYPE_RECEIVED="MESSAGE_RECEIVED";

    public Message(String message,String messageType)
    {
        this.message=message;
        this.messageType=messageType;
    }
    public Message(String message)
    {
        this.message=message;
        this.messageType=TYPE_SENT;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
