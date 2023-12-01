package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.course;
import com.example.sayhello.model.online;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class online_class implements Initializable {


    @FXML
    private AnchorPane b1;

    @FXML
    private ListView<online> online_view;
    private ObservableList<online> onlineObservableList;

    static online c2= new online();
    static course c= new course();
    void set_log(course ins)
    {
        c = ins;
    }


    public void view_history() throws FileNotFoundException {

        onlineObservableList = FXCollections.observableArrayList();
        set_items();
        online_view.setItems(onlineObservableList);
        online_view.setCellFactory(online_view -> new online_class_cell_factory());
    }

    public void set_items() throws FileNotFoundException {

        File directory = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language()+"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code()+ "/" + "online" );

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

                        onlineObservableList.add(c2);
                    }
                }
            }
        }
    }


    void get_learner(String n,String e, String c,String s) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + n + "/" + e + "/" + "course" + "/" + c +  "/" + "online" + "/" + s + "/online_class.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String tn = sc.next();
            String sd = sc.next();
            String cl = sc.next();
            String td = sc.next();

            c2 = new online(tn,td,sd,cl);
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
