package com.example.sayhello.controllers.learner;

import com.example.sayhello.model.learner;
import com.example.sayhello.model.message;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class chat_inbox_cell_translate  implements Initializable {

    @FXML
    private Label text2;
    static message msg = new message();

    public void setMsg(message msg) {
        this.msg = msg;
    }

    static learner learner1 = new learner();
    public void set_log(learner lern) {
        learner1 = lern;
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

        String translatedText = Translator.trans(msg.getMessage(),tl,ll);

        text2.setText(translatedText);
    }
}
