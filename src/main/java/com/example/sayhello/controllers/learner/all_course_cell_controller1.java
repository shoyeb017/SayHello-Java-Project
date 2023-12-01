package com.example.sayhello.controllers.learner;


import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.course;
import com.example.sayhello.model.learner;
import com.example.sayhello.view_manager.View_manager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class all_course_cell_controller1 implements Initializable
{

    public course course1;
    public all_course_cell_controller1(course course1) {
        this.course1 = course1;
    }
    public all_course_cell_controller1() {

    }

    static learner learner1 = new learner();
    public void set_learner_allcourse(learner l)
    {
        learner1 = l;
    }

    @FXML
    private Label c_code;

    @FXML
    private Label c_description;

    @FXML
    private Label c_name;

    @FXML
    private AnchorPane gridPane;
    @FXML
    private AnchorPane arrow;

    @FXML
    //private FontAwesomeIconView arrow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        c_code.setText(course1.getCourse_code());
        c_name.setText(course1.getCourse_name());
        c_description.setText(course1.getCourse_description());
        arrow.setOnMouseClicked(MouseEvent -> go_inbox());
    }
/*
        String p = learner3.getProfile_img();
        // System.out.println(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));

        f_name.setText(learner3.getFirst_name());

        arrow.setOnMouseClicked(MouseEvent -> go_inbox());*/

    static AnchorPane danchore = new AnchorPane();

    public void go_enroll() throws IOException {

        File userFile_enroll = new File("src/main/resources/com/example/sayhello/file/instructor/" + course1.getTeaching_language()+ "/" + course1.getEmail() + "/" + "enroll_now" );
        boolean is_user_file_created1 = userFile_enroll.mkdir();
        File userFile1_enroll= new File("src/main/resources/com/example/sayhello/file/instructor/" + course1.getTeaching_language()+ "/" + course1.getEmail() + "/" + "enroll_now" + "/" + learner1.getEmail());
        boolean is_user_file_created11 = userFile1_enroll.mkdir();
        File userFile2_enroll= new File("src/main/resources/com/example/sayhello/file/instructor/" + course1.getTeaching_language()+ "/" + course1.getEmail() + "/" + "enroll_now" + "/" + learner1.getEmail()+ "/" + "info.txt");
        FileWriter writer1 = new FileWriter(userFile2_enroll);
        writer1.write(learner1.getNative_language() + "\n");
        writer1.close();

        File userFile = new File("src/main/resources/com/example/sayhello/file/learner/" + learner1.getNative_language()+ "/" + learner1.getEmail() + "/" + "enroll_now" );

        File userFile1 = new File("src/main/resources/com/example/sayhello/file/learner/" + learner1.getNative_language()+ "/" + learner1.getEmail() + "/" + "enroll_now"  + "/" + "info.txt");

        if(!userFile.exists())
        {
            boolean is_user_file_created = userFile.mkdir();

            FileWriter writer = new FileWriter(userFile1);
            writer.write(0 + "\n");
            writer.write(0 + "\n");
            writer.close();
        }
    }

    public void go_inbox (){
//        System.out.println("clicked   "+learner3.getEmail());
//        chat_inbox ch_in = new chat_inbox();
//        ch_in.set_log_u(learner3);

//        course_details cd = new course_details();
//        cd.set_course_details(course1);
//        online_class oc = new online_class();
//        oc.set_log(course1);
//        study_material sm = new study_material();
//        sm.set_log(course1);

        course_details cd = new course_details();
        cd.set_course_details(course1);
        online_class oc = new online_class();
        oc.set_log(course1);
        study_material sm = new study_material();
        sm.set_log(course1);
        group_chat gc = new group_chat();
        gc.set_course(course1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/course_details.fxml"));

        try {
            go_enroll();
            view.close_stage(arrow);
            view.create_stage(fxmlLoader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }


}
