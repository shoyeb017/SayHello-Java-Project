package com.example.sayhello.controllers.instructor;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.instructor;
import com.example.sayhello.view_manager.View_manager;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
    @FXML
    public Pane p1;

    static instructor instructor = new instructor();
    public void set_log(instructor ins)
    {
        instructor = ins;
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

    public AnchorPane danchore = new AnchorPane();

    public void go_add_course(ActionEvent event) throws IOException {
        add_course add_course = new add_course();
        add_course.set_log(instructor);

        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/add_course.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void go_student(ActionEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/student.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }
    public void go_all_course(ActionEvent event) throws IOException {
        all_course all_course = new all_course();
        all_course.set_log(instructor);

        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/all_course.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

//    public void go_profile(ActionEvent event) throws IOException {
//        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/profile.fxml")));
//        danchore.getChildren().removeAll();
//        danchore.getChildren().setAll(fxml);
//    }

    public void go_profile(MouseEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/profile.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    View_manager view = new View_manager();

    public void go_about_us(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/about_us.fxml"));
        view.create_stage(fxmlLoader);
    }

    public void go_contact_us(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/contact_us.fxml"));
        view.create_stage(fxmlLoader,1280,760);
    }

    @FXML
    public Button log_out;
    public void go_log_out(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/LoginPage.fxml"));
        view.close_stage(log_out);
        view.create_stage(fxmlLoader);
    }


    public void go_home(MouseEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/home.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    @FXML
    public void set_home() {
        try {
            AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/home.fxml")));
            danchore.getChildren().clear();  // Clear the existing children.
            danchore.getChildren().add(fxml);
        } catch (IOException e) {
            e.printStackTrace();  // Handle or log the exception as needed.
        }
    }

    public Circle dp = new Circle();
    public Label dp_text = new Label();
    public Label dp_text1 = new Label();
    public void auto_upload_photo()  {
        String p = instructor.getProfile_img();
        instructor.setProfile_img(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        String name = instructor.getFirst_name() + " " + instructor.getLast_name();
        dp_text.setText(name);
        dp_text1.setText(instructor.getEmail());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        set_home();
        auto_upload_photo();
    }
}
