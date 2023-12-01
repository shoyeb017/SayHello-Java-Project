package com.example.sayhello.controllers.instructor;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.course;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;
public class all_course_cell_factory extends ListCell<course> {


    protected void updateItem(course co, boolean empty) {
        super.updateItem(co, empty);

        if(empty || co == null) {

            setText(null);
            setGraphic(null);

        }

        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/all_course_cell.fxml"));
            all_course_cell_controller allCourseCellController = new all_course_cell_controller(co);
            fxmlLoader.setController(allCourseCellController);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }
        }
    }

}
