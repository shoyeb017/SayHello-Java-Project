package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.study;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class study_material_cell_controller implements Initializable
{

    @FXML
    private FontAwesomeIconView arrow;

    @FXML
    private Label type;

    @FXML
    private Label t_name;

    public study study1;
    public study_material_cell_controller(study on) {
        this.study1 = on;
    }

    private File file;


    public void web(ActionEvent event) throws Exception
    {

        if(study1.getType().equals("Video"))
        {
            View_manager view = new View_manager();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/video_player.fxml"));

            video_player vp = new video_player();
            vp.setFile_path(study1.getStudy_link());

            view.create_stage(fxmlLoader);
        }

        else {
            // Create Desktop object
            Desktop d=Desktop.getDesktop();
            // Browse a URL, say google.com
            d.browse(new URI(study1.getStudy_link()));
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        t_name.setText(study1.getTopic_name());
        //class_link.setText(online1.getClass_link());
        type.setText(study1.getType());

         arrow.setOnMouseClicked(MouseEvent -> go_inbox());
    }



    public void go_inbox ()  {

        study_material_cell_bar_view study_bar = new study_material_cell_bar_view();
        study_bar.study_material_cell_bar_view(study1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/study_material_cell_bar_view.fxml"));

        try {
            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
