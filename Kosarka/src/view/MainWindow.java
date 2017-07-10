package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.Controller;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	private PageForRegularUser pageForUser = null;
	
	private DialogWindow login;
	
	private HomePage homePage;
	
	private PageForAdministrator pageForAdministrator;
	
	private CustomNewGame customeNewGame;
	
	private CustomNewReport customNewReport;

	private Controller controller;
	
	public static Dimension SIZE_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public MainWindow(String title) {
		super(title);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		
		homePage = new HomePage();
		getContentPane().add(homePage, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		mainPanel = new JSplitPane();
		mainPanel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		mainPanel.setDividerLocation(SIZE_SCREEN.width / 2 + 220);
		
		westpanel = new ImagePanel("images\\basketball_court.png", "images\\fenerbahce.png", "images\\crvena_zvezda.png", "FENERBAHCE", "CRVENA ZVEZDA", "images\\zeljko_obradovic.png", "images\\dejan_radonjic.png", new String[] {"images\\bobby_dixon.png", "images\\bogdan_bogdanovic.png", "images\\nikola_kalinic.png", "images\\pero_antic.png", "images\\ekpe_udoh.png", "images\\kostas_sloukas.png", "images\\james_nunnally.png", "images\\luigi_datome.png", "images\\jan_vesely.png", "images\\melih_mahmutoglu.png", "images\\baris_hersek.png", "images\\ahmet_duverioglu.png"}, new String[] {"images\\stefan_jovic.png", "images\\charles_jenkins.png", "images\\branko_lazic.png", "images\\marko_simonovic.png", "images\\ognjen_kuzmic.png", "images\\nate_wolters.png", "images\\nemanja_dangubic.png", "images\\marko_guduric.png", "images\\luka_mitrovic.png", "images\\milko_bjelica.png", "images\\deon_thompson.png", "images\\borisa_simanic.png"});
		eastpanel = new JPanel(new BorderLayout());
		
		westpanel.setBackground(Color.ORANGE);
		eastpanel.setBackground(Color.BLUE);
		
		northPanel = new JPanel(new GridLayout(6, 1));
		northPanel.setBackground(Color.GRAY);
		
		northLabel = new JLabel("FENERBAHCE - CRVENA ZVEZDA", JLabel.CENTER);
		northLabel.setFont(new Font("", Font.PLAIN, 25));
		
		cetvrtinaLbel = new JLabel("", JLabel.CENTER);
		cetvrtinaLbel.setFont(new Font("", Font.PLAIN, 25));
		
		dugmeZaCetvrtinu = new JButton("Zapocni prvu cetvrtinu");
		dugmeZaCetvrtinu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (dugmeZaCetvrtinu.getText().equals("Kraj")) {
					
				}
				else {
					cetvrtinaLbel.setText(indeksCetvrtine + ". Cetvrtina");
					indeksCetvrtine++;
					String ispis;
					if (indeksCetvrtine < 5) ispis = "Zapocni " + indeksCetvrtine + ". cetvrtinu";
					else ispis = "Kraj";
					dugmeZaCetvrtinu.setText(ispis);
				}
			}
		});
		dugmeZaCetvrtinu.setBackground(Color.GREEN);
		
		//northPanel.add(new JLabel("AAAAAAAAAA"));
		//northPanel.add(new JLabel("AAAAAAAAAA"));
		northPanel.add(cetvrtinaLbel);
		northPanel.add(new JLabel(""));
		northPanel.add(dugmeZaCetvrtinu);
		northPanel.add(new JLabel(""));
		northPanel.add(northLabel);
		northPanel.add(new JLabel(""));
//		northPanel.add(new JLabel("AAAAAAAAAA"));
		
		eastpanel.add(northPanel, BorderLayout.NORTH);
		//dataPanel = new DataPanel(); 
		//eastpanel.add(dataPanel, BorderLayout.CENTER);
		
		mainPanel.setLeftComponent(westpanel);
		mainPanel.setRightComponent(eastpanel);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		
	}
	
	public HomePage getHomePage() { return homePage; }
	public void setHomePage(HomePage homePage) { this.homePage = homePage; }
	
	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }

	public DialogWindow getLogin() { return login; }
	public void setLogin(DialogWindow login) { this.login = login; }

	public PageForRegularUser getPageForUser() { return pageForUser; }
	public void setPageForUser(PageForRegularUser pageForUser) { this.pageForUser = pageForUser;	}
	
	public CustomNewGame getCustomeNewGame() { return customeNewGame; }
	public void setCustomeNewGame(CustomNewGame customeNewGame) { this.customeNewGame = customeNewGame; }

	public void putPageForUserOnScreen() {
		getContentPane().removeAll();
		getContentPane().add(pageForUser, BorderLayout.CENTER);
		refresh();
	}
	
	public void putPageForAdminOnScreen()
	{
		getContentPane().removeAll();
		getContentPane().add(pageForAdministrator, BorderLayout.CENTER);
		refresh();
	}
	
	public void putHomePageOnScreen() {
		getContentPane().removeAll();
		getContentPane().add(homePage, BorderLayout.CENTER);
		refresh();
	}
	
	public void putPageForReportsOnScreen() {
		getContentPane().removeAll();
		getContentPane().add(pageForUser.getPageForReports(), BorderLayout.CENTER);
		refresh();
	}
	
	public void putPageForNewGamerOnScreen() {
		getContentPane().removeAll();
		getContentPane().add(pageForUser.getPageForNewGame(), BorderLayout.CENTER);
		refresh();
	}
	
	public void refresh() {
		revalidate();
		repaint();
	}

	public PageForAdministrator getPageForAdministrator() {
		return pageForAdministrator;
	}

	public void setPageForAdministrator(PageForAdministrator pageForAdministrator) {
		this.pageForAdministrator = pageForAdministrator;
	}

	public CustomNewReport getCustomNewReport() {
		return customNewReport;
	}

	public void setCustomNewReport(CustomNewReport customNewReport) {
		this.customNewReport = customNewReport;
	}

	
}
