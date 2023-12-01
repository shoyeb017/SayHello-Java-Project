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

public class find_partner_cell_controller implements Initializable {

    @FXML
    private FontAwesomeIconView arrow1;

    @FXML
    public Circle dp1;

    @FXML
    private Label f_name1;

    @FXML
    private AnchorPane gridPane;
    public learner learner5;
    public find_partner_cell_controller(learner learner2) {
        learner5 = learner2;
    }

    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        String p = learner5.getProfile_img();
        System.out.println("her  "+p);
        Image image = new Image(p);
        dp1.setFill(new ImagePattern(image));

        f_name1.setText(learner5.getFirst_name());

        arrow1.setOnMouseClicked(MouseEvent -> go_inbox());
    }

    public void go_inbox ()  {

        find_partner_cell_profile find = new find_partner_cell_profile();
        find.set_log_u(learner5);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/find_partner_cell_profile.fxml"));
        try {

            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
