package com.example.sayhello.controllers.instructor;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class add_course_cell extends ListCell<course> {


    @FXML
    private Label c_description;

    @FXML
    private Label c_name;
    @FXML
    private Label c_code;
    @FXML
    public AnchorPane gridPane;
    private FXMLLoader mLLoader;

    protected void updateItem(course co, boolean empty) {
        super.updateItem(co, empty);

        if (empty || co == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/add_course_cell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            c_name.setText(co.getCourse_name());
            c_description.setText(co.getCourse_description());
            c_code.setText(co.getCourse_code());

            setText(null);
            setGraphic(gridPane);


        }

    }

}
