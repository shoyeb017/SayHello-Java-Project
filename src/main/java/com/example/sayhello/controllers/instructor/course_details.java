package com.example.sayhello.controllers.instructor;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.course;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class course_details implements Initializable {

    @FXML
    private Label c_code;

    @FXML
    private Label c_description;

    @FXML
    private Label c_name;

    @FXML
    private AnchorPane danchore;

    @FXML
    private Circle dp;

    @FXML
    private Label dp_text1;

    @FXML
    private Label dp_text2;

    @FXML
    private Label dp_text4;

    @FXML
    private FontAwesomeIconView exit;

    static public course course1;

    public void set_course_details(course course2)
    {
        this.course1 = course2;
    }

    @FXML
    void go_exit(MouseEvent event) {
        View_manager view_manager = new View_manager();
        view_manager.close_stage(exit);
    }

    @FXML
    void go_group_chat(MouseEvent event) throws IOException {

        group_chat g_chat = new group_chat();
        g_chat.set_course(course1);
        group_chat_cell g_cell = new group_chat_cell();
        g_cell.set_course(course1);

        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/group_chat.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);

    }

    @FXML
    void go_online_class(MouseEvent event) throws IOException {

        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/online_class.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    @FXML
    void go_study_material(MouseEvent event) throws IOException {
        AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/study_material.fxml")));
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }

    public void update()
    {
        c_code.setText("#"+course1.getCourse_code());
        c_name.setText(course1.getCourse_name());
        c_description.setText(course1.getCourse_description());

        String p = course1.getProfile_img();
        //System.out.println(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        dp_text1.setText(course1.getFirst_name() + " " + course1.getLast_name());
        dp_text2.setText(course1.getEmail());

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();


        AnchorPane fxml = null;
        try {
            fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/instructor/online_class.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        danchore.getChildren().removeAll();
        danchore.getChildren().setAll(fxml);
    }
}
