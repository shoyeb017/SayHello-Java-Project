package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.feed_class;
import com.example.sayhello.model.learner;
import com.example.sayhello.view_manager.number_generate;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
public class feed implements Initializable {

    static learner learner1 = new learner();
    static feed_class feed_class2 = new feed_class();

    public void set_log(learner lern) {
        learner1 = lern;
    }

    @FXML
    private ListView<feed_class> partner_view;
    private ObservableList<feed_class> partnerObservableList;

    @FXML
    private Circle dp;

    @FXML
    private TextField text;
    @FXML
    private Label i1;

    public String img = "null";
    @FXML
    void upload(MouseEvent event) {
        FileChooser ch= new FileChooser();
        File file = ch.showOpenDialog(null);
        String p = file.toURI().toString();
        img = p;
        i1.setText("Image Uploaded");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> i1.setText("\0")));
        timeline.play();
    }

    @FXML
    void go_post(ActionEvent event) throws IOException {

        String t = text.getText();

        if(!t.isEmpty())
        {
            text.clear();

            number_generate number_generate1 = new number_generate();
            String p = number_generate1.generate_number();


            File userFile = new File("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getNative_language() +"/"+learner1.getEmail()+ "/"+"post");
            boolean is_user_file_created = userFile.mkdir();

            File userFile1 = new File("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getNative_language() +"/"+learner1.getEmail()+ "/post/"+ p);
            boolean is_user_file_created1 = userFile1.mkdir();

            String directoryPath = ("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getNative_language() +"/"+learner1.getEmail()+ "/post/"+ p +"/post.txt");
            feed_class2.setC_path(directoryPath);

            File infoFile = new File("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getNative_language() +"/"+learner1.getEmail()+ "/post/"+ p +"/post.txt");
            FileWriter writer = new FileWriter(infoFile,true);
            writer.write(learner1.getFirst_name()+" "+learner1.getLast_name() + "\n");
            writer.write(learner1.getProfile_img() + "\n");
            writer.write(t + "\n");
            writer.write("0" + "\n");
            writer.write(directoryPath + "\n");
            writer.write(img+ "\n");
            writer.close();

            feed_class msg = new feed_class(learner1.getFirst_name()+" "+learner1.getLast_name(), learner1.getProfile_img() , t ,0, directoryPath, img);
            partnerObservableList.add(msg);
        }
        else
        {
            i1.setText("Please Enter Text");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> i1.setText("\0")));
            timeline.play();
        }

    }

    public void view_history() throws FileNotFoundException {

        partnerObservableList = FXCollections.observableArrayList();

        set_items();
        set_items_me();

        partner_view.setItems(partnerObservableList);

        partner_view.setCellFactory(partner_view -> new feed_cell_factory());
    }

    public void set_items_me() throws FileNotFoundException {

        String directoryPath = ("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getNative_language() +"/"+ learner1.getEmail() + "/" + "post");

        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] filesAndDirs = directory.listFiles();

            if (filesAndDirs != null) {
                for (File fileOrDir : filesAndDirs) {
                    if (fileOrDir.isDirectory()) {
                        String p= fileOrDir.getName();
                        get_learner_me(p);

                    }
                }
            }
        }
    }
    void get_learner_me(String p) throws FileNotFoundException {

        File infoFile2 = new File("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getNative_language() +"/"+ learner1.getEmail() + "/" + "post" + "/" + p + "/" + "post.txt");

        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String l1 = sc.next();
            String l2 = sc.next();
            String l3 = sc.next();
            String l4 = sc.next();
            String l5 = sc.next();
            String l6 = sc.next();

            feed_class2 = new feed_class(l1,l2,l3,Integer.parseInt(l4),l5,l6);
            sc.close();

            partnerObservableList.add(feed_class2);
        }

    }

    public void set_items() throws FileNotFoundException {

            String directoryPath = ("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getLearning_language()+ "/");

            File directory = new File(directoryPath);

            // Check if the directory exists
            if (directory.exists() && directory.isDirectory()) {
                // List the files and subdirectories in the directory
                File[] filesAndDirs = directory.listFiles();

                if (filesAndDirs != null) {
                    for (File fileOrDir : filesAndDirs) {
                        if (fileOrDir.isDirectory()) {
                            String e1= fileOrDir.getName();
                            get_learner(e1);
                        }
                    }
                }
            }
    }


    void get_learner(String e) throws FileNotFoundException {


        File infoFile2 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + learner1.getLearning_language() + "/" + e + "/info.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String fn = sc.next();
            String ln = sc.next();
            String em = sc.next();
            String pa = sc.next();
            String gen = sc.next();
            String fr = sc.next();
            String na = sc.next();
            String le = sc.next();

            String pr = sc.next();

            String bi = sc.next();

            sc.close();

            if(le.equals(learner1.getNative_language())) {

                String directoryPath = ("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getLearning_language() +"/"+ e + "/" + "post");

                File directory = new File(directoryPath);

                // Check if the directory exists
                if (directory.exists() && directory.isDirectory()) {
                    // List the files and subdirectories in the directory
                    File[] filesAndDirs = directory.listFiles();

                    if (filesAndDirs != null) {
                        for (File fileOrDir : filesAndDirs) {
                            if (fileOrDir.isDirectory()) {
                                String p= fileOrDir.getName();
                                get_learner2(e,p);

                            }
                        }
                    }
                }

            }
        }

    }

    void get_learner2(String e,String p) throws FileNotFoundException {

        File infoFile2 = new File("src/main/resources/com/example/sayhello/file/learner/"+ learner1.getLearning_language() +"/"+ e + "/" + "post" + "/" + p + "/" + "post.txt");

        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);

            sc.useDelimiter("\n");

            String l1 = sc.next();
            String l2 = sc.next();
            String l3 = sc.next();
            String l4 = sc.next();
            String l5 = sc.next();
            String l6 = sc.next();

            feed_class2 = new feed_class(l1,l2,l3,Integer.parseInt(l4),l5,l6);
            sc.close();

            partnerObservableList.add(feed_class2);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //feed_class2.setImg_path("null");

        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String p = learner1.getProfile_img();
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));
    }
}
