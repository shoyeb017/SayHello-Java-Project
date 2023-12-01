package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.feed_class;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class feed_cell_controller implements Initializable {

    @FXML
    private Label count;

    @FXML
    private Circle dp;

    @FXML
    private AnchorPane d1;

    @FXML
    private Label name;

    @FXML
    private Label text;

    @FXML
    private FontAwesomeIconView translate1;
    @FXML
    private FontAwesomeIconView like1;

    public feed_class feed_class2;
    public feed_cell_controller(feed_class fee) {
        feed_class2 = fee;
    }

    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        String p = feed_class2.getDp();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        name.setText(feed_class2.getName());
        name.setStyle("-fx-text-fill: black;");

        text.setText(feed_class2.getMassage());
        text.setStyle("-fx-text-fill: black;");

        count.setText(String.valueOf(feed_class2.getCount()));
        count.setStyle("-fx-text-fill: black;");

        if(!feed_class2.getImg_path().equals("null")) {
            Image imag = new Image(feed_class2.getImg_path()); // Replace with the path to your image file
            ImageView imageView = new ImageView(imag);

            // Setting the fit width and fit height to fix the size
            imageView.setFitWidth(150); // Set your desired width
            imageView.setFitHeight(150); // Set your desired height

            d1.getChildren().add(imageView);
        }

        translate1.setOnMouseClicked(MouseEvent -> go_translate());

        like1.setOnMouseClicked(MouseEvent -> go_like());
    }

    public void go_translate ()  {

        feed_cell_translate find = new feed_cell_translate();
        find.set_feed(feed_class2);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/feed_cell_translate.fxml"));
        try {

            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int i =0;
    public void go_like ()  {

        i++;
        count.setText(String.valueOf(i));

    }
}
