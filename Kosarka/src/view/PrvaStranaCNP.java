package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.Delegat;
import model.Hala;
import model.Klub;
import model.Sudija;

@SuppressWarnings("serial")
public class PrvaStranaCNP extends JPanel implements ActionListener {
	private JComboBox<Klub> comboDomaciKlub;
	private JComboBox<Klub> comboGostujuciKlub;
	private JComboBox<Hala> comboHala;
	private JComboBox<Sudija> comboPrviSudija;
	private JComboBox<Sudija> comboDrugiSudija;
	private JComboBox<Sudija> comboTreciSudija;
	private JComboBox<Delegat> comboDelegat;
	
	private JButton buttonNext;
	private JButton buttonCancel;
	
	private JPanel centerPanel;
	private JPanel southPanel;
	
	private Controller controller;
	
	
	@SuppressWarnings("static-access")
	public PrvaStranaCNP(Controller controller) {
		setLayout(new BorderLayout());
		
		this.controller = controller;
		
		centerPanel = new JPanel(new GridLayout(10, 4));
		southPanel = new JPanel(new FlowLayout());
		
		ArrayList<Klub> klubovi = controller.aplikacija.getKlubovi(); 
		ArrayList<Hala> hale = controller.aplikacija.getHale();
		ArrayList<Sudija> sudije = controller.aplikacija.getSudije();
		ArrayList<Delegat> delegati = controller.aplikacija.getDelegati();
		
		comboDomaciKlub = new JComboBox<Klub>();
		comboGostujuciKlub = new JComboBox<Klub>();
		comboHala = new JComboBox<Hala>();
		comboPrviSudija = new JComboBox<Sudija>();
		comboDrugiSudija = new JComboBox<Sudija>();
		comboTreciSudija = new JComboBox<Sudija>();
		comboDelegat = new JComboBox<Delegat>();
		
		comboDomaciKlub.setBackground(Color.WHITE);
		comboGostujuciKlub.setBackground(Color.WHITE);
		comboHala.setBackground(Color.WHITE);
		comboPrviSudija.setBackground(Color.WHITE);
		comboDrugiSudija.setBackground(Color.WHITE);
		comboTreciSudija.setBackground(Color.WHITE);
		comboDelegat.setBackground(Color.WHITE);
		
		Klub prazanKlub = new Klub(-1, "", null, null, null, null);
		
		comboDomaciKlub.addItem(prazanKlub);
		for (int i = 0; i < klubovi.size(); i++) comboDomaciKlub.addItem(klubovi.get(i));
		
		comboGostujuciKlub.addItem(prazanKlub);
		for (int i = 0; i < klubovi.size(); i++) comboGostujuciKlub.addItem(klubovi.get(i));
		
		comboHala.addItem(new Hala("", "", ""));
		for (int i = 0; i < hale.size(); i++) comboHala.addItem(hale.get(i));
		
		Sudija prazanSudija = new Sudija(-1, "", "");
		
		comboPrviSudija.addItem(prazanSudija);
		comboDrugiSudija.addItem(prazanSudija);
		comboTreciSudija.addItem(prazanSudija);
		for (int i = 0; i < sudije.size(); i++) {
			comboPrviSudija.addItem(sudije.get(i));
			comboDrugiSudija.addItem(sudije.get(i));
			comboTreciSudija.addItem(sudije.get(i));
		}
		
		comboDelegat.addItem(new Delegat(-1, "", ""));
		for (int i = 0; i < delegati.size(); i++) comboDelegat.addItem(delegati.get(i));
		
		buttonNext = new JButton("Next");
		buttonCancel = new JButton("Cancel");
		
		buttonNext.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		for (int i = 0; i < 4; i++) centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel("")); centerPanel.add(new JLabel("Domaci klub: ")); centerPanel.add(comboDomaciKlub); centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel("")); centerPanel.add(new JLabel("Gostujuci klub: ")); centerPanel.add(comboGostujuciKlub); centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel("")); centerPanel.add(new JLabel("Hala: ")); centerPanel.add(comboHala); centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel("")); centerPanel.add(new JLabel("Prvi sudija: ")); centerPanel.add(comboPrviSudija); centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel("")); centerPanel.add(new JLabel("Drugi sudija: ")); centerPanel.add(comboDrugiSudija); centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel("")); centerPanel.add(new JLabel("Treci sudija: ")); centerPanel.add(comboTreciSudija); centerPanel.add(new JLabel(""));
		centerPanel.add(new JLabel("")); centerPanel.add(new JLabel("Delegat: ")); centerPanel.add(comboDelegat); centerPanel.add(new JLabel(""));
		for (int i = 0; i < 8; i++) add(new JLabel(""));
		//add(new JLabel("")); add(buttonNext); add(buttonCancel); add(new JLabel(""));
		
		southPanel.add(buttonNext); 
		southPanel.add(buttonCancel);
		
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        
		if (source == buttonNext) controller.processButtonNextForNewGameEvent();
        else if (source == buttonCancel) controller.processCancelFroNewgameEvent();
		
	}

	public JButton getButtonCancel() { return buttonCancel; }
	public void setButtonCancel(JButton buttonCancel) { this.buttonCancel = buttonCancel; }

	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }

	public JComboBox<Klub> getComboDomaciKlub() { return comboDomaciKlub; }
	public void setComboDomaciKlub(JComboBox<Klub> comboDomaciKlub) { this.comboDomaciKlub = comboDomaciKlub; }

	public JComboBox<Klub> getComboGostujuciKlub() { return comboGostujuciKlub; }
	public void setComboGostujuciKlub(JComboBox<Klub> comboGostujuciKlub) { this.comboGostujuciKlub = comboGostujuciKlub; }

	public JComboBox<Hala> getComboHala() { return comboHala; }
	public void setComboHala(JComboBox<Hala> comboHala) { this.comboHala = comboHala; }

	public JComboBox<Sudija> getComboPrviSudija() { return comboPrviSudija; }
	public void setComboPrviSudija(JComboBox<Sudija> comboPrviSudija) { this.comboPrviSudija = comboPrviSudija; }

	public JComboBox<Sudija> getComboDrugiSudija() { return comboDrugiSudija; }
	public void setComboDrugiSudija(JComboBox<Sudija> comboDrugiSudija) { this.comboDrugiSudija = comboDrugiSudija; }

	public JComboBox<Sudija> getComboTreciSudija() { return comboTreciSudija; }
	public void setComboTreciSudija(JComboBox<Sudija> comboTreciSudija) { this.comboTreciSudija = comboTreciSudija; }

	public JComboBox<Delegat> getComboDelegat() { return comboDelegat; }
	public void setComboDelegat(JComboBox<Delegat> comboDelegat) { this.comboDelegat = comboDelegat; }

	public JButton getButtonNext() { return buttonNext; }
	public void setButtonNext(JButton buttonNext) { this.buttonNext = buttonNext; }
}
