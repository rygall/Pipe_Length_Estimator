import java.util.Scanner;
import java.util.ArrayList;

/* @ Pipe_Estimator
   @ Created by Ryan Gallagher */


public class PipeEstimator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        ArrayList<Double> pipeSectionLengths = new ArrayList<>();
        UnitsOfMeasurement units = new UnitsOfMeasurement();


        double length;
        int elbows90 = 0;
        int elbows45 = 0;

        /* initializing the two strings for units of measurement and then obtaining the input and output
           units of measurement, there is also while loop to make sure they enter correct units */
        String unitsInput = "";
        String unitsOutput = "";
        while (!(unitsInput.equalsIgnoreCase("meters") || unitsInput.equalsIgnoreCase("feet") || unitsInput.equalsIgnoreCase("inches"))) {
            System.out.printf("\n\n\nEnter the units of measurement that you are using to measure the length of the section of pipe (meters, feet or inches): \n");
            unitsInput = keyboard.nextLine();
            if (!(unitsInput.equalsIgnoreCase("meters") || unitsInput.equalsIgnoreCase("feet") || unitsInput.equalsIgnoreCase("inches"))) {
                System.out.printf("\n\nERROR! INVALID UNITS OF MEASUREMENT, PLEASE ENTER UNITS OF MEASUREMENT AGAIN\n");
            }
        }
        while (!(unitsOutput.equalsIgnoreCase("meters") || unitsOutput.equalsIgnoreCase("feet") || unitsOutput.equalsIgnoreCase("inches"))) {
            System.out.println("Enter the units of measurement that you want the outputted estimated length to be (meters, feet or inches): ");
            unitsOutput = keyboard.nextLine();
            if (!(unitsOutput.equalsIgnoreCase("meters") || unitsOutput.equalsIgnoreCase("feet") || unitsOutput.equalsIgnoreCase("inches"))) {
                System.out.printf("\n\nERROR! INVALID UNITS OF MEASUREMENT, PLEASE ENTER UNITS OF MEASUREMENT AGAIN\n");
            }
        }

        //obtaining the length of each section of pipe and adding that length to an array list.
        System.out.printf("\nEnter the length of the first section of pipe: \n");
        length = keyboard.nextDouble();
        pipeSectionLengths.add(length);

        while (length != 0) {
            System.out.printf("\nEnter the length of the next section of pipe or enter the number 0 to estimate: \n");
            length = keyboard.nextDouble();
            pipeSectionLengths.add(length);
        }

        //summing up all the lengths of the different pipe sections using an enhanced for loop
        double totalLength = 0;
        for (Double l : pipeSectionLengths) {
            totalLength += l;
        }

        //adding 25% to the total length to give the estimated length
        double estTotalLength = totalLength * 1.25;

        //if statements to compute the number of 90 degree elbows
        if (unitsInput.equalsIgnoreCase("meters")) {
            elbows90 = (int) Math.ceil(estTotalLength / 2.438);
            elbows45 = (int) Math.ceil(estTotalLength / 1.22);
        }

        if (unitsInput.equalsIgnoreCase("feet")) {
            elbows90 = (int) Math.ceil(estTotalLength / 8.0);
            elbows45 = (int) Math.ceil(estTotalLength / 4.0);
        }

        if (unitsInput.equalsIgnoreCase("inches")) {
            elbows90 = (int) Math.ceil(estTotalLength / (8.0*12.0));
            elbows45 = (int) Math.ceil(estTotalLength / (4.0*12.0));
        }



        //print the estimate length with the unitsOutput if both input and output are the same
        if (unitsInput.equalsIgnoreCase(unitsOutput)) {
            System.out.printf("\n\nThe estimated total pipe length is: %.3f %s", estTotalLength, unitsOutput);
        }

        //below are just more if statements to convert and print to the proper output units from the given input units
        if ((unitsInput.equalsIgnoreCase("meters")) && (unitsOutput.equalsIgnoreCase("feet"))) {
            units.metersToFeet(estTotalLength);
            System.out.printf("\n\nThe estimated total pipe length is: %.3f %s", units.getFeet(), unitsOutput);
        }

        if ((unitsInput.equalsIgnoreCase("meters")) && (unitsOutput.equalsIgnoreCase("inches"))) {
            units.metersToInches(estTotalLength);
            System.out.printf("\n\nThe estimated total pipe length is: %.3f %s", units.getInches(), unitsOutput);
        }

        if ((unitsInput.equalsIgnoreCase("feet")) && (unitsOutput.equalsIgnoreCase("inches"))) {
            units.feetToInches(estTotalLength);
            System.out.printf("\n\nThe estimated total pipe length is: %.3f %s", units.getInches(), unitsOutput);
        }

        if ((unitsInput.equalsIgnoreCase("feet")) && (unitsOutput.equalsIgnoreCase("meters"))) {
            units.feetToMeters(estTotalLength);
            System.out.printf("\n\nThe estimated total pipe length is: %.3f %s", units.getMeters(), unitsOutput);
        }

        if ((unitsInput.equalsIgnoreCase("inches")) && (unitsOutput.equalsIgnoreCase("meters"))) {
            units.inchesToMeters(estTotalLength);
            System.out.printf("\n\nThe estimated total pipe length is: %.3f %s", units.getMeters(), unitsOutput);
        }

        if ((unitsInput.equalsIgnoreCase("inches")) && (unitsOutput.equalsIgnoreCase("feet"))) {
            units.inchesToFeet(estTotalLength);
            System.out.printf("\n\nEstimated total pipe length is: %.3f %s", units.getFeet(), unitsOutput);
        }

        System.out.printf("\nEstimated number of 90 degree elbows: %d", elbows90);
        System.out.printf("\nEstimated number of 45 degree elbows: %d\n\n\n", elbows45);

    }
}
