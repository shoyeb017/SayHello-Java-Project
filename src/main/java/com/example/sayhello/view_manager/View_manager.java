package com.example.sayhello.view_manager;

import com.example.sayhello.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class View_manager {


    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switch_scene(Parent root, EventObject event) throws IOException
    {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setTitle("SayHello");
        //stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/logo.png")).toString()));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public <type> void create_stage(type fxmlLoader) throws IOException
    {
        Scene scene = null;
        if(fxmlLoader instanceof FXMLLoader) scene = new Scene(((FXMLLoader) fxmlLoader).load());
        else if(fxmlLoader instanceof ScrollPane) scene = new Scene((ScrollPane)fxmlLoader);

        Stage stage=new Stage();
        stage.setTitle("SayHello");
        stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("image/logo.png")).toString()));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public <type> void create_stage(type fxmlLoader,int x,int y) throws IOException
    {
        //aspect ratio x : y;
        Scene scene = null;
        if(fxmlLoader instanceof FXMLLoader) scene = new Scene(((FXMLLoader) fxmlLoader).load(),x,y);
        else if(fxmlLoader instanceof ScrollPane) scene = new Scene((ScrollPane)fxmlLoader,x,y);

        Stage stage=new Stage();
        stage.setTitle("SayHello");
        //stage.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("images/logo.png")).toString()));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void close_stage(Node node)
    {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void close_stage(Button button)
    {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
