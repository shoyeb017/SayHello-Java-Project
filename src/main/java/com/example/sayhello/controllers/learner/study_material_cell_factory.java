package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.study;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class study_material_cell_factory extends ListCell<study> {


    protected void updateItem(study on, boolean empty) {
        super.updateItem(on, empty);

        if(empty || on == null) {

            setText(null);
            setGraphic(null);

        }

        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/study_material_cell.fxml"));
            study_material_cell_controller studyCellController = new study_material_cell_controller(on);
            fxmlLoader.setController(studyCellController);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }
        }
    }

}
