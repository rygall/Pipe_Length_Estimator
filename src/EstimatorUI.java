import javax.swing.*;
import java.util.ArrayList;

public class EstimatorUI {

    public EstimatorUI() {

        ArrayList<Double> pipeSectionLengths = new ArrayList<>();
        Pipe pipe = new Pipe();

        //obtaining units of measurement for input and output
        String[] unitsList = {"Meters", "Feet", "Inches", "Millimeters"};
        String unitsInput = (String) JOptionPane.showInputDialog(
                null,
                "Please select the units you are using to measure.",
                "Choose Input Units",
                JOptionPane.PLAIN_MESSAGE,
                null,
                unitsList,
                unitsList.length);
        if (unitsInput == null) {
            System.exit(0);
        }

        String unitsOutput = (String) JOptionPane.showInputDialog(
                null,
                "Please select the units for the output.",
                "Choose Output Units",
                JOptionPane.PLAIN_MESSAGE,
                null,
                unitsList,
                unitsList.length);
        if (unitsOutput == null) {
            System.exit(0);
        }



        //obtaining the length of each section of pipe and adding that length to an arraylist.
        //this code is wrapped in a try-catch block to make sure that we are getting numbers from the user
        int exception = 1;
        while (exception == 1) {
            try {
                String pipeLengthString = JOptionPane.showInputDialog("Please enter the first measurement in "
                        + unitsInput.toLowerCase() + ".");
                if (pipeLengthString == null) {
                    System.exit(0);
                }
                double pipeLength = Double.parseDouble(pipeLengthString);
                pipeSectionLengths.add(pipeLength);
                exception = 0;
            } catch (NumberFormatException e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "INVALID ENTRY...PLEASE ENTER A NUMBER");
                exception = 1;
            } catch (Exception e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "SOMETHING WENT WRONG...PLEASE TRY AGAIN");
                exception = 1;
            }
        }



        //asking if there is more measurements to be added, if yes, we get the length from the user
        //if no, we estimate the length of the pipe
        int lengthOption = JOptionPane.showConfirmDialog(
                null,
                "Are there more measurements to add?",
                "Adding Measurements",
                JOptionPane.YES_NO_OPTION);

        while (lengthOption == JOptionPane.YES_OPTION) {
            int exception2 = 1;
            while (exception2 == 1) {
                try {
                    String pipeLengthString = JOptionPane.showInputDialog("Please enter the next measurement in "
                            + unitsInput.toLowerCase() + ".");
                    if (pipeLengthString == null) {
                        System.exit(0);
                    }
                    double pipeLength = Double.parseDouble(pipeLengthString);
                    pipeSectionLengths.add(pipeLength);
                    lengthOption = JOptionPane.showConfirmDialog(
                            null,
                            "Are there more measurements to add?",
                            "Adding Measurements",
                            JOptionPane.YES_NO_OPTION);
                    exception2 = 0;
                } catch (NumberFormatException e) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "INVALID ENTRY...PLEASE ENTER A NUMBER");
                    exception2 = 1;
                } catch (Exception e) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "SOMETHING WENT WRONG...PLEASE TRY AGAIN");
                    exception2 = 1;
                }
            }
        }



        //summing up all the lengths of the different pipe sections using an enhanced for loop
        double totalLength = 0;
        for (Double l : pipeSectionLengths) {
            totalLength += l;
        }



        //creating new PipeSection object and storing the total lengths as feet
        if (unitsInput.equalsIgnoreCase("feet")) {
            pipe.setLength(totalLength);
        }
        if (unitsInput.equalsIgnoreCase("meters")) {
            totalLength = UnitConversion.metersToFeet(totalLength);
            pipe.setLength(totalLength);
        }
        if (unitsInput.equalsIgnoreCase("inches")) {
            totalLength = UnitConversion.inchesToFeet(totalLength);
            pipe.setLength(totalLength);
        }
        if (unitsInput.equalsIgnoreCase("millimeters")) {
            totalLength = UnitConversion.millimetersToFeet(totalLength);
            pipe.setLength(totalLength);
        }

        //calling for results and getting them
        double[] results = pipe.getEstimation();
        double length = results[0];
        int elbows90 = (int) results[1];
        int elbows45 = (int) results[2];



        //printing the estimated length as well as estimated 90s and 45s
        if (unitsOutput.equalsIgnoreCase("feet")) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,
                    String.format("The estimated length of the pipe is: %.2f %s",
                            length, unitsOutput.toLowerCase())
                            + "\nEstimated number of 90 degree elbows: " + elbows90
                            + "\nEstimated number of 45 degree elbows: " + elbows45);
        }
        if (unitsOutput.equalsIgnoreCase("meters")) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,
                    String.format("The estimated length of the pipe is: %.2f %s",
                            UnitConversion.feetToMeters(length), unitsOutput.toLowerCase())
                            + "\nEstimated number of 90 degree elbows: " + elbows90
                            + "\nEstimated number of 45 degree elbows: " + elbows45);
        }
        if (unitsOutput.equalsIgnoreCase("inches")) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,
                    String.format("The estimated length of the pipe is: %.2f %s",
                            UnitConversion.feetToInches(length), unitsOutput.toLowerCase())
                            + "\nEstimated number of 90 degree elbows: " + elbows90
                            + "\nEstimated number of 45 degree elbows: " + elbows45);
        }
        if (unitsOutput.equalsIgnoreCase("millimeters")) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,
                    String.format("The estimated length of the pipe is: %.2f %s",
                            UnitConversion.feetToMillimeters(length), unitsOutput.toLowerCase())
                            + "\nEstimated number of 90 degree elbows: " + elbows90
                            + "\nEstimated number of 45 degree elbows: " + elbows45);
        }


    }
}
