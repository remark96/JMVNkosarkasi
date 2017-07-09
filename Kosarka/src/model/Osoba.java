package model;

public abstract class Osoba {
	protected int id;
	protected String ime;
	protected String prezime;
	
	public Osoba(int id, String ime, String prezime) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getIme() { return ime; }
	public void setIme(String ime) { this.ime = ime; }

	public String getPrezime() { return prezime; }
	public void setPrezime(String prezime) { this.prezime = prezime; }
	
	
	public boolean equals(int id) { return this.id == id; }

	@Override
	public String toString() {
		return ime + " " + prezime; 
	}
	
}
