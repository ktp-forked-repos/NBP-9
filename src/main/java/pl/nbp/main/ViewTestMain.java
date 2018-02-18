package pl.nbp.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class is responsible for testing added views.
 */

public class ViewTestMain extends Application {
    final String appName = "NBP Currency Getter";


    /**
     *Method responsible for starting scene.
     */
    public void start(Stage primaryStage) {

        try {
            //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(""));
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/CreateNewUserView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle(appName);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
