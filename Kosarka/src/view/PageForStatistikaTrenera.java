package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PageForStatistikaTrenera extends JPanel{
	private JTable tabela;
	private JScrollPane mainPanel;
	private JLabel imeTrenera;
	private JPanel northPanel;
	
	public PageForStatistikaTrenera(String ime) {
		setLayout(new BorderLayout());
		
		tabela = new JTable();
		mainPanel = new JScrollPane(tabela);
		
		northPanel = new JPanel(new GridLayout(5, 3)); 
		
		imeTrenera = new JLabel(ime,JLabel.CENTER); 
		imeTrenera.setFont(new Font("Naziv fonta", Font.PLAIN, 25));
		imeTrenera.setForeground(Color.BLUE);
		
		for (int i = 0; i < 3; i++) northPanel.add(new JLabel(""));
		northPanel.add(new JLabel("")); northPanel.add(imeTrenera); northPanel.add(new JLabel(""));
		for (int i = 0; i < 9; i++) northPanel.add(new JLabel(""));
		
		add(northPanel, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JScrollPane getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JScrollPane mainPanel) {
		this.mainPanel = mainPanel;
	}

}

