import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstimatorUI extends JFrame implements ActionListener {

    //declaring an array of JTextFields to be used in the JPanel
    JTextField[] LengthFields = new JTextField[10];

    //declaring buttons and combo boxes here to make them visible to all methods in this class
    JButton SubmitButton;
    JComboBox InputUnitsOptions;
    JComboBox OutputUnitsOptions;


    EstimatorUI() {

        //string array to be used for combo boxes
        String[] units = {"Feet", "Meters", "Inches", "Millimeters"};

        //creates combo box to select input units
        InputUnitsOptions = new JComboBox(units);
        InputUnitsOptions.addActionListener(this);
        InputUnitsOptions.setBounds(10, 10, 100, 30);
        InputUnitsOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //creates combo box to select desired output units
        OutputUnitsOptions = new JComboBox(units);
        OutputUnitsOptions.addActionListener(this);
        OutputUnitsOptions.setBounds(10, 50, 100, 30);
        OutputUnitsOptions.setSelectedIndex(0);
        OutputUnitsOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //creates submit button to submit length
        SubmitButton = new JButton("Enter");
        SubmitButton.addActionListener(this);
        SubmitButton.setBounds(120, 450, 70 , 30);
        SubmitButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));


        //label for input units
        JLabel InputOptionsLabel = new JLabel();
        InputOptionsLabel.setText("Units for Input:");
        InputOptionsLabel.setBounds(5, 10, 150, 30);
        InputOptionsLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //label for output units
        JLabel OutputOptionsLabel = new JLabel();
        OutputOptionsLabel.setText("Units for Output:");
        OutputOptionsLabel.setBounds(5, 50, 150, 30);
        OutputOptionsLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //length label for text panel
        JLabel LengthLabel = new JLabel();
        LengthLabel.setText("Measured Lengths:");
        LengthLabel.setBounds(5, 90, 150, 30);
        LengthLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //creates new JPanel for text-fields and drop-downs
        JPanel InputPanel = new JPanel();
        InputPanel.setBackground(Color.darkGray);
        InputPanel.setBounds(145, 0, 220, 530);
        InputPanel.setLayout(null);
        InputPanel.add(SubmitButton);
        InputPanel.add(InputUnitsOptions);
        InputPanel.add(OutputUnitsOptions);

        //creating and adding 10 length fields to the Input Panel
        int y = 90;
        for (int i = 0; i < 10; i++) {
            LengthFields[i] = new JTextField();
            LengthFields[i].setBounds(10, y, 100, 30);
            LengthFields[i].setFont(new Font("Segoe UI", Font.PLAIN, 15));
            y+=40;
            InputPanel.add(LengthFields[i]);
        }

        //creates new JPanel for description of the required input
        JPanel TextPanel = new JPanel();
        TextPanel.setBackground(Color.lightGray);
        TextPanel.setBounds(0, 0, 145, 530);
        TextPanel.setLayout(null);
        TextPanel.add(LengthLabel);
        TextPanel.add(InputOptionsLabel);
        TextPanel.add(OutputOptionsLabel);

        //pipe icon for JFrame
        ImageIcon pipeIcon = new ImageIcon("pipeicon.png");

        //building JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Length & Fittings Estimation");
        this.setIconImage(pipeIcon.getImage());
        this.setSize(365, 530);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        this.add(TextPanel);
        this.add(InputPanel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SubmitButton) {

            Pipe pipe = new Pipe(); //pipe object to store total length
            double totalLength = 0; //will be used to sum all input length

            //obtaining user input for units used for input lengths and the desired units for output length
            String unitsInput = (String) InputUnitsOptions.getSelectedItem();
            String unitsOutput = (String) OutputUnitsOptions.getSelectedItem();

            //if a length field is filled out it is parsed into a double and then stores the length into the total
            for (int i = 0; i < 10; i++) {
                String value = LengthFields[i].getText().trim(); //trim to get rid of white space
                if (!(value.length() == 0)) { //checking to see if there is a value in the field
                    try {
                        double j =  Double.parseDouble(value); //setting value in field to a double
                        totalLength = totalLength + j; //adding length in the field to total length
                    } catch (NumberFormatException numberFormatException) {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "INVALID ENTRY...ENTER NUMBERS ONLY");
                        LengthFields[i].setText(""); //setting the text field that wasnt a double equal to empty
                        return;

                    }
                }

            }

            //clearing the text fields
            for (int i = 0; i < 10; i++) {
                LengthFields[i].setText("");
            }

            //stores the total length into the pipe object in feet
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
                        String.format("The estimated total length of the pipe is: %.2f %s",
                                length, unitsOutput.toLowerCase())
                                + "\nEstimated number of 90 degree elbows: " + elbows90
                                + "\nEstimated number of 45 degree elbows: " + elbows45);
            }
            if (unitsOutput.equalsIgnoreCase("meters")) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        String.format("The estimated total length of the pipe is: %.2f %s",
                                UnitConversion.feetToMeters(length), unitsOutput.toLowerCase())
                                + "\nEstimated number of 90 degree elbows: " + elbows90
                                + "\nEstimated number of 45 degree elbows: " + elbows45);
            }
            if (unitsOutput.equalsIgnoreCase("inches")) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        String.format("The estimated total length of the pipe is: %.2f %s",
                                UnitConversion.feetToInches(length), unitsOutput.toLowerCase())
                                + "\nEstimated number of 90 degree elbows: " + elbows90
                                + "\nEstimated number of 45 degree elbows: " + elbows45);
            }
            if (unitsOutput.equalsIgnoreCase("millimeters")) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f,
                        String.format("The estimated total length of the pipe is: %.2f %s",
                                UnitConversion.feetToMillimeters(length), unitsOutput.toLowerCase())
                                + "\nEstimated number of 90 degree elbows: " + elbows90
                                + "\nEstimated number of 45 degree elbows: " + elbows45);
            }


        }
    }


}