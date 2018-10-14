package edu.tonnetje.vat.main;

import edu.tonnetje.vat.presentation.ViewFunctions;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        ViewFunctions viewFunctions = new ViewFunctions();

        Label mainCalculateCylinderLabel = new Label("Calculate cylinder: ");
        viewFunctions.addElementToView(mainCalculateCylinderLabel, 0, 0);

        Button mainCalculateCylinderButton = new Button("Calculate");
        viewFunctions.addElementToView(mainCalculateCylinderButton, 0, 1);

        System.out.print(viewFunctions.getGrid().getChildren());

        window.setScene(viewFunctions.setNewScene());
        window.show();
    }
}
