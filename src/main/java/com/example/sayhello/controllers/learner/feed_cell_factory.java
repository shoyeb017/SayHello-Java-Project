package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.feed_class;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class feed_cell_factory extends ListCell<feed_class> {


    protected void updateItem(feed_class feed1, boolean empty) {
        super.updateItem(feed1, empty);

        if(empty || feed1 == null) {

            setText(null);
            setGraphic(null);

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/feed_cell.fxml"));

            feed_cell_controller find = new feed_cell_controller(feed1);
            fxmlLoader.setController(find);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }

            }

        }

    }
