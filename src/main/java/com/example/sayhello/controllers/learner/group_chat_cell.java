package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.course;
import com.example.sayhello.model.learner;
import com.example.sayhello.model.message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class group_chat_cell extends ListCell<message> {

    static public course course3;

    @FXML
    public Circle dpl = new Circle();
    public Label msgl = new Label();

    @FXML
    public Label msgr = new Label();


    @FXML
    public AnchorPane gridPane;
    public AnchorPane l;
    public AnchorPane r;

    private FXMLLoader mLLoader;

    public void set_course(course course1) {
        this.course3 = course1;
    }


    static learner learner3 = new learner();
    public void set_log(learner lern) {
        learner3 = lern;
    }
    protected void updateItem(message msg, boolean empty) {
        super.updateItem(msg, empty);

        if(empty || msg == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/group_chat_cell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            String p = msg.getSender_img();
            Image image = new Image(p);
            dpl.setFill(new ImagePattern(image));


            if(msg.getSender_img().equals(learner3.getProfile_img()))
            {
                l.setVisible(false);
                r.setVisible(true);

                msgr.setText(msg.getMessage());
            }
            else
            {
                r.setVisible(false);
                l.setVisible(true);

                msgl.setText(msg.getMessage());
            }

            setText(null);
            setGraphic(gridPane);
        }

    }
}
