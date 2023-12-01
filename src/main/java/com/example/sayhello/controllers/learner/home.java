package com.example.sayhello.controllers.learner;

import com.example.sayhello.HelloApplication;
import com.example.sayhello.model.learner;
import com.example.sayhello.view_manager.View_manager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
        name.setText(learner1.getFirst_name()+" "+learner1.getLast_name());
        N.setText(native_language);
        L.setText(learner_language);


        try {
            simulateTask();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public void open_translate(MouseEvent events) throws IOException {

        translate_full translate = new translate_full();
        translate.set_lang(learner1);

        View_manager view = new View_manager();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/learner/translate_full.fxml"));
        view.create_stage(fxmlLoader);
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

    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Label rate;
    private void simulateTask() throws FileNotFoundException {

        int p;
        File infoFile2 = new File("src/main/resources/com/example/sayhello/file/learner/" + learner1.getNative_language() + "/" + learner1.getEmail() + "/enroll_now/info.txt");
        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);
            sc.useDelimiter("\n");
            p = Integer.parseInt(sc.next());
        } else {
            p = 0;
        }
        // Create a background thread to simulate a time-consuming task
        Thread taskThread = new Thread(() -> {
            for (int i = 0; i <= 10*p; i++) {
                // Update the ProgressIndicator value on the JavaFX Application Thread
                int finalI = i;
                Platform.runLater(() -> {
                    progressIndicator.setProgress(finalI / 100.0);
                    rate.setText(finalI + "%");
                });

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        // Start the background thread
        taskThread.start();
    }

    @FXML
    public void copy(MouseEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(outputTextArea.getText());
        clipboard.setContent(content);
    }
}


//
//    private void delete_account()
//    {
//        if(customer_list.getSelectionModel().getSelectedItem()==null) return;
//
//        Client client = customer_list.getSelectionModel().getSelectedItem();
//
//        for(int i=0;i<clients.size();++i)
//        {
//            if(clients.get(i).getMail().equals(client.getMail())) clients.remove(clients.get(i));
//        }
//
//        File file = new File(Fpath.data_path+"Data/Client/"+client.getMail());
//        File[] ls = file.listFiles();
//
//        assert ls != null;
//        for(File f:ls) f.delete();
//
//        file.delete();
//    }