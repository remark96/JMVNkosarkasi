package view;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GraphicalElement {
	
	private BufferedImage bufferdImage;
	private String title;
	private int x = 0;
	private int y = 0;
	private int width;
	private int height;
	
	private TypeOfGraphicalElement type;
	private boolean domaci;
	
	private DataPanel dataPanel = null;
	
	public GraphicalElement(String str, int width, int height, TypeOfGraphicalElement type, boolean domaci) {
		try {
			this.bufferdImage = ImageIO.read(new File(str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] tokens = str.split("\\\\")[1].split("_");

		if (tokens.length == 1) this.title = tokens[0].split("\\.")[0].toUpperCase();
		else if (tokens.length >= 2) this.title =  tokens[0].toUpperCase() + " " + tokens[1].split("\\.")[0].toUpperCase();
		
		this.width = width;
		this.height = height;
		this.type = type;
		this.domaci = domaci;
	}
	
	public BufferedImage getBufferdImage() { return bufferdImage; }
	public void setBufferdImage(BufferedImage bufferdImage) { this.bufferdImage = bufferdImage; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public int getX() { return x; }
	public void setX(int x) { this.x = x; }

	public int getY() { return y; }
	public void setY(int y) { this.y = y; }

	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }

	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	
	public TypeOfGraphicalElement getType() { return type; }
	public void setType(TypeOfGraphicalElement type) { this.type = type; }
	
	public boolean getDomaci() { return domaci; }
	public void setDomaci(boolean domaci) { this.domaci = domaci; }
	
	public DataPanel getDataPanel() {
		if (dataPanel == null) {
			dataPanel = new DataPanel();
		}
		
		return dataPanel;
	}
	public void setDataPanel(DataPanel dataPanel) { this.dataPanel = dataPanel; }

	public boolean contains(Point point) { return point.getX() >= x && point.getX() <= x + width && point.getY() >= y && point.getY() <= y + height; }

	public boolean equals(GraphicalElement ge) { return title.equals(ge.title); }
	
}
