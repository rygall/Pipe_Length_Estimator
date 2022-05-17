import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PressureLossUI extends JFrame implements ActionListener {

    //inputs for fluid
    JComboBox FluidOptions;

    //inputs for flowrate
    JTextField FlowrateField;
    JComboBox FlowrateOptions;

    //inputs for pipe size
    JComboBox NPSOptions;

    //inputs for pipe material
    JComboBox MaterialOptions;

    //inputs for pipe length
    JTextField PipeLengthField;
    JComboBox PipeLengthUnitsOptions;

    //inputs for elevation change
    JTextField PipeElevationChangeField;
    JComboBox PipeElevationChangeOptions;

    //inputs for valves
    JComboBox[] valves = new JComboBox[5];

    //declaring buttons and combo boxes here to make them visible to all methods in this class
    JButton SubmitButton;

    PressureLossUI() {



        /* BELOW IS THE RIGHT HAND JPANEL */

        //string array to be used for fluids combo box
        String[] fluidList = {"Fresh Water", "Seawater", "F-76", "JP-5"};
        //combo box to select system fluid
        FluidOptions = new JComboBox(fluidList);
        FluidOptions.addActionListener(this);
        FluidOptions.setBounds(10, 10, 110, 30);
        FluidOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //text field for flowrate
        FlowrateField = new JTextField();
        FlowrateField.setBounds(10, 50, 100, 30);
        FlowrateField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //string array to be used for flowrate combo box
        String[] flowrateUnitsList = {"gpm", "m^3/hr"};
        //combo box to select input units for flowrate
        FlowrateOptions = new JComboBox(flowrateUnitsList);
        FlowrateOptions.addActionListener(this);
        FlowrateOptions.setBounds(115, 50, 80, 30);
        FlowrateOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //string array to be used for NPS combo box
        String[] npsList = {"1/4", "3/8", "1/2", "3/4", "1", "1-1/4", "1-1/2", "2", "2-1/2", "3",
                "4", "5", "6", "8", "10", "12"};
        //creates combo box to select pipe size
        NPSOptions = new JComboBox(npsList);
        NPSOptions.addActionListener(this);
        NPSOptions.setBounds(10, 90, 65, 30);
        NPSOptions.setSelectedIndex(0);
        NPSOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //string array to be used for material combo box
        String[] materialList = {"Copper Type K", "Copper Type L", "Copper Nickel 90/10",
                "Copper Nickel 70/30", "CRES 304L/316L"};
        //creates combo box to select pipe material
        MaterialOptions = new JComboBox(materialList);
        MaterialOptions.addActionListener(this);
        MaterialOptions.setBounds(10, 130, 165, 30);
        MaterialOptions.setSelectedIndex(0);
        MaterialOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //text field for pipe length
        PipeLengthField = new JTextField();
        PipeLengthField.setBounds(10, 170, 100, 30);
        PipeLengthField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //string array to be used for units combo boxes
        String[] lengthUnitsList = {"feet", "meters", "inches", "millimeters"};
        //creates combo box to select input units for length
        PipeLengthUnitsOptions = new JComboBox(lengthUnitsList);
        PipeLengthUnitsOptions.addActionListener(this);
        PipeLengthUnitsOptions.setBounds(115, 170, 100, 30);
        PipeLengthUnitsOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //text field for pipe elevation change
        PipeElevationChangeField = new JTextField();
        PipeElevationChangeField.setBounds(10, 210, 100, 30);
        PipeElevationChangeField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        //string array to be used for units combo boxes
        String[] heightUnitsList = {"feet", "meters", "inches", "millimeters"};
        //creates combo box to select input units for length
        PipeElevationChangeOptions = new JComboBox(heightUnitsList);
        PipeElevationChangeOptions.addActionListener(this);
        PipeElevationChangeOptions.setBounds(115, 210, 100, 30);
        PipeElevationChangeOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //creates submit button to submit length
        SubmitButton = new JButton("Enter");
        SubmitButton.addActionListener(this);
        SubmitButton.setBounds(225, 410, 70 , 30);
        SubmitButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //creates new JPanel for text-fields and drop-downs
        JPanel InputPanel = new JPanel();
        InputPanel.setBackground(Color.darkGray);
        InputPanel.setBounds(180, 0, 320, 490);
        InputPanel.setLayout(null);
        InputPanel.add(FluidOptions);
        InputPanel.add(FlowrateField);
        InputPanel.add(FlowrateOptions);
        InputPanel.add(NPSOptions);
        InputPanel.add(MaterialOptions);
        InputPanel.add(PipeLengthField);
        InputPanel.add(PipeLengthUnitsOptions);
        InputPanel.add(PipeElevationChangeField);
        InputPanel.add(PipeElevationChangeOptions);
        InputPanel.add(SubmitButton);

        //creating 5 combo boxes for valves
        String[] valveList = {"", "Ball", "Butterfly", "Check"};
        int y = 250;
        for (int i = 0; i < 5; i++) {
            valves[i] = new JComboBox(valveList);
            valves[i].setBounds(10, y, 100, 30);
            valves[i].setFont(new Font("Segoe UI", Font.PLAIN, 15));
            y+=40;
            InputPanel.add(valves[i]);
        }



        /* BELOW IS THE LEFT HAND JPANEL */

        //label for system fluid
        JLabel FluidLabel = new JLabel();
        FluidLabel.setText("System Fluid:");
        FluidLabel.setBounds(5, 10, 150, 30);
        FluidLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //label for flowrate
        JLabel FlowrateLabel = new JLabel();
        FlowrateLabel.setText("Flowrate:");
        FlowrateLabel.setBounds(5, 50, 150, 30);
        FlowrateLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //label for pipe size
        JLabel NPSLabel = new JLabel();
        NPSLabel.setText("Pipe Size (NPS):");
        NPSLabel.setBounds(5, 90, 150, 30);
        NPSLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //label for pipe material
        JLabel MaterialLabel = new JLabel();
        MaterialLabel.setText("Pipe Material:");
        MaterialLabel.setBounds(5, 130, 150, 30);
        MaterialLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //label for pipe length
        JLabel PipeLengthLabel = new JLabel();
        PipeLengthLabel.setText("Pipe Length:");
        PipeLengthLabel.setBounds(5, 170, 150, 30);
        PipeLengthLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //label for elevation change
        JLabel PipeElevationChangeLabel = new JLabel();
        PipeElevationChangeLabel.setText("Elevation Change (+/-):");
        PipeElevationChangeLabel.setBounds(5, 210, 170, 30);
        PipeElevationChangeLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //label for valves
        JLabel ValvesLabel = new JLabel();
        ValvesLabel.setText("Valves:");
        ValvesLabel.setBounds(5, 250, 170, 30);
        ValvesLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //creates new JPanel to show descriptions of the input fields
        JPanel TextPanel = new JPanel();
        TextPanel.setBackground(Color.lightGray);
        TextPanel.setBounds(0, 0, 180, 490);
        TextPanel.setLayout(null);
        TextPanel.add(FluidLabel);
        TextPanel.add(FlowrateLabel);
        TextPanel.add(PipeLengthLabel);
        TextPanel.add(NPSLabel);
        TextPanel.add(MaterialLabel);
        TextPanel.add(PipeElevationChangeLabel);
        TextPanel.add(ValvesLabel);



        /* BELOW IS THE OVERALL JFRAME */

        //pipe icon for JFrame
        ImageIcon pipeIcon = new ImageIcon("pipeicon.png");
        //building JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Pressure Loss Calculation");
        this.setIconImage(pipeIcon.getImage());
        this.setSize(500, 490);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        this.add(TextPanel);
        this.add(InputPanel);

    }



    /* BELOW IS THE ACTION LISTENER */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SubmitButton) {

            //pipe object to store inputs into and then perform the pressure loss calculation on that pipe object
            Pipe pipe = new Pipe();


            /* SETTING THE LENGTH OF THE PIPE OBJECT */
            double length = 0;
            String lengthString = PipeLengthField.getText().trim();
            if (!(lengthString.length() == 0)) { //checking to see if there is a value in the field
                try {
                    length =  Double.parseDouble(lengthString); //setting value in field to a double
                } catch (NumberFormatException numberFormatException) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "INVALID ENTRY...ENTER NUMBERS ONLY " +
                            "INTO PIPE LENGTH FIELD");
                    PipeLengthField.setText(""); //setting the text field that wasn't a double equal to empty
                    return;
                }
            }
            //storing pipe length units into local string
            String lengthUnits = (String) PipeLengthUnitsOptions.getSelectedItem();
            //stores the length into the pipe object in feet
            if (lengthUnits.equalsIgnoreCase("feet")) {
                pipe.setLength(length);
            }
            if (lengthUnits.equalsIgnoreCase("meters")) {
                length = UnitConversion.metersToFeet(length);
                pipe.setLength(length);
            }
            if (lengthUnits.equalsIgnoreCase("inches")) {
                length = UnitConversion.inchesToFeet(length);
                pipe.setLength(length);
            }
            if (lengthUnits.equalsIgnoreCase("millimeters")) {
                length = UnitConversion.millimetersToFeet(length);
                pipe.setLength(length);
            }


            /* SETTING THE FLOWRATE OF THE PIPE OBJECT */
            double flowRate = 0;
            String flowrateString = FlowrateField.getText().trim(); //obtaining the text field input and trimming it
            if (!(flowrateString.length() == 0)) { //if the field is not empty...do the following
                try {
                    flowRate =  Double.parseDouble(flowrateString); //setting value in field to a double
                } catch (NumberFormatException numberFormatException) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "INVALID ENTRY...ENTER NUMBERS ONLY " +
                            "INTO PIPE LENGTH FIELD");
                    FlowrateField.setText(""); //setting the text field that wasn't a double equal to empty
                    return;
                }
            }
            //storing flowrate units into local string
            String flowrateUnits = (String) FlowrateOptions.getSelectedItem();
            //stores the flowrate into the pipe object in gpm
            if (flowrateUnits.equalsIgnoreCase("gpm")) {
                pipe.setFlowRate(flowRate);
            }
            if (flowrateUnits.equalsIgnoreCase("m^3/hr")) {
                flowRate = flowRate / 0.2271;
                pipe.setFlowRate(flowRate);
            }


            /* SETTING THE NPS OF THE PIPE OBJECT */
            String NPS = (String) NPSOptions.getSelectedItem();
            pipe.setNPS(NPS);


            /* SETTING THE MATERIAL OF THE PIPE OBJECT */
            String material = (String) MaterialOptions.getSelectedItem();
            pipe.setMaterial(material);


            /* SETTING THE FLUID OF THE PIPE OBJECT */
            String fluid = (String) FluidOptions.getSelectedItem();
            pipe.setFluid(fluid);


            /* SETTING THE ELEVATION CHANGE OF THE PIPE OBJECT */
            double elevationChange = 0;
            String elevationChangeString = PipeElevationChangeField.getText().trim();
            if (!(elevationChangeString.length() == 0)) { //checking to see if there is a value in the field
                try {
                    elevationChange =  Double.parseDouble(elevationChangeString); //setting value in field to a double
                } catch (NumberFormatException numberFormatException) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "INVALID ENTRY...ENTER NUMBERS ONLY " +
                            "INTO PIPE LENGTH FIELD");
                    PipeElevationChangeField.setText(""); //setting the text field that wasn't a double equal to empty
                    return;
                }
            }
            //storing elevation change units into local string
            String elevationChangeUnits = (String) PipeElevationChangeOptions.getSelectedItem();
            //stores the elevation change into the pipe object in feet
            if (elevationChangeUnits.equalsIgnoreCase("feet")) {
                pipe.setElevationChange(elevationChange);
            }
            if (elevationChangeUnits.equalsIgnoreCase("meters")) {
                elevationChange = UnitConversion.metersToFeet(elevationChange);
                pipe.setElevationChange(elevationChange);;
            }
            if (elevationChangeUnits.equalsIgnoreCase("inches")) {
                elevationChange = UnitConversion.inchesToFeet(elevationChange);
                pipe.setElevationChange(elevationChange);;
            }
            if (elevationChangeUnits.equalsIgnoreCase("millimeters")) {
                elevationChange = UnitConversion.millimetersToFeet(elevationChange);
                pipe.setElevationChange(elevationChange);
            }


            /* ADDING VALVES INTO THE PIPE OBJECT */
            //if a valve is selected it is stored into the pipe object
            for (int i = 0; i < 5; i++) {
                String valve = (String) valves[i].getSelectedItem();
                if (!(valve.equalsIgnoreCase(""))) {
                    pipe.addValve(valve);
                }
            }



            /* RESETTING ALL COMBO BOXES AND FIELDS
            FluidOptions.setSelectedIndex(0);
            FlowrateField.setText("");
            FlowrateOptions.setSelectedIndex(0);
            NPSOptions.setSelectedIndex(0);
            MaterialOptions.setSelectedIndex(0);
            PipeLengthField.setText("");
            PipeLengthUnitsOptions.setSelectedIndex(0);
            PipeElevationChangeField.setText("");
            PipeElevationChangeOptions.setSelectedIndex(0);
            for (int i = 0; i < 5; i++) {
                valves[i].setSelectedIndex(0);
            }
            */


            //retrieving pressure loss calculations, unpacking them and then storing them as local variables
            double[] results = pipe.getPressureLoss();
            double velocity = results[0];
            double reynolds = results[1];
            double frictionfactor = results[2];
            double pressureloss = results[3];


            //printing inputs and results to console
            System.out.println("**PRESSURE LOSS**");
            System.out.printf("[Input] System Fluid = %s\n", fluid);
            System.out.printf("[Input] Flowrate = %.2f %s\n", flowRate, flowrateUnits);
            System.out.printf("[Input] Pipe Size (NPS) = %s\n", NPS);
            System.out.printf("[Input] Pipe Material = %s\n", material);
            System.out.printf("[Input] Pipe Length = %.2f %s\n", length, lengthUnits);
            System.out.printf("[Input] Elevation Change = %.2f %s\n", elevationChange, elevationChangeUnits);
            for (int i = 0; i < 5; i++) {
                String valve = (String) valves[i].getSelectedItem();
                if (!(valve.equalsIgnoreCase(""))) {
                    System.out.printf("[Input] Valve = %s\n", valve);
                }
            }

            System.out.printf("[Output] Velocity (ft/s) = %.2f\n", velocity);
            System.out.printf("[Output] Reynolds No = %.0f\n", reynolds);
            System.out.printf("[Output] Friction Factor = %.2f\n", frictionfactor);
            System.out.printf("[Output] Pressure Loss (psi) = %.2f\n", pressureloss);

            //closing PressureLossUI JFrame
            dispose();

        }
    }



}
