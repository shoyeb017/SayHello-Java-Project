package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import com.example.sayhello.model.message;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class chat_inbox_cell extends ListCell<message> {

    static public learner learner3;

    public void set_chat_inbox_cell(learner learner2) {
        this.learner3 = learner2;
    }


    protected void updateItem(message msg, boolean empty) {
        super.updateItem(msg, empty);

        if(empty || msg == null) {

            setText(null);
            setGraphic(null);

        }
        else {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/chat_inbox_cell.fxml"));

                chat_inbox_cell_controller find= new chat_inbox_cell_controller(msg);
                fxmlLoader.setController(find);

                setText(null);

                try { setGraphic(fxmlLoader.load());}
                catch (IOException e) { e.printStackTrace(); }

            }
        }

}

