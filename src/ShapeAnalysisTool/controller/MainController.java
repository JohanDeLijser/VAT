package ShapeAnalysisTool.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

/**
 * Class that handles the main view
 */
public class MainController {

    @FXML
    private Button loadButton;

    @FXML
    private RadioButton cubeRadio;
    @FXML
    private RadioButton cylinderRadio;
    @FXML
    private RadioButton sphereRadio;

    /**
     * Sets load view when load button is clicked
     */
    public void loadView() {
        try {
            ViewController viewController = new ViewController();
            viewController.toLoadView(loadButton);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }

    /**
     * Triggered when the calculate button on the main view is clicked, calls view function sends param as to which
     * radio button is selected so the right view will be opened
     */
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
