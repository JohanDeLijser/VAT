package ShapeAnalysisTool.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.awt.*;



public class MainController {

    @FXML
    private RadioButton cubeRadio;
    @FXML
    private RadioButton cylinderRadio;
    @FXML
    private RadioButton sphereRadio;


    public MainController() {

    }

    public void handleClick(ActionEvent event) {

        if (cubeRadio.isSelected()) {
            try {
                CylinderController cylinderController = new CylinderController();
                cylinderController.setCylinderView();
            } catch (Exception e) {
                System.out.println("Failed");
            }
        }
    }
}
