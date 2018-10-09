package ShapeAnalysisTool;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewFunctions extends Main {

    private GridPane grid;
    private ArrayList<Node> elements = new ArrayList<>();

    public ViewFunctions() {
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
    }

    public void addElementToView(Node element, int x, int y) {
        GridPane.setConstraints(element, x, y);
        grid.getChildren().add(element);
    }

    public Scene setNewScene() {
        return new Scene(grid, 500, 300);
    }

    public ArrayList<Node> getElements() {
        return elements;
    }

    public GridPane getGrid() {
        return grid;
    }
}
