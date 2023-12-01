package com.example.sayhello.controllers.instructor;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.online;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class online_class_cell_controller implements Initializable
{

    @FXML
    private FontAwesomeIconView arrow;

    @FXML
    private Hyperlink class_link;

    @FXML
    private Label schedule;

    @FXML
    private Label t_name;

    public online online1;
    public online_class_cell_controller(online on) {
        this.online1 = on;
    }


    public void web(ActionEvent event) throws Exception
    {

        // Create Desktop object
        Desktop d=Desktop.getDesktop();

        // Browse a URL, say google.com
        d.browse(new URI(online1.getClass_link()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        t_name.setText(online1.getTopic_name());
        schedule.setText(online1.getSchedule());
        //class_link.setText(online1.getClass_link());

         arrow.setOnMouseClicked(MouseEvent -> go_inbox());
    }



    public void go_inbox ()  {

        online_class_cell_bar_view one = new online_class_cell_bar_view();
        one.set_online_class_cell_control(online1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/online_class_cell_bar_view.fxml"));

        try {
            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
