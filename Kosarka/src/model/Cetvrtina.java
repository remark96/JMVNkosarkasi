package model;

import java.util.ArrayList;

public class Cetvrtina {
	private ArrayList<Sut> sutevi;
	
	private int asistencije;
	private int def_skokovi;
	private int ofa_skokovi;
	private int licne_greske1;
	private int licne_greske2;
	private int licne_greske3;
	private int nesportske_greske1;
	private int nesportske_greske2;
	private int nesportske_greske3;
	private int tehnicke_greske;
	private int blokade;
	private int koraci;
	private int duplaLopta;
	private int loseDodavanje;
	private int loseHvatanje;
	private int loseVodjenje;
	private int triSecUReketu;
	private int petSecPrilikomIzvodjenjaAuta;
	private int osamSecProsloPrePrelaskaSredineTerena;
	private int prekoPola;
	private int faulUNapaduSLoptom;
	private int faulUNapaduBezLopte;
	private int faulUOdbrani;
	
	public Cetvrtina() {
		sutevi = new ArrayList<Sut>();
		
		asistencije = 0;
		def_skokovi = 0;
		ofa_skokovi = 0;
		licne_greske1 = 0;
		licne_greske2 = 0;
		licne_greske3 = 0;
		nesportske_greske1 = 0;
		nesportske_greske2 = 0;
		nesportske_greske3 = 0;
		tehnicke_greske = 0;
		blokade = 0;
		koraci = 0;
		duplaLopta = 0;
		loseDodavanje = 0;
		loseHvatanje = 0;
		loseVodjenje = 0;
		triSecUReketu = 0;
		petSecPrilikomIzvodjenjaAuta = 0;
		osamSecProsloPrePrelaskaSredineTerena = 0;
		prekoPola = 0;
		faulUNapaduSLoptom = 0;
		faulUNapaduBezLopte = 0;
		faulUOdbrani = 0;
	}
	
	

	public Cetvrtina(ArrayList<Sut> sutevi, int asistencije, int def_skokovi, int ofa_skokovi, int licne_greske1,
			int licne_greske2, int licne_greske3, int nesportske_greske1, int nesportske_greske2,
			int nesportske_greske3, int tehnicke_greske, int blokade, int koraci, int duplaLopta, int loseDodavanje,
			int loseHvatanje, int loseVodjenje, int triSecUReketu, int petSecPrilikomIzvodjenjaAuta,
			int osamSecProsloPrePrelaskaSredineTerena, int prekoPola, int faulUNapaduSLoptom, int faulUNapaduBezLopte,
			int faulUOdbrani) {
	
		this.sutevi = sutevi;
		this.asistencije = asistencije;
		this.def_skokovi = def_skokovi;
		this.ofa_skokovi = ofa_skokovi;
		this.licne_greske1 = licne_greske1;
		this.licne_greske2 = licne_greske2;
		this.licne_greske3 = licne_greske3;
		this.nesportske_greske1 = nesportske_greske1;
		this.nesportske_greske2 = nesportske_greske2;
		this.nesportske_greske3 = nesportske_greske3;
		this.tehnicke_greske = tehnicke_greske;
		this.blokade = blokade;
		this.koraci = koraci;
		this.duplaLopta = duplaLopta;
		this.loseDodavanje = loseDodavanje;
		this.loseHvatanje = loseHvatanje;
		this.loseVodjenje = loseVodjenje;
		this.triSecUReketu = triSecUReketu;
		this.petSecPrilikomIzvodjenjaAuta = petSecPrilikomIzvodjenjaAuta;
		this.osamSecProsloPrePrelaskaSredineTerena = osamSecProsloPrePrelaskaSredineTerena;
		this.prekoPola = prekoPola;
		this.faulUNapaduSLoptom = faulUNapaduSLoptom;
		this.faulUNapaduBezLopte = faulUNapaduBezLopte;
		this.faulUOdbrani = faulUOdbrani;
	}

	public ArrayList<Sut> getSutevi() { return sutevi; }
	public void setSutevi(ArrayList<Sut> sutevi) { this.sutevi = sutevi; }

	public int getAsistencije() { return asistencije; }
	public void setAsistencije(int asistencije) { this.asistencije = asistencije; }

	public int getDef_skokovi() { return def_skokovi; }
	public void setDef_skokovi(int def_skokovi) { this.def_skokovi = def_skokovi; }

	public int getOfa_skokovi() { return ofa_skokovi; }
	public void setOfa_skokovi(int ofa_skokovi) { this.ofa_skokovi = ofa_skokovi; }

	public int getLicne_greske1() { return licne_greske1; }
	public void setLicne_greske1(int licne_greske1) { this.licne_greske1 = licne_greske1; }

	public int getLicne_greske2() { return licne_greske2; }
	public void setLicne_greske2(int licne_greske2) { this.licne_greske2 = licne_greske2; }

	public int getLicne_greske3() { return licne_greske3; }
	public void setLicne_greske3(int licne_greske3) { this.licne_greske3 = licne_greske3; }

	public int getNesportske_greske1() { return nesportske_greske1; }
	public void setNesportske_greske1(int nesportske_greske1) { this.nesportske_greske1 = nesportske_greske1; }

	public int getNesportske_greske2() { return nesportske_greske2; }
	public void setNesportske_greske2(int nesportske_greske2) { this.nesportske_greske2 = nesportske_greske2; }

	public int getNesportske_greske3() { return nesportske_greske3;}
	public void setNesportske_greske3(int nesportske_greske3) { this.nesportske_greske3 = nesportske_greske3; }

	public int getTehnicke_greske() { return tehnicke_greske; }
	public void setTehnicke_greske(int tehnicke_greske) { this.tehnicke_greske = tehnicke_greske; }

	public int getBlokade() { return blokade; }
	public void setBlokade(int blokade) { this.blokade = blokade; }

	public int getKoraci() { return koraci; }
	public void setKoraci(int koraci) { this.koraci = koraci; }

	public int getDuplaLopta() { return duplaLopta; }
	public void setDuplaLopta(int duplaLopta) { this.duplaLopta = duplaLopta; }

	public int getLoseDodavanje() { return loseDodavanje; }
	public void setLoseDodavanje(int loseDodavanje) { this.loseDodavanje = loseDodavanje; }
	
	public int getLoseHvatanje() { return loseHvatanje; }
	public void setLoseHvatanje(int loseHvatanje) { this.loseHvatanje = loseHvatanje; }

	public int getLoseVodjenje() { return loseVodjenje; }
	public void setLoseVodjenje(int loseVodjenje) { this.loseVodjenje = loseVodjenje; }

	public int getTriSecUReketu() { return triSecUReketu; }
	public void setTriSecUReketu(int triSecUReketu) { this.triSecUReketu = triSecUReketu; }

	public int getPetSecPrilikomIzvodjenjaAuta() { return petSecPrilikomIzvodjenjaAuta; }
	public void setPetSecPrilikomIzvodjenjaAuta(int petSecPrilikomIzvodjenjaAuta) { this.petSecPrilikomIzvodjenjaAuta = petSecPrilikomIzvodjenjaAuta; }

	public int getOsamSecProsloPrePrelaskaSredineTerena() { return osamSecProsloPrePrelaskaSredineTerena; }
	public void setOsamSecProsloPrePrelaskaSredineTerena(int osamSecProsloPrePrelaskaSredineTerena) { this.osamSecProsloPrePrelaskaSredineTerena = osamSecProsloPrePrelaskaSredineTerena; }

	public int getPrekoPola() { return prekoPola; }
	public void setPrekoPola(int prekoPola) { this.prekoPola = prekoPola; }

	public int getFaulUNapaduSLoptom() { return faulUNapaduSLoptom; }
	public void setFaulUNapaduSLoptom(int faulUNapaduSLoptom) { this.faulUNapaduSLoptom = faulUNapaduSLoptom; }

	public int getFaulUNapaduBezLopte() { return faulUNapaduBezLopte; }
	public void setFaulUNapaduBezLopte(int faulUNapaduBezLopte) { this.faulUNapaduBezLopte = faulUNapaduBezLopte; }

	public int getFaulUOdbrani() { return faulUOdbrani; }
	public void setFaulUOdbrani(int faulUOdbrani) { this.faulUOdbrani = faulUOdbrani; }
	
}
