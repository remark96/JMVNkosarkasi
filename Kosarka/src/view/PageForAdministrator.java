package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Aplikacija;
import model.Hala;
import model.Igrac;
import model.Klub;
import model.User;

@SuppressWarnings("serial")
public class PageForAdministrator extends JPanel implements ActionListener
{
	protected Aplikacija aplikacija;
	protected Controller controller;
	
	protected JLabel name;
	protected JLabel nameOfUser;
	
	protected JButton potvrdiUnos;
	protected JTextField unosId;
	protected JComboBox<Igrac> unosIdIzmena;
	protected JTextField unosIme;
	protected JTextField unosPrezime;
	protected JTextField unosVisina;
	protected JTextField unosTezina;
	protected JComboBox<Klub> unosIdKluba;
	protected JTextField unosFotografija;
	protected String trenutnaFunkcija;
	
	protected JTable table;
	
	protected JPanel northPanel;
	protected JComponent centerPanel;
	protected JPanel westPanel;
	
	protected VerticalMenuBar vmb;
	
	public PageForAdministrator(Aplikacija aplikacija, Controller controller) {
		setLayout(new BorderLayout());
		
		this.aplikacija = aplikacija;
		this.controller = controller;
		
		this.table = new JTable();
		
		this.northPanel = new JPanel(new GridLayout(2, 1));
		this.centerPanel = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		
		this.westPanel = new JPanel(new BorderLayout());
		
		name = new JLabel("RAD SA PODACIMA", JLabel.CENTER); 
		name.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		name.setForeground(Color.BLUE);
		
		nameOfUser = new JLabel("", JLabel.CENTER); 
		nameOfUser.setFont(new Font("Naziv fonta", Font.PLAIN, 30));
		nameOfUser.setForeground(Color.BLUE);
		
		northPanel.add(name);
		northPanel.add(nameOfUser);
		
		vmb = new VerticalMenuBar(aplikacija, this);
	
		westPanel.add(vmb, BorderLayout.NORTH);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(westPanel, BorderLayout.WEST);
		
		trenutnaFunkcija = "";
	}
	public void funcForWestPanel(User user) {
		String[] menusStr = { "KLUBOVI", "HALE", "IGRACI", "TRENERI", "SUDIJE", "DELEGATI", "KORISNICI", "OSTALO" };
		String[][] items = { { "Prikaz klubova", "Dodavanje klubova", "Izmena klubova", "Brisanje klubova" },
				{ "Prikaz hala", "Dodavanje hala", "Izmena hala", "Brisanje hala" },
				{ "Prikaz igraca", "Dodavanje igraca", "Izmena igraca", "Brisanje igraca" },
				{ "Prikaz trenera", "Dodavanje trenera", "Izmena trenera", "Brisanje trenera" },
				{ "Prikaz sudija", "Dodavanje sudija", "Izmena sudija", "Brisanje sudija" },
				{ "Prikaz delegata", "Dodavanje delegata", "Izmena delegata", "Brisanje delegata" },
				{ "Prikaz korisnika", "Dodavanje korisnika", "Izmena korisnika", "Brisanje korisnika" },
				{ "Promena lozinke", "Sign out" } };

		putMenuBar(menusStr, items);

	}

	public void funcForNorthPanel(User user) {

	}

	public void funcForCenterPanel(User user) {

	}

	public void prikaziIgrace() 
	{
		trenutnaFunkcija = "prikazi igrace";
		
		if (centerPanel != null) remove(centerPanel);
		centerPanel = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		ArrayList<Igrac> igraci = aplikacija.getIgraci();

		DefaultTableModel tm = new DefaultTableModel();
		tm.setColumnIdentifiers(new String[] { "Redni broj", "Id", "IdKluba", "Ime", "Prezime", "Visina", "Tezina",
				"Putanja do fotografije" });
		for (int i = 0; i < igraci.size(); i++) {
			tm.addRow(igraci.get(i).getArrayStrings(i + 1));
		}
		getTable().setModel(tm);
		
		add(centerPanel, BorderLayout.CENTER);
		
		validate();
		repaint();
	}

	@SuppressWarnings("static-access")
	public void dodajIgraca() 
	{
		trenutnaFunkcija = "dodaj igraca";
		
		if (centerPanel != null) remove(centerPanel);

		JPanel panel = new JPanel(new GridLayout(0, 3));

		JLabel praznaLabela1 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela2 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela3 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela4 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela5 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela6 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela7 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela8 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela9 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela10 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela11 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela12 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela13 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela14 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela15 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela16 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela17 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela18 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela19 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela20 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela21 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela22 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela23 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela24 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela25 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela26 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela27 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela28 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela29 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela30 = new JLabel("\t\t\t\t\t\t");
		
		JLabel labelaId = new JLabel("Unesite id: ");
		unosId = new JTextField();
		JLabel labelaIme = new JLabel("Unesite ime: ");
		unosIme = new JTextField();
		JLabel labelaPrezime = new JLabel("Unesite prezime: ");
		unosPrezime = new JTextField();
		JLabel labelaVisina = new JLabel("Unesite visinu: ");
		unosVisina = new JTextField();
		JLabel labelaTezina = new JLabel("Unesite tezinu: ");
		unosTezina = new JTextField();
		JLabel labelaIdKluba = new JLabel("Izaberite klub: ");
		unosIdKluba = new JComboBox<Klub>();
		JLabel labelaFotografija = new JLabel("Unesite putanju do fotografije: ");
		unosFotografija = new JTextField();
		potvrdiUnos = new JButton("Potvrdi unos");
		potvrdiUnos.addActionListener(this);
		
		Klub prazanKlub = new Klub(-1, "", null, null, null, null);
		unosIdKluba.addItem(prazanKlub);
		ArrayList<Klub> klubovi = aplikacija.getKlubovi();
		for (int i = 0; i < klubovi.size(); i++) unosIdKluba.addItem(klubovi.get(i));

		panel.add(praznaLabela1); panel.add(labelaId); panel.add(praznaLabela16);   
		panel.add(praznaLabela2); panel.add(unosId); panel.add(praznaLabela17);
		panel.add(praznaLabela3); panel.add(labelaIme); panel.add(praznaLabela18);
		panel.add(praznaLabela4); panel.add(unosIme); panel.add(praznaLabela19);
		panel.add(praznaLabela5); panel.add(labelaPrezime); panel.add(praznaLabela20);
		panel.add(praznaLabela6); panel.add(unosPrezime); panel.add(praznaLabela21);
		panel.add(praznaLabela7); panel.add(labelaVisina); panel.add(praznaLabela22);
		panel.add(praznaLabela8); panel.add(unosVisina); panel.add(praznaLabela23);
		panel.add(praznaLabela9); panel.add(labelaTezina); panel.add(praznaLabela24);
		panel.add(praznaLabela10); panel.add(unosTezina); panel.add(praznaLabela25);
		panel.add(praznaLabela11); panel.add(labelaIdKluba); panel.add(praznaLabela26);
		panel.add(praznaLabela12); panel.add(unosIdKluba); panel.add(praznaLabela27);
		panel.add(praznaLabela13); panel.add(labelaFotografija); panel.add(praznaLabela28);
		panel.add(praznaLabela14); panel.add(unosFotografija); panel.add(praznaLabela29);
		panel.add(praznaLabela15); panel.add(potvrdiUnos); panel.add(praznaLabela30);

		add(panel, BorderLayout.CENTER);
		revalidate();
		repaint();

	}
	
	@SuppressWarnings("static-access")
	public void izmeniIgraca()
	{
		trenutnaFunkcija = "izmeni igraca";
		
		if (centerPanel != null) remove(centerPanel);

		JPanel panel = new JPanel(new GridLayout(0, 3));

		JLabel praznaLabela1 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela2 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela3 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela4 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela5 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela6 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela7 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela8 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela9 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela10 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela11 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela12 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela13 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela14 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela15 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela16 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela17 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela18 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela19 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela20 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela21 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela22 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela23 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela24 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela25 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela26 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela27 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela28 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela29 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela30 = new JLabel("\t\t\t\t\t\t");
		
		JLabel labelaId = new JLabel("Izaberite igraca: ");
		unosIdIzmena = new JComboBox<Igrac>();
		JLabel labelaIme = new JLabel("Unesite ime: ");
		unosIme = new JTextField();
		JLabel labelaPrezime = new JLabel("Unesite prezime: ");
		unosPrezime = new JTextField();
		JLabel labelaVisina = new JLabel("Unesite visinu: ");
		unosVisina = new JTextField();
		JLabel labelaTezina = new JLabel("Unesite tezinu: ");
		unosTezina = new JTextField();
		JLabel labelaIdKluba = new JLabel("Izaberite klub: ");
		unosIdKluba = new JComboBox<Klub>();
		JLabel labelaFotografija = new JLabel("Unesite putanju do fotografije: ");
		unosFotografija = new JTextField();
		potvrdiUnos = new JButton("Potvrdi unos");
		potvrdiUnos.addActionListener(this);
		
		Igrac prazanIgrac = new Igrac(-1, "", "", -1, -1, -1, "");
		unosIdIzmena.addItem(prazanIgrac);
		ArrayList<Igrac> igraci = aplikacija.getIgraci();
		for(int i=0; i<igraci.size(); i++) unosIdIzmena.addItem(igraci.get(i));
		
		Klub prazanKlub = new Klub(-1, "", null, null, null, null);
		unosIdKluba.addItem(prazanKlub);
		ArrayList<Klub> klubovi = aplikacija.getKlubovi();
		for (int i = 0; i < klubovi.size(); i++) unosIdKluba.addItem(klubovi.get(i));

		panel.add(praznaLabela1); panel.add(labelaId); panel.add(praznaLabela16);   
		panel.add(praznaLabela2); panel.add(unosIdIzmena); panel.add(praznaLabela17);
		panel.add(praznaLabela3); panel.add(labelaIme); panel.add(praznaLabela18);
		panel.add(praznaLabela4); panel.add(unosIme); panel.add(praznaLabela19);
		panel.add(praznaLabela5); panel.add(labelaPrezime); panel.add(praznaLabela20);
		panel.add(praznaLabela6); panel.add(unosPrezime); panel.add(praznaLabela21);
		panel.add(praznaLabela7); panel.add(labelaVisina); panel.add(praznaLabela22);
		panel.add(praznaLabela8); panel.add(unosVisina); panel.add(praznaLabela23);
		panel.add(praznaLabela9); panel.add(labelaTezina); panel.add(praznaLabela24);
		panel.add(praznaLabela10); panel.add(unosTezina); panel.add(praznaLabela25);
		panel.add(praznaLabela11); panel.add(labelaIdKluba); panel.add(praznaLabela26);
		panel.add(praznaLabela12); panel.add(unosIdKluba); panel.add(praznaLabela27);
		panel.add(praznaLabela13); panel.add(labelaFotografija); panel.add(praznaLabela28);
		panel.add(praznaLabela14); panel.add(unosFotografija); panel.add(praznaLabela29);
		panel.add(praznaLabela15); panel.add(potvrdiUnos); panel.add(praznaLabela30);

		add(panel, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	public void obrisiIgraca()
	{
		trenutnaFunkcija = "obrisi igraca";
		
		if (centerPanel != null) remove(centerPanel);

		JPanel panel = new JPanel(new GridLayout(0, 3));

		JLabel praznaLabela1 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela2 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela3 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela4 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela5 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela6 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela7 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela8 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela9 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela10 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela11 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela12 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela13 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela14 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela15 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela16 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela17 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela18 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela19 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela20 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela21 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela22 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela23 = new JLabel("\t\t\t\t\t\t");
		JLabel praznaLabela24 = new JLabel("\t\t\t\t\t\t");
		
		JLabel labelaId = new JLabel("Unesite id: ");
		unosIdIzmena = new JComboBox<Igrac>();
		potvrdiUnos = new JButton("Potvrdi unos");
		potvrdiUnos.addActionListener(this);
		
		Igrac prazanIgrac = new Igrac(-1, "", "", -1, -1, -1, "");
		unosIdIzmena.addItem(prazanIgrac);
		ArrayList<Igrac> igraci = aplikacija.getIgraci();
		for(int i=0; i<igraci.size(); i++) unosIdIzmena.addItem(igraci.get(i));
				
		panel.add(praznaLabela1); panel.add(labelaId); panel.add(praznaLabela2);
		panel.add(praznaLabela3); panel.add(unosIdIzmena); panel.add(praznaLabela4);
		panel.add(praznaLabela5); panel.add(potvrdiUnos); panel.add(praznaLabela6);
		panel.add(praznaLabela7); panel.add(praznaLabela8); panel.add(praznaLabela9);
		panel.add(praznaLabela10); panel.add(praznaLabela11); panel.add(praznaLabela12);
		panel.add(praznaLabela13); panel.add(praznaLabela14); panel.add(praznaLabela15);
		panel.add(praznaLabela16); panel.add(praznaLabela17); panel.add(praznaLabela18);
		panel.add(praznaLabela19); panel.add(praznaLabela20); panel.add(praznaLabela21);
		panel.add(praznaLabela22); panel.add(praznaLabela23); panel.add(praznaLabela24);
	
		add(panel, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public void prikaziHale() 
	{
		trenutnaFunkcija = "prikazi hale";
		
		if (centerPanel != null) remove(centerPanel);
		centerPanel = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		ArrayList<Hala> hale = aplikacija.getHale();

		DefaultTableModel tm = new DefaultTableModel();
		tm.setColumnIdentifiers(new String[] { "Redni broj", "Naziv", "Adresa", "Mesto" });
		for (int i = 0; i < hale.size(); i++) {
			tm.addRow(hale.get(i).getArrayStrings(i + 1));
		}
		getTable().setModel(tm);

		add(centerPanel, BorderLayout.CENTER);
		validate();
		repaint();
	}

	public void fillPage(User user) {
		funcForNorthPanel(user);
		funcForCenterPanel(user);
		funcForWestPanel(user);
	}
	
	public void putMenuBar(String[] menusStr, String[][] items) {
		JMenu menu;
		MenuItem menuItem;
		
		for (int i = 0; i < menusStr.length ; i++) {
			menu = new JMenu(menusStr[i]);
			for (int j = 0; j < items[i].length; j++) {
				System.out.println(items[i].length);
				menuItem = new MenuItem(items[i][j], this);
				menuItem.addActionListener();
				menu.add(menuItem);
			}
			
			vmb.add(menu);
		}
		
		westPanel.revalidate();
		westPanel.repaint();
	
	}
	
	@Override
	public void actionPerformed(ActionEvent a) 
	{
		Object source = a.getSource();
		
		if(source == potvrdiUnos)
		{
			if(trenutnaFunkcija.equals("dodaj igraca"))
			{
				controller.dodavanjeIgraca(unosId.getText(), unosIme.getText(), unosPrezime.getText(), 
						unosVisina.getText(), unosTezina.getText(), (Klub) unosIdKluba.getSelectedItem(), unosFotografija.getText());
				unosId.setText("");
				unosIme.setText("");
				unosPrezime.setText("");
				unosVisina.setText("");
				unosTezina.setText("");
				unosIdKluba.setSelectedItem(new Klub(-1, "", null, null, null, null));
				unosFotografija.setText("");
			}
			else if(trenutnaFunkcija.equals("izmeni igraca"))
			{
				controller.izmenaIgraca((Igrac)unosIdIzmena.getSelectedItem(), unosIme.getText(), unosPrezime.getText(), 
						unosVisina.getText(), unosTezina.getText(), (Klub) unosIdKluba.getSelectedItem(), unosFotografija.getText());	
				Igrac prazanIgrac = new Igrac(-1, "", "", -1, -1, -1, "");
				unosIdIzmena.setSelectedItem(prazanIgrac);
				unosIme.setText("");
				unosPrezime.setText("");
				unosVisina.setText("");
				unosTezina.setText("");
				unosIdKluba.setSelectedItem(new Klub(-1, "", null, null, null, null));
				unosFotografija.setText("");
			}
			else if(trenutnaFunkcija.equals("obrisi igraca"))
			{
				controller.brisanjeIgraca((Igrac)unosIdIzmena.getSelectedItem());
				Igrac prazanIgrac = new Igrac(-1, "", "", -1, -1, -1, "");
				unosIdIzmena.setSelectedItem(prazanIgrac);
			}
		}
	}
	
	public JPanel getNorthPanel() { return northPanel; }
	public void setNorthPanel(JPanel northPanel) { this.northPanel = northPanel; }

	public JComponent getCenterPanel() { return centerPanel; }
	public void setCenterPanel(JScrollPane centerPanel) { this.centerPanel = centerPanel; }

	public JPanel getEastPanel() { return westPanel; }
	public void setEastPanel(JPanel eastPanel) { this.westPanel = eastPanel; }

	public JLabel getNameOfFaculty() { return name; }
	public void setNameOfFaculty(JLabel nameOfFaculty) { this.name = nameOfFaculty; }

	public JLabel getNameOfUser() { return nameOfUser; }
	public void setNameOfUser(JLabel nameOfUser) { this.nameOfUser = nameOfUser; }

	public JTable getTable() { return table; }
	public void setTable(JTable table) { this.table = table; }

	public VerticalMenuBar getVmb() { return vmb; }
	public void setVmb(VerticalMenuBar vmb) { this.vmb = vmb; }
	
	public Aplikacija getAplikacija() {
		return aplikacija;
	}

	public void setAplikacija(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
	}

}
