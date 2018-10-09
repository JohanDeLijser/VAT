package ShapeAnalysisTool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CylinderView extends Application {

    Stage cylinderWindow;

    public static void cylinderView(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        cylinderWindow = primaryStage;
        cylinderWindow.setTitle("VAT");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label cylinderRadiusLabel = new Label("Straal: ");
        GridPane.setConstraints(cylinderRadiusLabel, 0, 0);

        TextField cylinderRadiusInput = new TextField();
        GridPane.setConstraints(cylinderRadiusInput, 1, 0);

        Label cylinderHeightLabel = new Label("Hoogte: ");
        GridPane.setConstraints(cylinderHeightLabel, 0, 1);

        TextField cylinderHeightInput = new TextField();
        cylinderHeightInput.setPromptText("password");
        GridPane.setConstraints(cylinderHeightInput, 1, 1);

        grid.getChildren().addAll(cylinderRadiusLabel, cylinderRadiusInput, cylinderHeightLabel, cylinderHeightInput);

        Scene cylinderScene = new Scene(grid, 500, 300);
        cylinderWindow.setScene(cylinderScene);
        cylinderWindow.show();
    }
}
