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
import model.Igrac;
import model.IzvestajUtakmice;
import model.Klub;

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
	
	private int oldMouseX = -1;
	private int oldMouseY = -1;
	
	private int oldSelectedPersonX = -1;
	private int oldSelectedPersonY = -1;
	
	
    public ImagePanel(String pathOfImageOfCourt, Controller controller) {
    	this.setController(controller);
    	
    	hostPlayers = new GraphicalElement[IzvestajUtakmice.NUM_OF_PLAYERS];
    	guestPlayers = new GraphicalElement[IzvestajUtakmice.NUM_OF_PLAYERS];
    	
    	Klub domaciKlub = controller.aplikacija.getAktuelniIzvestajUtakmice().getUtakmica().getDomaciKlub();
    	Klub gostujuciKlub = controller.aplikacija.getAktuelniIzvestajUtakmice().getUtakmica().getGostujuciKlub();
    	
    	try {                
    		court = ImageIO.read(new File(pathOfImageOfCourt));
    		
    		domacinImage = new GraphicalElement(domaciKlub.getPutanjaDoFotografije(), 100, 100, TypeOfGraphicalElement.logoKluba, true);
    		gostImage = new GraphicalElement(gostujuciKlub.getPutanjaDoFotografije(), 100, 100, TypeOfGraphicalElement.logoKluba, false);
    		
    		
    		
    		trenerDomacin = new GraphicalElement(domaciKlub.getTrener().getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.trener, true);
        	trenerGost = new GraphicalElement(gostujuciKlub.getTrener().getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.trener, false);
    		
        	ArrayList<Igrac> domaciIgraci = domaciKlub.getIgraci();
        	ArrayList<Igrac> gostujuciIgraci = gostujuciKlub.getIgraci();
        	
    		for (int i = 0; i < IzvestajUtakmice.NUM_OF_PLAYERS; i++) {
    			hostPlayers[i] = new GraphicalElement(domaciIgraci.get(i).getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.igrac, true);
			}
    		
    		for (int i = 0; i < IzvestajUtakmice.NUM_OF_PLAYERS; i++) {
    			guestPlayers[i] = new GraphicalElement(gostujuciIgraci.get(i).getPutanjaDoFotografije(), 100, 75, TypeOfGraphicalElement.igrac, false);
			}
    		
    		
    		hostPlayers[0].setX(getX() +235);
    		hostPlayers[0].setY(getY() + 230);
    		
    		hostPlayers[1].setX(getX() + 400);
    		hostPlayers[1].setY(getY() + 207);
    		
    		hostPlayers[2].setX(getX() +50);
    		hostPlayers[2].setY(getY() + 207);
    		
    		hostPlayers[3].setX(getX() +110);
    		hostPlayers[3].setY(getY() + 55);
    		
    		hostPlayers[4].setX(getX() +350);
    		hostPlayers[4].setY(getY() + 55);
    		
    		hostPlayers[5].setX(getX() +680);
    		hostPlayers[5].setY(getY() + 17);
    		
    		hostPlayers[6].setX(getX() + 680);
    		hostPlayers[6].setY(getY() + 102);
    		
    		hostPlayers[7].setX(getX() +568);
    		hostPlayers[7].setY(getY() + 102);
    		
    		hostPlayers[8].setX(getX() +792);
    		hostPlayers[8].setY(getY() + 17);
    		
    		hostPlayers[9].setX(getX() +792);
    		hostPlayers[9].setY(getY() + 187);
    		
    		hostPlayers[10].setX(getX() +568);
    		hostPlayers[10].setY(getY() + 17);
    		
    		hostPlayers[11].setX(getX() + 792);
    		hostPlayers[11].setY(getY() + 102);
    		
    		//--------------------------------------------------------------
    		
    		guestPlayers[0].setX(getX() +235);
    		guestPlayers[0].setY(MainWindow.SIZE_SCREEN.height - 368);
    		
    		guestPlayers[1].setX(getX() + 50);
    		guestPlayers[1].setY(MainWindow.SIZE_SCREEN.height - 345);
    		
    		guestPlayers[2].setX(getX() +400);
    		guestPlayers[2].setY(MainWindow.SIZE_SCREEN.height - 345);
    		
    		guestPlayers[3].setX(getX() +360);
    		guestPlayers[3].setY(MainWindow.SIZE_SCREEN.height - 195);
			
    		guestPlayers[4].setX(getX() +110);
    		guestPlayers[4].setY(MainWindow.SIZE_SCREEN.height - 195);
    		
    		guestPlayers[5].setX(getX() +568);
    		guestPlayers[5].setY(getY() + 612);
    		
    		guestPlayers[6].setX(getX() + 680);
    		guestPlayers[6].setY(getY() + 527);
    		
    		guestPlayers[7].setX(getX() +680);
    		guestPlayers[7].setY(getY() + 612);
    		
    		guestPlayers[8].setX(getX() +792);
    		guestPlayers[8].setY(getY() + 442);
			
    		guestPlayers[9].setX(getX() +568);
    		guestPlayers[9].setY(getY() + 527); 
    		
    		guestPlayers[10].setX(getX() + 792);
    		guestPlayers[10].setY(getY() + 527);
    		
    		guestPlayers[11].setX(getX() +792); 
    		guestPlayers[11].setY(getY() + 612);
    		
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
		
    	} 
    	
    	catch (IOException ex) {
            // handle exception...
    	}
       
     
    }

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
				findAndSolveColision(hostPlayers);
			}
			else {
				condition = existsInTeam(guestPlayers);
				if (condition) {
					findAndSolveColision(guestPlayers);
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

	private void findAndSolveColision(GraphicalElement[] players) {
		for (GraphicalElement player : players) {
			if (!selectedGraphicalElement.equals(player) &&  (Math.abs(selectedGraphicalElement.getX() - player.getX()) < 100 /2) && (Math.abs(selectedGraphicalElement.getY() - player.getY()) < 75 /2)) { 
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

}