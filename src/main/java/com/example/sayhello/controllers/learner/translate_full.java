package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.learner;
import com.example.sayhello.view_manager.View_manager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class translate_full implements Initializable {

    @FXML
    public void Translate(ActionEvent event) throws IOException {
        translate();
    }

    @FXML
    private TextField inputTextField= new TextField();

    @FXML
    private Label outputTextArea= new Label();

    @FXML
    private Text lang_1= new Text();
    @FXML
    private Text lang_2= new Text();
    static learner learner1 = new learner();
    public  void set_lang(learner le)
    {
        learner1 = le;
    }

    static String ll=new String(),tl=new String(); //code for native and learning language
    static String learner_language=new String(), native_language=new String(); //name of native and learning language
    public String code(String a)
    {
        return switch (a) {
            case "Japanese" -> "ja";
            case "Chinese" -> "zh-CN";
            case "Mandarin" -> "zh-CN";
            case "Urdu" -> "ur";
            case "Arabic" -> "ar";
            case "Hindi" -> "hi";
            case "Bengali" -> "bn";
            default -> "en";
        };
    }
    public void set_ll_tl()
    {
        ll=code (native_language);
        tl=code(learner_language);
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
        learner_language=learner1.getLearning_language();
        native_language=learner1.getNative_language();
        lang_1.setText(native_language);
        lang_2.setText(learner_language);
        set_ll_tl();
        N.setText(native_language);
        L.setText(learner_language);

    }

    public void Cng(MouseEvent events) {

        int a = 0;

        String temp=learner_language;
        learner_language=native_language;
        native_language=temp;
        lang_1.setText(native_language);
        lang_2.setText(learner_language);
        temp=ll;
        ll=tl;
        tl=temp;
    }


    @FXML
    private FontAwesomeIconView close;
    public void close_translate(MouseEvent events) throws IOException {

        View_manager view = new View_manager();
        view.close_stage(close);
    }

    @FXML
    public void copy(MouseEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(outputTextArea.getText());
        clipboard.setContent(content);
    }
}
