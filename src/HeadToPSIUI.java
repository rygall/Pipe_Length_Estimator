import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeadToPSIUI extends JFrame implements ActionListener {

    JButton SubmitButton;
    JComboBox FluidOptions;
    JTextField headField;

    HeadToPSIUI() {

        //combo box for fluid options
        //string array to be used for fluids combo box
        String[] fluidList = {"Fresh Water", "Seawater", "F-76", "JP-5"};
        //combo box to select system fluid
        FluidOptions = new JComboBox(fluidList);
        FluidOptions.addActionListener(this);
        FluidOptions.setBounds(10, 10, 105, 30);
        FluidOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //text field for psi input
        headField = new JTextField();
        headField.setBounds(10, 50, 105, 30);
        headField.setFont(new Font("Segoe UI", Font.PLAIN, 15));


        //creates submit button to submit psi and fluid
        SubmitButton = new JButton("Enter");
        SubmitButton.addActionListener(this);
        SubmitButton.setBounds(125, 50, 70 , 30);
        SubmitButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //creates new JPanel for text-fields and drop-downs
        JPanel InputPanel = new JPanel();
        InputPanel.setBackground(Color.darkGray);
        InputPanel.setBounds(80, 0, 220, 130);
        InputPanel.setLayout(null);
        InputPanel.add(FluidOptions);
        InputPanel.add(headField);
        InputPanel.add(SubmitButton);


        //JLabel for fluid options
        JLabel FluidOptionsLabel = new JLabel();
        FluidOptionsLabel.setText("Fluid:");
        FluidOptionsLabel.setBounds(5, 10, 50, 30);
        FluidOptionsLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //JLabel for head input
        JLabel headInputLabel = new JLabel();
        headInputLabel.setText("Head (ft):");
        headInputLabel.setBounds(5, 50, 80, 30);
        headInputLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //creates new JPanel for description of the required to be input
        JPanel TextPanel = new JPanel();
        TextPanel.setBackground(Color.lightGray);
        TextPanel.setBounds(0, 0, 80, 130);
        TextPanel.setLayout(null);
        TextPanel.add(FluidOptionsLabel);
        TextPanel.add(headInputLabel);

        //pipe icon for JFrame
        ImageIcon pipeIcon = new ImageIcon("pipeicon.png");

        //building JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Head To PSI");
        this.setIconImage(pipeIcon.getImage());
        this.setSize(300, 130);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        this.add(InputPanel);
        this.add(TextPanel);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SubmitButton) {

            //creating psiToHead object
            HeadToPSI headToPSI = new HeadToPSI();

            //if elevation field is filled out it is parsed into a double and then stores the length into the total
            double head = 0;
            String headString = headField.getText().trim(); //trim to get rid of white space
            if (!(headString.length() == 0)) { //checking to see if there is a value in the field
                try {
                    head =  Double.parseDouble(headString); //setting value in field to a double
                } catch (NumberFormatException numberFormatException) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "INVALID ENTRY...ENTER NUMBERS ONLY");
                    headField.setText(""); //setting the text field that wasn't a double equal to empty
                    return;
                }
            }


            String fluid = (String) FluidOptions.getSelectedItem();
            headToPSI.setFluid(fluid);
            headToPSI.setHead(head);

            //getting result from psiToHead object
            double result = headToPSI.getPSI();

            //printing results
            JFrame g = new JFrame();
            JOptionPane.showMessageDialog(g, String.format("PSI: %.2f", result));

        }

    }



}

