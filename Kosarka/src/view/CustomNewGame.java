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
import model.Delegat;
import model.Hala;
import model.Klub;
import model.Sudija;


@SuppressWarnings("serial")
public class CustomNewGame extends JDialog implements ActionListener {
	private JComboBox<Klub> comboDomaciKlub;
	private JComboBox<Klub> comboGostujuciKlub;
	private JComboBox<Hala> comboHala;
	private JComboBox<Sudija> comboPrviSudija;
	private JComboBox<Sudija> comboDrugiSudija;
	private JComboBox<Sudija> comboTreciSudija;
	private JComboBox<Delegat> comboDelegat;
	
	private JButton buttonOK;
	private JButton buttonCancel;
	
	private Controller controller;
	
	public CustomNewGame() {
		
	}

	public CustomNewGame(Controller controller) {
		setSize(800, 500);
		setLayout(new GridLayout(10, 4));
		setTitle("Custom new game");
		setLocation(MainWindow.SIZE_SCREEN.width/5, MainWindow.SIZE_SCREEN.height/5);
		this.controller = controller;
		
		@SuppressWarnings("static-access")
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
		
		buttonOK = new JButton("OK");
		buttonCancel = new JButton("Cancel");
		
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		for (int i = 0; i < 4; i++) getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Domaci klub: ")); getContentPane().add(comboDomaciKlub); getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Gostujuci klub: ")); getContentPane().add(comboGostujuciKlub); getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Hala: ")); getContentPane().add(comboHala); getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Prvi sudija: ")); getContentPane().add(comboPrviSudija); getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Drugi sudija: ")); getContentPane().add(comboDrugiSudija); getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Treci sudija: ")); getContentPane().add(comboTreciSudija); getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel("")); getContentPane().add(new JLabel("Delegat: ")); getContentPane().add(comboDelegat); getContentPane().add(new JLabel(""));
		for (int i = 0; i < 4; i++) getContentPane().add(new JLabel(""));
		getContentPane().add(new JLabel(""));getContentPane().add(buttonOK);getContentPane().add(buttonCancel);getContentPane().add(new JLabel(""));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        
		if (source == buttonOK) controller.processOkForNewGameEvent();
        else if (source == buttonCancel) controller.processCancelFroNewgameEvent();
		
	}

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

	public JButton getButtonOK() { return buttonOK; }
	public void setButtonOK(JButton buttonOK) { this.buttonOK = buttonOK; }

	public JButton getButtonCancel() { return buttonCancel; }
	public void setButtonCancel(JButton buttonCancel) { this.buttonCancel = buttonCancel; }

	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; } 

}