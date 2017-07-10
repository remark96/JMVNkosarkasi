package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

import controller.Controller;
import model.IzvestajUtakmice;
import model.Utakmica;

@SuppressWarnings("serial")
public class PageForReports extends JPanel {

	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel westPanel;
	
	private PageForStatistikeIgraca pageForStatistikeDomacihIgraca; 
	private PageForStatistikeIgraca pageForStatistikeGostujucihIgraca; 
	
	JComboBox<String> comboBoxIgraci;
	
	private Controller controller;
	private VerticalMenuBar vmb;
	
	public PageForReports(Controller controller, IzvestajUtakmice izvestajUtakmice) {
		this.controller = controller;
		
		this.northPanel = new JPanel(new GridLayout(6, 5));
		this.westPanel = new JPanel(new BorderLayout());
		
		vmb = new VerticalMenuBar(controller, this);
		westPanel.add(vmb, BorderLayout.NORTH);
		
		Utakmica utakmica = izvestajUtakmice.getUtakmica();
		
		comboBoxIgraci = new JComboBox<String>();
		comboBoxIgraci.addItem(utakmica.getDomaciKlub().getImeKluba());
		comboBoxIgraci.addItem(utakmica.getGostujuciKlub().getImeKluba());
		
		for (int i = 0; i < 5; i++) northPanel.add(new JLabel(""));
		northPanel.add(new JLabel("")); northPanel.add(new JLabel("")); northPanel.add(comboBoxIgraci); northPanel.add(new JLabel("")); northPanel.add(new JLabel(""));
		for (int i = 0; i < 20; i++) northPanel.add(new JLabel(""));
			
		this.centerPanel = new PageForStatistikeIgraca(izvestajUtakmice.getStatistikaDomacihIgraca());
		add(centerPanel, BorderLayout.CENTER);
		
		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		
		
	}

	public void putMenuBar(String[] menusStr, String[][] items) {
		JMenu menu;
		MenuItem menuItem;
		
		for (int i = 0; i < menusStr.length ; i++) {
			menu = new JMenu(menusStr[i]);
			for (int j = 0; j < items[i].length; j++) {
				System.out.println(items[i].length);
				menuItem = new MenuItem(items[i][j], this);
				menuItem.addActionListener();
				menu.add(menuItem);
			}
			
			vmb.add(menu);
		}
		
		westPanel.revalidate();
		westPanel.repaint();
	
	}
	
	public void funcForWestPanel() {
		String[] menusStr = { "Statistika ekipa", "Statistika igraca", "Statistika trenera", "Statistika tima" };
		String[][] items = { { "Statistika domace ekipe", "Statistika gostujuce ekipe" },
				{ "Igrac domace ekipe", "Igrac gostujuce ekipe" }, { "Trener domace ekipe", "Trener gostujuce ekipe" },
				{ "Prikazi statistiku tima" }, };

		putMenuBar(menusStr, items);
	}



	public JPanel getNorthPanel() {
		return northPanel;
	}



	public void setNorthPanel(JPanel northPanel) {
		this.northPanel = northPanel;
	}



	public JPanel getCenterPanel() {
		return centerPanel;
	}



	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}



	public JPanel getWestPanel() {
		return westPanel;
	}



	public void setWestPanel(JPanel westPanel) {
		this.westPanel = westPanel;
	}



	public PageForStatistikeIgraca getPageForStatistikeDomacihIgraca() {
		return pageForStatistikeDomacihIgraca;
	}



	public void setPageForStatistikeDomacihIgraca(PageForStatistikeIgraca pageForStatistikeDomacihIgraca) {
		this.pageForStatistikeDomacihIgraca = pageForStatistikeDomacihIgraca;
	}



	public PageForStatistikeIgraca getPageForStatistikeGostujucihIgraca() {
		return pageForStatistikeGostujucihIgraca;
	}



	public void setPageForStatistikeGostujucihIgraca(PageForStatistikeIgraca pageForStatistikeGostujucihIgraca) {
		this.pageForStatistikeGostujucihIgraca = pageForStatistikeGostujucihIgraca;
	}



	public JComboBox<String> getComboBoxIgraci() {
		return comboBoxIgraci;
	}



	public void setComboBoxIgraci(JComboBox<String> comboBoxIgraci) {
		this.comboBoxIgraci = comboBoxIgraci;
	}



	public Controller getController() {
		return controller;
	}



	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public VerticalMenuBar getVmb() {
		return vmb;
	}



	public void setVmb(VerticalMenuBar vmb) {
		this.vmb = vmb;
	}
	
}
