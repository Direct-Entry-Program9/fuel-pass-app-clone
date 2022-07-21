package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScreenFormController {
    public AnchorPane pneSplashContainer;
    public Rectangle pgbContainer;
    public Rectangle pgbLoad;
    public Label txtLoading;

    public void initialize(){

        Timeline timeline = new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtLoading.setText("Connecting with the database...!");
                pgbLoad.setWidth(pgbContainer.getWidth()/4);
            }
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtLoading.setText("Loading data...!");
                pgbLoad.setWidth(2*pgbContainer.getWidth()/5);
            }
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtLoading.setText("Setting up the UI");
                pgbLoad.setWidth(3*pgbContainer.getWidth()/4);
            }
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                txtLoading.setText("Complete...!");
                pgbLoad.setWidth(pgbContainer.getWidth());
            }
        });
        KeyFrame keyFrame5 = new KeyFrame(Duration.millis(3500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    AnchorPane homeContainer = FXMLLoader.load(this.getClass().getResource("/view/HomeForm.fxml"));
                    Scene scene = new Scene(homeContainer);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.centerOnScreen();
                    stage.setTitle("National Fuel Pass");
                    txtLoading.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5);
        timeline.playFromStart();

    }
}
