package com.example.sayhello.model;


import java.io.File;

public class learner extends person
{
    String learning_language;
    String profile_img;
    String bio_text;

    public learner(String first_name, String last_name, String email, String password , String gender,String from,String native_language,String learning_language,String profile_img,String bio_text)
    {
        super(first_name,last_name,email,password ,gender,from,native_language);
        this.learning_language = learning_language;
        this.profile_img = profile_img;
        this.bio_text = bio_text;
    }

    public learner()
    {
        super("","","","","","","");
        this.learning_language= "";
        this.profile_img= "";
        this.bio_text= "";
    }

    @Override
    public boolean check_language() {

        String e = email;
        String t = native_language;
        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + t + "/" + e + "/info.txt");
        if(infoFile2.exists())
        {
            return true;
        }
        return false;
    }

    public String getLearning_language() {
        return learning_language;
    }

    public void setLearning_language(String learning_language) {
        this.learning_language = learning_language;
    }

    public String getProfile_img() {
        return profile_img;
    }
    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public String getBio_text() {
        return bio_text;
    }
    public void setBio_text(String bio_text) {
        this.bio_text = bio_text;
    }


}
