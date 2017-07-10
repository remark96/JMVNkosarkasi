package controller;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Aplikacija;
import model.Cetvrtina;
import model.DataBase;
import model.Igrac;
import model.IzvestajUtakmice;
import model.Klub;
import model.StanjeKlupa;
import model.StanjeTeren;
import model.StatistikaIgraca;
import model.Sut;
import model.User;
import model.VrstaSuta;
import view.CustomNewGame;
import view.DialogForKvadrant;
import view.DialogWindow;
import view.DrugaStranaCNP;
import view.GraphicalElement;
import view.ImagePanel;
import view.MainWindow;
import view.PageForAdministrator;
import view.PageForNewGame;
import view.PageForRegularUser;
import view.PageForReports;
import view.PrvaStranaCNP;
import view.Spinner;

public class Controller {
	public Aplikacija aplikacija;
	MainWindow mainWindow;
	
	
	public Controller(Aplikacija aplikacija, MainWindow mainWindow) {
		this.aplikacija = aplikacija;
		this.mainWindow = mainWindow;
	}
	
	public void checkLogin() {
		User user = findUser();
		
		if (user == null) JOptionPane.showMessageDialog(mainWindow.getLogin(), "Invalid username and/or password!", "Error", JOptionPane.ERROR_MESSAGE);
		else {
			mainWindow.getLogin().setVisible(false);
			
			
			//Person person = null;
			JPanel page = null;
			
			if (user.getAdministrator())
			{
				page = new PageForAdministrator(aplikacija, this);
				mainWindow.setPageForAdministrator((PageForAdministrator)page);
				mainWindow.putPageForAdminOnScreen();
				((PageForAdministrator) page).fillPage(user);
			}
			else
			{
				page = new PageForRegularUser();
				mainWindow.setPageForUser((PageForRegularUser)page);
				mainWindow.putPageForUserOnScreen();
			}		
				
		}
	}

	@SuppressWarnings("deprecation")
	public User findUser() {
		ArrayList<User> users = aplikacija.getUsers();
		
		if (users.size() == 0) {
			JOptionPane.showMessageDialog(null, "Nijedan user nije ucitan!");
			return null;
		}
		
		for (User user : users) {
			if (user.equals(mainWindow.getLogin().getFieldUsername().getText(), mainWindow.getLogin().getFieldPassword().getText())) return user;
		}
		
		return null;
	}

	public void processLoginEvent() {
		String[] namesOfFields = {"Username", "Password"};
		DialogWindow login = new DialogWindow(mainWindow, "Login", namesOfFields, true);
		mainWindow.setLogin(login);
		login.setVisible(true);
		
	}

	public void processExitEvent() {
		mainWindow.setVisible(false);
		System.exit(0);
		
	}

	public void processCancelEvent() {
		mainWindow.getLogin().setVisible(false);
	}

	public void processCheckBoxlEvent() {
		if (mainWindow.getLogin().getCheckBox().isSelected()) mainWindow.getLogin().getFieldPassword().setEchoChar((char)0);
		else  mainWindow.getLogin().getFieldPassword().setEchoChar('*');
	}

	public void processNewGameEvent() {
		mainWindow.setCustomeNewGame(new CustomNewGame(this));
		mainWindow.getCustomeNewGame().setVisible(true);
	}

	public void processReportsEvent() {
		// TODO Auto-generated method stub
		
	}

	public void processDugmeZaCetvrtinuEvent() {
		PageForNewGame pageForNewGame = mainWindow.getPageForNewGame();
		
		if (pageForNewGame.getDugmeZaCetvrtinu().getText().equals("Kraj")) {
			int opcija = JOptionPane.showOptionDialog(pageForNewGame, "Da li zelite sad da pogledate upravo kreirani izvestaj utakmice?", "Prikazivanje izvestaja utakmice...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			
			if (opcija == 0) {
				IzvestajUtakmice aktuelniIzvestaj = aplikacija.getAktuelniIzvestajUtakmice();
				mainWindow.setPageForReports(new PageForReports(this, aktuelniIzvestaj));
				mainWindow.putPageForReportsOnScreen();
			}
			else if (opcija == 1) mainWindow.putPageForUserOnScreen();
			
		}
		else {
			pageForNewGame.setIndeksCetvrtine(pageForNewGame.getIndeksCetvrtine() + 1);
			pageForNewGame.getCetvrtinaLabel().setText(pageForNewGame.getIndeksCetvrtine() + ". Cetvrtina");
			
			if (pageForNewGame.getIndeksCetvrtine() == 1) ukljuciDataPanele(pageForNewGame);
			
			String ispis;
			if (pageForNewGame.getIndeksCetvrtine() < 4) ispis = "Zapocni " + (pageForNewGame.getIndeksCetvrtine() + 1) + ". cetvrtinu";
			else ispis = "Kraj";
			pageForNewGame.getDugmeZaCetvrtinu().setText(ispis);
		}
		
	}
	
	private void ukljuciDataPanele(PageForNewGame pageForNewGame) {
		ImagePanel ip = pageForNewGame.getWestpanel();
		GraphicalElement[] hostPlayers = ip.getHostPlayers();
		GraphicalElement[] guestPlayers = ip.getGuestPlayers();
		GraphicalElement trenerDomacin  = ip.getTrenerDomacin();
		GraphicalElement trenerGost = ip.getTrenerGost();
		
		ArrayList<StatistikaIgraca> statistikeDomacihIgraca = aplikacija.getAktuelniIzvestajUtakmice().getStatistikaDomacihIgraca();
    	ArrayList<StatistikaIgraca> statistikeGostujucihIgraca = aplikacija.getAktuelniIzvestajUtakmice().getStatistikaGostujucihIgraca();
		
		for (int i = 0; i < hostPlayers.length; i++) {
			if (statistikeDomacihIgraca.get(i).getAktuelnoStanje().getTip() == 1) hostPlayers[i].getDataPanel().setEnabled(true);
			if(statistikeGostujucihIgraca.get(i).getAktuelnoStanje().getTip() == 1) guestPlayers[i].getDataPanel().setEnabled(true);
			
		}
		trenerDomacin.getDataPanel().setEnabled(true);
		trenerGost.getDataPanel().setEnabled(true);
		
	}

	public void processSpinnerEvent(int indeksAtributa, Spinner spinner) {
		IzvestajUtakmice aktuelniIzvestaj = aplikacija.getAktuelniIzvestajUtakmice();
		PageForNewGame pageForNewGame = mainWindow.getPageForNewGame();
		GraphicalElement selected = pageForNewGame.getWestpanel().selectedGraphicalElement;
		
		StatistikaIgraca statistikaIgraca;
		if (selected.getDomaci()) statistikaIgraca = aktuelniIzvestaj.getStatistikaDomacegIgr(selected.getTitle());
		else statistikaIgraca = aktuelniIzvestaj.getStatistikaGostujucegIgr(selected.getTitle());
		
		Cetvrtina cetvrtina = statistikaIgraca.getCetvrtina(pageForNewGame.getIndeksCetvrtine() - 1);
		
		if (indeksAtributa <= 5) {
			
			int kvadrant;
			if (indeksAtributa != 0 && indeksAtributa != 3) {
				pageForNewGame.setDialogForKvadrant(new DialogForKvadrant(this));
			
				DialogForKvadrant dialogForKvadrant = pageForNewGame.getDialogForKvadrant();
				dialogForKvadrant.setVisible(true);
				
				kvadrant = dialogForKvadrant.getKvadrant();
			}
			else {
				kvadrant = 5;
			}
					
			boolean pogodak = false;
			if (indeksAtributa <= 2) pogodak = true;
			
			ArrayList<Sut> sutevi = cetvrtina.getSutevi();
			sutevi.add(new Sut(VrstaSuta.values()[3 % (indeksAtributa + 1)] , kvadrant, pogodak));
			
			DataBase.updateSuteva(pageForNewGame.getIndeksCetvrtine(), statistikaIgraca.getIgrac().getId(), aktuelniIzvestaj.getUtakmica().getIdUtakmice(), sutevi);
			System.out.println("UPDATE-OVANI SU SUTEVI");
			
		}
		else {
			int value = Integer.parseInt(spinner.getValue().toString());
			switch (indeksAtributa) {
				case 6: cetvrtina.setAsistencije(value); break;
				case 7: cetvrtina.setDef_skokovi(value); break;
				case 8: cetvrtina.setOfa_skokovi(value); break;
				case 9: cetvrtina.setLicne_greske1(value); break;
				case 10: cetvrtina.setLicne_greske2(value); break;
				case 11: cetvrtina.setLicne_greske3(value); break;
				case 12: cetvrtina.setNesportske_greske1(value); break;
				case 13: cetvrtina.setNesportske_greske2(value); break;
				case 14: cetvrtina.setNesportske_greske3(value); break;
				case 15: cetvrtina.setTehnicke_greske(value); break;
				case 16: cetvrtina.setBlokade(value); break;
				case 17: cetvrtina.setKoraci(value); break;
				case 18: cetvrtina.setDuplaLopta(value); break;
				case 19: cetvrtina.setLoseDodavanje(value); break;
				case 20: cetvrtina.setLoseHvatanje(value); break;
				case 21: cetvrtina.setLoseVodjenje(value); break;
				case 22: cetvrtina.setTriSecUReketu(value); break;
				case 23: cetvrtina.setPetSecPrilikomIzvodjenjaAuta(value); break;
				case 24: cetvrtina.setOsamSecProsloPrePrelaskaSredineTerena(value); break;
				case 25: cetvrtina.setPrekoPola(value); break;
				case 26: cetvrtina.setFaulUNapaduSLoptom(value); break;
				case 27: cetvrtina.setFaulUNapaduBezLopte(value); break;
				case 28: cetvrtina.setFaulUOdbrani(value); break;	
				default: break;
			}
			System.out.println(Spinner.imenaAtributa[indeksAtributa] + "|" + indeksAtributa);
			String sql = "update CETVRTINA set " + Spinner.imenaAtributa[indeksAtributa] + " = " + spinner.getValue().toString() + " where redbr = " 
						+ pageForNewGame.getIndeksCetvrtine() + " and idigraca = " + statistikaIgraca.getIgrac().getId() + " and idutakmice = " 
						+ aktuelniIzvestaj.getUtakmica().getIdUtakmice();
			try {
				DataBase.statement.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		System.out.println("AAAAAAAAAAA");
		
	}
	
	public void processButtonNextForNewGameEvent() {
		CustomNewGame customNewGame = mainWindow.getCustomeNewGame();
		PrvaStranaCNP prvaStrana = customNewGame.getPrvaStrana();
		
		int indexDomacegKluba = prvaStrana.getComboDomaciKlub().getSelectedIndex();
		int indexGostujucegKluba = prvaStrana.getComboGostujuciKlub().getSelectedIndex();
		int indexDelegata = prvaStrana.getComboDelegat().getSelectedIndex();
		int indexHale = prvaStrana.getComboHala().getSelectedIndex();
		
		if (indexDomacegKluba == 0 || indexGostujucegKluba == 0 || indexDelegata == 0 || indexHale == 0 || indexDomacegKluba == indexGostujucegKluba) {
			JOptionPane.showMessageDialog(customNewGame, "Neispravan odabir!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ArrayList<Integer> indexiSudija = new ArrayList<Integer>();
		try {
			proveriIspravnostOdabiraSudije(prvaStrana.getComboPrviSudija().getSelectedIndex() - 1, indexiSudija);
			proveriIspravnostOdabiraSudije(prvaStrana.getComboDrugiSudija().getSelectedIndex() - 1, indexiSudija);
			proveriIspravnostOdabiraSudije(prvaStrana.getComboTreciSudija().getSelectedIndex() - 1, indexiSudija);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(customNewGame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		aplikacija.noviIzvestajUtakmice(indexDomacegKluba - 1, indexGostujucegKluba - 1, indexiSudija, indexDelegata - 1, indexHale - 1);
		
		customNewGame.getContentPane().remove(customNewGame.getPrvaStrana());
		customNewGame.setDrugaStrana(new DrugaStranaCNP(this));
		customNewGame.getContentPane().add(customNewGame.getDrugaStrana(), BorderLayout.CENTER);
			
			
	
		
//		else {
			
//			aplikacija.sacuvajNoviIzvestajUtakmice();
//			mainWindow.getCustomeNewGame().setVisible(false);
//			mainWindow.setPageForNewGame(new PageForNewGame(this));
//			mainWindow.putPageForNewGamerOnScreen();
//		}
		
		customNewGame.revalidate();
		customNewGame.repaint();
	}

	private void proveriIspravnostOdabiraSudije(int index, ArrayList<Integer> indexiSudija) throws Exception {
		for (Integer integer : indexiSudija) {
			if (integer == index) throw new Exception("Neispravan odabir sudija!");
		}
		
		indexiSudija.add(index);
		
		
	}
	
//	public void processOkForNewGameEvent() {
//		CustomNewGame customNewGame = mainWindow.getCustomeNewGame();
//		
//		int indexDomacegKluba = customNewGame.getComboDomaciKlub().getSelectedIndex();
//		int indexGostujucegKluba = customNewGame.getComboGostujuciKlub().getSelectedIndex();
//		int indexDelegata = customNewGame.getComboDelegat().getSelectedIndex();
//		int indexHale = customNewGame.getComboHala().getSelectedIndex();
//		
//		if (indexDomacegKluba == 0 || indexGostujucegKluba == 0 || indexDelegata == 0 || indexHale == 0 || indexDomacegKluba == indexGostujucegKluba) {
//			JOptionPane.showMessageDialog(customNewGame, "Neispravan odabir!", "Error", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		
//		ArrayList<Integer> indexiSudija = new ArrayList<Integer>();
//		try {
//			proveriIspravnostOdabiraSudije(customNewGame.getComboPrviSudija().getSelectedIndex() - 1, indexiSudija);
//			proveriIspravnostOdabiraSudije(customNewGame.getComboDrugiSudija().getSelectedIndex() - 1, indexiSudija);
//			proveriIspravnostOdabiraSudije(customNewGame.getComboTreciSudija().getSelectedIndex() - 1, indexiSudija);
//			
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(customNewGame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		
//		mainWindow.getCustomeNewGame().setVisible(false);
//		
//		aplikacija.noviIzvestajUtakmice(indexDomacegKluba - 1, indexGostujucegKluba - 1, indexiSudija, indexDelegata - 1, indexHale - 1);
//		aplikacija.sacuvajNoviIzvestajUtakmice();
//		
//		mainWindow.setPageForNewGame(new PageForNewGame(this));
//		mainWindow.putPageForNewGamerOnScreen();
//		
//	}

	public void processCancelFroNewgameEvent() {
		mainWindow.getCustomeNewGame().setVisible(false);
	}

	public void processOkButtonDialogForKvadrant() {
		DialogForKvadrant dialog = mainWindow.getPageForNewGame().getDialogForKvadrant();
		
		for (int i = 0; i < dialog.getRadioButtons().length; i++) {
			if (dialog.getRadioButtons()[i].isSelected()) {
				dialog.setKvadrant(i + 1);
				break;
			}
		}
		
		dialog.setVisible(false);
		
	}

	public void dodavanjeIgraca(String id, String ime, String prezime, String visina, String tezina, Klub klub, String pathFotografija) 
	{
		String sqlOsoba = "insert into osoba values(" + id + ", " + "'" + ime  + "'" + ", " + "'" + prezime  + "'" + ")";
		String sqlIgrac = "insert into igrac values(" + id + ", " + visina + ", " + tezina + ", " +  (new Integer(klub.getIdKluba())).toString()  + ", " + "'" + pathFotografija + "'" + ")";
		try {
			DataBase.statement.executeUpdate(sqlOsoba);
			DataBase.statement.executeUpdate(sqlIgrac);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void izmenaIgraca(Igrac igrac, String ime, String prezime, String visina, String tezina, Klub klub, String pathFotografija) {
		String sqlOsoba = "update osoba set " + "ime=" + "'" + ime  + "'" + ", " + "prezime=" + "'" + prezime  + "'" 
				+ " where idosobe=" + (new Integer(igrac.getId())).toString();
		String sqlIgrac = "update igrac set " + "visina=" + visina + ", " + "tezina=" + tezina + ", " +
				"idkluba=" + (new Integer(klub.getIdKluba())).toString() + ", " + 
				"putanjadofotografije=" + "'" + pathFotografija + "'" + " where " +
				"idigraca=" + (new Integer(igrac.getId())).toString();
		try {
			DataBase.statement.executeUpdate(sqlOsoba);
			DataBase.statement.executeUpdate(sqlIgrac);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void brisanjeIgraca(Igrac igrac)
	{
		String sqlIgrac = "delete from igrac where idigraca=" + (new Integer(igrac.getId())).toString();
		String sqlOsoba = "delete from osoba where idosobe=" + (new Integer(igrac.getId())).toString();
		try {
			DataBase.statement.executeUpdate(sqlIgrac);
			DataBase.statement.executeUpdate(sqlOsoba);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void processBackFroNewgameEvent() {
		CustomNewGame customNewGame = mainWindow.getCustomeNewGame();
		customNewGame.getContentPane().remove(customNewGame.getDrugaStrana());
		customNewGame.getContentPane().add(customNewGame.getPrvaStrana(), BorderLayout.CENTER);
		
		customNewGame.revalidate();
		customNewGame.repaint();
	}
	
	public void processButtonFinishForNewGameEvent() {
		CustomNewGame customNewGame = mainWindow.getCustomeNewGame();
		
		JCheckBox[] domaciCheckBox = customNewGame.getDrugaStrana().getDomaci();
		JCheckBox[] gostujuciCheckBox = customNewGame.getDrugaStrana().getGostujuci();
		
		ArrayList<StatistikaIgraca> statistikeDomacihIgraca = aplikacija.getAktuelniIzvestajUtakmice().getStatistikaDomacihIgraca();
		ArrayList<StatistikaIgraca> statistikeGostujucihIgraca = aplikacija.getAktuelniIzvestajUtakmice().getStatistikaGostujucihIgraca();
    	
		
		int[] prvaPostavaDomaci;
		int[] prvaPostavaGostujuci;
		
		try {
			prvaPostavaDomaci = proveriCheckiranje(domaciCheckBox);
			prvaPostavaGostujuci =  proveriCheckiranje(gostujuciCheckBox);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(customNewGame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		postaviPrvuPostavu(prvaPostavaDomaci, statistikeDomacihIgraca);
		postaviPrvuPostavu(prvaPostavaGostujuci, statistikeGostujucihIgraca);
		
		aplikacija.sacuvajNoviIzvestajUtakmice();
		mainWindow.getCustomeNewGame().setVisible(false);
		
//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setVisible(true);
//		progressBar.setToolTipText("Postavljanje terena...");
		
		
		mainWindow.setPageForNewGame(new PageForNewGame(this));
		mainWindow.putPageForNewGamerOnScreen();
		
	}
	
	private void postaviPrvuPostavu(int[] prvaPostava, ArrayList<StatistikaIgraca> statistikeIgraca) {
		boolean uslov;
		
		for (int i = 0; i < statistikeIgraca.size(); i++) {
			uslov = true;
			for (Integer index : prvaPostava) {
				if (i == index) {
					statistikeIgraca.get(i).promeniStanje(new StanjeTeren());
					uslov = false;
					break;
				}
			}
			
			if (uslov) statistikeIgraca.get(i).promeniStanje(new StanjeKlupa());
		}
		
	}
	
	private int[] proveriCheckiranje(JCheckBox[] checkBox) throws Exception {
		int br = 0;
		int[] prvaPostava = new int[5];
		
		for (int i = 0; i < checkBox.length; i++) {
			if (checkBox[i].isSelected()) {
				if (br >= 5) throw new Exception("Neispravno check-iranje startnih igraca!"); 
				prvaPostava[br] = i;
				br++;
				
			}
		}
		
		if (br != 5) throw new Exception("Neispravno check-iranje startnih igraca!"); 
		
		return prvaPostava;
	}

}
