package com.example.sayhello.controllers.learner;


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

public class learn implements Initializable {

    static learner learner1 = new learner();
    static learner learner2 = new learner();

    static instructor instructor1 = new instructor();

    public void set_log(learner lern) {
        learner1 = lern;
    }

    @FXML
    private ListView<instructor> instructor_view;
    private ObservableList<instructor> instructorObservableList;

    public void view_history() throws FileNotFoundException {

        instructorObservableList = FXCollections.observableArrayList();
        set_items();
        instructor_view.setItems(instructorObservableList);
        instructor_view.setCellFactory(instructor_view -> new learn_cell_factory());
    }

    public void set_items() throws FileNotFoundException {

        String directoryPath = "D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + learner1.getLearning_language();
       // String directoryPath = "D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + learner1.getLearning_language();
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String n1= learner1.getLearning_language();
                        String e1= fileOrDir.getName();

                        get_instructor(n1,e1);

                        instructorObservableList.add(instructor1);
                    }
                }
            }
        }
    }


    void get_instructor(String n, String e) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + n + "/" + e + "/info.txt");
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
            String tl = sc.next();
            String pr = sc.next();
            String bi = sc.next();

            instructor1 = new instructor(fn, ln, em, pa, gen, fr, na, tl, pr, bi);
            sc.close();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            group_chat gc = new group_chat();
            gc.set_log(learner1);
            group_chat_cell gc1 = new group_chat_cell();
            gc1.set_log(learner1);

            view_history();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
