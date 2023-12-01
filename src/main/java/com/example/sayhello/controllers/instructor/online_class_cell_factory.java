package com.example.sayhello.controllers.instructor;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.online;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;
public class online_class_cell_factory extends ListCell<online> {


    protected void updateItem(online on, boolean empty) {
        super.updateItem(on, empty);

        if(empty || on == null) {

            setText(null);
            setGraphic(null);

        }

        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/online_class_cell.fxml"));
            online_class_cell_controller onlineclassCellController = new online_class_cell_controller(on);
            fxmlLoader.setController(onlineclassCellController);
            setText(null);

            try { setGraphic(fxmlLoader.load());}
            catch (IOException e) { e.printStackTrace(); }
        }
    }

}
