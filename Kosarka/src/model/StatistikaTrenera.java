package model;

import java.util.ArrayList;

public class StatistikaTrenera {
	private ArrayList<String> timeouts;
	private int tehnickeGreske;
	private boolean izbacen;
	
	public StatistikaTrenera() {
		this.timeouts = new ArrayList<String>();
		this.tehnickeGreske = 0;
		this.izbacen = false;
	}
	
	public StatistikaTrenera(/*ArrayList<String> timeouts,*/int tehnickeGreske, boolean izbacen) {
		/*this.timeouts = timeouts;*/
		this.tehnickeGreske = tehnickeGreske;
		this.izbacen = izbacen;
	}
	
	public ArrayList<String> getTimeouts() { return timeouts; }
	public void setTimeouts(ArrayList<String> timeouts) { this.timeouts = timeouts; }

	public int getTehnickeGreske() { return tehnickeGreske; }
	public void setTehnickeGreske(int tehnickeGreske) { this.tehnickeGreske = tehnickeGreske; }
	
	public boolean isIzbacen() { return izbacen; }
	public void setIzbacen(boolean izbacen) { this.izbacen = izbacen; }
	
}
