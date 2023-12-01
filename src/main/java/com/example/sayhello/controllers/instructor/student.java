package com.example.sayhello.controllers.instructor;


import com.example.sayhello.model.course;
import com.example.sayhello.model.instructor;
import com.example.sayhello.model.learner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class student implements Initializable {

    static instructor instructor1 = new instructor();

    static learner learner2 = new learner();
    static course c = new course();

    @FXML
    private ListView<learner> student_view;
    private ObservableList<learner> studentObservableList;

    public void set_log(instructor ins)
    {
        instructor1 = ins;
    }

    public void view_history() throws FileNotFoundException {

        studentObservableList = FXCollections.observableArrayList();
        set_items();
        student_view.setItems(studentObservableList);
        student_view.setCellFactory(course_view -> new student_cell_factory());
    }

    public void set_items() throws FileNotFoundException {

        String directoryPath = "src/main/resources/com/example/sayhello/file/instructor/" + instructor1.getTeaching_language() + "/" + instructor1.getEmail() + "/" + "enroll_now";
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String c1= fileOrDir.getName();
                        get_learner(c1);

                        studentObservableList.add(learner2);
                    }
                }
            }
        }
    }


    void get_learner(String c) throws FileNotFoundException {

        File infoFile = new File("src/main/resources/com/example/sayhello/file/instructor/" + instructor1.getTeaching_language() + "/" + instructor1.getEmail() + "/" + "enroll_now/" + c + "/info.txt");
        Scanner sc1 = new Scanner(infoFile);
        sc1.useDelimiter("\n");
        String e = sc1.next();
        sc1.close();

        File infoFile2 = new File("src/main/resources/com/example/sayhello/file/learner/" + e + "/" + c + "/info.txt");
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
            String le = sc.next();

            String pr = sc.next();

            String bi = sc.next();
            System.out.println(pr);
            //System.out.println(bi);

            learner2 = new learner(fn, ln, em, pa, gen, fr, na, le, pr, bi);
            sc.close();
        }

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

