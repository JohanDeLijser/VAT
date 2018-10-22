package ShapeAnalysisTool.model;

import ShapeAnalysisTool.Main;
import ShapeAnalysisTool.shape.Cube;
import ShapeAnalysisTool.shape.Cylinder;
import ShapeAnalysisTool.shape.Sphere;

import java.sql.SQLException;

public class Model {

    public void addCubeToStorage(Cube cube) {
        try {
            Main.databaseConnection.insertCube(cube.getWidth(), cube.getLength(), cube.getHeight(), cube.getVolume());
        } catch (SQLException e) {
            System.out.println("Failed to insert cube into database");
        }
    }

    public void addCylinderToStorage(Cylinder cylinder) {
        try {
            Main.databaseConnection.insertCylinder(cylinder.getHeight(), cylinder.getRadius(), cylinder.getVolume());
        } catch (SQLException e) {
            System.out.println("Failed to insert cylinder into database");
        }
    }

    public void addSphereToStorage(Sphere sphere) {
        try {
            Main.databaseConnection.insertSphere(sphere.getRadius(), sphere.getVolume());
        } catch (SQLException e) {
            System.out.println("Failed to insert sphere into database");
        }
    }
}
