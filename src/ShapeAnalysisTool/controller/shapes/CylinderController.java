package ShapeAnalysisTool.controller.shapes;

import ShapeAnalysisTool.Main;
import ShapeAnalysisTool.controller.ViewController;
import ShapeAnalysisTool.model.Model;
import ShapeAnalysisTool.shape.Cylinder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Class that handles the cylinder calculation view
 */
public class CylinderController {

    @FXML
    private Button backButton;

    @FXML
    private TextField radiusField;
    @FXML
    private TextField heightField;

    private Double radius;
    private Double height;

    @FXML
    private TextField result;

    @FXML
    private Text notice;

    private Double resultDouble;

    private Cylinder cylinder;

    /**
     * Function is triggered when back button is clicked. Sets back view through viewfunction
     */
    @FXML
    public void goBack() {

        try {
            ViewController viewController = new ViewController();
            viewController.backToMainView(backButton);
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }

    /**
     * Triggered when calculate button is clicked. Calculates volume of the cylinder.
     */
    @FXML
    public void calculateCylinder() {
        if (!radiusField.getText().equals("") &&  !heightField.getText().equals("")) {
            radius = Double.parseDouble(radiusField.getText());
            height = Double.parseDouble(heightField.getText());

            cylinder = new Cylinder(radius, height);

            resultDouble = cylinder.getVolume();

            result.setText(Double.toString(cylinder.getVolume()));

            notice.setText("");
        }
    }

    public void saveCurrentShape() {

        if (resultDouble != null) {
            Main.model.addCylinderToStorage(cylinder);
            notice.setText("Successfully saved!");
            notice.getStyleClass().clear();
            notice.getStyleClass().add("successNotice");
        } else {
            notice.setText("No calculation done, nothing to save...");
            notice.getStyleClass().clear();
            notice.getStyleClass().add("failNotice");
        }
    }
}
