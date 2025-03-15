package edu.tecjerez.topicos.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class WidgetsParaCalcular extends JFrame implements ActionListener{
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	protected double result;
	
	JTextField base, altura, apotema;
	
	protected void piramide3DArea() {
		JLabel l1 = new JLabel("Base");
		agregarComponente(l1, 0, 0, 1, 1);
		
		base = new JTextField(5);
		agregarComponente(base, 1, 0, 1, 1);
		
		JLabel l2 = new JLabel("Altura");
		agregarComponente(l2, 0, 1, 1, 1);
		
		altura = new JTextField(5);
		agregarComponente(altura, 1, 1, 1, 1);
		
		JLabel l3 = new JLabel("Apotema");
		agregarComponente(l3, 0, 2, 1, 1);
		
		apotema = new JTextField(5);
		agregarComponente(apotema, 1, 2, 1, 1);
		
		
		
	}
	
	public void agregarComponente(JComponent componente, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(componente, gbc);
		add(componente);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
