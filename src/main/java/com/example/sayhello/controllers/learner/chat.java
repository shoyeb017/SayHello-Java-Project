package com.example.sayhello.controllers.learner;


import com.example.sayhello.model.learner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class chat implements Initializable {

    static learner learner1 = new learner();
    static learner learner2 = new learner();

    public void set_log(learner lern) {
        learner1 = lern;
    }

    @FXML
    private ListView<learner> chat_view;
    private ObservableList<learner> chatObservableList;

    public void view_history() throws FileNotFoundException {

        chatObservableList = FXCollections.observableArrayList();
        set_items();
        chat_view.setItems(chatObservableList);
        chat_view.setCellFactory(chat_view -> new chat_cell_factory());
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
            System.out.println(pr);

            sc.close();

            if(le.equals(learner1.getNative_language()))
            {
                learner2 = new learner(fn, ln, em, pa, gen, fr, na, le, pr, bi);
                chatObservableList.add(learner2);
            }
        }

    }

    public AnchorPane can = new AnchorPane();
    /*
    @FXML
    public Circle dp = new Circle();

    @FXML
    private Text f_name = new Text();
    private Text bio = new Text();

    public void set_pp(learner l) {
        can.setVisible(true);
        f_name.setText(l.getFirst_name());
        bio.setText(l.getBio_text());

        String p = learner2.getProfile_img();
        l.setProfile_img(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));
    }
*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        can.setVisible(false);
        try {
            chat_inbox_cell chatInboxCell = new chat_inbox_cell();
            chatInboxCell.set_chat_inbox_cell(learner1);

            chat_inbox_cell_controller chatInboxCellController = new chat_inbox_cell_controller();
            chatInboxCellController.set_chat_inbox_cell(learner1);

            chat_inbox_cell_translate chatInboxCellTranslate = new chat_inbox_cell_translate();
            chatInboxCellTranslate.set_log(learner1);

            view_history();

            chat_inbox ch_in = new chat_inbox();
            ch_in.set_log_me(learner1);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
