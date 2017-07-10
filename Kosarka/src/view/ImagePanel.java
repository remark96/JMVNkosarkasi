package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.Controller;
import model.IzvestajUtakmice;
import model.Klub;
import model.StanjeKlupa;
import model.StanjeTeren;
import model.StatistikaIgraca;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener {
	private Controller controller;
	
	private GraphicalElement trenerDomacin;
	private GraphicalElement trenerGost;
	
	private BufferedImage court;
	private GraphicalElement domacinImage;
	private GraphicalElement gostImage;
	
	private GraphicalElement[] hostPlayers;
	private GraphicalElement[] guestPlayers;
//	private int width;
//	private int height;
	
	public GraphicalElement selectedGraphicalElement;
	
	private int[] x_koordinate_domacih_igraca = {getX() +235, getX() + 400, getX() +50, getX() +110, getX() +350, getX() +680, getX() + 680, getX() +568, getX() +792, getX() +792, getX() +568, getX() + 792};
	private int[] y_koordinate_domacih_igraca = {getY() + 230, getY() + 207, getY() + 207, getY() + 55, getY() + 55, getY() + 17, getY() + 102, getY() + 102, getY() + 17, getY() + 187, getY() + 17, getY() + 102};
	private int[] x_koordinate_gostujucih_igraca = {getX() +235, getX() + 50, getX() +400, getX() +360, getX() +110, getX() +568, getX() + 680, getX() +680, getX() +792, getX() +568, getX() + 792, getX() +792};
	private int[] y_koordinate_gostujucih_igraca = {MainWindow.SIZE_SCREEN.height - 368, MainWindow.SIZE_SCREEN.height - 345, MainWindow.SIZE_SCREEN.height - 345, MainWindow.SIZE_SCREEN.height - 195, MainWindow.SIZE_SCREEN.height - 195, getY() + 612, getY() + 527, getY() + 612, getY() + 442, getY() + 527, getY() + 527, getY() + 612};
	
	private int oldMouseX = -1;
	private int oldMouseY = -1;
	
	private int oldSelectedPersonX = -1;
	private int oldSelectedPersonY = -1;
	
	
    public ImagePanel(String pathOfImageOfCourt, Controller controller) {
    	this.setController(controller);
    	
    	hostPlayers = new GraphicalElement[IzvestajUtakmice.NUM_OF_PLAYERS];
    	guestPlayers = new GraphicalElement[IzvestajUtakmice.NUM_OF_PLAYERS];
    	
    	IzvestajUtakmice aktuelniIzvestaj = controller.aplikacija.getAktuelniIzvestajUtakmice();
    	
    	Klub domaciKlub = aktuelniIzvestaj.getUtakmica().getDomaciKlub();
    	Klub gostujuciKlub = aktuelniIzvestaj.getUtakmica().getGostujuciKlub();
    	
    	try {                
    		court = ImageIO.read(new File(pathOfImageOfCourt));
    		
    		domacinImage = new GraphicalElement(domaciKlub.getPutanjaDoFotografije(), 100, 100, TypeOfGraphicalElement.logoKluba, true);
    		gostImage = new GraphicalElement(gostujuciKlub.getPutanjaDoFotografije(), 100, 100, TypeOfGraphicalElement.logoKluba, false);
    		
    		
    		
    		trenerDomacin = new GraphicalElement(domaciKlub.getTrener().getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.trener, true);
        	trenerGost = new GraphicalElement(gostujuciKlub.getTrener().getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.trener, false);
    		
        	ArrayList<StatistikaIgraca> statistikeDomacihIgraca = aktuelniIzvestaj.getStatistikaDomacihIgraca();
        	ArrayList<StatistikaIgraca> statistikeGostujucihIgraca = aktuelniIzvestaj.getStatistikaGostujucihIgraca();
        	
        	
    		for (int i = 0; i < IzvestajUtakmice.NUM_OF_PLAYERS; i++) {
    			hostPlayers[i] = new GraphicalElement(statistikeDomacihIgraca.get(i).getIgrac().getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.igrac, true);
    			
			}
    		
    		for (int i = 0; i < IzvestajUtakmice.NUM_OF_PLAYERS; i++) {
    			guestPlayers[i] = new GraphicalElement(statistikeGostujucihIgraca.get(i).getIgrac().getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.igrac, false);
			}
    		
    		//--------------------------------------------------------------
    		
    		int m, k;
        	
    		m = 0;
        	k = 5;
    		for (int i = 0; i < hostPlayers.length; i++) {
    			if (statistikeDomacihIgraca.get(i).getAktuelnoStanje().getTip() == 1) {
    				hostPlayers[i].setX(x_koordinate_domacih_igraca[m]);
            		hostPlayers[i].setY(y_koordinate_domacih_igraca[m]);
            		m++;
				}
    			else {
    				hostPlayers[i].setX(x_koordinate_domacih_igraca[k]);
            		hostPlayers[i].setY(y_koordinate_domacih_igraca[k]);
            		k++;
    			}
    			
    			
			}
    		
    		m = 0;
    		k = 5;
    		for (int j = 0; j < guestPlayers.length; j++) {
    			if (statistikeGostujucihIgraca.get(j).getAktuelnoStanje().getTip() == 1) {
    				guestPlayers[j].setX(x_koordinate_gostujucih_igraca[m]);
        			guestPlayers[j].setY(y_koordinate_gostujucih_igraca[m]);
        			m++;
    			}
    			else {
    				guestPlayers[j].setX(x_koordinate_gostujucih_igraca[k]);
            		guestPlayers[j].setY(y_koordinate_gostujucih_igraca[k]);
            		k++;
    			}
			}
    		
    		// -----------------------------------------------------
    		
    		trenerDomacin.setX(getX() +792);
    		trenerDomacin.setY(getY() + 272);
    		
    		trenerGost.setX(getX() +792);
    		trenerGost.setY(getY() + 357);
    		
    		//------------------------------------------------------
    		
    		domacinImage.setX(getX() + 618);
    		domacinImage.setY(getY() + 234);
    		
    		gostImage.setX(getX() + 618);
    		gostImage.setY(getY() + 365);
    		
    		addMouseListener(this);
    		addMouseMotionListener(this);
		
    		for (int i = 0; i < hostPlayers.length; i++) {
    			hostPlayers[i].getDataPanel().setEnabled(false);
    			guestPlayers[i].getDataPanel().setEnabled(false);
    		}
    		trenerDomacin.getDataPanel().setEnabled(false);
    		trenerGost.getDataPanel().setEnabled(false);
    	} 
    	
    	catch (IOException ex) {
            // handle exception...
    	}
       
     
    }

    public GraphicalElement getTrenerDomacin() { return trenerDomacin; }
	public void setTrenerDomacin(GraphicalElement trenerDomacin) { this.trenerDomacin = trenerDomacin; }
	
	public GraphicalElement getTrenerGost() { return trenerGost; }
	public void setTrenerGost(GraphicalElement trenerGost) { this.trenerGost = trenerGost; }

	public GraphicalElement[] getHostPlayers() { return hostPlayers; }
	public void setHostPlayers(GraphicalElement[] hostPlayers) { this.hostPlayers = hostPlayers; }

	public GraphicalElement[] getGuestPlayers() { return guestPlayers; }
	public void setGuestPlayers(GraphicalElement[] guestPlayers) { this.guestPlayers = guestPlayers; }

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(court, getX() + 10, getY() + 15, MainWindow.SIZE_SCREEN.width / 2 - 140, MainWindow.SIZE_SCREEN.height - 95, this);
        
        g.drawImage(domacinImage.getBufferdImage(), domacinImage.getX(), domacinImage.getY(), domacinImage.getWidth(), domacinImage.getHeight(), this);
        g.drawImage(gostImage.getBufferdImage(), gostImage.getX(), gostImage.getY(), gostImage.getWidth(), gostImage.getHeight(), this);
    
        for (GraphicalElement hostPlayer : hostPlayers) {
        	g.drawImage(hostPlayer.getBufferdImage(), hostPlayer.getX(), hostPlayer.getY(), hostPlayer.getWidth(), hostPlayer.getHeight(), this);
		}
        
        for (GraphicalElement guestPlayer : guestPlayers) {
        	g.drawImage(guestPlayer.getBufferdImage(), guestPlayer.getX(), guestPlayer.getY(), guestPlayer.getWidth(), guestPlayer.getHeight(), this);
		}
        
        g.drawImage(trenerDomacin.getBufferdImage(), trenerDomacin.getX(), trenerDomacin.getY(), trenerDomacin.getWidth(), trenerDomacin.getHeight(), this);
        g.drawImage(trenerGost.getBufferdImage(), trenerGost.getX(), trenerGost.getY(), trenerGost.getWidth(), trenerGost.getHeight(), this);
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(10));
        
        if (selectedGraphicalElement != null) {
//			g2D.setStroke(new BasicStroke(10));
        	g2D.setColor(Color.RED);
        	g2D.drawOval(selectedGraphicalElement.getX(), selectedGraphicalElement.getY() - 10, selectedGraphicalElement.getWidth(), selectedGraphicalElement.getWidth());	
        }
        
        g2D.setColor(Color.BLUE);
        g2D.drawLine(getX() + 568, getY() + 351, getX() + 887, getY() + 351);
        
		
    }
    
    private GraphicalElement getClickedGraphicalElement(MouseEvent e) {
    	for (GraphicalElement hostPlayer : hostPlayers) {
			if (hostPlayer.contains(e.getPoint()))  {
				return hostPlayer;
			}
    	}
    	
    	for (GraphicalElement guestPlayer : guestPlayers) {
			if (guestPlayer.contains(e.getPoint()))  {
				return guestPlayer;
			}
    	}
    	
    	if (trenerDomacin.contains(e.getPoint())) return trenerDomacin;
    	if (trenerGost.contains(e.getPoint())) return trenerGost;
    	if (domacinImage.contains(e.getPoint())) return domacinImage;
    	if (gostImage.contains(e.getPoint())) return gostImage;
    	
    	return null;
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		//selectedGraphicalElement = getClickedPlayer(e);
		
//		MainWindow mainWindow = (MainWindow) SwingUtilities.windowForComponent(this);
//		mainWindow.getIgrac().setText(selectedGraphicalElement.getNameAndSurname());
//		
//		revalidate();
//		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) { /*TODO Auto-generated method stub*/ }

	@Override
	public void mouseExited(MouseEvent arg0) { /*TODO Auto-generated method stub*/ }

	@Override
	public void mousePressed(MouseEvent e) {
		oldMouseX = e.getX();
		oldMouseY = e.getY();
		
		PageForNewGame pageForNewGame = ((MainWindow) SwingUtilities.windowForComponent(this)).getPageForNewGame();
		
		if (selectedGraphicalElement != null) {
			selectedGraphicalElement.setDataPanel(pageForNewGame.getDataPanel());
		}
		
		selectedGraphicalElement = getClickedGraphicalElement(e);
		
		if (selectedGraphicalElement != null) {
			oldSelectedPersonX = selectedGraphicalElement.getX();
			oldSelectedPersonY = selectedGraphicalElement.getY();
			
//			MainWindow mainWindow = (MainWindow) SwingUtilities.windowForComponent(this);
			
			pageForNewGame.getNorthLabel().setText(selectedGraphicalElement.getTitle());
			if (pageForNewGame.getDataPanel() != null) pageForNewGame.getEastPanel().remove(pageForNewGame.getDataPanel());
			pageForNewGame.setDataPanel(selectedGraphicalElement.getDataPanel());
			
			StatistikaIgraca statistikaIgraca;
			
			if (selectedGraphicalElement.getDomaci()) statistikaIgraca = controller.aplikacija.getAktuelniIzvestajUtakmice().getStatistikaDomacegIgr(selectedGraphicalElement.getTitle());
			else statistikaIgraca = controller.aplikacija.getAktuelniIzvestajUtakmice().getStatistikaGostujucegIgr(selectedGraphicalElement.getTitle());
			
			if (selectedGraphicalElement.getType() == TypeOfGraphicalElement.igrac && statistikaIgraca.getAktuelnoStanje().getTip() != 1) {
				pageForNewGame.getDataPanel().setEnabled(false);
			}
			
			//pageForNewGame.getEastpanel().add(selectedGraphicalElement.getDataPanel(), BorderLayout.CENTER);
			pageForNewGame.refreshDataPanel();
		}
		else {
			revalidate();
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		//selectedGraphicalElement = null;
		
		PageForNewGame pageForNewGame = ((MainWindow) SwingUtilities.windowForComponent(this)).getPageForNewGame();
		
		if (selectedGraphicalElement != null) {
			boolean condition = existsInTeam(hostPlayers);
			
			if(condition) {
				findAndSolveColision(hostPlayers, pageForNewGame);
			}
			else {
				condition = existsInTeam(guestPlayers);
				if (condition) {
					findAndSolveColision(guestPlayers, pageForNewGame);
				}
				else {
					selectedGraphicalElement.setX(oldSelectedPersonX);
					selectedGraphicalElement.setY(oldSelectedPersonY);
				}
				
			}
			
			
//			mainWindow.getIgrac().setText(selectedGraphicalElement.getNameAndSurname());
		}
		
		else pageForNewGame.getNorthLabel().setText(pageForNewGame.getDomacin() + " - " + pageForNewGame.getGost());
		
		revalidate();
		repaint();
	}

	private void findAndSolveColision(GraphicalElement[] players, PageForNewGame pageForNewGame) {
		for (GraphicalElement player : players) {
			if (!selectedGraphicalElement.equals(player) &&  (Math.abs(selectedGraphicalElement.getX() - player.getX()) < 100 /2) && (Math.abs(selectedGraphicalElement.getY() - player.getY()) < 75 /2)) { 
				StatistikaIgraca statistikaSelektovanogIgraca, statistikaIgraca;
				
				if (selectedGraphicalElement.getDomaci()) statistikaSelektovanogIgraca = controller.aplikacija.getAktuelniIzvestajUtakmice().getStatistikaDomacegIgr(selectedGraphicalElement.getTitle());
				else statistikaSelektovanogIgraca = controller.aplikacija.getAktuelniIzvestajUtakmice().getStatistikaGostujucegIgr(selectedGraphicalElement.getTitle());
				
				if (player.getDomaci()) statistikaIgraca = controller.aplikacija.getAktuelniIzvestajUtakmice().getStatistikaDomacegIgr(player.getTitle());
				else statistikaIgraca = controller.aplikacija.getAktuelniIzvestajUtakmice().getStatistikaGostujucegIgr(player.getTitle());
				
				if (statistikaSelektovanogIgraca.getAktuelnoStanje().getTip() != statistikaIgraca.getAktuelnoStanje().getTip()) {
					if (statistikaSelektovanogIgraca.getAktuelnoStanje().getTip() == 1) {
						statistikaSelektovanogIgraca.promeniStanje(new StanjeKlupa());
						selectedGraphicalElement.getDataPanel().setEnabled(false);
					}
					else if (statistikaSelektovanogIgraca.getAktuelnoStanje().getTip() == 2) {
						statistikaSelektovanogIgraca.promeniStanje(new StanjeTeren());
						if (pageForNewGame.getIndeksCetvrtine() != 0) selectedGraphicalElement.getDataPanel().setEnabled(true);
					}
					
					if (statistikaIgraca.getAktuelnoStanje().getTip() == 1) {
						statistikaIgraca.promeniStanje(new StanjeKlupa());
						player.getDataPanel().setEnabled(false);
					}
					else if (statistikaIgraca.getAktuelnoStanje().getTip() == 2) {
						statistikaIgraca.promeniStanje(new StanjeTeren());
						if (pageForNewGame.getIndeksCetvrtine() != 0) player.getDataPanel().setEnabled(true);
					}
				}
				
				
				if (selectedGraphicalElement.getType() == TypeOfGraphicalElement.igrac && statistikaIgraca.getAktuelnoStanje().getTip() != 1) {
					
				}
				
				selectedGraphicalElement.setX(player.getX());
				selectedGraphicalElement.setY(player.getY());
				
				player.setX(oldSelectedPersonX);
				player.setY(oldSelectedPersonY);
				
				return;	
			}
		}
		
		// ako nije doslo do dovoljnog preklapanja slika, onda se slika koja je pomerana vraca na staru poziciju
		selectedGraphicalElement.setX(oldSelectedPersonX);
		selectedGraphicalElement.setY(oldSelectedPersonY);
		
	}

	private boolean existsInTeam(GraphicalElement[] players) {
		for (GraphicalElement player : players) {
			
			if (selectedGraphicalElement.equals(player)) return true;
		}
		
		return false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//GraphicalElement hostPlayer = getClickedPlayer(e);
		
		if (selectedGraphicalElement != null) {
//			oldX = e.getX();
//			oldY = e.getY();
			if (selectedGraphicalElement.equals(trenerDomacin) || selectedGraphicalElement.equals(trenerGost) || selectedGraphicalElement.equals(domacinImage) || selectedGraphicalElement.equals(gostImage)) return;
			
			int raz_x = oldMouseX- e.getX();
			int raz_y = oldMouseY - e.getY(); 
			
			oldMouseX = e.getX();
			oldMouseY = e.getY();
			
			selectedGraphicalElement.setX(selectedGraphicalElement.getX() - raz_x);
			selectedGraphicalElement.setY(selectedGraphicalElement.getY() - raz_y);
			
			
			revalidate();
			repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }

	public GraphicalElement getDomacinImage() {
		return domacinImage;
	}

	public void setDomacinImage(GraphicalElement domacinImage) {
		this.domacinImage = domacinImage;
	}

	public GraphicalElement getGostImage() {
		return gostImage;
	}

	public void setGostImage(GraphicalElement gostImage) {
		this.gostImage = gostImage;
	}

	
}
