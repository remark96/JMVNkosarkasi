package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TextField extends JTextField implements FocusListener {
	
	private final Color focusColor = new Color(100, 250, 150);
	
	public TextField(int columns) {
		super(columns);
		
		addFocusListener(this);
		//setFocusable(false);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		setBackground(focusColor);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		setBackground(Color.WHITE);
	}

}
