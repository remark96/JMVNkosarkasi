package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utakmica {
	private int idUtakmice;
	private Klub domaciKlub;
	private Klub gostujuciKlub;
	private Sudija[] sudije;
	private Delegat delegat;
	private Hala hala;
	private Date date;
	
	public Utakmica(int idUtakmice, Klub domaciKlub, Klub gostujuciKlub, Sudija[] sudije, Delegat delegat, Hala hala, Date date) {
		this.idUtakmice = idUtakmice;
		this.domaciKlub = domaciKlub;
		this.gostujuciKlub = gostujuciKlub;
		this.sudije = sudije;
		this.delegat = delegat;
		this.hala = hala;
		this.date = date;
	}
	
	public int getIdUtakmice() { return idUtakmice; }
	public void setIdUtakmice(int idUtakmice) { this.idUtakmice = idUtakmice; }

	public Klub getDomaciKlub() { return domaciKlub; }
	public void setDomaciKlub(Klub domaciKlub) { this.domaciKlub = domaciKlub; }

	public Klub getGostujuciKlub() { return gostujuciKlub; }
	public void setGostujuciKlub(Klub gostujuciKlub) { this.gostujuciKlub = gostujuciKlub; }

	public Sudija[] getSudije() { return sudije; }
	public void setSudije(Sudija[] sudije) { this.sudije = sudije; }

	public Delegat getDelegat() { return delegat; }
	public void setDelegat(Delegat delegat) { this.delegat = delegat; }

	public Hala getHala() { return hala; }
	public void setHala(Hala hala) { this.hala = hala; }
	
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	
}
