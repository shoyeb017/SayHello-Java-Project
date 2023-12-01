package com.example.sayhello.controllers.instructor;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.controllers.learner.Translator;
import com.example.sayhello.model.instructor;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class home implements Initializable {

    @FXML
    public void Translate(ActionEvent event) throws IOException {
        translate();
    }

    @FXML
    private TextField inputTextField= new TextField();

    @FXML
    private Label outputTextArea= new Label();
    @FXML
    private TextField langu= new TextField();

    @FXML
    private Text lang_1= new Text();
    @FXML
    private Text lang_2= new Text();
    static instructor instructor1 = new instructor();
   public  void set_lang(instructor le)
    {
        instructor1 = le;
    }

    static String ll=new String(),tl=new String(); //code for native and learning language
    static String teaching_language=new String(), native_language=new String(); //name of native and learning language
   public String code(String a)
   {
       return switch (a) {
           case "Japanese" -> "ja";
           case "French" -> "fr";
           case "German" -> "de";
           case "Spanish" -> "es";
           case "Chinese" -> "zh-CN";
           case "Mandarin" -> "zh-CN";
           case "Urdu" -> "ur";
           case "Russian" -> "ru";
           case "Italian" -> "it";
           case "Korean" -> "ko";
           case "Portuguese" -> "pt";
           case "Arabic" -> "ar";
           case "Turkish" -> "tr";
           case "Hindi" -> "hi";
           case "Indonesian" -> "id";
           case "Dutch" -> "nl";
           case "Polish" -> "pl";
           case "Swedish" -> "sv";
           case "Greek" -> "el";
           case "Romanian" -> "ro";
           case "Czech" -> "cs";
           case "Bengali" -> "bn";
           case "Danish" -> "da";
           case "Finnish" -> "fi";
           case "Hungarian" -> "hu";
           case "Norwegian" -> "no";
           case "Slovak" -> "sk";
           case "Vietnamese" -> "vi";
           case "Thai" -> "th";
           case "Ukrainian" -> "uk";
           case "Hebrew" -> "he";
           case "Croatian" -> "hr";
           case "Catalan" -> "ca";
           case "Lithuanian" -> "lt";
           case "Slovenian" -> "sl";
           case "Filipino" -> "fil";
           case "Latvian" -> "lv";
           default -> "en";
       };
   }
    public void set_ll_tl()
    {
        ll=code (native_language);
        tl=code(teaching_language);
    }

    public void translate() {
        String translatedText = Translator.trans(inputTextField.getText(),ll,tl);

        if(translatedText.isEmpty())
            outputTextArea.setText("Translation");
        else
            outputTextArea.setText(translatedText);
    }
    @FXML
    Label name = new Label();
    @FXML
    Label N= new Label();
    @FXML
    Label L= new Label();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teaching_language=instructor1.getTeaching_language();
        native_language=instructor1.getNative_language();
        lang_1.setText(native_language);
        lang_2.setText(teaching_language);
        set_ll_tl();
        name.setText(instructor1.getFirst_name()+" "+instructor1.getLast_name());
        N.setText(native_language);
        L.setText(teaching_language);

    }

    public void Cng(MouseEvent events) {

        int a = 0;


        String temp = teaching_language;
        teaching_language = native_language;
        native_language = temp;
        lang_1.setText(native_language);
        lang_2.setText(teaching_language);
        temp = ll;
        ll = tl;
        tl = temp;
        //return;
    }


    public void open_translate(MouseEvent events) throws IOException {

        translate_full translate = new translate_full();
        translate.set_lang(instructor1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/instructor/translate_full.fxml"));
        view.create_stage(fxmlLoader);
    }

    View_manager view = new View_manager();
    public void go_contact_us(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/contact_us.fxml"));
        view.create_stage(fxmlLoader,1280,760);
    }

    @FXML
    private FontAwesomeIconView cp;
    @FXML
    public void copy(MouseEvent event) {
        try {

            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(outputTextArea.getText());
            clipboard.setContent(content);
            System.out.println(outputTextArea.getText());
        } catch (Exception e) {
            // Handle the exception (e.g., log it or show an error message)
            e.printStackTrace();
        }
    }


    @FXML
    void view1(MouseEvent event) throws URISyntaxException, IOException {
        // Create Desktop object
        Desktop d=Desktop.getDesktop();

        // Browse a URL, say google.com
        d.browse(new URI("https://www.duolingo.com/"));
    }

    @FXML
    void view2(MouseEvent event) throws URISyntaxException, IOException {
        // Create Desktop object
        Desktop d=Desktop.getDesktop();

        // Browse a URL, say google.com
        d.browse(new URI("https://www.fluentu.com/"));
    }

    @FXML
    void view3(MouseEvent event) throws URISyntaxException, IOException {
        // Create Desktop object
        Desktop d=Desktop.getDesktop();

        // Browse a URL, say google.com
        d.browse(new URI("https://www.tandem.net/"));
    }

    @FXML
    void view4(MouseEvent event) throws URISyntaxException, IOException {
        // Create Desktop object
        Desktop d=Desktop.getDesktop();

        // Browse a URL, say google.com
        d.browse(new URI("https://www.hellotalk.com/"));
    }

}