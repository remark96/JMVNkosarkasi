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
	
	public void noviIzvestajUtakmice(int indexDomacegKluba, int indexGostujucegKluba, ArrayList<Integer> indexiSudija, int indexDelegata, int indexHale) {
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
	}
	
	public static Hala izaberiHalu(ArrayList<Hala> hale, String nazivHale) {
		for (Hala hala : hale) {
			if (hala.equals(nazivHale)) return hala;
		}
		
		return null;
	}

	public static Sudija[] izaberiSudije(ArrayList<Sudija> sudijeLista, ArrayList<Integer> idSudija) {
		Sudija[] sudije = new Sudija[3];
		
		int i = 0;
		for (int j : idSudija) {
			for (Sudija sudija : sudijeLista) {
				if (sudija.equals(j)) {
					sudije[i] = sudija;
					break;
				}
			}
			
			i++;
		}
	
		return sudije;
	}

	public static Delegat izaberiDelegata(ArrayList<Delegat> delegati, int id) {
		for (Delegat delegat : delegati) {
			if (delegat.equals(id)) return delegat;
		}
		
		return null;
	}

	public static Klub izaberiKlub(ArrayList<Klub> klubovi, int id) {
		for (Klub klub : klubovi) {
			if (klub.equals(id)) return klub;
		}
		
		return null;
	}

	public void sacuvajNoviIzvestajUtakmice() {
		izvestaji.add(aktuelniIzvestajUtakmice);
		
		DataBase.writeNoviIzvestajUtakmice(aktuelniIzvestajUtakmice);
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

	public ArrayList<Igrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(ArrayList<Igrac> igraci) {
		this.igraci = igraci;
	}
	
}
