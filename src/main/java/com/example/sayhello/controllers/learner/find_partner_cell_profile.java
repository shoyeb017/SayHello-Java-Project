package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.learner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class find_partner_cell_profile implements Initializable {

    @FXML
    public Circle dp;

    @FXML
    private Label email;

    @FXML
    private Label f_name;

    @FXML
    private Label from;

    @FXML
    private Label l_lang;
    @FXML
    private Label bio;

    @FXML
    private Label n_lang;

    static learner learner2 = new learner();
    public void set_log_u(learner lern) {
        learner2 = lern;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        view_history();

    }

    public void view_history() {
        String p = learner2.getProfile_img();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        email.setText(learner2.getEmail());
        f_name.setText(learner2.getFirst_name());
        from.setText(learner2.getFrom());
        l_lang.setText(learner2.getLearning_language());
        n_lang.setText(learner2.getNative_language());
        bio.setText(learner2.getBio_text());

    }
}
