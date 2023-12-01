package com.example.sayhello.controllers.instructor;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class student_cell_factory extends ListCell<learner> {


    protected void updateItem(learner co, boolean empty) {
        super.updateItem(co, empty);

        if(empty || co == null) {

            setText(null);
            setGraphic(null);

        }

        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/student_cell.fxml"));
            student_cell_controller CellController = new student_cell_controller(co);
            fxmlLoader.setController(CellController);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }
        }
    }

}
