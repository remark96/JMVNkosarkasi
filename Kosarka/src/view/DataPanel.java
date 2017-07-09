package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class DataPanel extends JPanel {
	private JTabbedPane tabPanel1;
	private JTabbedPane tabPanel2;
	
	private Spinner[] spinners;
	
	
	
	private JPanel[] tabovi;  // {sutevi, asistencije, skokovi, greske, blokade, ukradene lopte, izgubljene lopte}
	private String[] namesOfTabs = {"Sutevi", "Asistencije", "Skokovi", "Greske", "Blokade", "Ukradene lopte", "Izgubljene lopte"};
	
	
	/*private JPanel tabSutevi =  new JPanel(new BorderLayout());
	private JPanel tabAsistencije =  new JPanel(new BorderLayout());
	private JPanel tabSkokovi =  new JPanel(new BorderLayout());
	
	private JPanel tabGreske =  new JPanel(new BorderLayout());
	private JPanel tabBlokade =  new JPanel(new BorderLayout());
	private JPanel tabUkradeneLopte =  new JPanel(new BorderLayout());
	private JPanel tabIzgubljeneLopte =  new JPanel(new BorderLayout());*/
	
	private final int BROJ_TABOVA = 7;
	
	public DataPanel() {
		super(new GridLayout(2, 1));
		
		
		
		tabPanel1 = new JTabbedPane();
		tabPanel2 = new JTabbedPane();
		
		tabovi = new JPanel[BROJ_TABOVA];
		for (int i = 0; i < BROJ_TABOVA; i++) tabovi[i] = new JPanel(new BorderLayout());
		
		int debljina;
		for (int j = 0; j < BROJ_TABOVA; j++) {
			if (j != 5) debljina = 20;
			else debljina = 2;
			
			tabovi[j].setBorder(BorderFactory.createLineBorder(Color.BLUE, debljina));
		}
		
		for (int k = 0; k < BROJ_TABOVA; k++) {
			if (k < 3)  tabPanel1.add(namesOfTabs[k], tabovi[k]);
			else tabPanel2.add(namesOfTabs[k], tabovi[k]);
		}
		
//		 JPanel sutevi = new JPanel(new BorderLayout());
//		 sutevi.setBorder(BorderFactory.createTitledBorder("Sutevi"));
		 
		 JPanel pogoci = new JPanel(new GridLayout(6, 2));
		 pogoci.setBorder(BorderFactory.createTitledBorder("Pogoci"));
		 
		 JPanel promasaji = new JPanel(new GridLayout(6, 2));
		 promasaji.setBorder(BorderFactory.createTitledBorder("Promasaji"));
		 
		 //SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 200, 1);
		 
		 spinners = new Spinner[30];
		 for (int i = 0; i < spinners.length; i++) spinners[i] = new Spinner(new SpinnerNumberModel(0, 0, 200, 1), i);
		 
		//spinner.setEditor(new JSpinner.NumberEditor(spinner));
		 
		 pogoci.add(new JLabel(" Pogodak za 1 "));
		 pogoci.add(spinners[0]);
		 pogoci.add(new JLabel(""));
		 pogoci.add(new JLabel(""));
		 pogoci.add(new JLabel(" Pogodak za 2 "));
		 pogoci.add(spinners[1]);
		 pogoci.add(new JLabel(""));
		 pogoci.add(new JLabel(""));
		 pogoci.add(new JLabel(" Pogodak za 3 "));
		 pogoci.add(spinners[2]);
		 pogoci.add(new JLabel(""));
		 pogoci.add(new JLabel(""));
		 
		 promasaji.add(new JLabel(" Promasaj za 1 "));
		 promasaji.add(spinners[3]);
		 promasaji.add(new JLabel(""));
		 promasaji.add(new JLabel(""));
		 promasaji.add(new JLabel(" Promasaj za 2 "));
		 promasaji.add(spinners[4]);
		 promasaji.add(new JLabel(""));
		 promasaji.add(new JLabel(""));
		 promasaji.add(new JLabel(" Promasaj za 3 "));
		 promasaji.add(spinners[5]);
		 promasaji.add(new JLabel(""));
		 promasaji.add(new JLabel(""));
		 
		 JPanel panelZaSuteve = new JPanel(new BorderLayout());
		 panelZaSuteve.add(new JLabel("                        "), BorderLayout.NORTH);
		 panelZaSuteve.add(pogoci, BorderLayout.WEST);
		 panelZaSuteve.add(promasaji, BorderLayout.EAST);
		 tabovi[0].add(panelZaSuteve, BorderLayout.NORTH); // tab za sut
		 
		// for (int i = 0; i < 14; i++) tabAsistencije.add(new JLabel(""));
		 JPanel panelZaAsistencije = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 4; i++) panelZaAsistencije.add(new JLabel(""));
		panelZaAsistencije.add(new JLabel("      Asistencije"));
		 panelZaAsistencije.add(spinners[6]);
		 panelZaAsistencije.add(new JLabel(""));
		 panelZaAsistencije.add(new JLabel(""));
		 tabovi[1].add(panelZaAsistencije, BorderLayout.NORTH);  // tab za asistencije
		 
		 JPanel panelZaSkokove = new JPanel(new GridLayout(4, 3));
		 for (int i = 0; i < 3; i++) panelZaSkokove.add(new JLabel(""));
		panelZaSkokove.add(new JLabel("   Defanzivni skokovi"));
		 panelZaSkokove.add(spinners[7]);
		 panelZaSkokove.add(new JLabel(""));
		 //panelZaSkokove.add(new JLabel(""));
		 for (int i = 0; i < 3; i++) panelZaSkokove.add(new JLabel(""));
		 panelZaSkokove.add(new JLabel("   Ofanzivni skokovi"));
		 panelZaSkokove.add(spinners[8]);
		 panelZaSkokove.add(new JLabel(""));
		 //panelZaSkokove.add(new JLabel(""));
		 tabovi[2].add(panelZaSkokove, BorderLayout.NORTH);  // tab za skokove
		 
		 JPanel licneGreske = new JPanel(new GridLayout(5, 2));
		 licneGreske.setBorder(BorderFactory.createTitledBorder("Licne greske"));
		 
		 JPanel nesportskeGreske = new JPanel(new GridLayout(5, 2));
		 nesportskeGreske.setBorder(BorderFactory.createTitledBorder("    Nesportske greske"));
		 
		 licneGreske.add(new JLabel("1 slobodno bac."));
		 licneGreske.add(spinners[9]);
		 licneGreske.add(new JLabel(""));
		 licneGreske.add(new JLabel(""));
		 licneGreske.add(new JLabel("2 slobodna bac."));
		 licneGreske.add(spinners[10]);
		 licneGreske.add(new JLabel(""));
		 licneGreske.add(new JLabel(""));
		 licneGreske.add(new JLabel("3 slobodna bac."));
		 licneGreske.add(spinners[11]);
//		 licneGreske.add(new JLabel(""));
//		 licneGreske.add(new JLabel(""));
		 
		 nesportskeGreske.add(new JLabel("1 slobodno bac."));
		 nesportskeGreske.add(spinners[12]);
		 nesportskeGreske.add(new JLabel(""));
		 nesportskeGreske.add(new JLabel(""));
		 nesportskeGreske.add(new JLabel("2 slobodna bac."));
		 nesportskeGreske.add(spinners[13]);
		 nesportskeGreske.add(new JLabel(""));
		 nesportskeGreske.add(new JLabel(""));
		 nesportskeGreske.add(new JLabel("3 slobodna bac."));
		 nesportskeGreske.add(spinners[14]);
//		 nesportskeGreske.add(new JLabel(""));
//		 nesportskeGreske.add(new JLabel(""));
		 
		 JPanel panelZaGreske = new JPanel(new BorderLayout());
		 JPanel tehnickeGreske = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 5; i++) tehnickeGreske.add(new JLabel(""));
		 tehnickeGreske.add(new JLabel("Tehnicke greske"));
		 tehnickeGreske.add(spinners[15]);
		 tehnickeGreske.add(new JLabel(""));
		 panelZaGreske.add(new JLabel("                        "), BorderLayout.NORTH);
		 panelZaGreske.add(licneGreske, BorderLayout.WEST);
		 panelZaGreske.add(nesportskeGreske, BorderLayout.EAST);
		 panelZaGreske.add(tehnickeGreske, BorderLayout.SOUTH);
		 tabovi[3].add(panelZaGreske, BorderLayout.NORTH);  // tab za greske
		 
		 
		 JPanel panelZaBlokade = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 4; i++) panelZaBlokade.add(new JLabel(""));
		panelZaBlokade.add(new JLabel("        Blokade"));
		 panelZaBlokade.add(spinners[16]);
		 panelZaBlokade.add(new JLabel(""));
		 panelZaBlokade.add(new JLabel(""));
		 tabovi[4].add(panelZaBlokade, BorderLayout.NORTH);  // tab za blokade
		 
		 JPanel panelZaIzgubljeneLopte = new JPanel(new GridLayout(11, 4));
		 //for (int i = 0; i < 3; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		panelZaIzgubljeneLopte.add(new JLabel("     Koraci"));
		 panelZaIzgubljeneLopte.add(spinners[17]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Dupla lopta"));
		 panelZaIzgubljeneLopte.add(spinners[18]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Lose dodavanje"));
		 panelZaIzgubljeneLopte.add(spinners[19]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Lose hvatanje"));
		 panelZaIzgubljeneLopte.add(spinners[20]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     3 sec u reketu"));
		 panelZaIzgubljeneLopte.add(spinners[21]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     8 sec pre pola"));
		 panelZaIzgubljeneLopte.add(spinners[22]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     5 sec u autu"));
		 panelZaIzgubljeneLopte.add(spinners[23]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Preko pola"));
		 panelZaIzgubljeneLopte.add(spinners[24]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Faul u napadu 1"));
		 panelZaIzgubljeneLopte.add(spinners[25]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Faul u napadu 2"));
		 panelZaIzgubljeneLopte.add(spinners[26]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Faul u odbrani"));
		 panelZaIzgubljeneLopte.add(spinners[27]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 panelZaIzgubljeneLopte.add(new JLabel("     Lose vodjenje"));
		 panelZaIzgubljeneLopte.add(spinners[28]);
		 tabovi[5].add(panelZaIzgubljeneLopte, BorderLayout.NORTH);  // tab za izgubljene lopte
		 
		 JPanel panelZaUkradeneLopte = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 4; i++) panelZaUkradeneLopte.add(new JLabel(""));
		panelZaUkradeneLopte.add(new JLabel("  Izgubljene lopte"));
		 panelZaUkradeneLopte.add(spinners[29]);
		 panelZaUkradeneLopte.add(new JLabel(""));
		 panelZaUkradeneLopte.add(new JLabel(""));
		 tabovi[6].add(panelZaUkradeneLopte, BorderLayout.NORTH);  // tab za ukradene lopte
		 
		 add(tabPanel1);
		 add(tabPanel2);
	}
}
