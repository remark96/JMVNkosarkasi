package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class DialogWindow extends JDialog implements ActionListener {
	
	private JLabel title;
	
	private String[] namesOfFields;
	
	private TextField fieldUsername;
	private PasswordField fieldPassword;
	
	private JCheckBox checkBox;
	
	private JPanel mainPanel;
	private JPanel panelForButtons;
	
	private JButton button1;
	private JButton buttonCancel;
	
	private Controller controller;
	
	private final int SIZE = 500;
	
	public DialogWindow (JFrame frame, String typeOfDialog, String[] namesOfFields, boolean modal) {
		super(frame, typeOfDialog, modal);
		setLocation(frame.getLocation().x + frame.getWidth()/4, frame.getLocation().y + frame.getHeight()/4);
		setSize(SIZE, SIZE);
		setLayout(new BorderLayout());
		
		this.namesOfFields = namesOfFields;
		
		title = new JLabel(typeOfDialog.toUpperCase(), JLabel.CENTER);
		title.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		title.setForeground(Color.BLUE);
		
		mainPanel = new JPanel(new GridLayout(namesOfFields.length*2 + 4, 3));
		panelForButtons = new JPanel(new FlowLayout());
		
		button1 = new JButton(typeOfDialog);
		buttonCancel = new JButton("Cancel");
		
		button1.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		panelForButtons.add(button1);
		panelForButtons.add(buttonCancel);
		
		JLabel label1 = new JLabel(namesOfFields[0], JLabel.CENTER);
		label1.setForeground(Color.BLUE);
		JLabel label2 = new JLabel(namesOfFields[1], JLabel.CENTER);
		label2.setForeground(Color.BLUE);
		
		fieldUsername = new TextField(35);
		fieldPassword = new PasswordField(35);
		
		fieldUsername.setText("markoradovic");
		fieldPassword.setText("python");
		// inicijalizovani radi lakseg testiranja
		
		checkBox = new JCheckBox("Prikazi password");
		checkBox.addActionListener(this);
		
		for (int i = 0; i < 6; i++) mainPanel.add(new JLabel());
		mainPanel.add(new JLabel()); mainPanel.add(label1); mainPanel.add(new JLabel());
		mainPanel.add(new JLabel()); mainPanel.add(fieldUsername); mainPanel.add(new JLabel());
		mainPanel.add(new JLabel()); mainPanel.add(label2); mainPanel.add(new JLabel());
		mainPanel.add(new JLabel()); mainPanel.add(fieldPassword); mainPanel.add(checkBox);
		for (int i = 0; i < 6; i++) mainPanel.add(new JLabel());
		
		getContentPane().add(title, BorderLayout.NORTH);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		getContentPane().add(panelForButtons, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (controller == null) controller = ((MainWindow) getParent()).getController();
		
		Object source = e.getSource();
        
		if (source == button1) controller.checkLogin();
        else if (source == buttonCancel) controller.processCancelEvent();
        else if (source == checkBox) controller.processCheckBoxlEvent();
		
	}

	public String[] getNamesOfFields() { return namesOfFields; }
	public void setNamesOfFields(String[] namesOfFields) { this.namesOfFields = namesOfFields; }

	public JPanel getMainPanel() { return mainPanel; }
	public void setMainPanel(JPanel mainPanel) { this.mainPanel = mainPanel; }

	public JPanel getPanelForButtons() { return panelForButtons; }
	public void setPanelForButtons(JPanel panelForButtons) { this.panelForButtons = panelForButtons; }

	public JButton getButton1() { return button1; }
	public void setButton1(JButton button1) { this.button1 = button1; }

	public JButton getButtonCancel() { return buttonCancel; }
	public void setButtonCancel(JButton buttonCancel) { this.buttonCancel = buttonCancel; }
	
	public TextField getFieldUsername() { return fieldUsername; }
	public void setFieldUsername(TextField fieldUsername) { this.fieldUsername = fieldUsername; }
	
	public PasswordField getFieldPassword() { return fieldPassword; }
	public void setFieldPassword(PasswordField fieldPassword) { this.fieldPassword = fieldPassword; }

	public JCheckBox getCheckBox() { return checkBox; }
	public void setCheckBox(JCheckBox checkBox) { this.checkBox = checkBox; }

	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }
}
