package com.example.sayhello.model;

public class message {
    public String message;
    public String sender_img;


    public message(String sender_img, String message) {
        this.message = message;
        this.sender_img = sender_img;
    }

    public message() {
        message = "";
        sender_img = "";
    }

    public String getMessage() {
        return message;
    }

    public String getSender_img() {
        return sender_img;
    }

}
