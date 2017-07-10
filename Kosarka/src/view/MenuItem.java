package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem implements ActionListener 
{
	private PageForAdministrator pfa;
	
	public MenuItem(String nameOfMenuItem, PageForAdministrator page) {
		super(nameOfMenuItem);
		this.pfa = page;
	}
	
	public void addActionListener() {
		addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		//vmb.getPage().funcForCenterPanel(menuItem);
		switch (e.getActionCommand()) 
		{
			case "Prikaz igraca":
				((PageForAdministrator) pfa).prikaziIgrace();
				break;

			case "Dodavanje igraca":
				((PageForAdministrator) pfa).dodajIgraca();
				break;
				
			case "Izmena igraca":
				((PageForAdministrator) pfa).izmeniIgraca();
				break;
				
			case "Brisanje igraca":
				((PageForAdministrator) pfa).obrisiIgraca();
				break;
									
			case "Prikaz hala":
				((PageForAdministrator) pfa).prikaziHale();
				break;
	
			case "Sign out":
				//((Page) pfa).signOut();
				break;
				
			default:
				break;
		}		
	}
}
