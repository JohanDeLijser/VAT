package ShapeAnalysisTool.model;

import java.sql.*;
import java.util.ArrayList;
import ShapeAnalysisTool.shape.Cube;
import ShapeAnalysisTool.shape.Cylinder;
import ShapeAnalysisTool.shape.Sphere;

public class Model {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    private Connection connection;

    // The Statement object has been defined as a field because some methods
    // may return a ResultSet object. If so, the statement object may not
    // be closed as you would do when it was a local variable in the query
    // execution method.
    private Statement statement;

    public Model() {
        connection = null;
        statement = null;
    }

    /**
     * Opens the database connection if its possible to do so
     * @return
     */
    public boolean openConnection() {
        boolean result = false;

        if (connection == null) {
            try {
                // Try to create a connection with the library database
                connection = DriverManager.getConnection("jdbc:mysql://localhost/vat?useSSL=false", "root", "");

                if (connection != null) {
                    statement = connection.createStatement();
                }

                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        } else {
            // A connection was already initalized.
            result = true;
        }

        return result;
    }

    /**
     * Get shape type string from the database
     * @param typeDouble
     * @return
     * @throws SQLException
     */
    public String selectShapeType(Double typeDouble) throws SQLException {
        int type = typeDouble.intValue();
        String selectQuery = "SELECT * FROM shapes WHERE ID = " + type ;
        String resultString = "";

        statement = connection.createStatement();
        ResultSet result;
        result = statement.executeQuery(selectQuery);

        while (result.next()) {
            resultString = result.getString("shape");
        }

        return resultString;
    }

    /**
     * Select all shape dimensions and return them in an ArrayList
     * @return
     * @throws SQLException
     */
    public ArrayList<ArrayList<Double>> selectAllDimensions() throws SQLException {

        String selectQuery = "SELECT * FROM dimensions " ;
        ArrayList<ArrayList<Double>> shapes = new ArrayList<>();

        statement = connection.createStatement();
        ResultSet result;
        result = statement.executeQuery(selectQuery);

        while (result.next()) {
            ArrayList<Double> shapeDimensions = new ArrayList<>();
            Double type = result.getDouble("type");
            shapeDimensions.add(type);
            Double length = result.getDouble("length");
            shapeDimensions.add(length);
            Double width = result.getDouble("width");
            shapeDimensions.add(width);
            Double radius = result.getDouble("radius");
            shapeDimensions.add(radius);
            Double height = result.getDouble("height");
            shapeDimensions.add(height);
            Double volume = result.getDouble("volume");
            shapeDimensions.add(volume);

            shapes.add(shapeDimensions);
        }

        return shapes;
    }

    /**
     * Inserts cube object values into database
     * @param cube
     * @throws SQLException
     */
    public void insertCube(Cube cube) throws SQLException {
        statement = connection.createStatement();
        Double length = cube.getLength();
        Double width = cube.getWidth();
        Double height = cube.getHeight();
        Double volume = cube.getVolume();
        String insertQuery = "INSERT INTO dimensions (type, length, width, height, volume) VALUES (1, " + length + ", " + width + ", " + height + ", " + volume + ");";
        statement.executeUpdate(insertQuery);
    }

    /**
     * Inserts cylinder object values into database
     * @param cylinder
     * @throws SQLException
     */
    public void insertCylinder(Cylinder cylinder) throws SQLException {
        statement = connection.createStatement();
        Double height = cylinder.getHeight();
        Double radius = cylinder.getRadius();
        Double volume = cylinder.getVolume();
        String insertQuery = "INSERT INTO dimensions(type, height, radius, volume) VALUES (2, " + height + ", " + radius + ", " + volume + ");";
        statement.executeUpdate(insertQuery);
    }

    /**
     * Inserts sphere object values into database
     * @param sphere
     * @throws SQLException
     */
    public void insertSphere(Sphere sphere) throws SQLException {
        statement = connection.createStatement();
        Double radius = sphere.getRadius();
        Double volume = sphere.getVolume();
        String insertQuery = "INSERT INTO dimensions (type, radius, volume) VALUES (3, " + radius + ", " + volume + ");";
        statement.executeUpdate(insertQuery);
    }
}


