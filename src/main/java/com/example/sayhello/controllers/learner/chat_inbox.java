package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.learner;
import com.example.sayhello.model.message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class chat_inbox implements Initializable {


    @FXML
    public Circle dp;

    @FXML
    public TextField f_name;

    static learner learner1 = new learner();
    static learner learner2 = new learner();

    static learner learner3 = new learner();
    static learner learner4 = new learner();

    public void set_log_me(learner lern) {
        learner1 = lern;
    }
    public void set_log_u(learner lern) {
        learner2 = lern;
    }

    public ListView<message> inbox_view;
    public ObservableList<message> inboxObservableList;


    public void view_history() throws FileNotFoundException {

        inboxObservableList = FXCollections.observableArrayList();
        set_items();
        inbox_view.setItems(inboxObservableList);
        inbox_view.setCellFactory(inbox_view -> new chat_inbox_cell());
    }

    public void set_items() throws FileNotFoundException {

        int l1 = learner1.getEmail().length();
        int l2 = learner2.getEmail().length();
        learner3 = learner1;
        learner4 = learner2;

        if (l1 < l2) {
            learner3 = learner2;
            learner4 = learner1;
        }

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/chat/"+ learner3.getEmail()+"/"+ learner4.getEmail()+"/inbox.txt");
        if (infoFile2.exists()) {
            Scanner scanner = new Scanner(infoFile2);
            scanner.useDelimiter("\n");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String line1 = scanner.nextLine();

                message msg = new message(line, line1);
                inboxObservableList.add(msg);
            }

            scanner.close();
        }


        }
   // }
    public TextField text1;

    public void btn_insert(MouseEvent event) throws IOException {
        String t = text1.getText();
        text1.clear();
        int l1 = learner1.getEmail().length();
        int l2 = learner2.getEmail().length();
        learner3 = learner1;
        learner4 = learner2;

        if (l1 < l2) {
            learner3 = learner2;
            learner4 = learner1;
        }

        File userFile = new File("src/main/resources/com/example/sayhello/file/chat/"+ learner3.getEmail());

        boolean is_user_file_created = userFile.mkdir();
        System.out.println(is_user_file_created);

        File userFile1 = new File("src/main/resources/com/example/sayhello/file/chat/"+ learner3.getEmail()+"/"+ learner4.getEmail());
        boolean is_user_file_created1 = userFile1.mkdir();
        System.out.println(is_user_file_created1);

        File infoFile = new File("src/main/resources/com/example/sayhello/file/chat/"+ learner3.getEmail()+"/"+ learner4.getEmail()+"/inbox.txt");
        FileWriter writer = new FileWriter(infoFile,true);
        writer.write(learner1.getProfile_img() + "\n");
        writer.write(t + "\n");
        writer.close();

        message msg = new message(learner1.getProfile_img(), t);
        inboxObservableList.add(msg);
    }
    public void update_u()
    {
        String p = learner2.getProfile_img();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        f_name.setText(learner2.getFirst_name()+" "+learner2.getLast_name());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    update_u();

        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
