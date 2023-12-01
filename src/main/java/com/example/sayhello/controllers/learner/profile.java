package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.learner;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class profile implements Initializable {

    @FXML
    private Label email;

    @FXML
    private Label f_name;

    @FXML
    private Label from;

    @FXML
    private Label gender;

    @FXML
    private Label lerning_lang;

    @FXML
    private Label native_lang;
    @FXML
    public Circle dp = new Circle();
    @FXML
    public Label bio ;

    @FXML
    private FontAwesomeIconView f;

    @FXML
    private FontAwesomeIconView m;

    static learner learner = new learner();
    public void set_log(learner lern)
    {
        learner = lern;
    }


    public Rectangle rec1, rec2, rec3;
    private void set_animation(Rectangle rect, double time, int direction)
    {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), rect);
        rotateTransition.setByAngle(direction*360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
    }

    public void auto_upload_photo()  {
        String p = learner.getProfile_img();
        learner.setProfile_img(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        email.setText(learner.getEmail());
        String s = learner.getFirst_name() + " " + learner.getLast_name();
        f_name.setText(s);
        from.setText(learner.getFrom());
        gender.setText(learner.getGender());
        lerning_lang.setText(learner.getLearning_language());
        native_lang.setText(learner.getNative_language());
        auto_upload_photo();
        bio.setText(learner.getBio_text());

        if(learner.getGender().equals("Male"))
        {
            m.setVisible(true);
            f.setVisible(false);
        }
        else {
            m.setVisible(false);
            f.setVisible(true);
        }

        set_animation(rec1, 10000, 1);
        set_animation(rec2, 8000, -1);
        set_animation(rec3, 5000, 1);
    }
}
