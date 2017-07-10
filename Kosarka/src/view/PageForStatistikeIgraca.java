package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.IzvestajUtakmice;
import model.StatistikaIgraca;

@SuppressWarnings("serial")
public class PageForStatistikeIgraca extends JPanel {
	private Tab[] tabovi;
	private ArrayList<StatistikaIgraca> statistikeIgraca;
	
	private JTabbedPane tabPanel;
	
	public PageForStatistikeIgraca(ArrayList<StatistikaIgraca> statistikeIgraca ) {
		setLayout(new BorderLayout());
		this.statistikeIgraca = statistikeIgraca;
		
		
		tabPanel = new JTabbedPane();
		
		tabovi = new Tab[IzvestajUtakmice.NUM_OF_PLAYERS];
	
		
		for (int i = 0; i < tabovi.length; i++) {
			tabovi[i] = new Tab();
			tabovi[i].podesiModelTabele(statistikeIgraca.get(i).getCetvrtine());
			tabPanel.add(statistikeIgraca.get(i).getIgrac().toString(), tabovi[i]);
		}
		
		add(tabPanel, BorderLayout.CENTER);
		
		
	}
	
	public Tab[] getTabovi() { return tabovi; }
	public void setTabovi(Tab[] tabovi) { this.tabovi = tabovi; }

	public ArrayList<StatistikaIgraca> getStatistikeIgraca() { return statistikeIgraca; }
	public void setStatistikeIgraca(ArrayList<StatistikaIgraca> statistikeIgraca) { this.statistikeIgraca = statistikeIgraca; }
	
}

