package com.example.sayhello.model;

public class online {

    public String topic_name;
    public String schedule;
    public String class_link;
    public String topic_description;


    public online(String topic_name, String topic_description, String schedule, String class_link) {
        this.topic_name = topic_name;
        this.topic_description = topic_description;
        this.schedule = schedule;
        this.class_link = class_link;
    }

    public online() {
        topic_name="";
        topic_description="";
        schedule="";
        class_link="";
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getTopic_description() {
        return topic_description;
    }

    public void setTopic_description(String topic_description) {
        this.topic_description = topic_description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getClass_link() {
        return class_link;
    }

    public void setClass_link(String class_link) {
        this.class_link = class_link;
    }
}
