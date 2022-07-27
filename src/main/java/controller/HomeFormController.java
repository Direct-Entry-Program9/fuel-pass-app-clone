package controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class HomeFormController {

    public AnchorPane pneHomeForm;
    public ImageView imgLogo;
    public AnchorPane imgContainer;

    public void initialize() throws IOException {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Navigation.navigate(Routes.WELCOME);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /*AnchorPane welcomeFormContainer = FXMLLoader.load(this.getClass().getResource("/view/WelcomeForm.fxml"));
        pneHomeForm.getChildren().add(welcomeFormContainer);

        AnchorPane.setBottomAnchor(welcomeFormContainer,0.0);
        AnchorPane.setTopAnchor(welcomeFormContainer,0.0);
        AnchorPane.setLeftAnchor(welcomeFormContainer,0.0);
        AnchorPane.setRightAnchor(welcomeFormContainer,0.0);*/
    }

    public void imgLogoOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        pneHomeForm.getChildren().clear();
        initialize();
    }

    public void pneLoginOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN);
        /*AnchorPane adminLoginContainer = FXMLLoader.load(this.getClass().getResource("/view/AdminLoginForm.fxml"));
        pneHomeForm.getChildren().clear();
        pneHomeForm.getChildren().add(adminLoginContainer);

        AnchorPane.setBottomAnchor(adminLoginContainer,0.0);
        AnchorPane.setTopAnchor(adminLoginContainer,0.0);
        AnchorPane.setLeftAnchor(adminLoginContainer,0.0);
        AnchorPane.setRightAnchor(adminLoginContainer,0.0);*/

    }

    public void pneLoginOnKeyReleased(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE){
            pneLoginOnMouseClicked(null);
        }
    }
}
