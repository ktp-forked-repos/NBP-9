package pl.nbp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.ResourceBundle;

public class NbpAppController implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private Label loginLabel;

    @FXML
    private ComboBox<?> userComboBox;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button createUserButton;

    public void initialize(URL location, ResourceBundle resources) {

    }
}
