package model;

import java.util.ArrayList;

public class StatistikaIgraca {
	private Igrac igrac;
	private ArrayList<Cetvrtina> cetvrtine;
	private StanjeIgraca aktuelnoStanje;
	private double minutes;
	

	public StatistikaIgraca(Igrac igrac, StanjeIgraca stanjeIgraca) {
		this.igrac = igrac;
		this.aktuelnoStanje = stanjeIgraca;
		cetvrtine = new ArrayList<Cetvrtina>();
		for (int i = 0; i < 4; i++) cetvrtine.add(new Cetvrtina());
		minutes = 0;
	}
	
	public StatistikaIgraca(Igrac igrac, StanjeIgraca stanjeIgraca, ArrayList<Cetvrtina> cetvrtine, double minutes) {
		this.igrac = igrac;
		this.aktuelnoStanje = stanjeIgraca;
		this.cetvrtine = cetvrtine;
		this.minutes = minutes;
	}
	
	public Igrac getIgrac() { return igrac; }
	public void setIgrac(Igrac igrac) { this.igrac = igrac; }

	public ArrayList<Cetvrtina> getCetvrtine() { return cetvrtine; }
	public void setCetvrtine(ArrayList<Cetvrtina> cetvrtine) { this.cetvrtine = cetvrtine; }

	public StanjeIgraca getAktuelnoStanje() { return aktuelnoStanje; }
	public void promeniStanje(StanjeIgraca aktuelnoStanje) { this.aktuelnoStanje = aktuelnoStanje; }

	public double getMinutes() { return minutes; }
	public void setMinutes(double minutes) { this.minutes = minutes; }
	
	public Cetvrtina getCetvrtina(int i) { return cetvrtine.get(i); }
	
}

