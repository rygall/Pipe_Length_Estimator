import javax.swing.*;

public class HeadToPSIUI {

    public HeadToPSIUI() {

        HeadToPSI headToPSI = new HeadToPSI();

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
            return;
        }
        headToPSI.setFluid(pipeFluid);

        //obtaining head
        //this is wrapped in a try-catch block in order to make sure we get a number from users
        int exception1 = 1;
        while (exception1 == 1) {
            try {
                String headString = JOptionPane.showInputDialog("Please enter the head in feet.");
                if (headString == null) {
                    return;
                }
                double head = Double.parseDouble(headString);
                headToPSI.setHead(head);
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



        double result = headToPSI.getPSI();


        //printing results
        JFrame g = new JFrame();
        JOptionPane.showMessageDialog(g, String.format("PSI: %.2f", result));


    }

}
