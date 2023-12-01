package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;
public class chat_cell_factory extends ListCell<learner> {



    learner learner3 = new learner();

    protected void updateItem(learner learner2, boolean empty) {
        super.updateItem(learner2, empty);

        if(empty || learner2 == null) {

            setText(null);
            setGraphic(null);

        }

        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/chat_cell.fxml"));
            chat_cell_controller chatCellController = new chat_cell_controller(learner2);
            fxmlLoader.setController(chatCellController);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }
        }
        }

    }
