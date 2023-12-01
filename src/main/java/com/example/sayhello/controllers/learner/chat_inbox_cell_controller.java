package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import com.example.sayhello.model.message;
import com.example.sayhello.view_manager.View_manager;
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

public class chat_inbox_cell_controller implements Initializable {


    @FXML
    public Circle dpl = new Circle();
    public Label msgl = new Label();

    @FXML
    public Circle dpr = new Circle();
    public Label msgr = new Label();


    @FXML
    public AnchorPane gridPane;
    public AnchorPane l;
    public AnchorPane r;

    public message msg = new message();

    public chat_inbox_cell_controller() {
    }
    public chat_inbox_cell_controller(message msg) {
        this.msg = msg;
    }

    static public learner learner3;

    public void set_chat_inbox_cell(learner learner2) {
        this.learner3 = learner2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(msg.getSender_img().equals(learner3.getProfile_img()))
        {

            l.setVisible(false);
            r.setVisible(true);
            dpl.setVisible(false);
            dpr.setVisible(true);
            String p = msg.getSender_img();
            Image image = new Image(p);
            dpr.setFill(new ImagePattern(image));

            msgr.setText(msg.getMessage());
        }
        else
        {
            l.setVisible(true);
            r.setVisible(false);
            dpl.setVisible(true);
            dpr.setVisible(false);

            String p = msg.getSender_img();
            Image image = new Image(p);
            dpl.setFill(new ImagePattern(image));

            msgl.setText(msg.getMessage());
            // AnchorPane.setLeftAnchor(msgl, 10.0);
            //AnchorPane.setRightAnchor(msgl, 10.0);
        }

        msgr.setOnMouseClicked(MouseEvent -> go_inboxr());
        msgl.setOnMouseClicked(MouseEvent -> go_inboxl());

    }

    private void go_inboxr() {

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/chat_cell_translate.fxml"));
        try {

            chat_inbox_cell_translate chatInboxCellTranslate = new chat_inbox_cell_translate();
            chatInboxCellTranslate.setMsg(msg);

            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void go_inboxl() {

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/chat_cell_translate.fxml"));
        try {

            chat_inbox_cell_translate chatInboxCellTranslate = new chat_inbox_cell_translate();
            chatInboxCellTranslate.setMsg(msg);

            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
