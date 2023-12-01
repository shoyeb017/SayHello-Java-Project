package com.example.sayhello.controllers.instructor;


import com.example.sayhello.model.course;
import com.example.sayhello.model.message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class group_chat implements Initializable {


    @FXML
    public Circle dp;

    @FXML
    public TextField f_name;

    static course c = new course();

    public void set_course(course lern) {
        c = lern;
    }

    public ListView<message> inbox_view;
    public ObservableList<message> inboxObservableList;


    public void view_history() throws FileNotFoundException {

        inboxObservableList = FXCollections.observableArrayList();
        set_items();
        inbox_view.setItems(inboxObservableList);
        inbox_view.setCellFactory(inbox_view -> new group_chat_cell());
    }

    public void set_items() throws FileNotFoundException {


        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language() +"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code()+ "/" + "group_chat" + "/chat.txt");
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
    public TextField text1;

    public void btn_insert(MouseEvent event) throws IOException {
        String t = text1.getText();
        text1.clear();

        File userFile = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language() +"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code()+ "/" + "group_chat");

        boolean is_user_file_created = userFile.mkdir();
        System.out.println(is_user_file_created);

        File infoFile = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language() +"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code()+ "/" + "group_chat/chat.txt");
        FileWriter writer = new FileWriter(infoFile,true);
        writer.write(c.getProfile_img() + "\n");
        writer.write(t + "\n");
        writer.close();

        message msg = new message(c.getProfile_img(), t);
        inboxObservableList.add(msg);
    }

//    public void update_u()
//    {
//        String p = learner2.getProfile_img();
//        Image image = new Image(p);
//        dp.setFill(new ImagePattern(image));
//
//        f_name.setText(learner2.getFirst_name()+" "+learner2.getLast_name());
//    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //update_u();

        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
