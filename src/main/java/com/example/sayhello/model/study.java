package com.example.sayhello.model;

public class study {

    public String topic_no;
    public String topic_name;
    public String type;
    public String study_link;
    public String topic_description;

    public study(String topic_no, String topic_name, String study_link, String type, String topic_description) {
        this.topic_no = topic_no;
        this.topic_name = topic_name;
        this.study_link = study_link;
        this.type = type;
        this.topic_description = topic_description;
    }

    public study() {
        topic_no="";
        topic_name="";
        study_link="";
        type="";
        topic_description="";
    }

    public String getTopic_no() {
        return topic_no;
    }

    public void setTopic_no(String topic_no) {
        this.topic_no = topic_no;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getStudy_link() {
        return study_link;
    }

    public void setStudy_link(String study_link) {
        this.study_link = study_link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopic_description() {
        return topic_description;
    }


    public void setTopic_description(String topic_description) {
        this.topic_description = topic_description;
    }

}
