package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import com.example.sayhello.view_manager.View_manager;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Dashboard implements Initializable  {
    @FXML
    public Pane p1;

    static learner learner = new learner();
    public void set_log(learner lern)
    {
        learner = lern;
    }

    public void dashboard_open_action1(MouseEvent mouseEvent)
    {
        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.6));
        slide.setNode(p1);
        slide.setToX(220);
        slide.play();
    }

    public void dashboard_open_action2(MouseEvent mouseEvent)
    {
        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.6));
        slide.setNode(p1);
        slide.setToX(-138);
        slide.play();
    }

    public AnchorPane danchore;

    @FXML
    public void set_home() {
        try {
            AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/home.fxml")));
            danchore.getChildren().clear();  // Clear the existing children.
            danchore.getChildren().add(fxml);
        } catch (IOException e) {
            e.printStackTrace();  // Handle or log the exception as needed.
        }
    }


    public void go_home(MouseEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/home.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }
    public void go_learn(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/learn.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void go_chatbox(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/chat.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }
    public void go_find_partner(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/find_partner.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void go_feed(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/feed.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void go_profile(MouseEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/profile.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    View_manager view = new View_manager();

    public void go_about_us(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/about_us.fxml"));
        view.create_stage(fxmlLoader,1280,760);
    }

    public void go_contact_us(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/contact_us.fxml"));
        view.create_stage(fxmlLoader,1280,760);
    }

    @FXML
    public Button log_out;
    public void go_log_out(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/LoginPage.fxml"));
        Scene scene = new Scene(((FXMLLoader) fxmlLoader).load());
        //scene.setFill(Color.TRANSPARENT);

        view.close_stage(log_out);

        Stage stage=new Stage();
        stage.setTitle("SayHello");
        stage.setScene(scene);
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();
    }

    public Circle dp = new Circle();
    public Label dp_text = new Label();
    public Label dp_text1 = new Label();
    public void auto_upload_photo()  {
        String p = learner.getProfile_img();
        learner.setProfile_img(p);
        Image image = new Image(p,50,50,false,false);
        dp.setFill(new ImagePattern(image));

        dp_text.setText(learner.getFirst_name() + " " + learner.getLast_name());
        dp_text1.setText(learner.getEmail());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            set_home();
            auto_upload_photo();
            System.out.println(learner.getEmail());
    }
}
