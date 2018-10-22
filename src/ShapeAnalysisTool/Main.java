package ShapeAnalysisTool;

import ShapeAnalysisTool.controller.MainController;
import ShapeAnalysisTool.model.DatabaseConnection;
import ShapeAnalysisTool.model.Model;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    public static Model model = new Model();
    public static DatabaseConnection databaseConnection = new DatabaseConnection();

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        setMainView();
    }

    /**
     * Sets the main view when program is started
     * @throws Exception
     */
    public void setMainView() throws Exception {
        Parent mainSceneFxml = FXMLLoader.load(getClass().getResource("view/main.fxml"));
        Scene newScene = new Scene(mainSceneFxml);
        window.setScene(newScene);
        window.show();
    }

    public static void main(String[] args) {
        databaseConnection.openConnection();
        launch(args);
    }
}