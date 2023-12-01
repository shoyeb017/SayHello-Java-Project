package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.online;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class online_class_cell_bar_view implements Initializable {

    @FXML
    private Label t_des;

    @FXML
    private Hyperlink t_link;

    @FXML
    private Label t_name;

    @FXML
    private Label t_sd;

    @FXML
    private FontAwesomeIconView exit;

    static public online online1 = new online();
    public void set_online_class_cell_control(online on) {
        online1 = on;
    }

    @FXML
    void go_exit(MouseEvent event) {
        View_manager view_manager = new View_manager();
        view_manager.close_stage(exit);
    }

    public void web(ActionEvent event) throws Exception
    {

        // Create Desktop object
        Desktop d=Desktop.getDesktop();

        // Browse a URL, say google.com
        d.browse(new URI(online1.getClass_link()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t_des.setText(online1.getTopic_description());
        t_name.setText(online1.getTopic_name());
        t_sd.setText(online1.getSchedule());
        t_link.setText(online1.getClass_link());
    }
}