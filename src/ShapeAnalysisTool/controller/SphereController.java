package ShapeAnalysisTool.controller;

import ShapeAnalysisTool.shape.Sphere;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SphereController {

    @FXML
    private Button backButton;

    @FXML
    private TextField radiusField;
    @FXML
    private TextField result;

    @FXML
    public void goBack() {

        try {
            ViewController viewController = new ViewController();
            viewController.backToMainView(backButton);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }

    @FXML
    public void calculateSphere() {
        if (!radiusField.getText().equals("")) {
            Double radius = Double.parseDouble(radiusField.getText());

            Sphere sphere = new Sphere(radius);

            result.setText(Double.toString(sphere.getVolume()));
        }
    }
}
