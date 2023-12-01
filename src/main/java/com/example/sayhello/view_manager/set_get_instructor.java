package com.example.sayhello.view_manager;

import com.example.sayhello.controllers.instructor.Dashboard;
import com.example.sayhello.controllers.instructor.home;
import com.example.sayhello.controllers.instructor.profile;
import com.example.sayhello.controllers.instructor.student;
import com.example.sayhello.model.instructor;
import com.example.sayhello.model.log_in;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class set_get_instructor {


    static instructor instructor = new instructor();
    static log_in log = new log_in();

    public void set_log(log_in l) throws FileNotFoundException {
        log = l;
        get_instructor();
        set_instructor();
    }
    void set_instructor() {
        Dashboard dashboard = new Dashboard();
        dashboard.set_log(instructor);
        profile profile = new profile();
        profile.set_log(instructor);
        student st = new student();
        st.set_log(instructor);
        home hm = new home();
        hm.set_lang(instructor);

    }
    void get_instructor() throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + log.getLanguage() + "/" + log.getEmail() + "/info.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);
            sc.useDelimiter("\n");
            String fn = sc.next();
            String ln = sc.next();
            String em = sc.next();
            String pa = sc.next();
            String gen = sc.next();
            String fr = sc.next();
            String na = sc.next();
            String te = sc.next();
            String pr = sc.next();
            String bi = sc.next();

            instructor = new instructor(fn, ln, em, pa, gen, fr, na, te, pr, bi);
        }

    }

}
