package com.example.sayhello.model;

abstract class person
{
    String first_name;
     String last_name;
    String email;
    String password;
    String gender;
    String from;
    String native_language;

    public person(String first_name, String last_name, String email, String password , String gender,String from,String native_language)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.from = from;
        this.native_language = native_language;
    }

    abstract boolean check_language();

    public  String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public  String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getNative_language() {
        return native_language;
    }
    public void setNative_language(String native_language) {
        this.native_language = native_language;
    }



}

