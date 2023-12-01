package com.example.sayhello.controllers.instructor;

import com.example.sayhello.model.course;
import com.example.sayhello.model.study;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class study_material implements Initializable {

    public ComboBox<String> type= new ComboBox<>();

    @FXML
    private AnchorPane b1;

    @FXML
    private TextField tdes;

    @FXML
    private TextField tlink;

    @FXML
    private TextField tname;

    @FXML
    private TextField tno;

    @FXML
    private Label error_text;

    @FXML
    private FontAwesomeIconView upload;

    @FXML
    private ListView<study> study_view;
    private ObservableList<study> studyObservableList;

    static study c2= new study();
    static course c= new course();
    public static study study1 = new study();
    void set_log(course ins)
    {
        c = ins;
    }


    @FXML
    void upload(MouseEvent event) {
        FileChooser ch= new FileChooser();
        File file = ch.showOpenDialog(null);
        String p = file.toURI().toString();
        study1.setStudy_link(p);
        tlink.setText(p);
    }

    @FXML
    void open_bar(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(b1);
        slide.setToY(-330);
        slide.play();
    }

    @FXML
    void close_bar(MouseEvent event) {

        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(b1);
        slide.setToY(330);
        slide.play();
    }

    @FXML
    void add_bar(MouseEvent event) throws IOException {

        study1.setTopic_name(tname.getText());
        study1.setTopic_description(tdes.getText());
        study1.setTopic_no(tno.getText());
        study1.setType(type.getValue());

        if (tname.getText().isBlank() || tdes.getText().isBlank() || tno.getText().isBlank() || type.getValue() == null || tlink.getText().isBlank() ) {
            error_text.setText("Please fill all the fields");
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new javafx.animation.KeyFrame(Duration.seconds(2), evt -> error_text.setText("")));
            timeline.play();
        }

        else {
            File userFile0 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + c.getTeaching_language() + "/" + c.getEmail() + "/" + "course" + "/" + c.getCourse_code() + "/" + "study_material");
            boolean is_user_file_created0 = userFile0.mkdir();

            File userFile = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + c.getTeaching_language() + "/" + c.getEmail() + "/" + "course" + "/" + c.getCourse_code() + "/" + "study_material" + "/" + study1.getTopic_no());

            if (!userFile.exists()) {
                boolean is_user_file_created = userFile.mkdir();
                System.out.println(is_user_file_created);

                File infoFile1 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + c.getTeaching_language() + "/" + c.getEmail() + "/" + "course" + "/" + c.getCourse_code() + "/" + "study_material" + "/" + study1.getTopic_no() + "/study.txt");

                FileWriter writer = new FileWriter(infoFile1, true);

                writer.write(study1.getTopic_no() + "\n");
                writer.write(study1.getTopic_name() + "\n");
                writer.write(study1.getStudy_link() + "\n");
                writer.write(study1.getType() + "\n");
                writer.write(study1.getTopic_description() + "\n");

                writer.close();

                studyObservableList.add(study1);

                tname.clear();
                tdes.clear();
                tlink.clear();
                type.setValue(null);
            }

        }
    }

    public void view_history() throws FileNotFoundException {

        studyObservableList = FXCollections.observableArrayList();
        set_items();
        study_view.setItems(studyObservableList);
        study_view.setCellFactory(study_view -> new study_material_cell_factory());
    }

    public void set_items() throws FileNotFoundException {

        File directory = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/"+ c.getTeaching_language()+"/"+ c.getEmail()+"/"+  "course" + "/" +c.getCourse_code()+ "/" + "study_material" );

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

                        studyObservableList.add(c2);
                    }
                }
            }
        }
    }


    void get_learner(String n,String e, String c,String s) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/instructor/" + n + "/" + e + "/" + "course" + "/" + c +  "/" + "study_material" + "/" + s + "/study.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String tno = sc.next();
            String tn = sc.next();
            String cho = sc.next();
            String tm = sc.next();
            String td = sc.next();

            c2 = new study(tno,tn,cho,tm,td);
            sc.close();
        }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        type.getItems().addAll("Video", "PDF", "Photo", "Audio", "Text", "Other");


        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
