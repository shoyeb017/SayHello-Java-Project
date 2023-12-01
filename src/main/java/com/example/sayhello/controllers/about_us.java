package com.example.sayhello.controllers;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class about_us {

    @FXML
    private FontAwesomeIconView fb;
    private FontAwesomeIconView ig;
    private FontAwesomeIconView tt;
    @FXML
    private ImageView img;



    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    @FXML
    void go_contact_us(MouseEvent event) throws IOException {
        View_manager view_manager = new View_manager();
        view_manager.close_stage(img);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/contact_us.fxml"));
        view_manager.create_stage(fxmlLoader,1280,760);
    }

    @FXML
    void go_exit(MouseEvent event) {
        View_manager view_manager = new View_manager();
        view_manager.close_stage(img);
    }

    @FXML
    void go_fb(MouseEvent event) throws URISyntaxException, IOException {
        Desktop d =Desktop.getDesktop();
        d.browse(new URI("https://facebook.com/"));
    }

    @FXML
    void go_insta(MouseEvent event) throws URISyntaxException, IOException {
        Desktop d =Desktop.getDesktop();
        d.browse(new URI("https://instagram.com/"));
    }

    @FXML
    void go_twit(MouseEvent event) throws URISyntaxException, IOException {
        Desktop d =Desktop.getDesktop();
        d.browse(new URI("https://twitter.com/"));
    }



}
