package model;

import java.util.ArrayList;

public class IzvestajUtakmice {
	private Utakmica utakmica;
	private ArrayList<StatistikaIgraca> statistikaDomacihIgraca;
	private ArrayList<StatistikaIgraca> statistikaGostujucihIgraca;
	private StatistikaTrenera statistikaDomacegTrenera;
	private StatistikaTrenera statistikaGostujucegTrenera;
	
	public static final int NUM_OF_PLAYERS = 12;
	
	
	public IzvestajUtakmice(Utakmica utakmica) {
		this.utakmica = utakmica;
		
		ArrayList<Igrac> domaci = utakmica.getDomaciKlub().getIgraci();
		ArrayList<Igrac> gostujuci = utakmica.getGostujuciKlub().getIgraci();
		
		statistikaDomacihIgraca = new ArrayList<StatistikaIgraca>();
		statistikaGostujucihIgraca = new ArrayList<StatistikaIgraca>();
		
		for (int i = 0; i < NUM_OF_PLAYERS; i++) {
			statistikaDomacihIgraca.add(new StatistikaIgraca(domaci.get(i), new StanjeIgracKojiCeIgrati()));
			statistikaGostujucihIgraca.add(new StatistikaIgraca(gostujuci.get(i), new StanjeIgracKojiCeIgrati()));
		}
		
		statistikaDomacegTrenera = new StatistikaTrenera(utakmica.getDomaciKlub().getTrener());
		statistikaGostujucegTrenera = new StatistikaTrenera(utakmica.getGostujuciKlub().getTrener());
	}

	public Utakmica getUtakmica() { return utakmica; }
	public void setUtakmica(Utakmica utakmica) { this.utakmica = utakmica; }

	public ArrayList<StatistikaIgraca> getStatistikaDomacihIgraca() { return statistikaDomacihIgraca; }
	public void setStatistikaDomacihIgraca(ArrayList<StatistikaIgraca> statistikaDomacihIgraca) { this.statistikaDomacihIgraca = statistikaDomacihIgraca; }

	public ArrayList<StatistikaIgraca> getStatistikaGostujucihIgraca() { return statistikaGostujucihIgraca; }
	public void setStatistikaGostujucihIgraca(ArrayList<StatistikaIgraca> statistikaGostujucihIgraca) { this.statistikaGostujucihIgraca = statistikaGostujucihIgraca; }

	public StatistikaTrenera getStatistikaDomacegTrenera() { return statistikaDomacegTrenera; }
	public void setStatistikaDomacegTrenera(StatistikaTrenera statistikaDomacegTrenera) { this.statistikaDomacegTrenera = statistikaDomacegTrenera; }

	public StatistikaTrenera getStatistikaGostujucegTrenera() { return statistikaGostujucegTrenera; }
	public void setStatistikaGostujucegTrenera(StatistikaTrenera statistikaGostujucegTrenera) { this.statistikaGostujucegTrenera = statistikaGostujucegTrenera; }
	
	
	public StatistikaIgraca getStatistikaDomacegIgr(String str) {
		for (StatistikaIgraca statistikaIgraca : statistikaDomacihIgraca) {
			if (str.equalsIgnoreCase(statistikaIgraca.getIgrac().ime + " " + statistikaIgraca.getIgrac().prezime)) return statistikaIgraca;
		}
		
		return null;
	}
	
	public StatistikaIgraca getStatistikaGostujucegIgr(String str) {
		for (StatistikaIgraca statistikaIgraca : statistikaGostujucihIgraca) {
			if (str.equalsIgnoreCase(statistikaIgraca.getIgrac().ime + " " + statistikaIgraca.getIgrac().prezime)) return statistikaIgraca;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		if (utakmica.getIdUtakmice()==0) return "";
		return utakmica.getDomaciKlub().getImeKluba()+" - "+utakmica.getGostujuciKlub().getImeKluba()+" , "+utakmica.getDate();
	}
}
