package ShapeAnalysisTool.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class ViewController {

    public void backToMainView(Button backButton) throws Exception {
        Stage window = (Stage) backButton.getScene().getWindow();
        Parent newSceneFxml = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        Scene newScene = new Scene(newSceneFxml);
        window.setScene(newScene);
        window.show();
    }

    public void setCalculateView(RadioButton selectedRadio, String selectedShape) throws Exception {
        Stage window = (Stage) selectedRadio.getScene().getWindow();
        Parent newSceneFxml = FXMLLoader.load(getClass().getResource("../view/" + selectedShape + "View.fxml"));
        Scene newScene = new Scene(newSceneFxml);
        window.setScene(newScene);
        window.show();
    }
}
