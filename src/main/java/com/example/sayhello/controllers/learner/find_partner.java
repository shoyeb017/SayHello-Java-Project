package com.example.sayhello.controllers.learner;

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

public class find_partner implements Initializable {

    static learner learner1 = new learner();
    static learner learner2 = new learner();

    public void set_log(learner lern) {
        learner1 = lern;
    }

    @FXML
    private ListView<learner> partner_view;
    private ObservableList<learner> partnerObservableList;

    public void view_history() throws FileNotFoundException {
        //new_transaction_pane.setVisible(false);
        //history_list.setVisible(true);
        System.out.println("hello");
        partnerObservableList = FXCollections.observableArrayList();

        set_items();

        partner_view.setItems(partnerObservableList);

        partner_view.setCellFactory(partner_view -> new find_partner_cell_factory());
    }

    public void set_items() throws FileNotFoundException {

            String directoryPath = "D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + learner1.getLearning_language();
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
                            get_learner(n1,e1);

                        }
                    }
                }
            }
    }


    void get_learner(String n, String e) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + n + "/" + e + "/info.txt");
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

            sc.close();

            if(le.equals(learner1.getNative_language())) {
                learner2 = new learner(fn, ln, em, pa, gen, fr, na, le, pr, bi);
                partnerObservableList.add(learner2);
            }
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
