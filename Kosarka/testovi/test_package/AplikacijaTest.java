package test_package;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Aplikacija;
import model.DataBase;
import model.Delegat;
import model.Hala;
import model.IzvestajUtakmice;
import model.Klub;
import model.Sudija;
import model.Utakmica;

public class AplikacijaTest {
	static Aplikacija aplikacija;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		aplikacija = new Aplikacija();
	}
	
	@Test
	public void testNoviIzvestajUtakmice() {
		ArrayList<Integer> indeksiSudija1 =  new ArrayList<Integer>();
		indeksiSudija1.add(0);
		indeksiSudija1.add(1);
		indeksiSudija1.add(2);
		
		ArrayList<Integer> indeksiSudija2 =  new ArrayList<Integer>();
		indeksiSudija2.add(0);
		indeksiSudija2.add(1);
		indeksiSudija2.add(10);
		
		boolean condition1 = aplikacija.noviIzvestajUtakmice(0, 1, indeksiSudija1, 0, 0);
		boolean condition2 = aplikacija.noviIzvestajUtakmice(0, 1, indeksiSudija2, 0, 0);
		
		assertTrue(condition1);
		assertFalse(condition2);
	}

	@Test
	public void testSacuvajNoviIzvestajUtakmice() {
		int idUtakmice1 = DataBase.kreirajIdZaNovuUtakmicu();
		Klub domaciKlub1 = aplikacija.getKlubovi().get(0);
		Klub gostujuciKlub1 =aplikacija.getKlubovi().get(1);
		
		int idUtakmice2 = idUtakmice1;
		Klub domaciKlub2 = aplikacija.getKlubovi().get(2);
		Klub gostujuciKlub2 =aplikacija.getKlubovi().get(3);
		
		ArrayList<Integer> indeksiSudija1 = new ArrayList<Integer>();
		indeksiSudija1.add(0);
		indeksiSudija1.add(1);
		indeksiSudija1.add(2);
		ArrayList<Integer> indeksiSudija2 =  indeksiSudija1;
		
		Sudija[] sudijeZaUtakmicu1 = new Sudija[indeksiSudija1.size()] ;
		for (int i = 0; i < indeksiSudija1.size(); i++) sudijeZaUtakmicu1[i] = aplikacija.getSudije().get(indeksiSudija1.get(i));
		
		Sudija[] sudijeZaUtakmicu2 = new Sudija[indeksiSudija2.size()] ;
		for (int i = 0; i < indeksiSudija2.size(); i++) sudijeZaUtakmicu2[i] = aplikacija.getSudije().get(indeksiSudija2.get(i));
		
		Delegat delegat1 = aplikacija.getDelegati().get(0);
		Delegat delegat2 = aplikacija.getDelegati().get(0);
		
		Hala hala1 = aplikacija.getHale().get(1);
		Hala hala2 = aplikacija.getHale().get(2);
		
		Date date1 = new Date();
		Date date2 = date1;
		
		Utakmica utakmica1 = new Utakmica(idUtakmice1, domaciKlub1, gostujuciKlub1, sudijeZaUtakmicu1, delegat1, hala1, date1);
		Utakmica utakmica2 = new Utakmica(idUtakmice2, domaciKlub2, gostujuciKlub2, sudijeZaUtakmicu2, delegat2, hala2, date2);
		
		IzvestajUtakmice izvestajUtakmice1 = new IzvestajUtakmice(utakmica1);
		IzvestajUtakmice izvestajUtakmice2 = new IzvestajUtakmice(utakmica2);
		
		boolean condition1 = aplikacija.sacuvajNoviIzvestajUtakmice(izvestajUtakmice1);
		boolean condition2 = aplikacija.sacuvajNoviIzvestajUtakmice(izvestajUtakmice2);
		
		assertTrue(condition1);
		assertFalse(condition2);
	}

}
