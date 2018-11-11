package ShapeAnalysisTool.controller.shapes;

import ShapeAnalysisTool.Main;
import ShapeAnalysisTool.controller.ViewController;
import ShapeAnalysisTool.shape.Cube;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

/**
 * Class that handles the cube calculation view
 */
public class CubeController {

    @FXML
    private Button backButton;

    @FXML
    private TextField lengthField;
    @FXML
    private TextField widthField;
    @FXML
    private TextField heightField;

    private Double length;
    private Double width;
    private Double height;

    @FXML
    private TextField result;
    @FXML
    private Text notice;

    private Double resultDouble;

    private Cube cube;

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
     * Triggered when calculate button is clicked. Calculates volume of the cube.
     */
    @FXML
    public void calculateCube() {
        if (!lengthField.getText().equals("") && !widthField.getText().equals("") && !heightField.getText().equals("")) {
            length = Double.parseDouble(lengthField.getText());
            width = Double.parseDouble(widthField.getText());
            height = Double.parseDouble(heightField.getText());

            cube = new Cube(length, width, height);

            resultDouble = cube.getVolume();

            result.setText(Double.toString(cube.getVolume()));

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
                Main.model.insertCube(cube);
                notice.setText("Successfully saved!");
                notice.getStyleClass().clear();
                notice.getStyleClass().add("successNotice");
                saveButton.setVisible(false);
            } catch (SQLException e) {
                notice.setText("Something went wrong");
                notice.getStyleClass().clear();
                notice.getStyleClass().add("failNotice");
                System.out.println("Failed to insert cube into database");
            }
        } else {
            notice.setText("No calculation done, nothing to save...");
            notice.getStyleClass().clear();
            notice.getStyleClass().add("failNotice");
        }
    }
}
