package com.example.sayhello.model;

public class log_in
{
    String email;
    String password;
    String language;

    public log_in(String email, String password, String language)
    {
        this.email = email;
        this.password = password;
        this.language = language;
    }

    public log_in()
    {
        this.email = "";
        this.password = "";
        this.language = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password= password;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language= language;
    }
}

