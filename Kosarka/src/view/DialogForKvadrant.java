package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.Controller;

@SuppressWarnings("serial")
public class DialogForKvadrant extends JDialog {
	private Controller controller;
	
	private int kvadrant;
	private JRadioButton[] radioButtons;
	
	private JLabel labelForImage;
	
	JPanel centerPanel;
	
	private JButton OK;
	
	private final int NUM_OF_R_BUTTS = 6;
	
	public DialogForKvadrant(Controller controller) {
		setSize(new Dimension(500, 600));
		setLayout(new BorderLayout());
		setTitle("Biranje kvadranta za sut...");
		setModal(true);
		setLocation(600, 100);
		setUndecorated(true);
		getRootPane().setBorder( BorderFactory.createLineBorder(Color.DARK_GRAY, 20) );
		
		this.setController(controller);
		
		centerPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
        			g.drawImage(ImageIO.read(new File("images/half_basketball_court.png")), centerPanel.getX(), centerPanel.getY(),getWidth(), getHeight() / 2, centerPanel);
        		} catch (IOException e1) {
        			e1.printStackTrace();
        		}
            }

        }; 
		
		
		String[] namesOfRadioButtons = {"1. kvdrant", "2. kvdrant", "3. kvdrant", "4. kvdrant", "5. kvdrant", "6. kvdrant"};
		
		JPanel southPanel = new JPanel(new BorderLayout());
		
		JPanel panelForRadioButtons = new JPanel(new GridLayout(6, 5));
		
		ButtonGroup group = new ButtonGroup();
		radioButtons = new JRadioButton[NUM_OF_R_BUTTS];
		
		panelForRadioButtons.add(new JLabel(""));
		for (int i = 0; i < radioButtons.length /2; i++) {
			radioButtons[i] = new JRadioButton(namesOfRadioButtons[i]); 
			group.add(radioButtons[i]);
			panelForRadioButtons.add(radioButtons[i]);
		}
		
		for (int i = 0; i < 7; i++) panelForRadioButtons.add(new JLabel(""));
		
		for (int i = radioButtons.length /2; i < radioButtons.length; i++) {
			radioButtons[i] = new JRadioButton(namesOfRadioButtons[i]); 
			group.add(radioButtons[i]);
			panelForRadioButtons.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);
		
		for (int i = 0; i < 16; i++) panelForRadioButtons.add(new JLabel(""));
		
		southPanel.add(panelForRadioButtons, BorderLayout.NORTH);
		
		JPanel panelForOK = new JPanel(new FlowLayout());
		
		OK = new JButton("Ok");
		OK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.processOkButtonDialogForKvadrant();
			}
		});
		panelForOK.add(OK);
		southPanel.add(panelForOK, BorderLayout.SOUTH);
		
		centerPanel.add(southPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);
		
		//centerPanel.repaint();
		
	}

	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }

	public int getKvadrant() { return kvadrant; }
	public void setKvadrant(int kvadrant) { this.kvadrant = kvadrant; }

	public JLabel getLabelForImage() { return labelForImage; }
	public void setLabelForImage(JLabel labelForImage) { this.labelForImage = labelForImage; }

	public JRadioButton[] getRadioButtons() { return radioButtons; }
	public void setRadioButtons(JRadioButton[] radioButtons) { this.radioButtons = radioButtons; }
	
}
