package com.example.sayhello.model;

public class feed_class {
    String name;
    String dp;
    String massage;
    int count;
    String img_path;
    String c_path;

    public feed_class(String name, String dp, String massage, int count,String c_path,String img_path) {
        this.name = name;
        this.dp = dp;
        this.massage = massage;
        this.count = count;
        this.img_path = img_path;
        this.c_path = c_path;
    }
    public feed_class()
    {
        this.name = "";
        this.dp = "";
        this.massage = "";
        this.count = 0;
        this.img_path = "";
        this.c_path = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getC_path() {
        return c_path;
    }

    public void setC_path(String c_path) {
        this.c_path = c_path;
    }
}
