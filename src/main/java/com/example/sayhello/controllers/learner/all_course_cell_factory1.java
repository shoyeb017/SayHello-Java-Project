package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.course;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;
public class all_course_cell_factory1 extends ListCell<course> {


    protected void updateItem(course co, boolean empty) {
        super.updateItem(co, empty);

        if(empty || co == null) {

            setText(null);
            setGraphic(null);

        }

        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/all_course_cell.fxml"));
            all_course_cell_controller1 allCourseCellController1 = new all_course_cell_controller1(co);
            fxmlLoader.setController(allCourseCellController1);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }
        }
    }

}
