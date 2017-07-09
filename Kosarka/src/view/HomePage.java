package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.Controller;

@SuppressWarnings("serial")
public class HomePage extends JPanel implements ActionListener {
	private JLabel welcomeMessage;
	private JButton buttonLogin;
	private JButton buttonExit;
	private JLabel labelForImage;
	private JPanel panelForButtons;
	
	private Controller controller;
	
	public HomePage() {
		setLayout(new BorderLayout());
		setBackground(Color.ORANGE);
		
		welcomeMessage = new JLabel("WELCOME TO APPLICATION",JLabel.CENTER); 
		welcomeMessage.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		welcomeMessage.setForeground(Color.BLUE);
	
		labelForImage = new JLabel("", new ImageIcon("images/obradovic_logo.jpg"), JLabel.CENTER);
		
		panelForButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,25, 25));
		panelForButtons.setBackground(Color.RED);
		
		buttonLogin = new JButton("Login");
		buttonExit = new JButton("Exit");
		
		buttonLogin.addActionListener(this);
		buttonExit.addActionListener(this);
		
		panelForButtons.add(buttonLogin);
		panelForButtons.add(buttonExit);
		
		add(welcomeMessage, BorderLayout.NORTH);
		add(labelForImage, BorderLayout.CENTER);
		add(panelForButtons, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller == null) controller = ((MainWindow) SwingUtilities.getWindowAncestor(this)).getController();
		
		Object source = e.getSource();
        
		if (source == buttonLogin) controller.processLoginEvent();
        else if (source == buttonExit) controller.processExitEvent();
		
	}
	

}
