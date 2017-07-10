package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataBase {
	static Connection connection;
	static PreparedStatement preparedStatment;
	public static Statement statement;
	static ResultSet resultSet;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
	
	public static void  initDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JovoSunjka", "ftn");
			statement = connection.createStatement();

			//preparedStatment = connection.prepareStatement(sql)
		}
		catch (Exception e) {
			
		}
	}

	public void zatvori() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public void prikaziPodatkeUTabeli(JTable table) {
		try {
			String query = "select * from Igrac";
			resultSet = statement.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	*/
	
	public static void kreirajTabele() {
		/*AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Izvestaj.class);
		config.configure("hibernate.cfg.xml");
	
		new SchemaExport(config).create(true, true);*/
	}
	
	public static ArrayList<User> readUsers() {
		ArrayList<User> users = new ArrayList<User>();
		String query = "select * from KORISNIK";
		try {
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				users.add(new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("administrator") == 1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
		//return (ArrayList<User>) DbUtils.resultSetToNestedList(resultSet);
	}

	public static ArrayList<IzvestajUtakmice> readReports(ArrayList<Hala> hale, ArrayList<Klub> klubovi, ArrayList<Sudija> sudijeLista, ArrayList<Delegat> delegati) {
		ArrayList<IzvestajUtakmice> izvestaji = new ArrayList<IzvestajUtakmice>();
		
		String query;
		ArrayList<Integer> idsUtakmica = new ArrayList<Integer>();
		ArrayList<Klub> ucitaniKlubovi = new ArrayList<Klub>();
		ArrayList<ArrayList<Integer>> sudijeZaUtakmice = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> delegatiZaUtakmice = new ArrayList<Integer>();
		ArrayList<Date> datumiZaUtakmice = new ArrayList<Date>();
		ArrayList<String> haleZaUtakmice = new ArrayList<String>();
		
		try {
			query = "select * from UTAKMICA";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
			
				 idsUtakmica.add(resultSet.getInt("idutakmice"));
			
				ucitaniKlubovi.add(Aplikacija.izaberiKlub(klubovi, resultSet.getInt("iddomacina")));
				ucitaniKlubovi.add(Aplikacija.izaberiKlub(klubovi, resultSet.getInt("idgosta")));
				
				delegatiZaUtakmice.add(resultSet.getInt("iddelegata"));
				
				haleZaUtakmice.add(resultSet.getString("nazivhale"));
				datumiZaUtakmice.add(resultSet.getDate("datumivreme"));
			}
			
			for (int i = 0; i < idsUtakmica.size(); i++) {
				query = "select idsudije from UTAKMICA_SUDIJA where idutakmice = " + idsUtakmica.get(i); 
				resultSet = statement.executeQuery(query);
				
				sudijeZaUtakmice.add(new ArrayList<Integer>());
				while(resultSet.next()) sudijeZaUtakmice.get(i).add(resultSet.getInt("idsudije"));
			}

			Sudija[] sudije;
			Delegat delegat;
			Hala hala;
			Utakmica utakmica;
			IzvestajUtakmice izvestajUtakmice;
			
			for (int i = 0, j = 0;  i < sudijeZaUtakmice.size(); i++, j+=2) {
				sudije = Aplikacija.izaberiSudije(sudijeLista, sudijeZaUtakmice.get(i));
				delegat = Aplikacija.izaberiDelegata(delegati, delegatiZaUtakmice.get(i));
				hala = Aplikacija.izaberiHalu(hale, haleZaUtakmice.get(i));
				
				
				
				utakmica = new Utakmica(idsUtakmica.get(i), ucitaniKlubovi.get(j), ucitaniKlubovi.get(j+1), sudije, delegat, hala, datumiZaUtakmice.get(i));
				
				izvestajUtakmice = new IzvestajUtakmice(utakmica);
				
				pokupiStatistikeZaIgrace(idsUtakmica.get(i), izvestajUtakmice.getUtakmica().getDomaciKlub().getIgraci(), izvestajUtakmice.getStatistikaDomacihIgraca());
				pokupiStatistikeZaIgrace(idsUtakmica.get(i), izvestajUtakmice.getUtakmica().getGostujuciKlub().getIgraci(), izvestajUtakmice.getStatistikaGostujucihIgraca());
				
				pokupiStatistikuZaTrenera(idsUtakmica.get(i), izvestajUtakmice.getUtakmica().getDomaciKlub().getTrener(), izvestajUtakmice.getStatistikaDomacegTrenera());
				pokupiStatistikuZaTrenera(idsUtakmica.get(i), izvestajUtakmice.getUtakmica().getGostujuciKlub().getTrener(), izvestajUtakmice.getStatistikaGostujucegTrenera());
				
				izvestaji.add(izvestajUtakmice);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return izvestaji;
	}

	private static void pokupiStatistikuZaTrenera(int idUtakmice, Trener trener, StatistikaTrenera statistikaTrenera) {
		String query;
		
		try {
			query = "select count(*) broj_redova from STATISTIKA_TRENERA";
			resultSet = statement.executeQuery(query);
			resultSet.next();
			if (resultSet.getInt("broj_redova") == 0) return;
			
			query = "select tehnickegreske, izbacen from STATISTIKA_TRENERA where idutakmice = " + idUtakmice + " and idtrenera = " + trener.getId();
			resultSet = statement.executeQuery(query);
			resultSet.next();
			
			statistikaTrenera = new StatistikaTrenera(resultSet.getInt("tehnickegreske"), resultSet.getInt("izbacen") == 1); // TODO fale timeouts
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void pokupiStatistikeZaIgrace(int idUtakmice, ArrayList<Igrac> igraci, ArrayList<StatistikaIgraca> statistikeIgraca) {
		String query;
		StanjeIgraca aktuelnoStanje = null;
		int aktuelnoStanjeInt;
		
		try {
			for (Igrac igrac : igraci) {
				query = "select count(*) broj_redova from STATISTIKA_IGRACA";
				resultSet = statement.executeQuery(query);
				resultSet.next();
				if (resultSet.getInt("broj_redova") == 0) continue;
				
				query = "select aktuelnostanje from STATISTIKA_IGRACA where idutakmice = " + idUtakmice + " and idigraca = " + igrac.getId();
				resultSet = statement.executeQuery(query);
				resultSet.next();
				
				aktuelnoStanjeInt = resultSet.getInt("aktuelnostanje");
				switch (aktuelnoStanjeInt) {
					case 0: aktuelnoStanje = new StanjeTeren(); break;
					case 1: aktuelnoStanje = new StanjeKlupa(); break;
					case 2: aktuelnoStanje = new StanjeIzbacen(); break;
					default: break;
				}
				
				statistikeIgraca.add(new StatistikaIgraca(igrac, aktuelnoStanje));// TODO false podaci po cetvrtinama
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Sudija> readSudije() {
		ArrayList<Sudija> sudije = new ArrayList<Sudija>();
		
		String query;
		ArrayList<Integer> idsSudija = new ArrayList<Integer>();
		
		try{
			query = "select idsudije from SUDIJA";
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) idsSudija.add(resultSet.getInt("idsudije"));
			
			for (Integer id : idsSudija) {
				query = "select ime, prezime from OSOBA where idosobe = " + id;
				resultSet = statement.executeQuery(query);
				
				resultSet.next(); 
				sudije.add(new Sudija(id, resultSet.getString("ime"), resultSet.getString("prezime")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sudije;
	}

	public static ArrayList<Delegat> readDelegate() {
		ArrayList<Delegat> delegati = new ArrayList<Delegat>();
		
		String query;
		ArrayList<Integer> idsDelegata = new ArrayList<Integer>();
		
		try{
			query = "select iddelegata from DELEGAT";
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) idsDelegata.add(resultSet.getInt("iddelegata"));
			
			for (Integer id : idsDelegata) {
				query = "select ime, prezime from OSOBA where idosobe = " + id;
				resultSet = statement.executeQuery(query);
				
				resultSet.next(); 
				delegati.add(new Delegat(id, resultSet.getString("ime"), resultSet.getString("prezime")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return delegati;
	}
	
	public static ArrayList<Igrac> readIgraci() {
		ArrayList<Igrac> igraci = new ArrayList<Igrac>();
		for(int i=0; i<Aplikacija.getKlubovi().size(); i++)
		{
			for(int j=0; j<Aplikacija.getKlubovi().get(i).getIgraci().size(); j++)
			{
				igraci.add(Aplikacija.getKlubovi().get(i).getIgraci().get(j));
			}
		}
		return igraci;
		//return (ArrayList<User>) DbUtils.resultSetToNestedList(resultSet);
	}
	
	public static ArrayList<Klub> readKlubovi(ArrayList<Hala> hale) {
		ArrayList<Klub> klubovi = new ArrayList<Klub>();
		ArrayList<Igrac> igraci;
		
		ArrayList<Integer> idsKlubova = new ArrayList<Integer>();
		ArrayList<String> imenaKlubova = new ArrayList<String>();
		ArrayList<Integer> idsTrenera = new ArrayList<Integer>();
		ArrayList<String> putanjeDoFotografijaTrenera = new ArrayList<String>();
		ArrayList<ArrayList<String>> putanjeDoFotografijaIgraca = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Integer>> igraciZaKlubove = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> haleZaKlubove = new ArrayList<String>();
		ArrayList<String> putanjeDoFotografijaKlubova = new ArrayList<String>();
		
		String query;
		
		try {
			query = "select * from KLUB k, TRENER t where k.idkluba = t.idkluba";
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				idsKlubova.add(resultSet.getInt("idkluba"));
				imenaKlubova.add(resultSet.getString("imekluba"));
				idsTrenera.add(resultSet.getInt("idtrenera"));
				haleZaKlubove.add(resultSet.getString("nazivhale"));
				putanjeDoFotografijaKlubova.add(resultSet.getString("putanjadofotografije"));
			}
			
			for (Integer integer : idsTrenera) {
				query = "select putanjadofotografije from TRENER where idtrenera = " + integer;
				resultSet = statement.executeQuery(query);
				resultSet.next();
				putanjeDoFotografijaTrenera.add(resultSet.getString("putanjadofotografije"));
			}
			
			for (int i = 0; i < idsKlubova.size(); i++) {
				query = "select idigraca, visina, tezina, putanjadofotografije from IGRAC where idkluba = " + idsKlubova.get(i);
				resultSet = statement.executeQuery(query);
				
				igraciZaKlubove.add(new ArrayList<Integer>());
				putanjeDoFotografijaIgraca.add(new ArrayList<String>());
				while (resultSet.next()) {
					igraciZaKlubove.get(i).add(resultSet.getInt("idigraca"));
					igraciZaKlubove.get(i).add(resultSet.getInt("visina"));
					igraciZaKlubove.get(i).add(resultSet.getInt("tezina"));
					putanjeDoFotografijaIgraca.get(i).add(resultSet.getString("putanjadofotografije"));
				}
			}
			
			for (int i = 0; i < igraciZaKlubove.size(); i++) {
				igraci = new ArrayList<Igrac>();
				for (int j = 0, k = 0; j < igraciZaKlubove.get(i).size(); j+=3, k++) {
					query = "select ime, prezime from OSOBA where idosobe = " + igraciZaKlubove.get(i).get(j);
					resultSet = statement.executeQuery(query);
					
					resultSet.next(); 
					igraci.add(new Igrac(igraciZaKlubove.get(i).get(j), resultSet.getString("ime"), resultSet.getString("prezime"), igraciZaKlubove.get(i).get(j+1), igraciZaKlubove.get(i).get(j+2), idsKlubova.get(i), putanjeDoFotografijaIgraca.get(i).get(k)));
				}
				
				query = "select ime, prezime from OSOBA where idosobe = " + idsTrenera.get(i);
				resultSet = statement.executeQuery(query);
				
				resultSet.next(); 
				Trener trener = new Trener(idsTrenera.get(i), resultSet.getString("ime"), resultSet.getString("prezime"), putanjeDoFotografijaTrenera.get(i));
				
				Hala hala = Aplikacija.izaberiHalu(hale, haleZaKlubove.get(i));
				
				klubovi.add(new Klub(idsKlubova.get(i), imenaKlubova.get(i), igraci, trener, hala, putanjeDoFotografijaKlubova.get(i)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return klubovi;
	}

	public static ArrayList<Hala> readHalle() {
		ArrayList<Hala> hale = new ArrayList<Hala>();
		String query = "select * from HALA";
		try {
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				hale.add(new Hala(resultSet.getString("naziv"), resultSet.getString("adresa"), resultSet.getString("mesto")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hale;
	}

	public static int kreirajIdZaNovuUtakmicu() {
		int idUtakmice = -1;
		
		String query = "select nvl(max(idutakmice), 0) maksimalni from UTAKMICA";
		try {
			resultSet = statement.executeQuery(query);
			resultSet.next();
			idUtakmice = resultSet.getInt("maksimalni");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idUtakmice + 1;
	}
	
	public static void updateSuteva(int indexCetvrtine, int idIgraca, int idUtakmice, ArrayList<Sut> sutevi) {
		String suteviStr = "";
		int sutZa1 = 0, sutZa2 = 0, sutZa3 = 0, pogociZa1 = 0, pogociZa2 = 0, pogociZa3 = 0;
		for (int i = 1; i <= 6; i++) {
			for (Sut sut : sutevi) {
				if (sut.getKvadrant() == i) {
					
					switch (sut.getVrsta()) {
						case jedanPoen:
							if (sut.isPogodak()) pogociZa1++; 
							sutZa1++;
							break;
							
						case dvaPoena:
							if (sut.isPogodak()) pogociZa2++; 
							sutZa2++;
							break;
							
						case triPoena:
							if (sut.isPogodak()) pogociZa3++; 
							sutZa3++;
							break;
		
						default:
							break;
					}
				}
			}
		
			suteviStr += i + "-1:" + pogociZa1 + "/" + sutZa1 + "," + "2:" + pogociZa2 + "/" + sutZa2 + "," + "3:" + pogociZa3 + "/" + sutZa3 + ";";
		}
		
		suteviStr = suteviStr.substring(0, suteviStr.length() - 1);
		
		String sql = "update CETVRTINA set sutevi = '" + suteviStr + "' where redbr = " + indexCetvrtine + " and idigraca = " + idIgraca + " and idutakmice = " + idUtakmice;
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeNoviIzvestajUtakmice(IzvestajUtakmice aktuelniIzvestajUtakmice) {
		Utakmica utakmica = aktuelniIzvestajUtakmice.getUtakmica();
		Klub domacin = utakmica.getDomaciKlub();
		Klub gost = utakmica.getGostujuciKlub();
		Hala hala = utakmica.getHala();
		
		aktuelniIzvestajUtakmice.getStatistikaDomacihIgraca();
		
		// nije zavrsena ova funkcija
		//TODO
		
		try {
			String sql = "insert into UTAKMICA values(" + utakmica.getIdUtakmice() + ", " + domacin.getIdKluba() + ", "
					+ gost.getIdKluba() + ", '" + hala.getNaziv() + "', '" + sdf.format(utakmica.getDate()) + "', " + utakmica.getDelegat().id + ")" ;
		
			statement.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
