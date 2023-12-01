package com.example.sayhello.controllers.instructor;

import com.example.sayhello.model.study;
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

public class study_material_cell_bar_view implements Initializable {

    @FXML
    private Label t_des;

    @FXML
    private Hyperlink t_link;

    @FXML
    private Label t_name;


    @FXML
    private FontAwesomeIconView exit;

    static public study study1 = new study();
    public void study_material_cell_bar_view(study on) {
        study1 = on;
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
        d.browse(new URI(study1.getStudy_link()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t_des.setText(study1.getTopic_description());
        t_name.setText(study1.getTopic_name());
        t_link.setText(study1.getStudy_link());
    }
}