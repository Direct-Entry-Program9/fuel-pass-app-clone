package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.NavigableMap;

public class Navigation {

    private static AnchorPane pneContainer;

    public static void init(AnchorPane pneContainer){
        Navigation.pneContainer=pneContainer;
    }

    public static void navigate(Routes route) throws IOException {

        pneContainer.getChildren().clear();
        URL resource;
        switch (route){
            case WELCOME:
                resource = Navigation.class.getResource("/view/WelcomeForm.fxml");
                break;
            case REGISTRATION:
                resource = Navigation.class.getResource("/view/RegisterForm.fxml");
                break;
            case LOGIN:
                resource = Navigation.class.getResource("/view/LoginForm.fxml");
                break;
            case ADMIN_LOGIN:
                resource = Navigation.class.getResource("/view/AdminLoginForm.fxml");
                break;
            case DASHBOARD:
                resource = Navigation.class.getResource("/view/UserDashboardForm.fxml");
                break;
            default:
                resource = Navigation.class.getResource("/view/ControlCenterForm.fxml");
        }

        Parent container = FXMLLoader.load(resource);
        pneContainer.getChildren().add(container);
        AnchorPane.setBottomAnchor(container,0.0);
        AnchorPane.setLeftAnchor(container,0.0);
        AnchorPane.setRightAnchor(container,0.0);
        AnchorPane.setTopAnchor(container,0.0);
    }

}
