package com.example.sayhello.controllers;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class contactus implements Initializable {

    @FXML
    private AnchorPane slide= new AnchorPane();
    @FXML
    private Text text1= new Text();
    @FXML
    private HBox fb= new HBox();
    @FXML
    private HBox ig= new HBox();
    @FXML
    private HBox tt= new HBox();
    @FXML
    private Button b= new Button();
    @FXML
    private Button submit= new Button();
    @FXML
    private TextField subject= new TextField();
    @FXML
    private TextArea msg= new TextArea();
    @FXML
    public void exit()
    {
        //close stage
        Stage stage = (Stage) slide.getScene().getWindow();
        stage.close();


    }
    @FXML
    public void submit()
    {

        //submit the feedback in mail
        String sub = subject.getText();
        String message = msg.getText();
        Mail_background mail = new Mail_background();
        if(sub.equals(""))
            sub = "No Subject";
        if(!message.equals(""))
        {
            mail.sendEmail(sub,message);
        }



        subject.setText("");
        msg.setText("");
        //make the slide object smaller

        TranslateTransition Slide = new TranslateTransition();
        Slide.setNode(slide);
        Slide.setByY(430);

        Slide.setByX(0);
        Slide.play();
        fb.setVisible(true);
        ig.setVisible(true);
        tt.setVisible(true);
//        b.setVisible(true);
        text1.setVisible(true);




    }
    @FXML
    public void popop()
    {
        //pop up transition of the slide object
        fb.setVisible(false);
        ig.setVisible(false);
        tt.setVisible(false);
//        b.setVisible(false);
        text1.setVisible(false);
        TranslateTransition Slide = new TranslateTransition();
        Slide.setNode(slide);
        Slide.setByY(-430);
        Slide.setByX(0);
        Slide.play();

    }

    @FXML
    public void go_to_fb()
    {
        //open fb page
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.facebook.com/"));
        }
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void go_to_ig()
    {
        //open ig page
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.instagram.com/"));
        }
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void go_to_tt()
    {
        //open twitter page
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://twitter.com/"));
        }
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // pop up transition of the slide object
        fb.setVisible(true);
        ig.setVisible(true);
        tt.setVisible(true);
//        b.setVisible(true);
        text1.setVisible(true);



    }

}
