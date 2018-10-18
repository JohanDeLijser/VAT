package ShapeAnalysisTool.controller;

import ShapeAnalysisTool.shape.Cylinder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CylinderController {

    @FXML
    private Button backButton;

    @FXML
    private TextField radiusField;
    @FXML
    private TextField heightField;

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
    public void calculateCylinder() {
        if (!radiusField.getText().equals("") &&  !heightField.getText().equals("")) {
            Double radius = Double.parseDouble(radiusField.getText());
            Double height = Double.parseDouble(heightField.getText());

            Cylinder cylinder = new Cylinder(radius, height);

            result.setText(Double.toString(cylinder.getVolume()));
        }
    }
}
