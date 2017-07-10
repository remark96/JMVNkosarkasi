package view;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import controller.Controller;
import model.DataBase;
import model.IzvestajUtakmice;

@SuppressWarnings("serial")
public class PageForReports extends JPanel {

	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel westPanel;
	
	private PageForStatistikeIgraca pageForStatistikeDomacihIgraca; 
	private PageForStatistikeIgraca pageForStatistikeGostujucihIgraca; 
	
	private PageForStatistikaEkipe pageForStatistikaDomaceEkipe;
	private PageForStatistikaEkipe pageForStatistikaGostujuceEkipe;
	
	private PageForStatistikaTrenera pageForStatistikaDomacegTrenera;
	private PageForStatistikaTrenera pageForStatistikaGostujucegTrenera;
	
	private PageBasicInformationForUtakmica pageBasicInformationForUtakmica;
	
	
	JComboBox<String> comboBoxIgraci;
	
	private Controller controller;
	private VerticalMenuBar vmb;
	
	public PageForReports(Controller controller) {
		this.controller = controller;
		
		this.westPanel = new JPanel(new BorderLayout());
		IzvestajUtakmice izvestajUtakmice=controller.aplikacija.getAktuelniIzvestajUtakmice();
		
		this.pageForStatistikeDomacihIgraca = new PageForStatistikeIgraca(izvestajUtakmice.getStatistikaDomacihIgraca());
		this.pageForStatistikeGostujucihIgraca = new PageForStatistikeIgraca(izvestajUtakmice.getStatistikaGostujucihIgraca());
		
		this.pageForStatistikaDomaceEkipe=new PageForStatistikaEkipe(izvestajUtakmice.getUtakmica().getDomaciKlub().getImeKluba());
		this.pageForStatistikaGostujuceEkipe=new PageForStatistikaEkipe(izvestajUtakmice.getUtakmica().getGostujuciKlub().getImeKluba());
		
		this.pageForStatistikaDomacegTrenera=new PageForStatistikaTrenera(izvestajUtakmice.getUtakmica().getDomaciKlub().getTrener().toString());
		this.pageForStatistikaGostujucegTrenera=new PageForStatistikaTrenera(izvestajUtakmice.getUtakmica().getGostujuciKlub().getTrener().toString());
		
		pageBasicInformationForUtakmica = new PageBasicInformationForUtakmica(izvestajUtakmice.getUtakmica().toString(), izvestajUtakmice.getUtakmica().getHala().toString(), DataBase.sdf.format(izvestajUtakmice.getUtakmica().getDate()));
		
		
		vmb = new VerticalMenuBar(this);
		funcForWestPanel();
		vmb.getMenu(0).addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				putPagePageBasicInformationForUtakmica();
				
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		westPanel.add(vmb, BorderLayout.NORTH);
		
		this.centerPanel = pageBasicInformationForUtakmica;
		add(centerPanel, BorderLayout.CENTER);
		
		add(westPanel, BorderLayout.WEST);
		
		
	}

	public void putMenuBar(String[] menusStr, String[][] items) {
		JMenu menu;
		MenuItem menuItem;
		
		for (int i = 0; i < menusStr.length ; i++) {
			menu = new JMenu(menusStr[i]);
			for (int j = 0; j < items[i].length; j++) {
				System.out.println(items[i].length);
				menuItem = new MenuItem(items[i][j], this, controller, vmb);
				menuItem.addActionListener();
				menu.add(menuItem);
			}
			
			vmb.add(menu);
		}
		
		westPanel.revalidate();
		westPanel.repaint();
	
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
	
	public void putPageForStatistikaIgraca(PageForStatistikeIgraca pageForStatistikeIgraca){
		remove(centerPanel);
		centerPanel=pageForStatistikeIgraca;
		add(centerPanel,BorderLayout.CENTER);
		refresh();
		
	}
	public void putPageForStatistikaEkipe(PageForStatistikaEkipe pageForStatistikaEkipe){
		remove(centerPanel);
		centerPanel=pageForStatistikaEkipe;
		add(centerPanel,BorderLayout.CENTER);
		refresh();
		
	}
	public void putPageForStatistikaTrenera(PageForStatistikaTrenera pageForStatistikaTrenera){
		remove(centerPanel);
		centerPanel=pageForStatistikaTrenera;
		add(centerPanel,BorderLayout.CENTER);
		refresh();
		
	}
	public void putPagePageBasicInformationForUtakmica(){
		remove(centerPanel);
		centerPanel = pageBasicInformationForUtakmica;
		add(centerPanel,BorderLayout.CENTER);
		refresh();
		
	}
	
	public void funcForWestPanel() {
		String[] menusStr = { "Osnovni podaci za utakmicu","Statistika ekipa", "Statistika igraca", "Statistika trenera" };
		String[][] items = { {}, { "Statistika domace ekipe", "Statistika gostujuce ekipe" },
				{ "Igrac domace ekipe", "Igrac gostujuce ekipe" }, { "Trener domace ekipe", "Trener gostujuce ekipe" },
				};

		putMenuBar(menusStr, items);
	}

	public PageForStatistikaEkipe getPageForStatistikaDomaceEkipe() {
		return pageForStatistikaDomaceEkipe;
	}

	public void setPageForStatistikaDomaceEkipe(PageForStatistikaEkipe pageForStatistikaDomaceEkipe) {
		this.pageForStatistikaDomaceEkipe = pageForStatistikaDomaceEkipe;
	}

	public PageForStatistikaEkipe getPageForStatistikaGostujuceEkipe() {
		return pageForStatistikaGostujuceEkipe;
	}

	public void setPageForStatistikaGostujuceEkipe(PageForStatistikaEkipe pageForStatistikaGostujuceEkipe) {
		this.pageForStatistikaGostujuceEkipe = pageForStatistikaGostujuceEkipe;
	}

	public PageForStatistikaTrenera getPageForStatistikaDomacegTrenera() {
		return pageForStatistikaDomacegTrenera;
	}

	public void setPageForStatistikaDomacegTrenera(PageForStatistikaTrenera pageForStatistikaDomacegTrenera) {
		this.pageForStatistikaDomacegTrenera = pageForStatistikaDomacegTrenera;
	}

	public PageForStatistikaTrenera getPageForStatistikaGostujucegTrenera() {
		return pageForStatistikaGostujucegTrenera;
	}

	public void setPageForStatistikaGostujucegTrenera(PageForStatistikaTrenera pageForStatistikaGostujucegTrenera) {
		this.pageForStatistikaGostujucegTrenera = pageForStatistikaGostujucegTrenera;
	}

	public PageBasicInformationForUtakmica getPageBasicInformationForUtakmica() {
		return pageBasicInformationForUtakmica;
	}

	public void setPageBasicInformationForUtakmica(PageBasicInformationForUtakmica pageBasicInformationForUtakmica) {
		this.pageBasicInformationForUtakmica = pageBasicInformationForUtakmica;
	}

	public void refresh() {
		revalidate();
		repaint();
	}

}

