package model;

import java.util.ArrayList;

public class StatistikaTrenera {
	private Trener trener;
	private ArrayList<String> timeouts;
	private int tehnickeGreske;
	private boolean izbacen;
	
	public StatistikaTrenera(Trener trener) {
		this.trener = trener;
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
	
	public boolean getIzbacen() { return izbacen; }
	public void setIzbacen(boolean izbacen) { this.izbacen = izbacen; }

	public Trener getTrener() { return trener; }
	public void setTrener(Trener trener) { this.trener = trener; }
	
}
