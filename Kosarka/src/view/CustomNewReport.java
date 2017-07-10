package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import controller.Controller;
import model.IzvestajUtakmice;


@SuppressWarnings("serial")
public class CustomNewReport extends JDialog implements ActionListener {
	private JComboBox<IzvestajUtakmice> comboUtakmica;
	private JButton buttonOK;
	private JButton buttonCancel;
	private Controller controller;
	
	public CustomNewReport() {
		
	}
	public CustomNewReport(Controller controller) {
		setSize(800, 500);
		setLayout(new GridLayout(10, 4));
		setTitle("Custom new game");
		setLocation(MainWindow.SIZE_SCREEN.width/5, MainWindow.SIZE_SCREEN.height/5);
		this.controller = controller;
		ArrayList<IzvestajUtakmice>utakmice=controller.aplikacija.getIzvestaji();
		
		comboUtakmica=new JComboBox<IzvestajUtakmice>();
		comboUtakmica.setBackground(Color.WHITE);
		for (int i=0;i<utakmice.size();i++) comboUtakmica.addItem(utakmice.get(i));
		
		
		
		buttonOK = new JButton("OK");
		buttonCancel = new JButton("Cancel");
		
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Izaberite utakmicu: ")); getContentPane().add(comboUtakmica); getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel(""));getContentPane().add(buttonOK);getContentPane().add(buttonCancel);getContentPane().add(new JLabel(""));
		
	}
	
	public JComboBox<IzvestajUtakmice> getComboUtakmica() {
		return comboUtakmica;
	}
	public void setComboUtakmica(JComboBox<IzvestajUtakmice> comboUtakmica) {
		this.comboUtakmica = comboUtakmica;
	}
	public JButton getButtonOK() {
		return buttonOK;
	}
	public void setButtonOK(JButton buttonOK) {
		this.buttonOK = buttonOK;
	}
	public JButton getButtonCancel() {
		return buttonCancel;
	}
	public void setButtonCancel(JButton buttonCancel) {
		this.buttonCancel = buttonCancel;
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == buttonOK) controller.processOkForReportEvent();
		else if (source == buttonCancel) controller.processCancelForReportEvent();
				
	}
}

