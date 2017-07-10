package view;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Controller;


@SuppressWarnings("serial")
public class Spinner extends JSpinner implements ChangeListener {
	private Controller controller;
	public static String[] imenaAtributa = {
			"pogdak_za_1",
			"pogdak_za_2",
			"pogdak_za_3",
			"promasaj_za_1",
			"promasaj_za_2",
			"promasaj_za_3",
			"asistencije",
			"def_skokovi",
			"ofa_skokovi",
			"licne_greske1",
			"licne_greske2",
			"licne_greske3",
			"nesportske_greske1",
			"nesportske_greske2",
			"nesportske_greske3",
			"tehnicke_greske",
			"blokade",
			"koraci",
			"duplaLopta",
			"loseDodavanje",
			"loseHvatanje",
			"loseVodjenje",
			"triSecUReketu",
			"petSecPrilikomIzvodjenjaAuta",
			"osamSecProsloPrePrelaSredTer",
			"prekoPola",
			"faulUNapaduSLoptom",
			"faulUNapaduBezLopte",
			"faulUOdbrani"
			}; 
	
	private int indeksAtributa;
	
	public int getIndeksAtributa() {
		return indeksAtributa;
	}

	public void setIndeksAtributa(int indeksAtributa) {
		this.indeksAtributa = indeksAtributa;
	}

	public Spinner(SpinnerNumberModel model, int indeksAtributa) {
		super(model);
		this.indeksAtributa = indeksAtributa;
		addChangeListener(this);
	
		
		//db = new DataBase();
	}

	/*public void addChangeListener() {
		addChangeListener(this);
	}*/
	

	@Override
	public void stateChanged(ChangeEvent e) {
		if (controller == null) controller = ((MainWindow) SwingUtilities.windowForComponent(this)).getController();
		
		controller.processSpinnerEvent(indeksAtributa, this);
	}

}
