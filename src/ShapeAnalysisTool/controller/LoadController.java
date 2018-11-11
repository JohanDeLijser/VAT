package ShapeAnalysisTool.controller;

import ShapeAnalysisTool.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;


import java.sql.SQLException;
import java.util.ArrayList;


public class LoadController {

    @FXML
    private Button backButton;

    @FXML
    private Button loadSavedShapes;

    @FXML
    private FlowPane loadResultPane;

    private ArrayList<ArrayList<Double>> shapes;

    /**
     * Constructor
     */
    public LoadController() {

        try {
            shapes = Main.model.selectAllDimensions();
        } catch (SQLException e) {
            System.out.print("Failed to load shapes");
        }
    }


    /**
     * Triggered when go back button is clicked
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
     * Load all saved shapes and display them
     */
    public void displayLoadedShapes() {
        loadSavedShapes.setVisible(false);

        for (ArrayList shape : shapes) {
            String type = "";
            Double typeDouble = Double.parseDouble(shape.get(0).toString());
            Double length = Double.parseDouble(shape.get(1).toString());
            Double width = Double.parseDouble(shape.get(2).toString());
            Double radius = Double.parseDouble(shape.get(3).toString());
            Double height = Double.parseDouble(shape.get(4).toString());
            Double volume = Double.parseDouble(shape.get(5).toString());

            try {
                type = Main.model.selectShapeType(typeDouble);
            } catch (SQLException e) {
                System.out.println("Failed to get type or type doesn't exist");
            }

            if (typeDouble == 1.0) {
                displayCube(type, length, width, height, volume);
            } else if (typeDouble == 2.0) {
                displayCylinder(type, radius, height, volume);
            } else if (typeDouble == 3.0) {
                displaySphere(type, radius, volume);
            }
        }
    }

    /**
     * Display cube object
     * @param type
     * @param length
     * @param width
     * @param height
     * @param volume
     */
    public void displayCube(String type, Double length, Double width, Double height, Double volume) {
        Text typeResult = new Text(type + " with dimensions:");
        typeResult.getStyleClass().add("typeString");
        Text result = new Text("Length: " + length.toString() + ", Width: " + width.toString() + ", Height: " + height.toString() + ". Makes volume of: " + volume.toString());
        loadResultPane.getChildren().addAll(typeResult, result);
    }

    /**
     * Display cylinder object
     * @param type
     * @param radius
     * @param height
     * @param volume
     */
    public void displayCylinder(String type, Double radius, Double height, Double volume) {
        Text typeResult = new Text(type + " with dimensions:");
        typeResult.getStyleClass().add("typeString");
        Text result = new Text("Radius: " + radius.toString() + ", Height: " + height.toString() + ". Makes volume of: " + volume.toString());
        loadResultPane.getChildren().addAll(typeResult, result);
    }

    /**
     * Display sphere object
     * @param type
     * @param radius
     * @param volume
     */
    public void displaySphere(String type, Double radius, Double volume) {
        Text typeResult = new Text(type + " with dimensions:");
        typeResult.getStyleClass().add("typeString");
        Text result = new Text("Radius: " + radius.toString() + ". Makes volume of: " + volume.toString());
        loadResultPane.getChildren().addAll(typeResult, result);
    }
}
