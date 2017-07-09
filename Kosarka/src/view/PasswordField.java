package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class PasswordField extends JPasswordField implements FocusListener {

private final Color focusColor = new Color(100, 250, 150);
	
	public PasswordField(int columns) {
		super(columns);
		
		setEchoChar('*');
		
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
