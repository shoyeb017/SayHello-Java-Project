package com.example.sayhello.controllers;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.forget;
import com.example.sayhello.view_manager.InvalidEmailException;
import com.example.sayhello.view_manager.View_manager;
import com.example.sayhello.view_manager.check_email;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Forgot_pass implements Initializable
{
    public TextField a_mail;
    public TextField otp_code;
    public PasswordField new_pass;
    public PasswordField confirm_pass;
    public Label error_text1;
    public Label error_text2;
    public Label error_text3;
    public Label error_text4;
    public Label new_pass_message;
    public static int code;

    static forget forget1 = new forget();


    @FXML
    private ComboBox<String> acc_type=new ComboBox<>();
    private String[] acc_type_value = {"learner", "instructor"};

    @FXML
    private ComboBox<String> lang = new ComboBox<>();
    private String[] lang_value = {"Bengali", "English", "Japanese", "Mandarin", "Urdu", "Arabic"};

    @FXML
    private TextField u_email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lang.getItems().addAll(lang_value);
        acc_type.getItems().addAll(acc_type_value);
    }

    @FXML
    void go_forgetpass1(ActionEvent event) throws IOException {

        forget1.setEmail(u_email.getText());
        forget1.setAcc_type(acc_type.getValue());
        forget1.setLang(lang.getValue());

        File path = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/" + forget1.getAcc_type() +"/" + forget1.getLang() +"/"+ forget1.getEmail() +"/info.txt");

        if (u_email.getText().isBlank() || acc_type.getValue()==null || lang.getValue()==null)
        {
            error_text1.setText("Fill out all the fields to proceed.");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ev -> error_text1.setText("")));
            timeline.play();
        }
        else if (!path.exists())
        {
            error_text1.setText("Wrong credentials. Please Check Again.");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ev -> error_text1.setText("")));
            timeline.play();
        }
         else
        {
            View_manager view = new View_manager();
            Parent root1 = FXMLLoader.load(HelloApplication.class.getResource("fxml/forget_pass1.fxml"));
            view.switch_scene(root1, event);
        }

    }



    public void go_otp(ActionEvent event) throws IOException {

        boolean ch = false;
        try {
            ch = check_email.isEmailValid(a_mail.getText());
        } catch (InvalidEmailException e) {
            error_text2.setText("Email invalid");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev -> error_text2.setText("")));
            timeline.play();
            throw new RuntimeException(e);
        }

        System.out.println(a_mail.getText());
        Mail_background mail_background_task = new Mail_background();
        code = mail_background_task.sendOTP(a_mail.getText());

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("fxml/OTP.fxml"));
        View_manager view = new View_manager();
        view.switch_scene(root, event);

    }

    public void go_send_it_again(ActionEvent event) throws IOException {
        View_manager view = new View_manager();
        Parent root1 = FXMLLoader.load(HelloApplication.class.getResource("fxml/forget_pass1.fxml"));
        view.switch_scene(root1, event);
    }


    public void go_new_pass(ActionEvent event) throws IOException {

        if(otp_code.getText().isBlank())
        {
            error_text3.setText("Code cannot be blank");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> error_text3.setText("")));
            timeline.play();
        }
        else
        {
            if(otp_code.getText().equals(String.valueOf(code)))
            {
                View_manager view = new View_manager();
                Parent root1 = FXMLLoader.load(HelloApplication.class.getResource("fxml/create_new_pass.fxml"));
                view.switch_scene(root1,event);
            }
            else
            {
                error_text3.setText("Code do not match");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> error_text3.setText("")));
                timeline.play();
            }
        }
    }

    @FXML
    private Button close_btn;

    public void close(ActionEvent event) throws IOException {

        String tnew = new_pass.getText();
        String tconfirm = confirm_pass.getText();

        if(new_pass.getText().isBlank() || confirm_pass.getText().isBlank())
        {
            error_text4.setText("Field cannot be empty");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> error_text4.setText("")));
            timeline.play();
        }

        else if(!new_pass.getText().equals(confirm_pass.getText()))
        {
            error_text4.setText("Passwords do not match");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), ev-> error_text4.setText("")));
            timeline.play();
        }
        else
        {
            try
            {
                File path = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/" + forget1.getAcc_type() +"/" + forget1.getLang() +"/"+ forget1.getEmail() +"/info.txt");
                Scanner sc = new Scanner(path);

                sc.useDelimiter("\n");

                String p = sc.next();
                String l1 = p;
                p = sc.next();
                String l2 = p;
                p = sc.next();
                String l3 = p;
                p = sc.next();
                String l4 = p;
                p = sc.next();
                String l5 = p;
                p = sc.next();
                String l6 = p;
                p = sc.next();
                String l7 = p;
                p = sc.next();
                String l8 = p;
                p = sc.next();
                String l9 = p;
                p = sc.next();
                String l10 = p;


                BufferedWriter writer = new BufferedWriter(new FileWriter(path));

                writer.write(l1 + "\n");
                writer.write(l2 + "\n");
                writer.write(l3 + "\n");
                writer.write(tnew + "\n");
                writer.write(l5 + "\n");
                writer.write(l6 + "\n");
                writer.write(l7 + "\n");
                writer.write(l8 + "\n");
                writer.write(l9 + "\n");
                writer.write(l10 + "\n");
                writer.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            View_manager view = new View_manager();
            view.close_stage(close_btn);
        }

    }
}
