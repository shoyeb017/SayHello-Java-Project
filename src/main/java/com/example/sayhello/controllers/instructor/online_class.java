package com.example.sayhello.controllers.instructor;

import com.example.sayhello.model.course;
import com.example.sayhello.model.online;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Scanner;

public class online_class implements Initializable {

    public ComboBox<String> hr= new ComboBox<>();
    public ComboBox<String> min= new ComboBox<>();
    public ComboBox<String> ampm= new ComboBox<>();

    @FXML
    private AnchorPane b1;

    @FXML
    private DatePicker cal = new DatePicker();

    @FXML
    private TextField tdes;

    @FXML
    private TextField tlink;

    @FXML
    private TextField tname;


    @FXML
    private Label error_text;

    @FXML
    private ListView<online> online_view;
    private ObservableList<online> onlineObservableList;

    static online c2= new online();
    static course c= new course();
    void set_log(course ins)
    {
        c = ins;
    }


    @FXML
    void open_bar(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(b1);
        slide.setToY(630);
        slide.play();
    }

    @FXML
    void close_bar(MouseEvent event) {

        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(b1);
        slide.setToY(-630);
        slide.play();
    }

    @FXML
    void add_bar(MouseEvent event) throws IOException {

        if (tname.getText().isBlank() || tdes.getText().isBlank() || tlink.getText().isBlank() || hr.getValue() == null || min.getValue() == null || ampm.getValue() == null  || cal.getValue() == null) {
            error_text.setText("Please fill all the fields");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new javafx.animation.KeyFrame(Duration.seconds(2), evt -> error_text.setText("")));
            timeline.play();
        }

        else {
            online online1 = new online();

            online1.setTopic_name(tname.getText());
            online1.setTopic_description(tdes.getText());
            online1.setClass_link(tlink.getText());

            String time = hr.getValue() + "  " + min.getValue() + " " + ampm.getValue();
            LocalDate myDate = cal.getValue();
            String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));

            online1.setSchedule(time + "  " + myFormattedDate);

            File userFile0 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + c.getTeaching_language() + "/" + c.getEmail() + "/" + "course" + "/" + c.getCourse_code() + "/" + "online");
            boolean is_user_file_created0 = userFile0.mkdir();

            File userFile = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + c.getTeaching_language() + "/" + c.getEmail() + "/" + "course" + "/" + c.getCourse_code() + "/" + "online" + "/" + online1.getSchedule());

            if (!userFile.exists()) {
                boolean is_user_file_created = userFile.mkdir();
                System.out.println(is_user_file_created);

                File infoFile1 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + c.getTeaching_language() + "/" + c.getEmail() + "/" + "course" + "/" + c.getCourse_code() + "/" + "online" + "/" + online1.getSchedule() + "/online_class.txt");

                FileWriter writer = new FileWriter(infoFile1, true);

                writer.write(online1.getTopic_name() + "\n");
                writer.write(online1.getSchedule() + "\n");
                writer.write(online1.getClass_link() + "\n");
                writer.write(online1.getTopic_description() + "\n");
                writer.close();

                onlineObservableList.add(online1);

                tname.clear();
                tdes.clear();
                tlink.clear();
                hr.setValue(null);
                min.setValue(null);
                ampm.setValue(null);
                cal.setValue(null);
            }
        }

    }

    public void view_history() throws FileNotFoundException {

        onlineObservableList = FXCollections.observableArrayList();
        set_items();
        online_view.setItems(onlineObservableList);
        online_view.setCellFactory(online_view -> new online_class_cell_factory());
    }

    public void set_items() throws FileNotFoundException {

        File directory = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language()+"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code()+ "/" + "online" );

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String n1= c.getTeaching_language();
                        String e1= c.getEmail();
                        String c1= c.getCourse_code();
                        String s1= fileOrDir.getName();

                        get_learner(n1,e1,c1,s1);

                        onlineObservableList.add(c2);
                    }
                }
            }
        }
    }


    void get_learner(String n,String e, String c,String s) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + n + "/" + e + "/" + "course" + "/" + c +  "/" + "online" + "/" + s + "/online_class.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String tn = sc.next();
            String sd = sc.next();
            String cl = sc.next();
            String td = sc.next();

            c2 = new online(tn,td,sd,cl);
            sc.close();
        }

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        b1.setLayoutY(-330);

        for (int hour = 1; hour <= 12; hour++) {
            hr.getItems().add(String.format("%02d", hour));
        }
        for (int minute = 0; minute < 60; minute ++) {
            min.getItems().add(String.format("%02d", minute));
        }
        ampm.getItems().addAll("AM", "PM");


        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
