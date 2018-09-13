package ShapeAnalysisTool;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Wat is de breedte?");

        int width = Integer.parseInt(reader.nextLine());

        System.out.print("Wat is de lengte?");

        int length = Integer.parseInt(reader.nextLine());

        System.out.print("Wat is de hoogte?");

        int height = Integer.parseInt(reader.nextLine());

        int Number = Calculations.contentOfSquare(width, length, height);

	    System.out.print("De inhoud van de kubus is: " + Number);
    }
}
