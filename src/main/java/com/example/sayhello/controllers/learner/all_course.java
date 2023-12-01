package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.course;
import com.example.sayhello.model.instructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class all_course implements Initializable {

    static instructor instructor1 = new instructor();

    public void set_instructor(instructor lern) {
        instructor1 = lern;
    }


    static course cour = new course();
    static course c = new course();

    @FXML
    private Text i_name;


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
        course_view.setCellFactory(course_view -> new all_course_cell_factory1());
    }

    public void set_items() throws FileNotFoundException {

        String directoryPath = "D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + instructor1.getTeaching_language() + "/" + instructor1.getEmail() + "/" + "course";
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        i_name.setText(instructor1.getFirst_name()+" "+instructor1.getLast_name());

        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
