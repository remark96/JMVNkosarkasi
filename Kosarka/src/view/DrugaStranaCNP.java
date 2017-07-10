package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.Igrac;
import model.IzvestajUtakmice;
import model.Klub;

@SuppressWarnings("serial")
public class DrugaStranaCNP extends JPanel implements ActionListener {
	
	private JButton buttonFinish;
	private JButton buttonCancel;
	private JButton buttonBack;
	
	private JCheckBox[] domaci;
	private JCheckBox[] gostujuci;
	
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private Controller controller;
	
	public DrugaStranaCNP(Controller controller) {
		setLayout(new BorderLayout());
		
		this.controller = controller;
		
		northPanel = new JPanel(new GridLayout(2, 3));
		centerPanel = new JPanel(new GridLayout(16, 4)); 
		southPanel = new JPanel(new FlowLayout());
		
		JLabel label = new JLabel("Biranje startnih igraca",JLabel.CENTER); 
		label.setFont(new Font("Naziv fonta", Font.PLAIN, 25));
		label.setForeground(Color.BLUE);
		
		northPanel.add(new JLabel(""));
		northPanel.add(label);
		for (int i = 0; i < 4; i++) northPanel.add(new JLabel(""));
		
		buttonFinish = new JButton("Finish");
		buttonCancel = new JButton("Cancel");
		buttonBack = new JButton("Back");
		
		buttonFinish.addActionListener(this);
		buttonCancel.addActionListener(this);
		buttonBack.addActionListener(this);
		
		domaci = new JCheckBox[IzvestajUtakmice.NUM_OF_PLAYERS];
		gostujuci = new JCheckBox[IzvestajUtakmice.NUM_OF_PLAYERS];
		
		Klub domaciKlub = controller.aplikacija.getAktuelniIzvestajUtakmice().getUtakmica().getDomaciKlub();
    	Klub gostujuciKlub = controller.aplikacija.getAktuelniIzvestajUtakmice().getUtakmica().getGostujuciKlub();
		
    	ArrayList<Igrac> domaciIgraci = domaciKlub.getIgraci();
    	ArrayList<Igrac> gostujuciIgraci = gostujuciKlub.getIgraci();
    	
    	JLabel labelD = new JLabel(domaciKlub.getImeKluba().toUpperCase());
    	JLabel labelG = new JLabel(gostujuciKlub.getImeKluba().toUpperCase());
    	
    	labelD.setForeground(Color.BLUE);
    	labelG.setForeground(Color.BLUE);
    	
    	centerPanel.add(new JLabel(""));
    	centerPanel.add(labelD);
    	centerPanel.add(new JLabel(""));
    	centerPanel.add(labelG);
		for (int i = 0; i < domaci.length; i++) {
			centerPanel.add(new JLabel(""));
			domaci[i] = new JCheckBox(domaciIgraci.get(i).toString());
			centerPanel.add(domaci[i]);
			centerPanel.add(new JLabel(""));
			gostujuci[i] = new JCheckBox(gostujuciIgraci.get(i).toString());
			centerPanel.add(gostujuci[i]);
		}
		
		southPanel.add(buttonBack);
		southPanel.add(buttonFinish);
		southPanel.add(buttonCancel);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        
		if (source == buttonFinish) controller.processButtonFinishForNewGameEvent();
        else if (source == buttonCancel) controller.processCancelFroNewgameEvent();
        else if (source == buttonBack) controller.processBackFroNewgameEvent();
		
	}

	public JButton getButtonFinish() { return buttonFinish; }
	public void setButtonFinish(JButton buttonFinish) { this.buttonFinish = buttonFinish; }

	public JButton getButtonCancel() { return buttonCancel; }
	public void setButtonCancel(JButton buttonCancel) { this.buttonCancel = buttonCancel; }

	public JButton getButtonBack() { return buttonBack; }
	public void setButtonBack(JButton buttonBack) { this.buttonBack = buttonBack; }

	public JCheckBox[] getDomaci() { return domaci; }
	public void setDomaci(JCheckBox[] domaci) { this.domaci = domaci; }

	public JCheckBox[] getGostujuci() { return gostujuci; }
	public void setGostujuci(JCheckBox[] gostujuci) { this.gostujuci = gostujuci; }

	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }
	
}

