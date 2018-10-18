package ShapeAnalysisTool;

import ShapeAnalysisTool.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        setMainView();
    }

    public void setMainView() throws Exception {
        Parent mainSceneFxml = FXMLLoader.load(getClass().getResource("view/main.fxml"));
        Scene newScene = new Scene(mainSceneFxml);
        window.setScene(newScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}