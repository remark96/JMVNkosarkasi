package packet;

import controller.Controller;
import model.Aplikacija;
import view.MainWindow;

public class Main{

	public static void main(String[] args) {
		Aplikacija aplikacija = new Aplikacija(); // model
		
		MainWindow mainWindow = new MainWindow("Kosarka"); // view
		mainWindow.setVisible(true);

		Controller  controller = new Controller(aplikacija, mainWindow);
		
		mainWindow.setController(controller);
	}

}
