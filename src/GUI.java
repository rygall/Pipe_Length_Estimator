import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.*;


public class GUI extends JFrame implements ActionListener {

	JButton EstimatorButton;
	JButton PressureLossButton;
	JButton HeadToPSIButton;
	JButton PSIToHeadButton;
	TextAreaOutputStream console;



	GUI() {
		
		//this adds a button for psi to head calc
		PSIToHeadButton = new JButton();
		PSIToHeadButton.setBounds(30, 170, 200, 50);
		PSIToHeadButton.addActionListener(this);
		PSIToHeadButton.setText("PSI to Head");
		PSIToHeadButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		PSIToHeadButton.setFocusable(false);
		PSIToHeadButton.setBackground(Color.gray);

		//this adds a button for head to psi calc
		HeadToPSIButton = new JButton();
		HeadToPSIButton.setBounds(250, 170, 200, 50);
		HeadToPSIButton.addActionListener(this);
		HeadToPSIButton.setText("Head to PSI");
		HeadToPSIButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		HeadToPSIButton.setFocusable(false);
		HeadToPSIButton.setBackground(Color.gray);

		//this adds a button for pipe length estimation to the GUI JFrame
		EstimatorButton = new JButton();
		EstimatorButton.setBounds(30, 250, 200, 50);
		EstimatorButton.addActionListener(this);
		EstimatorButton.setText("Length & Fittings");
		EstimatorButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		EstimatorButton.setFocusable(false);
		EstimatorButton.setBackground(Color.gray);
		
		//this adds a button for pressure loss calculation for the GUI JFrame
		PressureLossButton = new JButton();
		PressureLossButton.setBounds(250, 250, 200, 50);
		PressureLossButton.addActionListener(this);
		PressureLossButton.setText("Pressure Loss");
		PressureLossButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		PressureLossButton.setFocusable(false);
		PressureLossButton.setBackground(Color.gray);

		//options panel which contains buttons
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(Color.darkGray);
		optionsPanel.setBounds(0, 100, 500, 600);

		//pipe icon for title JPanel
		ImageIcon pipeIcon = new ImageIcon("pipeicon.png");

		//title label for title panel
		JLabel titleLabel = new JLabel();
		titleLabel.setText("SELECT A CALCULATION");
		titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		//title panel
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.lightGray);
		titlePanel.setBounds(0, 0, 500, 100);
		titlePanel.setLayout(new BorderLayout());
		titlePanel.add(titleLabel);

		//label for results panel
		JLabel resultsLabel = new JLabel();
		resultsLabel.setText("RESULTS");
		resultsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		resultsLabel.setVerticalAlignment(JLabel.CENTER);
		resultsLabel.setHorizontalAlignment(JLabel.CENTER);

		//jpanel to label results
		JPanel resultsPanel = new JPanel();
		resultsPanel.setBackground(Color.lightGray);
		resultsPanel.setBounds(510, 0, 500, 100);
		resultsPanel.setLayout(new BorderLayout());
		resultsPanel.add(resultsLabel);

		//results text area
		JTextArea ta = new JTextArea();
		ta.setEditable(false);
		ta.setBackground(Color.white);
		ta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		ta.setForeground(Color.BLACK);
		ta.setBounds(20, 10, 450, 590);
		console = new TextAreaOutputStream(ta, 22);
		PrintStream resultsStream = new PrintStream(console);
		System.setOut(resultsStream);
		System.setErr(resultsStream);

		//JScrollPane that contains output stream
		JScrollPane consolePanel = new JScrollPane();
		consolePanel.setBackground(Color.white);
		consolePanel.setBounds(510, 100, 500, 600);
		consolePanel.setLayout(null);
		consolePanel.createVerticalScrollBar();
		consolePanel.add(ta);

		//JPanel to split calc options and results
		JPanel middleBarPanel = new JPanel();
		middleBarPanel.setBackground(Color.BLACK);
		middleBarPanel.setBounds(500, 100, 10, 600);

		//JPanel sitting above bar to split options
		JPanel upperMiddleBarPanel = new JPanel();
		upperMiddleBarPanel.setBackground(Color.BLACK);
		upperMiddleBarPanel.setBounds(500, 0, 10, 100);


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Piping Hand Calcs");
		this.setIconImage(pipeIcon.getImage());
		this.setSize(1010, 700);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		this.add(EstimatorButton);
		this.add(PressureLossButton);
		this.add(HeadToPSIButton);
		this.add(PSIToHeadButton);
		this.add(titlePanel);
		this.add(optionsPanel);
		this.add(upperMiddleBarPanel);
		this.add(middleBarPanel);
		this.add(resultsPanel);
		this.add(consolePanel);

	}


    @Override
    public void actionPerformed(ActionEvent e) {

		//if estimator button is clicked open the estimator UI
        if (e.getSource()==EstimatorButton) {
			console.clear();
            EstimatorUI estimatorexecute = new EstimatorUI();
        }
		//if pressure loss button is clicked open the pressure loss UI
        if (e.getSource()==PressureLossButton) {
			console.clear();
            PressureLossUI pressurelossexecute = new PressureLossUI();
        }
		//if the head to psi button is clicked open the head to psi UI
		if (e.getSource()==HeadToPSIButton) {
			console.clear();
			HeadToPSIUI headtopsiexecute = new HeadToPSIUI();
		}
		//if the psi to head button is clicked open the psi to head UI
		if (e.getSource()==PSIToHeadButton) {
			console.clear();
			PSIToHeadUI psitoheadexecute = new PSIToHeadUI();
		}


    }



}
