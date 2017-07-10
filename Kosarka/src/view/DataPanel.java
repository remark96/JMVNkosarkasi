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
	private JLabel[] labels;
	
	private JPanel[] pomocniPaneli;
	
	
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
		
		pomocniPaneli = new JPanel[4];
		
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
		 
		pomocniPaneli[0] = new JPanel(new GridLayout(6, 2)); 
		 pomocniPaneli[0].setBorder(BorderFactory.createTitledBorder("Pogoci"));
		 
		 pomocniPaneli[1] = new JPanel(new GridLayout(6, 2));
		 pomocniPaneli[1].setBorder(BorderFactory.createTitledBorder("Promasaji"));
		 
		 //SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 200, 1);
		 
		 spinners = new Spinner[30];
		 for (int i = 0; i < spinners.length; i++) spinners[i] = new Spinner(new SpinnerNumberModel(0, 0, 200, 1), i);
		 
		//spinner.setEditor(new JSpinner.NumberEditor(spinner));
		 
		 labels = new JLabel[30];
		 
		 labels[0] = new JLabel(" Pogodak za 1 ");
		 pomocniPaneli[0].add(labels[0]);
		 pomocniPaneli[0].add(spinners[0]);
		 pomocniPaneli[0].add(new JLabel(""));
		 pomocniPaneli[0].add(new JLabel(""));
		 labels[1] = new JLabel(" Pogodak za 2 ");
		 pomocniPaneli[0].add(labels[1]);
		 pomocniPaneli[0].add(spinners[1]);
		 pomocniPaneli[0].add(new JLabel(""));
		 pomocniPaneli[0].add(new JLabel(""));
		 labels[2] = new JLabel(" Pogodak za 3 ");
		 pomocniPaneli[0].add(labels[2]);
		 pomocniPaneli[0].add(spinners[2]);
		 pomocniPaneli[0].add(new JLabel(""));
		 pomocniPaneli[0].add(new JLabel(""));
		 
		 labels[3] = new JLabel(" Promasaj za 1 ");
		 pomocniPaneli[1].add(labels[3]);
		 pomocniPaneli[1].add(spinners[3]);
		 pomocniPaneli[1].add(new JLabel(""));
		 pomocniPaneli[1].add(new JLabel(""));
		 labels[4] = new JLabel(" Promasaj za 2 ");
		 pomocniPaneli[1].add(labels[4]);
		 pomocniPaneli[1].add(spinners[4]);
		 pomocniPaneli[1].add(new JLabel(""));
		 pomocniPaneli[1].add(new JLabel(""));
		 labels[5] = new JLabel(" Promasaj za 3 ");
		 pomocniPaneli[1].add(labels[5]);
		 pomocniPaneli[1].add(spinners[5]);
		 pomocniPaneli[1].add(new JLabel(""));
		 pomocniPaneli[1].add(new JLabel(""));
		 
		 JPanel panelZaSuteve = new JPanel(new BorderLayout());
		 panelZaSuteve.add(new JLabel("                        "), BorderLayout.NORTH);
		 panelZaSuteve.add(pomocniPaneli[0], BorderLayout.WEST);
		 panelZaSuteve.add(pomocniPaneli[1], BorderLayout.EAST);
		 tabovi[0].add(panelZaSuteve, BorderLayout.NORTH); // tab za sut
		 
		// for (int i = 0; i < 14; i++) tabAsistencije.add(new JLabel(""));
		 JPanel panelZaAsistencije = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 4; i++) panelZaAsistencije.add(new JLabel(""));
		 labels[6] = new JLabel("      Asistencije");
		panelZaAsistencije.add(labels[6]);
		 panelZaAsistencije.add(spinners[6]);
		 panelZaAsistencije.add(new JLabel(""));
		 panelZaAsistencije.add(new JLabel(""));
		 tabovi[1].add(panelZaAsistencije, BorderLayout.NORTH);  // tab za asistencije
		 
		 JPanel panelZaSkokove = new JPanel(new GridLayout(4, 3));
		 for (int i = 0; i < 3; i++) panelZaSkokove.add(new JLabel(""));
		 labels[7] = new JLabel("   Defanzivni skokovi");
		panelZaSkokove.add(labels[7]);
		 panelZaSkokove.add(spinners[7]);
		 panelZaSkokove.add(new JLabel(""));
		 //panelZaSkokove.add(new JLabel(""));
		 for (int i = 0; i < 3; i++) panelZaSkokove.add(new JLabel(""));
		 labels[8] = new JLabel("   Ofanzivni skokovi");
		 panelZaSkokove.add(labels[8]);
		 panelZaSkokove.add(spinners[8]);
		 panelZaSkokove.add(new JLabel(""));
		 //panelZaSkokove.add(new JLabel(""));
		 tabovi[2].add(panelZaSkokove, BorderLayout.NORTH);  // tab za skokove
		 
		 pomocniPaneli[2] = new JPanel(new GridLayout(5, 2));
		 pomocniPaneli[2].setBorder(BorderFactory.createTitledBorder("Licne greske"));
		 
		 pomocniPaneli[3] = new JPanel(new GridLayout(5, 2));
		 pomocniPaneli[3].setBorder(BorderFactory.createTitledBorder("    Nesportske greske"));
		 
		 labels[9] = new JLabel("1 slobodno bac.");
		 pomocniPaneli[2].add(labels[9]);
		 pomocniPaneli[2].add(spinners[9]);
		 pomocniPaneli[2].add(new JLabel(""));
		 pomocniPaneli[2].add(new JLabel(""));
		 labels[10] = new JLabel("2 slobodna bac.");
		 pomocniPaneli[2].add(labels[10]);
		 pomocniPaneli[2].add(spinners[10]);
		 pomocniPaneli[2].add(new JLabel(""));
		 pomocniPaneli[2].add(new JLabel(""));
		 labels[11] = new JLabel("3 slobodna bac.");
		 pomocniPaneli[2].add(labels[11]);
		 pomocniPaneli[2].add(spinners[11]);
//		 licneGreske.add(new JLabel(""));
//		 licneGreske.add(new JLabel(""));
		 
		 labels[12] = new JLabel("1 slobodno bac.");
		 pomocniPaneli[3].add(labels[12]);
		 pomocniPaneli[3].add(spinners[12]);
		 pomocniPaneli[3].add(new JLabel(""));
		 pomocniPaneli[3].add(new JLabel(""));
		 labels[13] = new JLabel("2 slobodna bac.");
		 pomocniPaneli[3].add(labels[13]);
		 pomocniPaneli[3].add(spinners[13]);
		 pomocniPaneli[3].add(new JLabel(""));
		 pomocniPaneli[3].add(new JLabel(""));
		 labels[14] = new JLabel("3 slobodna bac.");
		 pomocniPaneli[3].add(labels[14]);
		 pomocniPaneli[3].add(spinners[14]);
//		 nesportskeGreske.add(new JLabel(""));
//		 nesportskeGreske.add(new JLabel(""));
		 
		 JPanel panelZaGreske = new JPanel(new BorderLayout());
		 JPanel tehnickeGreske = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 5; i++) tehnickeGreske.add(new JLabel(""));
		 labels[15] = new JLabel("Tehnicke greske");
		 tehnickeGreske.add(labels[15]);
		 tehnickeGreske.add(spinners[15]);
		 tehnickeGreske.add(new JLabel(""));
		 panelZaGreske.add(new JLabel("                        "), BorderLayout.NORTH);
		 panelZaGreske.add(pomocniPaneli[2], BorderLayout.WEST);
		 panelZaGreske.add(pomocniPaneli[3], BorderLayout.EAST);
		 panelZaGreske.add(tehnickeGreske, BorderLayout.SOUTH);
		 tabovi[3].add(panelZaGreske, BorderLayout.NORTH);  // tab za greske
		 
		 
		 JPanel panelZaBlokade = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 4; i++) panelZaBlokade.add(new JLabel(""));
		 labels[16] = new JLabel("        Blokade");
		panelZaBlokade.add(labels[16]);
		 panelZaBlokade.add(spinners[16]);
		 panelZaBlokade.add(new JLabel(""));
		 panelZaBlokade.add(new JLabel(""));
		 tabovi[4].add(panelZaBlokade, BorderLayout.NORTH);  // tab za blokade
		 
		 JPanel panelZaIzgubljeneLopte = new JPanel(new GridLayout(11, 4));
		 //for (int i = 0; i < 3; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[17] = new JLabel("     Koraci");
		panelZaIzgubljeneLopte.add(labels[17]);
		 panelZaIzgubljeneLopte.add(spinners[17]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[18] = new JLabel("     Dupla lopta");
		 panelZaIzgubljeneLopte.add(labels[18]);
		 panelZaIzgubljeneLopte.add(spinners[18]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[19] = new JLabel("     Lose dodavanje");
		 panelZaIzgubljeneLopte.add(labels[19]);
		 panelZaIzgubljeneLopte.add(spinners[19]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[20] = new JLabel("     Lose hvatanje");
		 panelZaIzgubljeneLopte.add(labels[20]);
		 panelZaIzgubljeneLopte.add(spinners[20]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[21] = new JLabel("     3 sec u reketu");
		 panelZaIzgubljeneLopte.add(labels[21]);
		 panelZaIzgubljeneLopte.add(spinners[21]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[22] = new JLabel("     8 sec pre pola");
		 panelZaIzgubljeneLopte.add(labels[22]);
		 panelZaIzgubljeneLopte.add(spinners[22]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[23] = new JLabel("     5 sec u autu");
		 panelZaIzgubljeneLopte.add(labels[23]);
		 panelZaIzgubljeneLopte.add(spinners[23]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[24] = new JLabel("     Preko pola");
		 panelZaIzgubljeneLopte.add(labels[24]);
		 panelZaIzgubljeneLopte.add(spinners[24]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[25] = new JLabel("     Faul u napadu 1");
		 panelZaIzgubljeneLopte.add(labels[25]);
		 panelZaIzgubljeneLopte.add(spinners[25]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[26] = new JLabel("     Faul u napadu 2");
		 panelZaIzgubljeneLopte.add(labels[26]);
		 panelZaIzgubljeneLopte.add(spinners[26]);
		 for (int i = 0; i < 4; i++) panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[27] = new JLabel("     Faul u odbrani");
		 panelZaIzgubljeneLopte.add(labels[27]);
		 panelZaIzgubljeneLopte.add(spinners[27]);
		 //panelZaIzgubljeneLopte.add(new JLabel(""));
		 labels[28] = new JLabel("     Lose vodjenje");
		 panelZaIzgubljeneLopte.add(labels[28]);
		 panelZaIzgubljeneLopte.add(spinners[28]);
		 tabovi[5].add(panelZaIzgubljeneLopte, BorderLayout.NORTH);  // tab za izgubljene lopte
		 
		 JPanel panelZaUkradeneLopte = new JPanel(new GridLayout(2, 4));
		 for (int i = 0; i < 4; i++) panelZaUkradeneLopte.add(new JLabel(""));
		 labels[29] = new JLabel("  Izgubljene lopte");
		panelZaUkradeneLopte.add(labels[29]);
		 panelZaUkradeneLopte.add(spinners[29]);
		 panelZaUkradeneLopte.add(new JLabel(""));
		 panelZaUkradeneLopte.add(new JLabel(""));
		 tabovi[6].add(panelZaUkradeneLopte, BorderLayout.NORTH);  // tab za ukradene lopte
		 
		 add(tabPanel1);
		 add(tabPanel2);
	}

	public Spinner[] getSpinners() { return spinners; }
	public void setSpinners(Spinner[] spinners) { this.spinners = spinners; }
	
	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		
		for (int i = 0; i < labels.length; i++) {
			labels[i].setEnabled(b);
			spinners[i].setEnabled(b);
		}
		
		for (int i = 0; i < pomocniPaneli.length; i++) pomocniPaneli[i].setEnabled(b);
	}
}
