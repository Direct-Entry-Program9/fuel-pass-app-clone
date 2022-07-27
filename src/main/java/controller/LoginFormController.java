package controller;

import db.IntMemoryDB;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.Routes;

import java.io.IOException;


public class LoginFormController {
    public TextField txtNic;
    public Button btnLogin;
    public AnchorPane pneLoginFormContainer;

    public void lblRegisterOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.REGISTRATION);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if (!RegisterFormController.isValidNIC(txtNic.getText()) || IntMemoryDB.findUser(txtNic.getText())==null){
            new Alert(Alert.AlertType.ERROR,"Please enter valid NIC to login").showAndWait();
            txtNic.requestFocus();
        }else {
            Navigation.navigate(Routes.DASHBOARD);
        }
    }
}
