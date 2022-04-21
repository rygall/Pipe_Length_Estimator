import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

        JButton EstimatorButton;
        JButton PressureLossButton;

        GUI() {

            EstimatorButton = new JButton();
            EstimatorButton.setBounds(30, 250, 200, 50);
            EstimatorButton.addActionListener(this);
            EstimatorButton.setText("Length Estimation");
            EstimatorButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            EstimatorButton.setFocusable(false);
            EstimatorButton.setBackground(Color.gray);


            PressureLossButton = new JButton();
            PressureLossButton.setBounds(250, 250, 200, 50);
            PressureLossButton.addActionListener(this);
            PressureLossButton.setText("Pressure Loss");
            PressureLossButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            PressureLossButton.setFocusable(false);
            PressureLossButton.setBackground(Color.gray);


            ImageIcon pipeicon = new ImageIcon("pipeicon-3.png");

            JLabel titleLabel = new JLabel();
            titleLabel.setText("SELECT A CALCULATION");
            titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            titleLabel.setVerticalAlignment(JLabel.CENTER);
            titleLabel.setHorizontalAlignment(JLabel.CENTER);


            JPanel titlePanel = new JPanel();
            titlePanel.setBackground(Color.lightGray);
            titlePanel.setBounds(0, 0, 500, 100);
            titlePanel.setLayout(new BorderLayout());
            titlePanel.add(titleLabel);


            JPanel optionsPanel = new JPanel();
            optionsPanel.setBackground(Color.darkGray);
            optionsPanel.setBounds(0, 100, 500, 300);


            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setTitle("  Piping Hand Calcs");
            this.setIconImage(pipeicon.getImage());
            this.setSize(500, 400);
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setFont(new Font("Times New Roman", Font.PLAIN, 10));
            this.add(EstimatorButton);
            this.add(PressureLossButton);
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
    }


}
