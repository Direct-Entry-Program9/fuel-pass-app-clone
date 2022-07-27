package controller;

import db.IntMemoryDB;
import db.User;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.net.URL;

public class RegisterFormController {
    public AnchorPane pneRegisterForm;
    public TextField txtNic;
    public Label lblNicStatus;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;
    public Button btnRegister;

    private  void setDisableCmp(boolean disable){
        txtAddress.setDisable(disable);
        txtFirstName.setDisable(disable);
        txtLastName.setDisable(disable);
        btnRegister.setDisable(disable);
    }

    public void initialize(){
        Platform.runLater(txtNic::requestFocus);
        txtNic.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldText, String currentText) {

                setDisableCmp(true);

                if (currentText.isBlank()){
                    lblNicStatus.setText("Please enter valid NIC number to proceed");
                    lblNicStatus.setTextFill(Color.BLACK);
                }
                else {
                    if (isValidNIC(currentText)){
                        lblNicStatus.setText("Valid NIC");
                        lblNicStatus.setTextFill(Color.GREEN);
                        setDisableCmp(false);
                    }else {
                        lblNicStatus.setText("Invalid NIC");
                        lblNicStatus.setTextFill(Color.RED);
                    }
                }
            }
        });
    }
    public static boolean isValidNIC(String input){
        if (input.length()!=10) return false;
        if (!(input.endsWith("v") || input.endsWith("V"))) return false;
        if (!input.substring(0,9).matches("\\d+")) return false;
        return true;
    }

    public void lblLoginOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN);
        /*URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        AnchorPane loginForm = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneRegisterForm.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(loginForm);
        AnchorPane.setBottomAnchor(loginForm,0.0);
        AnchorPane.setTopAnchor(loginForm,0.0);
        AnchorPane.setLeftAnchor(loginForm,0.0);
        AnchorPane.setRightAnchor(loginForm,0.0);*/

    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {

        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();

        //validate First Name
        if (firstName.isBlank()){
            new Alert(Alert.AlertType.ERROR,"First name is required").showAndWait();
            txtFirstName.requestFocus();
            return;
        }
        else if (!isName(firstName)) {
            new Alert(Alert.AlertType.ERROR,"Please Enter Valid Name").showAndWait();
            txtFirstName.requestFocus();
            return;
        }
        //valid address
        else if (address.trim().length()<3) {
            new Alert(Alert.AlertType.ERROR,"Address is required").showAndWait();
            txtAddress.requestFocus();
            return;
        }
        else if (lastName.isBlank()) {
            txtLastName.setText("");
        }


        User user = new User(nic, firstName, lastName, address);
        boolean result = IntMemoryDB.registerUser(user);

        /*txtAddress.clear();
        txtNic.clear();
        txtFirstName.clear();
        txtLastName.clear();*/
        if (result){
            new Alert(Alert.AlertType.INFORMATION, "Registration is Success. You will be redirected to login page").showAndWait();
            lblLoginOnMouseClicked(null);
        }else{
            new Alert(Alert.AlertType.INFORMATION, "User already registered").showAndWait();
            txtNic.requestFocus();
        }




    }

    public boolean isName(String input){
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (!Character.isLetter(aChar) && aChar != ' ') return false;
        }
        return true;
    }
}
