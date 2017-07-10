package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
class VerticalMenuBar extends JMenuBar {
	  private static final LayoutManager grid = new GridLayout(0,1);
	  private JPanel page;
	private Controller controller;
	  
	  public VerticalMenuBar(Controller controller, JPanel page) {
		  this.controller = controller;
		  this.page = page;
		  setLayout(grid);
	  }

	  public Controller getController() {
			return controller;
		}

		public void setController(Controller controller) {
			this.controller = controller;
		}

	public JPanel getPage() {
		return page;
	}

	public void setPage(JPanel page) {
		this.page = page;
	}
	  
	  
}
