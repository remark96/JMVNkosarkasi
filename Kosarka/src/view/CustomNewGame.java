package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import controller.Controller;


@SuppressWarnings("serial")
public class CustomNewGame extends JDialog {
	private PrvaStranaCNP prvaStrana;
	private DrugaStranaCNP drugaStrana;
	
	public CustomNewGame() {
		
	}

	public CustomNewGame(Controller controller) {
		setSize(800, 500);
		setLayout(new BorderLayout());
		setModal(true);
		setTitle("Custom new game");
		setLocation(MainWindow.SIZE_SCREEN.width/5, MainWindow.SIZE_SCREEN.height/5);
		
		prvaStrana = new PrvaStranaCNP(controller);
		//drugaStrana = new DrugaStranaCNP(co);
		
		
		getContentPane().add(prvaStrana, BorderLayout.CENTER);
	}

	public PrvaStranaCNP getPrvaStrana() { return prvaStrana; }
	public void setPrvaStrana(PrvaStranaCNP prvaStrana) { this.prvaStrana = prvaStrana; }

	public DrugaStranaCNP getDrugaStrana() { return drugaStrana; }
	public void setDrugaStrana(DrugaStranaCNP drugaStrana) { this.drugaStrana = drugaStrana; }

}