package com.example.sayhello.controllers.learner;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class video_player implements Initializable {

    public static String file_path = new String();

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    @FXML
    private MediaView mediaView = new MediaView();

    @FXML
    private FontAwesomeIconView playButton, pauseButton, resetButton;

    private Media media;
    private MediaPlayer mediaPlayer;


    @FXML
    private ProgressBar songProgressBar;

    public void playMedia() {

        beginTimer();
        mediaPlayer.play();
//        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
//            Duration duration = mediaPlayer.getMedia().getDuration();
//            double current = newValue.toSeconds();
//            double total = duration.toSeconds();
//            double progress = current / total;
//            songProgressBar.setProgress(progress);
//        });

    }
    public void pauseMedia() {

        cancelTimer();
        mediaPlayer.pause();
    }
    public void resetMedia() {

        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            songProgressBar.setProgress(0);
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }


    private Timer timer  = new Timer();
    private TimerTask task;

    private boolean running;

    public void beginTimer() {

        timer = new Timer();

        task = new TimerTask() {

            public void run() {

                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                songProgressBar.setProgress(current/end);

                if(current/end == 1) {

                    cancelTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void cancelTimer() {

        running = false;
        timer.cancel();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File(file_path);
        System.out.println("Here: " + file.toURI().toString());
        String p = file_path;
        System.out.println("p : "+p);
        media = new Media(p);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }
}
