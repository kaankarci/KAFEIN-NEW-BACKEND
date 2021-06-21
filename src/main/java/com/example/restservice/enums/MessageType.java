package com.example.restservice.enums;

public enum  MessageType {
    SUCCESS("İşlem başarılı!"),
    ERROR("İşlem başarısız");

    private String messageText;

    MessageType(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }
}
