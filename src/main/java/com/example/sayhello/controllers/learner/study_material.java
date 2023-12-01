package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.course;
import com.example.sayhello.model.study;
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

public class study_material implements Initializable {


    @FXML
    private ListView<study> study_view;
    private ObservableList<study> studyObservableList;

    static study c2= new study();
    static course c= new course();
    public static study study1 = new study();
    void set_log(course ins)
    {
        c = ins;
    }


    public void view_history() throws FileNotFoundException {

        studyObservableList = FXCollections.observableArrayList();
        set_items();
        study_view.setItems(studyObservableList);
        study_view.setCellFactory(study_view -> new study_material_cell_factory());
    }

    public void set_items() throws FileNotFoundException {

        File directory = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language()+"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code()+ "/" + "study_material" );

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String n1= c.getTeaching_language();
                        String e1= c.getEmail();
                        String c1= c.getCourse_code();
                        String s1= fileOrDir.getName();

                        get_learner(n1,e1,c1,s1);

                        studyObservableList.add(c2);
                    }
                }
            }
        }
    }


    void get_learner(String n,String e, String c,String s) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + n + "/" + e + "/" + "course" + "/" + c +  "/" + "study_material" + "/" + s + "/study.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String tno = sc.next();
            String tn = sc.next();
            String cho = sc.next();
            String tm = sc.next();
            String td = sc.next();

            c2 = new study(tno,tn,cho,tm,td);
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
