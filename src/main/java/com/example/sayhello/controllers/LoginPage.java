package com.example.sayhello.controllers;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.controllers.learner.Dashboard;
import com.example.sayhello.model.instructor;
import com.example.sayhello.model.learner;
import com.example.sayhello.model.log_in;
import com.example.sayhello.view_manager.*;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginPage implements Initializable {

    public TextField email_address1;
    public PasswordField password1;
    @FXML
    private ComboBox <String> native_lang = new ComboBox<>();
    private String[] native_lang_value = {"Bengali", "English", "Japanese", "Mandarin", "Urdu", "Arabic"};

    public Label error_text1;

    public Button create1, create2;
    public Label power;
    public Label power1;
    public Button login_btn1, login_btn0;


    public ImageView i1;
//    public ImageView i2;


    log_in log = new log_in();
    check_email check_mail = new check_email();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        native_lang.getItems().addAll(native_lang_value);
        native_lang2.getItems().addAll(native_lang_value2);

        p3.setLayoutY(0);
        p4.setLayoutY(-763);

        pi.setLayoutX(190);
        pi.setLayoutY(-450);

        a1.setLayoutY(750);
        a2.setLayoutY(750);
        insts.setDisable(false);
        learns.setDisable(true);
    }

    public Pane p1;
    public Pane p2;
    public Pane pi;

    public void start_page(ActionEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(p1);
        slide.setToX(-1450);
        slide.play();

        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(0.7));
        slide1.setNode(p2);
        slide1.setToX(1450);
        slide1.play();

        TranslateTransition slide3 = new TranslateTransition();
        slide3.setDuration(Duration.seconds(0.8));
        slide3.setNode(a2);
        slide3.setToY(-600);
        slide3.play();

        TranslateTransition slide4 = new TranslateTransition();
        slide4.setDuration(Duration.seconds(0.8));
        slide4.setNode(pi);
        slide4.setToY(465);
        slide4.play();

    }

    public Pane p3;
    public Pane p4;

    public AnchorPane a1;
    public AnchorPane a2;
    @FXML
    Button insts = new Button();
    @FXML
    Button learns = new Button();

    public void btn3(MouseEvent event) {
        // disable the btn3 mouseevent when the animation is running
        insts.setDisable(true);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(p4);
        slide.setToY(763);
        slide.play();


        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(0.7));
        slide1.setNode(p3);
        slide1.setToY(-763);
        slide1.play();

        TranslateTransition slide3 = new TranslateTransition();
        slide3.setDuration(Duration.seconds(0.7));
        slide3.setNode(a2);
        slide3.setToY(750);
        slide3.play();

        TranslateTransition slide4 = new TranslateTransition();
        slide4.setDuration(Duration.seconds(0.7));
        slide4.setNode(a1);
        slide4.setToY(-600);
        slide4.play();

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.6), pi);
        rotateTransition.setByAngle(360); // Rotate 360 degrees
        rotateTransition.setCycleCount(1); // Rotate once
        // Create a TranslateTransition
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.6), pi);
        translateTransition.setByX(870); // Translate 100 pixels to the right
        translateTransition.setCycleCount(1); // Translate once
        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, translateTransition);
        parallelTransition.play();

        learns.setDisable(false);

    }

    public void btn4(MouseEvent event) {

        learns.setDisable(true);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(p3);
        slide.setToY(0);
        slide.play();

        TranslateTransition slide1 = new TranslateTransition();
        slide1.setDuration(Duration.seconds(0.7));
        slide1.setNode(p4);
        slide1.setToY(-763);
        slide1.play();

        TranslateTransition slide3 = new TranslateTransition();
        slide3.setDuration(Duration.seconds(0.7));
        slide3.setNode(a2);
        slide3.setToY(-600);
        slide3.play();

        TranslateTransition slide4 = new TranslateTransition();
        slide4.setDuration(Duration.seconds(0.7));
        slide4.setNode(a1);
        slide4.setToY(750);
        slide4.play();

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.6), pi);
        rotateTransition.setByAngle(-360); // Rotate 360 degrees
        rotateTransition.setCycleCount(1); // Rotate once
        // Create a TranslateTransition
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.6), pi);
        translateTransition.setByX(-870); // Translate 100 pixels to the right
        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, translateTransition);
        parallelTransition.play();
        insts.setDisable(false);
    }
    public void btn(MouseEvent event) {
//        TranslateTransition slide = new TranslateTransition();
//
//        slide.setDuration(Duration.seconds(0.3));
//        slide.setNode(l1);
//        slide.setToX(640);
//        slide.play();
//
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.3), ae -> {
//            button1.setVisible(false);
//            i1.setVisible(false);
//            button2.setVisible(true);
//            i2.setVisible(true);
//        }));
//        timeline.play();
//
    }
//
//
    public void btn2(MouseEvent event) {
//        TranslateTransition slide = new TranslateTransition();
//
//        slide.setDuration(Duration.seconds(0.3));
//        slide.setNode(l1);
//
//        slide.setToX(1);
//        slide.play();
//
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.3), ae -> {
//            button2.setVisible(false);
//            i2.setVisible(false);
//            button1.setVisible(true);
//            i1.setVisible(true);
//        }));
//        timeline.play();
//
    }

    View_manager view = new View_manager();

    public void login1(ActionEvent event) throws IOException {
        String e1 = email_address1.getText();
        String p1 = password1.getText();
        String lang1 = native_lang.getValue();

        log = new log_in(e1, p1, lang1);

        if (!log.getEmail().isEmpty() && !log.getPassword().isEmpty() && log.getLanguage() != null) {

            boolean check = false;
            try {
                check = check_email.isEmailValid(log.getEmail());
            } catch (InvalidEmailException e) {
                error_text1.setText("Invalid Email");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
                timeline.play();
                throw new RuntimeException(e);
            }

            learner learner1 = new learner("","",log.getEmail(),"","","",log.getLanguage(),"","","");

            if (learner1.check_language()) {
                File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + log.getLanguage() + "/" + log.getEmail() + "/info.txt");
                Scanner sc = new Scanner(infoFile2);

                String p = sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();
                System.out.println(p);
                System.out.println(p1);

                Dashboard d = new Dashboard();
                if (p.equals(log.getPassword())) {

                    set_get_learner set_get_learner = new set_get_learner();   //set_get_learner is a class
                    set_get_learner.set_log(log);

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/Dashboard.fxml"));
                    view.close_stage(login_btn1);
                    view.create_stage(fxmlLoader);
                } else {
                    error_text1.setText("Wrong Password");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
                    timeline.play();
                }

            } else {
                error_text1.setText("Wrong credentials");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
                timeline.play();
            }
        } else {
            error_text1.setText("Some field are empty");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
            timeline.play();
        }

    }


    public TextField email_address2;
    public PasswordField password2;
    @FXML
    private ComboBox<String> native_lang2 = new ComboBox<>();
    private String[] native_lang_value2 = {"Bengali", "English", "Japanese", "Mandarin", "Urdu", "Arabic"};

    public Label error_text2;


    public void login0(ActionEvent event) throws IOException {

        String e2 = email_address2.getText();
        String p2 = password2.getText();
        String lang2 = native_lang2.getValue();

        log = new log_in(e2, p2, lang2);
        //System.out.println(check);

        if (!log.getEmail().isEmpty() && !log.getPassword().isEmpty() && log.getLanguage() != null) {

            boolean check1 = false;
            try {
                check1 = check_email.isEmailValid(log.getEmail());
            } catch (InvalidEmailException e) {
                error_text2.setText("Invalid Email");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("\0")));
                timeline.play();
                throw new RuntimeException(e);
            }

            instructor instructor1 = new instructor("","",log.getEmail(),"","","","",log.getLanguage(),"","");

            if (instructor1.check_language()) {

                File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + log.getLanguage() + "/" + log.getEmail() + "/info.txt");
                Scanner sc = new Scanner(infoFile2);
                sc.useDelimiter("\n");
                String p ;
                p= sc.next();
                p = sc.next();
                p = sc.next();
                p = sc.next();

                System.out.println("p "+p);
                System.out.println("p2 "+p2);

                Dashboard d = new Dashboard();
                if (p.equals(log.getPassword())) {

                    set_get_instructor set_get_instructor = new set_get_instructor();
                    set_get_instructor.set_log(log);

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/Dashboard.fxml"));
                    view.close_stage(login_btn0);
                    view.create_stage(fxmlLoader);
                } else {
                    error_text2.setText("Wrong Password");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("\0")));
                    timeline.play();
                }

            } else {
                error_text2.setText("Wrong credentials");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("\0")));
                timeline.play();
            }
        } else {
            error_text2.setText("Some field are empty");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("\0")));
            timeline.play();
        }

    }



    @FXML
    void go_forget_pass(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/forget_pass.fxml"));
        view.create_stage(fxmlLoader);
    }

    public void switchTolearner_signup1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/learner_signup1.fxml"));
        view.close_stage(create1);
        view.create_stage(fxmlLoader);

    }

    public void switchToinstructor_signup1(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/signup1.fxml"));
        view.close_stage(create1);
        view.create_stage(fxmlLoader);

    }

}

