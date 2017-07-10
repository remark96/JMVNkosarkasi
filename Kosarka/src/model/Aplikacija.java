package model;

import java.util.ArrayList;
import java.util.Date;

public class Aplikacija {
	private ArrayList<User> users;
	private ArrayList<IzvestajUtakmice> izvestaji;
	private ArrayList<Sudija> sudije;
	private ArrayList<Delegat> delegati;
	private static ArrayList<Klub> klubovi;
	private ArrayList<Hala> hale;
	private ArrayList<Igrac> igraci;
	
	private IzvestajUtakmice aktuelniIzvestajUtakmice;
	
	//private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	
	public Aplikacija() {
		DataBase.initDB();
		
		users = DataBase.readUsers();
		hale = DataBase.readHalle();
		klubovi = DataBase.readKlubovi(hale);
		sudije = DataBase.readSudije();
		delegati = DataBase.readDelegate();
		igraci = DataBase.readIgraci();
		izvestaji = DataBase.readReports(hale, klubovi, sudije, delegati);
		
	}
	
	public boolean noviIzvestajUtakmice(int indexDomacegKluba, int indexGostujucegKluba, ArrayList<Integer> indexiSudija, int indexDelegata, int indexHale) {
		try {
			int idUtakmice = DataBase.kreirajIdZaNovuUtakmicu();
			Klub domaciKlub = klubovi.get(indexDomacegKluba);
			Klub gostujuciKlub = klubovi.get(indexGostujucegKluba);
			
			Sudija[] sudijeZaUtakmicu = new Sudija[indexiSudija.size()] ;
			for (int i = 0; i < indexiSudija.size(); i++) sudijeZaUtakmicu[i] = sudije.get(indexiSudija.get(i));
			
			Delegat delegat = delegati.get(indexDelegata);
			Hala hala = hale.get(indexHale);
			Date date = new Date();
			
			Utakmica utakmica = new Utakmica(idUtakmice, domaciKlub, gostujuciKlub, sudijeZaUtakmicu, delegat, hala, date);
			
			aktuelniIzvestajUtakmice = new IzvestajUtakmice(utakmica);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean sacuvajNoviIzvestajUtakmice(IzvestajUtakmice izvestajUtakmice) {
		try {
			izvestaji.add(izvestajUtakmice);
		} catch (NullPointerException e) {
			return false;
		}
		
		boolean uslov = DataBase.writeNoviIzvestajUtakmice(izvestajUtakmice);
		if (uslov) return true;
		return false;
	}

	public ArrayList<User> getUsers() { return users; }
	public void setUsers(ArrayList<User> users) { this.users = users; }

	public ArrayList<IzvestajUtakmice> getIzvestaji() { return izvestaji; }
	public void setIzvestaji(ArrayList<IzvestajUtakmice> izvestaji) { this.izvestaji = izvestaji; }

	public ArrayList<Sudija> getSudije() { return sudije; }
	public void setSudije(ArrayList<Sudija> sudije) { this.sudije = sudije; }

	public ArrayList<Delegat> getDelegati() { return delegati; }
	public void setDelegati(ArrayList<Delegat> delegati) { this.delegati = delegati; }

	public static ArrayList<Klub> getKlubovi() { return klubovi; }
	@SuppressWarnings("static-access")
	public void setKlubovi(ArrayList<Klub> klubovi) { this.klubovi = klubovi; }

	public ArrayList<Hala> getHale() { return hale; }
	public void setHale(ArrayList<Hala> hale) { this.hale = hale; }

	public IzvestajUtakmice getAktuelniIzvestajUtakmice() { return aktuelniIzvestajUtakmice; }
	public void setAktuelniIzvestajUtakmice(IzvestajUtakmice aktuelniIzvestajUtakmice) { this.aktuelniIzvestajUtakmice = aktuelniIzvestajUtakmice; }

	public ArrayList<Igrac> getIgraci() { return igraci; }
	public void setIgraci(ArrayList<Igrac> igraci) { this.igraci = igraci; }
	
}
