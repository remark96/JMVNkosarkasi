package model;

public class Trener extends Osoba {
	private String putanjaDoFotografije;

	public Trener(int id, String ime, String prezime, String putanjaDoFotografije) {
		super(id, ime, prezime);
		this.putanjaDoFotografije = putanjaDoFotografije;
	}

	public String getPutanjaDoFotografije() { return putanjaDoFotografije; }
	public void setPutanjaDoFotografije(String putanjaDoFotografije) { this.putanjaDoFotografije = putanjaDoFotografije; }

}
