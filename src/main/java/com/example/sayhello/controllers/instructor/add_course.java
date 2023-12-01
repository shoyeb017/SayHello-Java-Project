package com.example.sayhello.controllers.instructor;

import com.example.sayhello.model.course;
import com.example.sayhello.model.instructor;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class add_course implements Initializable {

    @FXML
    private TextField c_des;

    @FXML
    private TextField c_nam;

    @FXML
    private TextField c_code;

    @FXML
    private Label t_lang;
    @FXML
    private Label error_text;

    static instructor instructor1 = new instructor();

    static course cour = new course();
    static course c = new course();

    @FXML
    private ListView<course> course_view;
    private ObservableList<course> courseObservableList;

    void set_log(instructor ins)
    {
        instructor1 = ins;
    }

    public void view_history() throws FileNotFoundException {

        courseObservableList = FXCollections.observableArrayList();
        set_items();
        course_view.setItems(courseObservableList);
        course_view.setCellFactory(course_view -> new add_course_cell());
    }

    public void set_items() throws FileNotFoundException {

        String directoryPath = "D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + instructor1.getTeaching_language() + "/" + instructor1.getEmail() +"/" +"course";
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String n1= instructor1.getTeaching_language();
                        String e1= instructor1.getEmail();
                        String c1= fileOrDir.getName();
                        get_learner(n1,e1,c1);

                        courseObservableList.add(cour);
                        System.out.println(e1);
                    }
                }
            }
        }
    }


    void get_learner(String n,String e, String c) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + n + "/" + e + "/" + "course" + "/" + c +  "/course_info.txt");
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
            String cc = sc.next();
            String cn = sc.next();
            String cd = sc.next();
            int t = sc.nextInt();
            System.out.println(pr);
            //System.out.println(bi);

            cour = new course(fn, ln, em, pa, gen, fr, na, te, pr, bi, cc, cn, cd, t);
            sc.close();
        }

    }


    @FXML
    void go_add_course(ActionEvent event) throws IOException {
        String t = c_code.getText();
        String c_name = c_nam.getText();
        String c_description = c_des.getText();
        String c_language = instructor1.getTeaching_language();

        c = new course(instructor1.getFirst_name(),instructor1.getLast_name(),instructor1.getEmail(),instructor1.getPassword(),instructor1.getGender(),
                instructor1.getFrom(),instructor1.getNative_language(),instructor1.getTeaching_language(),instructor1.getProfile_img(),
                instructor1.getBio_text(), t , c_name ,c_description,0);


        File userFile0 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language()+"/"+ c.getEmail()+"/" + "course" );
        boolean is_user_file_created0 = userFile0.mkdir();

        File userFile = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language()+"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code());

        if (userFile.exists() && userFile.isDirectory()) {
            error_text.setText("Course Code Already Exist");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text.setText("\0")));
            timeline.play();
        }
        else {
            boolean is_user_file_created = userFile.mkdir();
            System.out.println(is_user_file_created);

            File infoFile1 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + c.getTeaching_language() + "/" + c.getEmail() + "/" + "course" + "/" +c.getCourse_code() + "/course_info.txt");

            FileWriter writer = new FileWriter(infoFile1, true);

            writer.write(c.getFirst_name() + "\n");
            writer.write(c.getLast_name() + "\n");
            writer.write(c.getEmail() + "\n");
            writer.write(c.getPassword() + "\n");
            writer.write(c.getGender() + "\n");
            writer.write(c.getFrom() + "\n");
            writer.write(c.getNative_language() + "\n");
            writer.write(c.getTeaching_language() + "\n");
            writer.write(c.getProfile_img() + "\n");
            writer.write(c.getBio_text() + "\n");
            writer.write(c.getCourse_code() + "\n");
            writer.write(c.getCourse_name() + "\n");
            writer.write(c.getCourse_description() + "\n");
            writer.write(c.getTotal() + "\n");
            writer.close();

            courseObservableList.add(c);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t_lang.setText(instructor1.getTeaching_language());

        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}