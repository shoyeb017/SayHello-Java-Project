package com.example.sayhello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Stage stage11 = new Stage();

        FXMLLoader fxmlLoader11 = new FXMLLoader(HelloApplication.class.getResource("fxml/LoginPage.fxml"));
        Scene scene11 = new Scene(fxmlLoader11.load());
//        Image icon = new Image("src/main/resources/com/example/sayhello/image/logo.png");
//        stage11.getIcons().add(icon);
        stage11.getIcons().add(new Image(Objects.requireNonNull(HelloApplication.class.getResource("image/logo.png")).toString()));
        //scene11.setFill(Color.TRANSPARENT);
        stage11.setResizable(false);
        stage11.setTitle("SayHello");
        stage11.setScene(scene11);
//        stage11.initStyle(StageStyle.TRANSPARENT);
        stage11.show();
    }


    public static void main(String[] args) {
        launch();
    }
}