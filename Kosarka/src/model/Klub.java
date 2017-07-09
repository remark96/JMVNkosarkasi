package model;

import java.util.ArrayList;

public class Klub {
	private int idKluba;
	private String imeKluba;
	private ArrayList<Igrac> igraci;
	private Trener trener;
	private Hala hala;
	private String putanjaDoFotografije;
	
	public Klub(int idKluba, String imeKluba, ArrayList<Igrac> igraci, Trener trener, Hala hala, String putanjaDoFotografije) {
		this.idKluba = idKluba;
		this.imeKluba = imeKluba;
		this.igraci = igraci;
		this.trener = trener;
		this.hala = hala;
		this.putanjaDoFotografije = putanjaDoFotografije;
	}

	public int getIdKluba() { return idKluba; }
	public void setIdKluba(int idKluba) { this.idKluba = idKluba; }

	public String getImeKluba() { return imeKluba; }
	public void setImeKluba(String imeKluba) { this.imeKluba = imeKluba; }

	public ArrayList<Igrac> getIgraci() { return igraci; }
	public void setIgraci(ArrayList<Igrac> igraci) { this.igraci = igraci; }

	public Trener getTrener() { return trener; }
	public void setTrener(Trener trener) { this.trener = trener; }

	public Hala getHala() { return hala; }
	public void setHala(Hala hala) { this.hala = hala; }
	
	public String getPutanjaDoFotografije() { return putanjaDoFotografije; }
	public void setPutanjaDoFotografije(String putanjaDoFotografije) { this.putanjaDoFotografije = putanjaDoFotografije; }

	public boolean equals(int id) { return idKluba == id; }
	
	@Override
	public String toString() {
		if (imeKluba.equals("")) return imeKluba;
		return imeKluba.toUpperCase() + " (" + hala.getMesto() + ")"; 
	}
	
}
