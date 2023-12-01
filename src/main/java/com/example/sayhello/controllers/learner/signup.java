package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import com.example.sayhello.view_manager.InvalidEmailException;
import com.example.sayhello.view_manager.View_manager;
import com.example.sayhello.view_manager.check_email;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class signup implements Initializable {

    @FXML
    public Button complete1 = new Button();

    @FXML
    public AnchorPane lanchore = new AnchorPane();
    public AnchorPane lanchore2 = new AnchorPane();
    public AnchorPane lanchore3 = new AnchorPane();


    @FXML
    private javafx.scene.control.TextField first_name;
    @FXML
    private javafx.scene.control.TextField last_name;
    @FXML
    private javafx.scene.control.TextField email;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField re_pass;
    @FXML
    private ChoiceBox<String> gender = new ChoiceBox<>();
    private String[] gender_value = {"Male","Female"};
    @FXML
    public Label error_text,error_text1,error_text2;


    @FXML
    private ChoiceBox<String> from = new ChoiceBox<>();
    private String[] from_value = {"Bangladesh","USA","Japan","China","Pakistan","Saudi_Arabia"};
    @FXML
    private ChoiceBox<String> native_lang = new ChoiceBox<>();
    private String[] native_lang_value = {"Bengali","English","Japanese","Mandarin","Urdu","Arabic"};
    @FXML
    private ChoiceBox<String> learn_lang = new ChoiceBox<>();
    private String[] learn_lang_value = {"Bengali","English","Japanese","Mandarin","Urdu","Arabic"};

    @FXML
    public RadioButton radio ;
    @FXML
    public Circle dp = new Circle();
    public TextField bio = new TextField();

    View_manager view = new View_manager();
    private Parent root;

    static String fn ;
    static String ln ;
    static String em ;
    static String pa ;
    static String repa ;
    static String gen ;
    static String fr ;
    static String na ;
    static String le ;
    static learner learner = new learner();
    check_email check_mail = new check_email();
    public void switch_learner_signup2(ActionEvent event) throws IOException{

        fn = first_name.getText();
        ln = last_name.getText();
        em = email.getText();
        pa = pass.getText();
        repa = re_pass.getText();
        gen = gender.getValue();

        learner = new learner(fn,ln,em,pa,gen,"","","","","");


        if( learner.getFirst_name().length() > 0 && learner.getLast_name().length() > 0 && learner.getEmail().length() > 0 && learner.getPassword().length() > 0 && repa.length() > 0 && learner.getGender() != null)
        {
            boolean check = false;
            try {
                check = check_mail.isEmailValid(learner.getEmail());
            } catch (InvalidEmailException e) {
                error_text.setText("Invalid Email");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text.setText("\0")));
                timeline.play();
                throw new RuntimeException(e);
            }

            if(pa.equals(repa))
            {
                //AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/learner_signup2.fxml")));
                //lanchore.getChildren().removeAll();
                //lanchore.getChildren().add(fxml);
                root = FXMLLoader.load(HelloApplication.class.getResource("fxml/learner/learner_signup2.fxml"));
                view.switch_scene(root,event);
            }
            else
            {

                    error_text.setText("Password not match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text.setText("\0")));
                    timeline.play();
            }
        }
        else
        {
            error_text.setText("Some field may empty");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text.setText("\0")));
            timeline.play();
        }

    }
    public void switch_learner_signup3(ActionEvent event) throws IOException {
        fr = from.getValue();
        na = native_lang.getValue();
        le = learn_lang.getValue();

        learner = new learner(fn,ln,em,pa,gen,fr,na,le,"","");


        if( learner.getFrom() != null && learner.getNative_language() != null && learner.getLearning_language() != null)
        {
            //AnchorPane fxml = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("fxml/learner/learner_signup3.fxml")));
            //lanchore.getChildren().removeAll();
            //lanchore2.getChildren().add(fxml);
            root = FXMLLoader.load(HelloApplication.class.getResource("fxml/learner/learner_signup3.fxml"));
            view.switch_scene(root,event);
        }
        else
        {
            error_text1.setText("Some field may empty");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text1.setText("\0")));
            timeline.play();
        }

    }

    public void complete_back_login(ActionEvent event) throws IOException {

        learner.setBio_text(bio.getText());

        if(radio.isSelected())
        {
            create_user();
            root = FXMLLoader.load(HelloApplication.class.getResource("fxml/LoginPage.fxml"));
            view.switch_scene(root,event);
        }

        else
        {
            error_text2.setText("Please fill the Dot");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), ae -> error_text2.setText("\0")));
            timeline.play();
        }

    }

    public static void create_user() throws IOException
    {
        System.out.println(learner.getFirst_name());
        System.out.println(learner.getEmail());

        File userFile = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + learner.getNative_language());
        boolean is_user_file_created = userFile.mkdir();
        System.out.println(is_user_file_created);

        File userFile1 = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/"+learner.getNative_language()+"/"+ learner.getEmail());
        boolean is_user_file_created1 = userFile1.mkdir();
        System.out.println(is_user_file_created1);

        File infoFile = new File("D:/Java Project/learner/src/main/resources/com/example/sayhello/file/learner/" + learner.getNative_language()+"/"+ learner.getEmail()+"/info.txt");
        FileWriter writer = new FileWriter(infoFile);
        writer.write(learner.getFirst_name() + "\n");
        writer.write(learner.getLast_name()  + "\n");
        writer.write(learner.getEmail()  + "\n");
        writer.write(learner.getPassword() + "\n");
        writer.write(learner.getGender() + "\n");
        writer.write(learner.getFrom()  + "\n");
        writer.write(learner.getNative_language() + "\n");
        writer.write(learner.getLearning_language()+ "\n");
        writer.write(learner.getProfile_img()+ "\n");
        writer.write(learner.getBio_text()+ "\n");
        writer.close();
    }

    public void upload_photo(ActionEvent event) throws IOException {
        FileChooser ch= new FileChooser();
        File file = ch.showOpenDialog(null);
        String p = file.toURI().toString();
        learner.setProfile_img(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));
    }

    public void auto_upload_photo_bio()  {
        String p = "file:/D:/Java Project/learner/src/main/resources/com/example/sayhello/image/dp.png";
        String b = "Hello, I am new here";
        learner.setProfile_img(p);
        Image image = new Image(p);
        dp.setFill(new ImagePattern(image));
        learner.setBio_text(b);
    }

    public void back_login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource("fxml/LoginPage.fxml"));
        view.switch_scene(root,event);
    }
    public void back_sign1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource("fxml/learner/learner_signup1.fxml"));
        view.switch_scene(root,event);
    }
    public void back_sign2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource("fxml/learner/learner_signup2.fxml"));
        view.switch_scene(root,event);
    }

//    public void back_login(MouseEvent event) throws IOException {
//        root = FXMLLoader.load(HelloApplication.class.getResource("fxml/LoginPage.fxml"));
//        view.switch_scene(root,event);
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gender.getItems().addAll(gender_value);
        from.getItems().addAll(from_value);
        native_lang.getItems().addAll(native_lang_value);
        learn_lang.getItems().addAll(learn_lang_value);

        auto_upload_photo_bio();
    }
}
