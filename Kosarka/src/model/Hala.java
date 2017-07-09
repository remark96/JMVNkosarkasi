package model;

public class Hala {
	private String naziv;
	private String adresa;
	private String mesto;
	
	public Hala(String naziv, String adresa, String mesto) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.mesto = mesto;
	}
	
	public String getNaziv() { return naziv; }
	public void setNaziv(String naziv) { this.naziv = naziv; }
	
	public String getAdresa() { return adresa; }
	public void setAdresa(String adresa) { this.adresa = adresa; }
	
	public String getMesto() {return mesto; }
	public void setMesto(String mesto) { this.mesto = mesto; }
	
	public boolean equals(String naziv) { return this.naziv.equals(naziv); }


	@Override
	public String toString() {
		if (naziv.equals("")) return naziv;
		return naziv + " (" + mesto + ")"; 
	}
	
	public String[] getArrayStrings(int i) 
	{ 
		return new String[] {"" + i + ".", naziv, adresa , mesto}; 
	}
}
