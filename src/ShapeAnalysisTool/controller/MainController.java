package ShapeAnalysisTool.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;


public class MainController {

    @FXML
    private RadioButton cubeRadio;
    @FXML
    private RadioButton cylinderRadio;
    @FXML
    private RadioButton sphereRadio;


    public void handleClick() {
        RadioButton selectedRadio = new RadioButton();
        String selectedRadioString = "";

        if (cubeRadio.isSelected()) {
            selectedRadio = cubeRadio;
            selectedRadioString = "cube";
        } else if (cylinderRadio.isSelected()) {
            selectedRadio = cylinderRadio;
            selectedRadioString = "cylinder";
        } else if (sphereRadio.isSelected()) {
            selectedRadio = sphereRadio;
            selectedRadioString = "sphere";
        }

        if (selectedRadio != null && !selectedRadioString.equals("")) {
            try {
                ViewController viewController = new ViewController();
                viewController.setCalculateView(selectedRadio, selectedRadioString);
            } catch (Exception e) {
                System.out.println("Failed");
            }
        }
    }
}
