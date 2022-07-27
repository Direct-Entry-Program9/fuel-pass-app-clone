package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.Routes;

import java.io.IOException;

public class WelcomeFormController {
    public Button btnRegister;
    public Button btnLogin;
    public AnchorPane pneRoot;

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.REGISTRATION);
        /*AnchorPane registerFormContainer = FXMLLoader.load(this.getClass().getResource("/view/RegisterForm.fxml"));
        AnchorPane pneHomeContainer = (AnchorPane) pneRoot.getParent();
        pneHomeContainer.getChildren().clear();
        pneHomeContainer.getChildren().add(registerFormContainer);

        AnchorPane.setBottomAnchor(registerFormContainer,0.0);
        AnchorPane.setRightAnchor(registerFormContainer,0.0);
        AnchorPane.setLeftAnchor(registerFormContainer,0.0);
        AnchorPane.setTopAnchor(registerFormContainer,0.0);*/

    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.LOGIN);
        /*AnchorPane loginFormContainer = FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        AnchorPane pneHomeContainer = (AnchorPane) pneRoot.getParent();
        pneHomeContainer.getChildren().clear();
        pneHomeContainer.getChildren().add(loginFormContainer);

        AnchorPane.setRightAnchor(loginFormContainer,0.0);
        AnchorPane.setLeftAnchor(loginFormContainer,0.0);
        AnchorPane.setTopAnchor(loginFormContainer,0.0);
        AnchorPane.setBottomAnchor(loginFormContainer,0.0);*/
    }
}
