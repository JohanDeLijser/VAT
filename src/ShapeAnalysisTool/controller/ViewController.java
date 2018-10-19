package ShapeAnalysisTool.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * Class that handles switchings scenes
 */
public class ViewController {

    /**
     * Sets scene back to the main view
     * @param backButton
     * @throws Exception
     */
    public void backToMainView(Button backButton) throws Exception {
        Stage window = (Stage) backButton.getScene().getWindow();
        Parent newSceneFxml = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        Scene newScene = new Scene(newSceneFxml);
        window.setScene(newScene);
        window.show();
    }

    /**
     * Sets scene to the load view, used for loading saved shapes
     * @param loadButton
     * @throws Exception
     */
    public void toLoadView(Button loadButton) throws Exception {
        Stage window = (Stage) loadButton.getScene().getWindow();
        Parent newSceneFxml = FXMLLoader.load(getClass().getResource("../view/loadView.fxml"));
        Scene newScene = new Scene(newSceneFxml);
        window.setScene(newScene);
        window.show();
    }

    /**
     * Sets calculate view according to which radiobutton is selected in the main view
     * @param selectedRadio
     * @param selectedShape
     * @throws Exception
     */
    public void setCalculateView(RadioButton selectedRadio, String selectedShape) throws Exception {
        Stage window = (Stage) selectedRadio.getScene().getWindow();
        Parent newSceneFxml = FXMLLoader.load(getClass().getResource("../view/" + selectedShape + "View.fxml"));
        Scene newScene = new Scene(newSceneFxml);
        window.setScene(newScene);
        window.show();
    }
}
