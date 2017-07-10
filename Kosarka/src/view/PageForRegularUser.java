package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.Controller;

@SuppressWarnings("serial")
public class PageForRegularUser extends JPanel implements ActionListener {
	private JButton newGame;
	private JButton reports;
	
	private PageForNewGame pageForNewGame;
	private PageForReports pageForReports;
	
	private Controller controller;
	
	
	public PageForRegularUser() {
		setLayout(new GridLayout(3, 5));
		setBackground(Color.BLUE);
		
		newGame = new JButton(new ImageIcon("images/new_game.jpg"));
		reports = new JButton(new ImageIcon("images/reports.jpg"));
		
		newGame.setToolTipText("Zapocnite novu utakmicu");
		reports.setToolTipText("Pogledajte izvestaje");
		
		newGame.setBackground(Color.RED);
		reports.setBackground(new Color(0, 120, 60));
		
		newGame.addActionListener(this);
		reports.addActionListener(this);
		
		for (int i = 0; i < 6; i++) add(new JLabel());
		add(newGame);
		add(new JLabel());
		add(reports);
		for (int i = 0; i < 6; i++) add(new JLabel());
	}

	
	public PageForReports getPageForReports() {
		return pageForReports;
	}

	public void setPageForReports(PageForReports pageForReports) {
		this.pageForReports = pageForReports;
	}
	
	public PageForNewGame getPageForNewGame() {
		return pageForNewGame;
	}

	public void setPageForNewGame(PageForNewGame pageForNewGame) {
		this.pageForNewGame = pageForNewGame;
	}
	
	public JButton getNewGame() { return newGame; }
	public void setNewGame(JButton newGame) { this.newGame = newGame; }

	public JButton getReports() { return reports; }
	public void setReports(JButton reports) { this.reports = reports; }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (controller == null) controller = ((MainWindow) SwingUtilities.windowForComponent(this)).getController();
		
		Object source = e.getSource();
        
		if (source == newGame) controller.processNewGameEvent();
        else if (source == reports) controller.processReportsEvent();
	}
	
	
}
