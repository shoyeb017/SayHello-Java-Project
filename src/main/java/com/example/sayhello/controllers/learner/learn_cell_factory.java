package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.instructor;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class learn_cell_factory extends ListCell<instructor> {


    protected void updateItem(instructor ins, boolean empty) {
        super.updateItem(ins, empty);

        if(empty || ins == null) {

            setText(null);
            setGraphic(null);

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/learn_cell.fxml"));
            learn_cell_controller learn = new learn_cell_controller(ins);
            fxmlLoader.setController(learn);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }

        }

    }

}
