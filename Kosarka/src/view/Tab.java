package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cetvrtina;

@SuppressWarnings("serial")
public class Tab extends JPanel {
	private JTable tabela;
	private JScrollPane scrollPane;
	

	public Tab() {
		setLayout(new BorderLayout());
		
		tabela = new JTable();
		scrollPane = new JScrollPane(tabela);
		
		JPanel pomocni = new JPanel(new GridLayout(4, 1));
		for (int i = 0; i < 3; i++) pomocni.add(new JLabel("                                                                      "));
		
		add(pomocni, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	
	public JTable getTabela() { return tabela; }
	public void setTabela(JTable tabela) { this.tabela = tabela; }
	
	public void podesiModelTabele (ArrayList<Cetvrtina> cetvrtine) {
		DefaultTableModel tm = new DefaultTableModel();
//		tm.setColumnIdentifiers(new String[] {"Quarter", "P", "MIN", "PTS","REB","AST","BLK","FGM","FGA","FG%",
//				"3PM","3PA","3P%","FTM","FTA","FT%","OREB","DREB","TOV","TF","PF","+/-"});
		
		tm.setColumnIdentifiers(new String[] {"WWWW", "EEEE", "RRRR"});
		
		for (int i = 0; i < cetvrtine.size(); i++) {
			tm.addRow(cetvrtine.get(i).getArrayStrings(i+1));
		}
		
		tabela.setModel(tm);
	}
}

