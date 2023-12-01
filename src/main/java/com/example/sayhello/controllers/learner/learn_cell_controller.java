package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.instructor;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class learn_cell_controller implements Initializable
{

    public Circle dp = new Circle();

    public instructor instructor1;
    public learn_cell_controller(instructor in) {
        this.instructor1 = in;
    }


    @FXML
    private FontAwesomeIconView arrow;


    @FXML
    private AnchorPane gridPane;

    @FXML
    private Label i_bio;

    @FXML
    private Label i_email;

    @FXML
    private Label i_name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        i_name.setText(instructor1.getFirst_name() + " "+ instructor1.getLast_name());
        i_email.setText(instructor1.getEmail());
        i_bio.setText(instructor1.getBio_text());

        String p = instructor1.getProfile_img();
        // System.out.println(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

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

        all_course ac = new  all_course();
        ac.set_instructor(instructor1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/all_course.fxml"));

        try {
            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
