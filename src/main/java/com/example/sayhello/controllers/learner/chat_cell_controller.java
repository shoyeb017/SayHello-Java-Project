package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
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

public class chat_cell_controller implements Initializable
{
    @FXML
    public Circle dp = new Circle();

    @FXML
    private Label f_name = new Label();

    public learner learner3;

    public chat_cell_controller(learner learner2) {
        this.learner3 = learner2;
    }

    public FontAwesomeIconView arrow ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        String p = learner3.getProfile_img();
       // System.out.println(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        f_name.setText(learner3.getFirst_name());

        arrow.setOnMouseClicked(MouseEvent -> go_inbox());
    }

    static AnchorPane danchore = new AnchorPane();


    public void go_inbox ()  {
        System.out.println("clicked   "+learner3.getEmail());
        chat_inbox ch_in = new chat_inbox();
        ch_in.set_log_u(learner3);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/chat_inbox.fxml"));
        try {

            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
