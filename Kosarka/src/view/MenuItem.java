package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.Controller;
import model.IzvestajUtakmice;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem implements ActionListener 
{
	private JPanel page;
	private Controller controller;
	private VerticalMenuBar vmb;
	
	public MenuItem(String nameOfMenuItem, JPanel page, Controller controller, VerticalMenuBar vmb) {
		super(nameOfMenuItem);
		this.page = page;
		this.controller = controller;
		this.vmb = vmb;
	}
	
	public void addActionListener() {
		addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		//vmb.getPage().funcForCenterPanel(menuItem);
		//PageForAdministrator pageForAdministrator = ((PageForAdministrator) page);
		//PageForAdministrator pageForAdministrator = new PageForAdministrator(controller.aplikacija, controller);
		IzvestajUtakmice aktuelniIzvestaj = controller.aplikacija.getAktuelniIzvestajUtakmice();
		
		switch (e.getActionCommand()) 
		{
			case "Prikaz igraca":
				((PageForAdministrator) page).prikaziIgrace();
				break;

			case "Dodavanje igraca":
				((PageForAdministrator) page).dodajIgraca();
				break;
				
			case "Izmena igraca":
				((PageForAdministrator) page).izmeniIgraca();
				break;
				
			case "Brisanje igraca":
				((PageForAdministrator) page).obrisiIgraca();
				break;
									
			case "Prikaz hala":
				((PageForAdministrator) page).prikaziHale();
				break;
				
			case "Statistika domace ekipe":
				vmb.prikaziStatistikuEkipe(aktuelniIzvestaj.getStatistikaDomacihIgraca(),true);
			break;
			case "Statistika gostujuce ekipe":
				vmb.prikaziStatistikuEkipe(aktuelniIzvestaj.getStatistikaGostujucihIgraca(),false);
			break;
			case "Igrac domace ekipe":
				vmb.prikaziStatistikuIgracaDomaceEkipe();
			break;
			case "Igrac gostujuce ekipe":
				vmb.prikaziStatistikuIgracaGostujuceEkipe();
			break;
			case "Trener domace ekipe":
				vmb.prikaziStatistikuTrenera(aktuelniIzvestaj.getStatistikaDomacegTrenera(),true);
			break;
			case "Trener gostujuce ekipe":
				vmb.prikaziStatistikuTrenera(aktuelniIzvestaj.getStatistikaGostujucegTrenera(),false);
			break;
			
			default:
				break;
		}		
	}
}
