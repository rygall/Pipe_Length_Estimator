import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PSIToHeadUI extends JFrame implements ActionListener {

    JButton SubmitButton;
    JComboBox FluidOptions;
    JTextField psiField;

    PSIToHeadUI() {

        //combo box for fluid options
        //string array to be used for fluids combo box
        String[] fluidList = {"Fresh Water", "Seawater", "F-76", "JP-5"};
        //combo box to select system fluid
        FluidOptions = new JComboBox(fluidList);
        FluidOptions.addActionListener(this);
        FluidOptions.setBounds(10, 10, 110, 30);
        FluidOptions.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //text field for psi input
        psiField = new JTextField();
        psiField.setBounds(10, 50, 105, 30);
        psiField.setFont(new Font("Segoe UI", Font.PLAIN, 15));


        //creates submit button to submit psi and fluid
        SubmitButton = new JButton("Enter");
        SubmitButton.addActionListener(this);
        SubmitButton.setBounds(125, 50, 70 , 30);
        SubmitButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        //creates new JPanel for text-fields and drop-downs
        JPanel InputPanel = new JPanel();
        InputPanel.setBackground(Color.darkGray);
        InputPanel.setBounds(70, 0, 220, 130);
        InputPanel.setLayout(null);
        InputPanel.add(FluidOptions);
        InputPanel.add(psiField);
        InputPanel.add(SubmitButton);


        //JLabel for fluid options
        JLabel FluidOptionsLabel = new JLabel();
        FluidOptionsLabel.setText("Fluid:");
        FluidOptionsLabel.setBounds(5, 10, 50, 30);
        FluidOptionsLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //JLabel for PSI input
        JLabel psiInputLabel = new JLabel();
        psiInputLabel.setText("PSI:");
        psiInputLabel.setBounds(5, 50, 50, 30);
        psiInputLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));

        //creates new JPanel for description of the required to be input
        JPanel TextPanel = new JPanel();
        TextPanel.setBackground(Color.lightGray);
        TextPanel.setBounds(0, 0, 70, 130);
        TextPanel.setLayout(null);
        TextPanel.add(FluidOptionsLabel);
        TextPanel.add(psiInputLabel);

        //pipe icon for JFrame
        ImageIcon pipeIcon = new ImageIcon("pipeicon.png");

        //building JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("PSI To Head");
        this.setIconImage(pipeIcon.getImage());
        this.setSize(290, 130);
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
            PSIToHead psiToHead = new PSIToHead();

            //if elevation field is filled out it is parsed into a double and then stores the length into the total
            double psi = 0;
            String psiString = psiField.getText().trim(); //trim to get rid of white space
            if (!(psiString.length() == 0)) { //checking to see if there is a value in the field
                try {
                    psi =  Double.parseDouble(psiString); //setting value in field to a double
                } catch (NumberFormatException numberFormatException) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "INVALID ENTRY...ENTER NUMBERS ONLY");
                    psiField.setText(""); //setting the text field that wasn't a double equal to empty
                    return;
                }
            }

            String fluid = (String) FluidOptions.getSelectedItem();
            psiToHead.setFluid(fluid);
            psiToHead.setPSI(psi);

            //getting result from psiToHead object
            double result = psiToHead.getHead();

            System.out.println("**PSI TO HEAD**");
            System.out.printf("[Input]  Fluid = %s\n", fluid);
            System.out.printf("[Input]  PSI = %.2f\n", psi);
            System.out.printf("[Output] Head (ft) = %.2f", result);
            System.out.println("");

            dispose();
        }


    }

}
