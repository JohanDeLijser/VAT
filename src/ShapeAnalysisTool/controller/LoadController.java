package ShapeAnalysisTool.controller;

import ShapeAnalysisTool.Main;
import ShapeAnalysisTool.shape.Cube;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;


public class LoadController {

    @FXML
    private Button backButton;

    public LoadController() {
        
    }

    @FXML
    public void goBack() {

        try {
            ViewController viewController = new ViewController();
            viewController.backToMainView(backButton);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }
}
