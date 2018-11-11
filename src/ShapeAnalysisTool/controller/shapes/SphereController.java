package ShapeAnalysisTool.controller.shapes;

import ShapeAnalysisTool.Main;
import ShapeAnalysisTool.controller.ViewController;
import ShapeAnalysisTool.shape.Sphere;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

/**
 * Class that handles the sphere calculation view
 */
public class SphereController {

    @FXML
    private Button backButton;

    @FXML
    private TextField radiusField;
    @FXML
    private TextField result;

    @FXML
    private Text notice;

    private Double resultDouble;

    private Sphere sphere;

    @FXML
    private Button saveButton;

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
     * Triggered when calculate button is clicked. Calculates volume of the sphere.
     */
    @FXML
    public void calculateSphere() {
        if (!radiusField.getText().equals("")) {
            Double radius = Double.parseDouble(radiusField.getText());

            sphere = new Sphere(radius);

            resultDouble = sphere.getVolume();

            result.setText(Double.toString(sphere.getVolume()));

            notice.setText("");

            saveButton.setVisible(true);
        }
    }

    /**
     * Save current shape to database
     */
    public void saveCurrentShape() {

        if (resultDouble != null) {

            try {
                Main.model.insertSphere(sphere);
                notice.setText("Successfully saved!");
                notice.getStyleClass().clear();
                notice.getStyleClass().add("successNotice");
                saveButton.setVisible(false);
            } catch (SQLException e) {
                notice.setText("Something went wrong");
                notice.getStyleClass().clear();
                notice.getStyleClass().add("failNotice");
                System.out.println("Failed to insert sphere into database");
            }

        } else {
            notice.setText("No calculation done, nothing to save...");
            notice.getStyleClass().clear();
            notice.getStyleClass().add("failNotice");
        }
    }
}
