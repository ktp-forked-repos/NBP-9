package pl.nbp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for CreateNewUserView Window
 */

public class CreateNewUserController implements Initializable {

    @FXML
    private Label FirstName;

    @FXML
    private TextField InputFirstNameTextField;

    @FXML
    private Label LastNameLabel;

    @FXML
    private TextField InputLastNameTextField;

    @FXML
    private Label PasswordLabel;

    @FXML
    private PasswordField InputPasswordField;

    @FXML
    private Label RepeatPasswordLabel;

    @FXML
    private PasswordField InputRepeatPasswordField;

    @FXML
    private Button CreateNewUserButton;

    @FXML
    private Button BackToUserListButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
