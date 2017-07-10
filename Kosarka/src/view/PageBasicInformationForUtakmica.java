package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PageBasicInformationForUtakmica extends JPanel {
	
	private JLabel nazivUtakmice;
	private JLabel nazivHale;
	private JLabel datum;
	private JPanel northPanel;
	
	public PageBasicInformationForUtakmica(String utakmica,String hala,String datumUtakmice) {
		setLayout(new BorderLayout());
		
		northPanel = new JPanel(new GridLayout(8, 4)); 
		
		nazivUtakmice = new JLabel(utakmica,JLabel.CENTER); 
		nazivUtakmice.setFont(new Font("Naziv fonta", Font.PLAIN, 20));
		nazivUtakmice.setForeground(Color.BLUE);
		
		nazivHale = new JLabel(hala,JLabel.CENTER); 
		nazivHale.setFont(new Font("Naziv fonta", Font.PLAIN, 20));
		nazivHale.setForeground(Color.BLUE);
		
		datum = new JLabel(datumUtakmice,JLabel.CENTER); 
		datum.setFont(new Font("Naziv fonta", Font.PLAIN, 20));
		datum.setForeground(Color.BLUE);
		
		for (int i = 0; i < 20; i++) northPanel.add(new JLabel(""));
		northPanel.add(new JLabel("")); northPanel.add(nazivUtakmice); northPanel.add(new JLabel("")); northPanel.add(new JLabel(""));
		northPanel.add(new JLabel("")); northPanel.add(new JLabel("   Naziv hale: ")); northPanel.add(nazivHale); northPanel.add(new JLabel(""));
		northPanel.add(new JLabel("")); northPanel.add(new JLabel("   Datum utakmice: ")); northPanel.add(datum); northPanel.add(new JLabel(""));

		
		add(northPanel, BorderLayout.NORTH);
		
	}
}
