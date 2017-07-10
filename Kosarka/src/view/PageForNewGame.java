package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controller.Controller;
import model.Utakmica;

@SuppressWarnings("serial")
public class PageForNewGame extends JSplitPane implements ActionListener {
	private Controller controller;
	
	private DialogForKvadrant dialogForKvadrant;
	
	private String domacin;
	private String gost;
	
	private ImagePanel westpanel;
	private JPanel eastpanel;
	private JPanel northPanel;
	
	private DataPanel dataPanel;
	
	private JLabel northLabel;
	private JLabel cetvrtinaLabel;
	private JButton dugmeZaCetvrtinu;
	
	private int indeksCetvrtine = 0;
	
	private Dimension SIZE_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
	
	public PageForNewGame(Controller controller) {
		setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		setDividerLocation(SIZE_SCREEN.width / 2 + 220);
		
		this.controller = controller;
		
		Utakmica utakmica = controller.aplikacija.getAktuelniIzvestajUtakmice().getUtakmica();
		
		domacin = utakmica.getDomaciKlub().getImeKluba();
		gost = utakmica.getGostujuciKlub().getImeKluba();
		
		westpanel = new ImagePanel("images\\basketball_court.png", controller);
		eastpanel = new JPanel(new BorderLayout());
		
		westpanel.setBackground(Color.ORANGE);
		eastpanel.setBackground(Color.BLUE);
		
		northPanel = new JPanel(new GridLayout(6, 1));
		northPanel.setBackground(Color.GRAY);
		
		northLabel = new JLabel(domacin + " - " + gost, JLabel.CENTER);
		northLabel.setFont(new Font("", Font.PLAIN, 25));
		
		cetvrtinaLabel = new JLabel("", JLabel.CENTER);
		cetvrtinaLabel.setFont(new Font("", Font.PLAIN, 25));
		
		dugmeZaCetvrtinu = new JButton("Zapocni 1. cetvrtinu");
		dugmeZaCetvrtinu.addActionListener(this);
		dugmeZaCetvrtinu.setBackground(Color.GREEN);
	
		northPanel.add(cetvrtinaLabel);
		northPanel.add(new JLabel(""));
		northPanel.add(dugmeZaCetvrtinu);
		northPanel.add(new JLabel(""));
		northPanel.add(northLabel);
		northPanel.add(new JLabel(""));
		
		eastpanel.add(northPanel, BorderLayout.NORTH);
		
		setLeftComponent(westpanel);
		setRightComponent(eastpanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		if (controller == null) controller = ((MainWindow) SwingUtilities.windowForComponent(this)).getController();
		
		controller.processDugmeZaCetvrtinuEvent();
	}

	public void refreshDataPanel() {
		eastpanel.add(dataPanel, BorderLayout.CENTER);
		eastpanel.revalidate();
		eastpanel.repaint();
	}
	
	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }

	public String getDomacin() { return domacin; }
	public void setDomacin(String domacin) { this.domacin = domacin; }

	public String getGost() { return gost; }
	public void setGost(String gost) { this.gost = gost; }

	public JPanel getEastpanel() { return eastpanel; }
	public void setEastpanel(JPanel eastpanel) { this.eastpanel = eastpanel; }
	
	public JPanel getNorthPanel() { return northPanel; }
	public void setNorthPanel(JPanel northPanel) { this.northPanel = northPanel; }

	public JLabel getCetvrtinaLabel() { return cetvrtinaLabel; }
	public void setCetvrtinaLabel(JLabel cetvrtinaLabel) { this.cetvrtinaLabel = cetvrtinaLabel; }

	public JButton getDugmeZaCetvrtinu() { return dugmeZaCetvrtinu; }
	public void setDugmeZaCetvrtinu(JButton dugmeZaCetvrtinu) { this.dugmeZaCetvrtinu = dugmeZaCetvrtinu; }

	public int getIndeksCetvrtine() { return indeksCetvrtine; }
	public void setIndeksCetvrtine(int indeksCetvrtine) { this.indeksCetvrtine = indeksCetvrtine; }

	public ImagePanel getWestpanel() { return westpanel; }
	public void setWestpanel(ImagePanel westpanel) { this.westpanel = westpanel; }

	public JPanel getEastPanel() { return eastpanel; }
	public void setEastPanel(JPanel eastpanel) { this.eastpanel = eastpanel; }

	public JLabel getNorthLabel() { return northLabel; }
	public void setNorthLabel(JLabel northLabel) { this.northLabel = northLabel; }

	public DataPanel getDataPanel() { return dataPanel; }
	public void setDataPanel(DataPanel dataPanel) { this.dataPanel = dataPanel; }

	public DialogForKvadrant getDialogForKvadrant() { return dialogForKvadrant; }
	public void setDialogForKvadrant(DialogForKvadrant dialogForKvadrant) { this.dialogForKvadrant = dialogForKvadrant; }
	
}
