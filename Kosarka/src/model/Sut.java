package model;

import model.VrstaSuta;

public class Sut {
	private VrstaSuta vrsta;
	private int kvadrant;
	private boolean pogodak;
	
	public Sut(VrstaSuta vrsta, int kvadrant, boolean pogodak) {
		this.vrsta = vrsta;
		this.kvadrant = kvadrant;
		this.pogodak = pogodak;
	}
	public VrstaSuta getVrsta() { return vrsta; }
	public void setVrsta(VrstaSuta vrsta) { this.vrsta = vrsta; }
	
	public int getKvadrant() { return kvadrant; }
	public void setKvadrant(int kvadrant) { this.kvadrant = kvadrant; }
	
	public boolean isPogodak() { return pogodak; }
	public void setPogodak(boolean pogodak) { this.pogodak = pogodak; }
	
}
