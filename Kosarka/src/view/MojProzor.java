package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.OsluskivacNovaUtakmica;
import controler.OsluskivacPrikazIzvestaja;
import controler.OsluskivacRadSaPodacima;

@SuppressWarnings("serial")
public class MojProzor extends JFrame
{
	ProzorZaLogovanje prozorZaLogovanje;
	JLabel pozdravnaPoruka;
	JPanel glavniPanel;
	JButton dugmeNovaUtakmica;
	JButton dugmePrikazIzvestaja;
	JButton dugmeRadSaPodacima;


	public MojProzor()
	{
		super("Kosarka");
		
		inicijalizujProzor();
		kreirajKomponente();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void inicijalizujProzor()
	{
		setSize(800, 450);
		setLayout(new BorderLayout());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void kreirajPozdravnuPoruku()
	{
		pozdravnaPoruka = new JLabel("Dobrodosli!",JLabel.CENTER); 
		pozdravnaPoruka.setFont(new Font("Naziv fonta", Font.PLAIN, 50));
		pozdravnaPoruka.setForeground(Color.BLUE);
	}

	public void kreirajKomponente()
	{
		glavniPanel = new JPanel(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.HORIZONTAL;

		dugmeNovaUtakmica = new JButton("Nova Utakmica");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		//gbc.weighty = 0.5;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		glavniPanel.add(dugmeNovaUtakmica, gbc);
		dugmeNovaUtakmica.addActionListener(new OsluskivacNovaUtakmica(this));
		
		dugmePrikazIzvestaja = new JButton("Prikaz Izvestaja");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.5;
		//gbc.weighty = 0.5;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		glavniPanel.add(dugmePrikazIzvestaja, gbc);
		dugmePrikazIzvestaja.addActionListener(new OsluskivacPrikazIzvestaja(this));

		dugmeRadSaPodacima = new JButton("Rad sa Podacima");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.0;
		//gbc.weighty = 0.5;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		glavniPanel.add(dugmeRadSaPodacima, gbc);
		dugmeRadSaPodacima.addActionListener(new OsluskivacRadSaPodacima(this));

		
		kreirajPozdravnuPoruku();
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		getContentPane().add(pozdravnaPoruka, BorderLayout.NORTH);
	}

	public void pozoviNaslovnuStranu()
	{
		getContentPane().removeAll();
		getContentPane().add(glavniPanel, BorderLayout.CENTER);
		osvezi();
	}

	public void osvezi()
	{
		revalidate();
		repaint();
	}
}
