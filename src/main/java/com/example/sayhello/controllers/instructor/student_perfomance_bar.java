package com.example.sayhello.controllers.instructor;

import com.example.sayhello.model.learner;
import com.example.sayhello.model.perfomance_calculation;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class student_perfomance_bar implements Initializable , perfomance_calculation {

    @FXML
    private FontAwesomeIconView c1;

    @FXML
    private FontAwesomeIconView c10;

    @FXML
    private FontAwesomeIconView c2;

    @FXML
    private FontAwesomeIconView c3;

    @FXML
    private FontAwesomeIconView c4;

    @FXML
    private FontAwesomeIconView c5;

    @FXML
    private FontAwesomeIconView c6;

    @FXML
    private FontAwesomeIconView c7;

    @FXML
    private FontAwesomeIconView c8;

    @FXML
    private FontAwesomeIconView c9;

    private FontAwesomeIconView fne = new FontAwesomeIconView();

    @FXML
    private AnchorPane gridPane;

    @FXML
    private Label name;

    @FXML
    private Label rate;

    static learner learner1 = new learner();

    public void set_learner1(learner l)
    {
        this.learner1= l;
    }

    static int count=0;

    @FXML
    void c1(MouseEvent event) {
        count = 1;
        rate.setText("1");
        fne=c1;
    }

    @FXML
    void c10(MouseEvent event) {

        count = 10;
        rate.setText("10");
        fne=c10;
    }

    @FXML
    void c2(MouseEvent event) {
        count = 2;
        rate.setText("2");
        fne=c2;
    }

    @FXML
    void c3(MouseEvent event) {

        count = 3;
        rate.setText("3");
        fne=c3;
    }

    @FXML
    void c4(MouseEvent event) {

        count = 4;
        rate.setText("4");
        fne=c4;
    }

    @FXML
    void c5(MouseEvent event) {

        count = 5;
        rate.setText("5");
        fne=c5;
    }

    @FXML
    void c6(MouseEvent event) {

        count = 6;
        rate.setText("6");
        fne=c6;
    }

    @FXML
    void c7(MouseEvent event) {

        count = 7;
        rate.setText("7");
        fne=c7;
    }

    @FXML
    void c8(MouseEvent event) {

        count = 8;
        rate.setText("8");
        fne=c8;
    }

    @FXML
    void c9(MouseEvent event) {

        count = 9;
        rate.setText("9");
        fne=c9;
    }

    public int update_average(int old_average,int  num_ratings,int  new_rating)
    {
        int new_average = ((old_average * num_ratings) + new_rating) / (num_ratings + 1);
        return new_average;
    }

    @FXML
    void go_done(ActionEvent event) throws IOException {

        File userFile1 = new File("src/main/resources/com/example/sayhello/file/learner/" + learner1.getNative_language()+ "/" + learner1.getEmail() + "/" + "enroll_now"  + "/" + "info.txt");

        if(userFile1.exists())
        {
            Scanner sc = new Scanner(userFile1);
            sc.useDelimiter("\n");

            int l1 = Integer.parseInt(sc.next());
            int l2 = Integer.parseInt(sc.next());
            System.out.println("l1="+l1);
            System.out.println("l2="+l2);

            sc.close();

            int ne = update_average(l1,l2,count);
            System.out.println("ne="+ne);


            FileWriter writer = new FileWriter(userFile1);
            writer.write( ne + "\n");
            writer.write(l2+1 + "\n");
            writer.close();

        }
        View_manager view = new View_manager();
        view.close_stage(fne);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(learner1.getFirst_name()+" "+learner1.getLast_name());
    }
}