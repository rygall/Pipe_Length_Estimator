import javax.swing.*;

public class PressureLossUI {

    public PressureLossUI() {

        Pipe pipe = new Pipe();

        //WE HAVE TO ENSURE THAT WE ALWAYS OBTAIN THE NPS BEFORE GETTING ANY VALVES OR MATERIAL
        //OTHERWISE WE WOULD BE ADDING VALVES WITH NO INNER DIAMETER TO CALCULATE EQUIVALENT LENGTH

        //obtaining pipe length
        int exception1 = 1;
        while (exception1 == 1) {
            try {
                double pipeLength = Double.parseDouble(
                        JOptionPane.showInputDialog("Please enter the length of the pipe in feet."));
                pipe.setLength(pipeLength);
                exception1 = 0;
            } catch (NumberFormatException e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "INVALID ENTRY...PLEASE ENTER A NUMBER");
                exception1 = 1;
            } catch (Exception e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "SOMETHING WENT WRONG...PLEASE TRY AGAIN");
                exception1 = 1;
            }
        }


        //obtaining pipe size
        String[] npsList = {"1/4", "3/8", "1/2", "3/4", "1", "1-1/4", "1-1/2", "2", "2-1/2", "3",
                "4", "5", "6", "8", "10", "12"};
        String pipeNPS = (String) JOptionPane.showInputDialog(
                null,
                "Please select the pipe size.",
                "Pipe NPS",
                JOptionPane.QUESTION_MESSAGE,
                null,
                npsList,
                npsList.length);
        if (pipeNPS == null) {
            System.exit(0);
        }
        pipe.setNPS(pipeNPS);


        //obtaining pipe material
        String[] materialList = {"Copper Type K", "Copper Type L", "Copper Nickel 90/10",
                "Copper Nickel 70/30", "CRES 304L/316L"};
        String pipeMaterial = (String) JOptionPane.showInputDialog(
                null,
                "Please select the pipe material.",
                "Pipe Material",
                JOptionPane.QUESTION_MESSAGE,
                null,
                materialList,
                materialList.length);
        if (pipeMaterial == null) {
            System.exit(0);
        }
        pipe.setMaterial(pipeMaterial);


        //obtaining valves
        int valveOption = JOptionPane.showConfirmDialog(
                null,
                "Are there valves in this section of pipe?",
                "Adding Valves",
                JOptionPane.YES_NO_OPTION);

        String[] valveList = {"Ball", "Butterfly", "Check"};
        while (valveOption == JOptionPane.YES_OPTION) {
            String valve = (String) JOptionPane.showInputDialog(
                    null,
                    "Please select a valve to add.",
                    "Adding Valves",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    valveList,
                    valveList.length);
            if (valve == null) {
                System.exit(0);
            }
            pipe.addValve(valve);
            valveOption = JOptionPane.showConfirmDialog(
                    null,
                    "Is there another valve to add?",
                    "Adding Valves",
                    JOptionPane.YES_NO_OPTION);
        }


        //obtaining fluid
        String[] fluidList = {"Fresh Water", "Seawater", "F-76", "JP-5"};
        String pipeFluid = (String) JOptionPane.showInputDialog(
                null,
                "Please select the fluid.",
                "Fluid",
                JOptionPane.QUESTION_MESSAGE,
                null,
                fluidList,
                fluidList.length);
        if (pipeFluid == null) {
            System.exit(0);
        }
        pipe.setFluid(pipeFluid);


        //obtaining the flow rate
        int exception2 = 1;
        while (exception2 == 1) {
            try {
                double flowRate = Double.parseDouble(
                        JOptionPane.showInputDialog("Please enter the flow rate in gallons per minute."));
                pipe.setFlowRate(flowRate);
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


        //obtaining change in elevation
        // if there is a change in elevation we obtain the height differential from the user
        // the user input is wrapped in a try-catch block to make sure we are getting numbers
        int elevationOption = JOptionPane.showConfirmDialog(
                null,
                "Is there a change in elevation from the start point to end point?",
                "Elevation Change",
                JOptionPane.YES_NO_OPTION);
        if (elevationOption == JOptionPane.YES_OPTION) {
            int exception3 = 1;
            while (exception3 == 1) {
                try {
                    String elevationchangeString = JOptionPane.showInputDialog("Please enter the change in elevation in feet."
                            + String.format("\n(Positive Values for Positive " +
                            "Changes in the Delta Z direction)"));
                    if (elevationchangeString == null) {
                        System.exit(0);
                    }
                    double elevationchange = Double.parseDouble(elevationchangeString);
                    pipe.setElevationChange(elevationchange);
                    exception3 = 0;
                } catch (NumberFormatException e) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "INVALID ENTRY...PLEASE ENTER A NUMBER");
                    exception3 = 1;
                } catch (Exception e) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "SOMETHING WENT WRONG...PLEASE TRY AGAIN");
                    exception3 = 1;
                }
            }
        }


        //retrieving pressure loss calculations, unpacking them and then storing them as local variables
        double[] results = pipe.getPressureLoss();
        double velocity = results[0];
        double reynolds = results[1];
        double frictionfactor = results[2];
        double pressureloss = results[3];


        //printing results
        JFrame g = new JFrame();
        JOptionPane.showMessageDialog(g,
                String.format("Velocity (ft/s) : %.2f", velocity)
                        + String.format("\nReynolds Number : %.0f", reynolds)
                        + String.format("\nFriction Factor : %.4f", frictionfactor)
                        + String.format("\nPressure Loss (psi): %.2f", pressureloss));





    }
}
