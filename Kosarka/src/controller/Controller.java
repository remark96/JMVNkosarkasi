package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Aplikacija;
import model.Cetvrtina;
import model.DataBase;
import model.IzvestajUtakmice;
import model.StatistikaIgraca;
import model.Sut;
import model.User;
import model.VrstaSuta;
import view.CustomNewGame;
import view.DialogForKvadrant;
import view.DialogWindow;
import view.GraphicalElement;
import view.MainWindow;
import view.PageForAdministrator;
import view.PageForNewGame;
import view.PageForRegularUser;
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
				page = new PageForAdministrator(aplikacija);
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
			
		}
		else {
			pageForNewGame.getCetvrtinaLabel().setText(pageForNewGame.getIndeksCetvrtine() + ". Cetvrtina");
			pageForNewGame.setIndeksCetvrtine(pageForNewGame.getIndeksCetvrtine() + 1);;
			String ispis;
			if (pageForNewGame.getIndeksCetvrtine() < 5) ispis = "Zapocni " + pageForNewGame.getIndeksCetvrtine() + ". cetvrtinu";
			else ispis = "Kraj";
			pageForNewGame.getDugmeZaCetvrtinu().setText(ispis);
		}
		
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

	public void processOkForNewGameEvent() {
		CustomNewGame customNewGame = mainWindow.getCustomeNewGame();
		
		int indexDomacegKluba = customNewGame.getComboDomaciKlub().getSelectedIndex();
		int indexGostujucegKluba = customNewGame.getComboGostujuciKlub().getSelectedIndex();
		int indexDelegata = customNewGame.getComboDelegat().getSelectedIndex();
		int indexHale = customNewGame.getComboHala().getSelectedIndex();
		
		if (indexDomacegKluba == 0 || indexGostujucegKluba == 0 || indexDelegata == 0 || indexHale == 0 || indexDomacegKluba == indexGostujucegKluba) {
			JOptionPane.showMessageDialog(customNewGame, "Neispravan odabir!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ArrayList<Integer> indexiSudija = new ArrayList<Integer>();
		try {
			proveriIspravnostOdabiraSudije(customNewGame.getComboPrviSudija().getSelectedIndex() - 1, indexiSudija);
			proveriIspravnostOdabiraSudije(customNewGame.getComboDrugiSudija().getSelectedIndex() - 1, indexiSudija);
			proveriIspravnostOdabiraSudije(customNewGame.getComboTreciSudija().getSelectedIndex() - 1, indexiSudija);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(customNewGame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		mainWindow.getCustomeNewGame().setVisible(false);
		
		aplikacija.noviIzvestajUtakmice(indexDomacegKluba - 1, indexGostujucegKluba - 1, indexiSudija, indexDelegata - 1, indexHale - 1);
		aplikacija.sacuvajNoviIzvestajUtakmice();
		
		mainWindow.setPageForNewGame(new PageForNewGame(this));
		mainWindow.putPageForNewGamerOnScreen();
		
	}

	private void proveriIspravnostOdabiraSudije(int index, ArrayList<Integer> indexiSudija) throws Exception {
		for (Integer integer : indexiSudija) {
			if (integer == index) throw new Exception("Neispravan odabir sudija!");
		}
		
		indexiSudija.add(index);
		
		
	}

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


}
