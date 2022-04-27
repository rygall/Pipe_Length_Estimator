import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

        JButton EstimatorButton;
        JButton PressureLossButton;
		JButton UnitConversionButton;
		JButton HeadToPSIButton;
		JButton PSIToHeadButton;


	GUI() {

				//this adds a button for psi to head calc
				PSIToHeadButton = new JButton();
				PSIToHeadButton.setBounds(30, 170, 200, 50);
				PSIToHeadButton.addActionListener(this);
				PSIToHeadButton.setText("PSI to Head");
				PSIToHeadButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				PSIToHeadButton.setFocusable(false);
				PSIToHeadButton.setBackground(Color.gray);

				//this adds a button for head to psi calc
				HeadToPSIButton = new JButton();
				HeadToPSIButton.setBounds(250, 170, 200, 50);
				HeadToPSIButton.addActionListener(this);
				HeadToPSIButton.setText("Head to PSI");
				HeadToPSIButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				HeadToPSIButton.setFocusable(false);
				HeadToPSIButton.setBackground(Color.gray);

				//this adds a button for pipe length estimation to the GUI JFrame
            	EstimatorButton = new JButton();
				EstimatorButton.setBounds(30, 250, 200, 50);
				EstimatorButton.addActionListener(this);
            	EstimatorButton.setText("Length Estimation");
            	EstimatorButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            	EstimatorButton.setFocusable(false);
            	EstimatorButton.setBackground(Color.gray);
		
				//this adds a button for pressure loss calculation for the GUI JFrame
            	PressureLossButton = new JButton();
            	PressureLossButton.setBounds(250, 250, 200, 50);
            	PressureLossButton.addActionListener(this);
            	PressureLossButton.setText("Pressure Loss"); 
				PressureLossButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            	PressureLossButton.setFocusable(false);
            	PressureLossButton.setBackground(Color.gray);

				//options panel which contains buttons
				JPanel optionsPanel = new JPanel();
				optionsPanel.setBackground(Color.darkGray);
				optionsPanel.setBounds(0, 100, 500, 300);

				//pipe icon for title JPanel
				ImageIcon pipeIcon = new ImageIcon("pipeicon.png");

				//JLabel for title panel
            	JLabel titleLabel = new JLabel();
            	titleLabel.setText("SELECT A CALCULATION");
            	titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
				titleLabel.setVerticalAlignment(JLabel.CENTER);
            	titleLabel.setHorizontalAlignment(JLabel.CENTER);

				//title panel
            	JPanel titlePanel = new JPanel();
				titlePanel.setBackground(Color.lightGray);
				titlePanel.setBounds(0, 0, 500, 100);
            	titlePanel.setLayout(new BorderLayout());
            	titlePanel.add(titleLabel);

            	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	this.setLayout(null);
            	this.setTitle("  Piping Hand Calcs");
            	this.setIconImage(pipeIcon.getImage());
            	this.setSize(500, 400);
            	this.setVisible(true);
            	this.setResizable(false);
            	this.setLocationRelativeTo(null);
            	this.setFont(new Font("Times New Roman", Font.PLAIN, 10));
				//this.add(UnitConversionButton);
				this.add(EstimatorButton);
				this.add(PressureLossButton);
            	this.add(HeadToPSIButton);
				this.add(PSIToHeadButton);
				this.add(optionsPanel);
            	this.add(titlePanel);

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==EstimatorButton) {
            EstimatorUI estimatorexecute = new EstimatorUI();
        }
        if (e.getSource()==PressureLossButton) {
            PressureLossUI pressurelossexecute = new PressureLossUI();
        }
		if (e.getSource()==HeadToPSIButton) {
			HeadToPSIUI headtopsiexecute = new HeadToPSIUI();
		}
		if (e.getSource()==PSIToHeadButton) {
			PSIToHeadUI psitoheadexecute = new PSIToHeadUI();
		}



    }

}
