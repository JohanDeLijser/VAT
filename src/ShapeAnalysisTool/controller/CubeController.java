package ShapeAnalysisTool.controller;

import ShapeAnalysisTool.shape.Cube;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CubeController {

    @FXML
    private Button backButton;

    @FXML
    private TextField lengthField;
    @FXML
    private TextField widthField;
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
    public void calculateCube() {
        if (!lengthField.getText().equals("") && !widthField.getText().equals("") && !heightField.getText().equals("")) {
            Double length = Double.parseDouble(lengthField.getText());
            Double width = Double.parseDouble(widthField.getText());
            Double height = Double.parseDouble(heightField.getText());

            Cube cube = new Cube(length, width, height);

            result.setText(Double.toString(cube.getVolume()));
        }
    }
}
