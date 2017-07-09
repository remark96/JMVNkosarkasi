package model;

public class Igrac extends Osoba {
	private int visina;
	private int tezina;
	private int idKluba;
	private String putanjaDoFotografije;
	
	public Igrac(int id, String ime, String prezime, int visina, int tezina, int idKluba, String putanjaDoFotografije) {
		super(id, ime, prezime);
		this.visina = visina;
		this.tezina = tezina;
		this.idKluba = idKluba;
		this.putanjaDoFotografije = putanjaDoFotografije;
	}

	public int getVisina() { return visina; }
	public void setVisina(int visina) { this.visina = visina; }

	public int getTezina() { return tezina; }
	public void setTezina(int tezina) { this.tezina = tezina; }

	public int getIdKluba() { return idKluba; }
	public void setIdKluba(int idKluba) { this.idKluba = idKluba; }
	
	public String getPutanjaDoFotografije() { return putanjaDoFotografije; }
	public void setPutanjaDoFotografije(String putanjaDoFotografije) { this.putanjaDoFotografije = putanjaDoFotografije; }

	public String[] getArrayStrings(int i) 
	{ 
		return new String[] {"" + i + ".", (new Integer(super.getId())).toString(), 
				(new Integer(idKluba)).toString(), super.getIme(), 
				super.getPrezime(), (new Integer(visina)).toString(),
				(new Integer(tezina)).toString(), putanjaDoFotografije}; 
	}
}
