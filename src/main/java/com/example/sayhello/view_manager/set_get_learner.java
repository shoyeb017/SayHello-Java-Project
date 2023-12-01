package com.example.sayhello.view_manager;

import com.example.sayhello.controllers.Mail_background;
import com.example.sayhello.controllers.learner.*;
import com.example.sayhello.model.learner;
import com.example.sayhello.model.log_in;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class set_get_learner {

    static learner learner = new learner();
    static log_in log = new log_in();

    public void set_log(log_in l) throws FileNotFoundException {
        log = l;
        get_learner();
        set_learner();
    }

    void set_learner() {
        Dashboard dashboard = new Dashboard();
        dashboard.set_log(learner);
        home home = new home();
        home.set_lang(learner);
        profile profile = new profile();
        profile.set_log(learner);
        find_partner find_partner = new find_partner();
        find_partner.set_log(learner);
        chat ch = new chat();
        ch.set_log(learner);
        learn ln = new learn();
        ln.set_log(learner);
        feed f = new feed();
        f.set_log(learner);
        feed_cell_translate fct= new feed_cell_translate();
        fct.set_log(learner);
        Mail_background mail_background = new Mail_background();
        mail_background.set_lang(learner);

        all_course_cell_controller1 all = new all_course_cell_controller1();
        all.set_learner_allcourse(learner);


    }

    void get_learner() throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + log.getLanguage() + "/" + log.getEmail() + "/info.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            String fn = sc.next();
            String ln = sc.next();
            String em = sc.next();
            String pa = sc.next();
            String gen = sc.next();
            String fr = sc.next();
            String na = sc.next();
            String le = sc.next();
            sc.useDelimiter("\n");
            String pr = sc.next();

            String bi = sc.next();

            System.out.println(bi);

            learner = new learner(fn, ln, em, pa, gen, fr, na, le, pr, bi);

        }

    }
}
