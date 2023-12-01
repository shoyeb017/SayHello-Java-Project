package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class find_partner_cell_factory extends ListCell<learner> {


    protected void updateItem(learner learner2, boolean empty) {
        super.updateItem(learner2, empty);

        if(empty || learner2 == null) {

            setText(null);
            setGraphic(null);

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/find_partner_cell.fxml"));
            System.out.println("here"+ learner2.getFirst_name());
            find_partner_cell_controller find= new find_partner_cell_controller(learner2);
            fxmlLoader.setController(find);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }

            }

        }

    }
