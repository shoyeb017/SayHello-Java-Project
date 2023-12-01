package com.example.sayhello.controllers.instructor;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.course;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class all_course_cell_controller implements Initializable
{

    public course course1;
    public all_course_cell_controller(course course1) {
        this.course1 = course1;
    }

    @FXML
    private Label c_code;

    @FXML
    private Label c_description;

    @FXML
    private Label c_name;

    @FXML
    private AnchorPane gridPane;


    @FXML
    private FontAwesomeIconView arrow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        c_code.setText(course1.getCourse_code());
        c_name.setText(course1.getCourse_name());
        c_description.setText(course1.getCourse_description());
        arrow.setOnMouseClicked(MouseEvent -> go_inbox());
    }
/*
        String p = learner3.getProfile_img();
        // System.out.println(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        f_name.setText(learner3.getFirst_name());

        arrow.setOnMouseClicked(MouseEvent -> go_inbox());*/

    static AnchorPane danchore = new AnchorPane();


    public void go_inbox ()  {
//        System.out.println("clicked   "+learner3.getEmail());
//        chat_inbox ch_in = new chat_inbox();
//        ch_in.set_log_u(learner3);

        course_details cd = new course_details();
        cd.set_course_details(course1);
        online_class oc = new online_class();
        oc.set_log(course1);
        study_material sm = new study_material();
        sm.set_log(course1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/course_details.fxml"));

        try {
            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
