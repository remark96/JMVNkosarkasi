package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JMenuBar;

import model.Aplikacija;

@SuppressWarnings("serial")
class VerticalMenuBar extends JMenuBar {
	  private static final LayoutManager grid = new GridLayout(0,1);
	  private Aplikacija aplikacija;
	  // private JTable table;
	  private PageForAdministrator page;
	  
	  public VerticalMenuBar(Aplikacija aplikacija, PageForAdministrator page) {
		  this.setAplikacija(aplikacija);
		  this.setPage(page);
		  setLayout(grid);
	  }

	public Aplikacija getAplikacija() {
		return aplikacija;
	}

	public void setAplikacija(Aplikacija aplikacija) {
		this.aplikacija = aplikacija;
	}

	public PageForAdministrator getPage() {
		return page;
	}

	public void setPage(PageForAdministrator page) {
		this.page = page;
	}
	  
	  
}
