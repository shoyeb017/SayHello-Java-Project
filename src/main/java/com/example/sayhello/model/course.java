package com.example.sayhello.model;

public class course extends person
{
    String teaching_language;
    String profile_img;
    String bio_text;

    String course_code;
    String course_name;
    String course_description;

    int total;
    public course(String first_name, String last_name, String email, String password ,
                  String gender,String from,String native_language,String teaching_language,
                  String profile_img,String bio_text,String course_code,String course_name,String course_description,int total)

    {
        super(first_name,last_name,email,password ,gender,from,native_language);
        this.teaching_language = teaching_language;
        this.profile_img = profile_img;
        this.bio_text = bio_text;
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_description = course_description;
        this.total = total;
    }

    public course()
    {
        super("","","","","","","");
        this.teaching_language= "";
        this.profile_img= "";
        this.bio_text= "";
        this.course_code = "";
        this.course_name = "";
        this.course_description = "";
        this.total = 0;
    }

    public String getTeaching_language() {
        return teaching_language;
    }



    public void setTeaching_language(String teaching_language) {
        this.teaching_language = teaching_language;
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

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    boolean check_language() {
        return false;
    }
}
