package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.feed_class;
import com.example.sayhello.model.learner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class feed_cell_translate implements Initializable {

    static learner learner1 = new learner();
    public void set_log(learner lern) {
        learner1 = lern;
    }

    @FXML
    private Label text2;

    static feed_class feed_class2 = new feed_class();

    public void set_feed(feed_class fc)
    {
        feed_class2 = fc;
    }

    public String code(String a)
    {
        return switch (a) {
            case "Japanese" -> "ja";
            case "Mandarin" -> "zh-CN";
            case "Urdu" -> "ur";
            case "Arabic" -> "ar";
            case "Hindi" -> "hi";
            case "Bengali" -> "bn";
            default -> "en";
        };
    }

    static String ll=new String(),tl=new String(); //code for native and learning language
    public void set_ll_tl()
    {
        ll=code (learner1.getNative_language());
        tl=code(learner1.getLearning_language());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        set_ll_tl();
        text2.setText(feed_class2.getMassage());

        String translatedText = Translator.trans(feed_class2.getMassage(),tl,ll);

        text2.setText(translatedText);
    }
}