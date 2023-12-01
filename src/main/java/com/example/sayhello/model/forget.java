package com.example.sayhello.model;

public class forget {

    public String acc_type;
    public String lang;
    public String email;

    public forget(String acc_type, String lang, String email) {
        this.acc_type = acc_type;
        this.lang = lang;
        this.email = email;
    }

    public forget() {
        this.email = "";
        this.acc_type = "";
        this.lang = "";
    }

    public String getEmail() {
        return email;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public String getLang() {
        return lang;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }



}
