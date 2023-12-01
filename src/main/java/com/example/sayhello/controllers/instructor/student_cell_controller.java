package com.example.sayhello.controllers.instructor;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import com.example.sayhello.view_manager.View_manager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class student_cell_controller implements Initializable
{

    public learner learner1;
    public student_cell_controller(learner l) {
        this.learner1 = l;
    }

    @FXML
    private Label name;

    @FXML
    private AnchorPane arrow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        name.setText(learner1.getFirst_name() + " "+ learner1.getLast_name());

        arrow.setOnMouseClicked(MouseEvent -> go_inbox());
    }
/*
        String p = learner3.getProfile_img();
        // System.out.println(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        f_name.setText(learner3.getFirst_name());

        arrow.setOnMouseClicked(MouseEvent -> go_inbox());*/

    public void go_inbox ()  {
//        System.out.println("clicked   "+learner3.getEmail());
//        chat_inbox ch_in = new chat_inbox();
//        ch_in.set_log_u(learner3);

        student_perfomance_bar bar = new student_perfomance_bar();
        bar.set_learner1(learner1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/student_perfomance_bar.fxml"));

        try {
            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
