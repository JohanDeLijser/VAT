package ShapeAnalysisTool.model;

import ShapeAnalysisTool.shape.Cube;
import ShapeAnalysisTool.shape.Cylinder;
import ShapeAnalysisTool.shape.Sphere;

import java.util.ArrayList;

public class Model {

    private ArrayList<ArrayList> cubes = new ArrayList<>();
    private ArrayList<ArrayList> cylinders = new ArrayList<>();
    private ArrayList<ArrayList> spheres = new ArrayList<>();

    public void addCubeToStorage(Cube cube) {
        ArrayList<Double> cubeShape = new ArrayList<>();

        cubeShape.add(cube.getWidth());
        cubeShape.add(cube.getLength());
        cubeShape.add(cube.getHeight());
        cubeShape.add(cube.getVolume());

        cubes.add(cubeShape);
    }

    public void addCylinderToStorage(Cylinder cylinder) {
        ArrayList<Double> cylinderShape = new ArrayList<>();

        cylinderShape.add(cylinder.getHeight());
        cylinderShape.add(cylinder.getRadius());
        cylinderShape.add(cylinder.getVolume());

        cylinders.add(cylinderShape);
    }

    public void addSphereToStorage(Sphere sphere) {
        ArrayList<Double> sphereShape = new ArrayList<>();

        sphereShape.add(sphere.getRadius());
        sphereShape.add(sphere.getVolume());

        spheres.add(sphereShape);
    }

    public ArrayList getSavedShapes() {
        ArrayList<ArrayList> shapes = new ArrayList<>();

        if (!cubes.isEmpty()) {
            shapes.add(cubes);
        }
        if (!cylinders.isEmpty()) {
            shapes.add(cylinders);
        }
        if (!spheres.isEmpty()) {
            shapes.add(spheres);
        }

        return shapes;
    }
}
