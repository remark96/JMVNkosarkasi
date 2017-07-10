package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuItem extends JMenuItem implements ActionListener 
{
	private JPanel page;
	
	public MenuItem(String nameOfMenuItem, JPanel page) {
		super(nameOfMenuItem);
		this.page = page;
	}
	
	public void addActionListener() {
		addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		//vmb.getPage().funcForCenterPanel(menuItem);
		PageForAdministrator pageForAdministrator = (PageForAdministrator) page;
		
		switch (e.getActionCommand()) 
		{
			case "Prikaz igraca":
				pageForAdministrator.prikaziIgrace();
				break;

			case "Dodavanje igraca":
				pageForAdministrator.dodajIgraca();
				break;
				
			case "Izmena igraca":
				pageForAdministrator.izmeniIgraca();
				break;
				
			case "Brisanje igraca":
				pageForAdministrator.obrisiIgraca();
				break;
									
			case "Prikaz hala":
				pageForAdministrator.prikaziHale();
				break;
				
			default:
				break;
		}		
	}
}
