package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AdminLoginFormController {
    public AnchorPane pneAdminLoginForm;
    public PasswordField txtPassword;
    private static int attempt = 3;
    private static final String ADMIN_PASSWORD = "Manelka";

    public void initialize(){
        Platform.runLater(txtPassword::requestFocus);
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
        if (!txtPassword.getText().equals(ADMIN_PASSWORD)){
            if (attempt==0){
                new Alert(Alert.AlertType.ERROR, "Sorry You have reached maximum attempt").showAndWait();
                Platform.exit();
                return;
            }
            attempt--;
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid admin password. you have only " + (attempt+1) + " attempts. Please check and Re-enter Correct Password");

            URL resource = this.getClass().getResource("/audio/accessDenied.mp3");
            Media media = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();


            InputStream resourceAsStream = this.getClass().getResourceAsStream("/image/denied.png");
            Image image = new Image(resourceAsStream);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(48);
            imageView.setFitWidth(48);
            alert.setGraphic(imageView);

            alert.setHeaderText("Invalid Login Credential");
            alert.setTitle("Access Denied");

            alert.showAndWait();
            mediaPlayer.dispose();
            txtPassword.requestFocus();
            return;
        }

        URL resource = this.getClass().getResource("/view/ControlCenterForm.fxml");
        AnchorPane controlCenter = FXMLLoader.load(resource);

        AnchorPane pneController = (AnchorPane) pneAdminLoginForm.getParent();
        pneController.getChildren().clear();
        pneController.getChildren().add(controlCenter);

        AnchorPane.setRightAnchor(controlCenter,0.0);
        AnchorPane.setLeftAnchor(controlCenter,0.0);
        AnchorPane.setTopAnchor(controlCenter,0.0);
        AnchorPane.setBottomAnchor(controlCenter,0.0);
    }
}
