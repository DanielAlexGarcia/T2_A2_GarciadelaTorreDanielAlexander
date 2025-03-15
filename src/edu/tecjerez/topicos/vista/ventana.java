package edu.tecjerez.topicos.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.tecjerez.topicos.figuras.*;
import edu.tecjerez.topicos.figuras.tresDimensiones.*;
import edu.tecjerez.topicos.figuras.dosDimensiones.*;

class VentanaInicio extends JFrame implements ActionListener{
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	String[] opTiFig = {
		"3D","2D"	
	};
	String[] opFig2d = {
			"Rombo", "Circulo", "Elipce"
	};
	String[] opFig3d = {
		"piramide", "Cono"	
	};
	
	JComboBox<String> opTipoFig, opFig, opCalcular;
	JTextField PTXT1, PTXT2, PTXT3, result;
	JButton calcular, llenarCampos, Dudas;
	JLabel Pl1, Pl2, Pl3;
	
	double dato1, dato2, dato3;
	
	byte tipoFig = 0;
	String figura = "", calcula = "";
	boolean redy = false;
	
	protected VentanaInicio() {
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Figuras");
		setSize(400,400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel l1 = new JLabel("Selecciona dimension \nde la figura");
		agregarComponente(l1, 0, 0, 1, 1);
				
		opTipoFig = new JComboBox<String>();
		opTipoFig.addItem("ninguno");
		for (int i= 0; i< opTiFig.length; i++) {
			opTipoFig.addItem(opTiFig[i]);
		}
		agregarComponente(opTipoFig, 1, 0, 1, 1);
		opTipoFig.addActionListener(this);
		
		
		JLabel l2 = new JLabel("Selecciona la figura a calcular");
		agregarComponente(l2, 0, 1, 1, 1);
		
		opFig = new JComboBox<String>();
		opFig.addItem("ninguna");
		agregarComponente(opFig, 1, 1, 1, 1);
		opFig.addActionListener(this);
		
		JLabel l3 = new JLabel("¿Que quieres calcular?");
		agregarComponente(l3, 0, 2, 1, 1);
		
		opCalcular = new JComboBox<String>();
		opCalcular.addItem("ninguna");
		agregarComponente(opCalcular, 1, 2, 1, 1);
		opCalcular.addActionListener(this);
		
		
		JPanel muestra = new JPanel();
			muestra.setLayout(gbl);
			
			Pl1 = new JLabel("Base");
			agregarComponente(muestra, Pl1, 0, 0, 1, 1);
			
			PTXT1 = new JTextField(5);
			PTXT1.setEditable(false);
			agregarComponente(muestra, PTXT1, 1, 0, 1, 1);
			
			Pl2 = new JLabel("ALtura");
			agregarComponente(muestra, Pl2, 0, 1, 1, 1);
			
			PTXT2 = new JTextField(5);
			PTXT2.setEditable(false);
			agregarComponente(muestra, PTXT2, 1, 1, 1, 1);
			
			Pl3 = new JLabel("Diametro");
			agregarComponente(muestra, Pl3, 0, 2, 1, 1);
			
			PTXT3 = new JTextField(5);
			PTXT3.setEditable(false);
			agregarComponente(muestra, PTXT3, 1, 2, 1, 1);
		
		
		agregarComponente(muestra, 0, 3, 2, 1);
		
		
		JLabel l4 = new JLabel("Resultado");
		agregarComponente(l4, 0, 4, 1, 1);
		
		result = new JTextField(10);
		result.setEditable(false);
		agregarComponente(result, 1, 4, 1, 1);
		
		llenarCampos = new JButton("Llenar campos");
		llenarCampos.addActionListener(this);
		agregarComponente(llenarCampos, 0, 5, 2, 1);
		
		
		calcular = new JButton("Calcular");
		calcular.addActionListener(this);
		calcular.setEnabled(false);
		agregarComponente(calcular, 0, 6, 2, 1);
		
		Dudas = new JButton("¿Tienes alguna duda?");
		Dudas.addActionListener(this);
		agregarComponente(Dudas, 0, 7, 2, 1);
		
		
		
		
		
	}
	private boolean sonNums() {
		try {
			dato1 = Double.parseDouble(PTXT1.getText());
			dato2 = Double.parseDouble(PTXT2.getText());
			dato3 = Double.parseDouble(PTXT3.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private void cambiarLabels (String var1, String var2, String var3) {
		Pl1.setText(var1);
		Pl2.setText(var2);
		Pl3.setText(var3);
	}
	
	private void trueFalseTextFiend(boolean txt1, boolean txt2, boolean txt3) {
		PTXT1.setEditable(txt1);
		PTXT2.setEditable(txt2);
		PTXT3.setEditable(txt3);
	}
	
	private void agregarComponente(JComponent componente, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(componente, gbc);
		add(componente);
	}
	private void agregarComponente(JPanel panel, JComponent componente, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(componente, gbc);
		panel.add(componente, gbc);
	}
	private void restablecer() {
		trueFalseTextFiend(false, false, false);
		calcular.setEnabled(false);
		PTXT1.setText("");
		PTXT2.setText("");
		PTXT3.setText("");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == calcular) {
			
			boolean nums = sonNums();
			if (!nums) {
				JFrame jFrame = new JFrame();
    			JOptionPane.showMessageDialog(jFrame, "1 o mas campos esta vacio o no es un numero");
			}
			else if(opFig.getSelectedItem().equals("piramide")) {
				piramide p = new tresDimensiones(). new piramide();
				p.setVarsPiramide(dato1, dato2, dato3);
				
				if(opCalcular.getSelectedItem().equals("Area")) {
					result.setText(String.valueOf(p.calcularAreaTotal()));
				}
				else if(opCalcular.getSelectedItem().equals("volumen")) {
					result.setText(String.valueOf(p.calcularVolumen()));
				}
			}
			else if (opFig.getSelectedItem().equals("Cono")) {
				Cono p = new tresDimensiones(). new Cono();
				p.setVarsCono(dato1, dato2);
				
				if (opCalcular.getSelectedItem().equals("Area")) {
					result.setText(String.valueOf(p.calcularAreaTotal()));
				}
				else if (opCalcular.getSelectedItem().equals("volumen")) {
					result.setText(String.valueOf(p.calcularVolumen()));
				}
			}
			else if(opFig.getSelectedItem().equals("Rombo")) {
				Rombo n = new dosDimensiones().new Rombo();
				n.setvarsRombo(dato1, dato2, dato3);
				if (opCalcular.getSelectedItem().equals("Area")) {
					result.setText(String.valueOf(n.calcularArea()));
				}
				else if (opCalcular.getSelectedItem().equals("perimetro")) {
					result.setText(String.valueOf(n.calcularPerimetro()));
				}
				
			}
			else if (opFig.getSelectedItem().equals("Circulo")) {
				Circulo n = new dosDimensiones().new Circulo();
				n.setRadio(dato1);
				
				if (opCalcular.getSelectedItem().equals("Area")) {
					result.setText(String.valueOf(n.calcularArea()));
				}
				else if(opCalcular.getSelectedItem().equals("perimetro")) {
					result.setText(String.valueOf(n.calcularPerimetro()));
				}
				
			}
			else if (opFig.getSelectedItem().equals("Elipce")) {
				Elipce n = new dosDimensiones().new Elipce();
				n.setVarsElipce(dato1, dato2);
				
				if(opCalcular.getSelectedItem().equals("Area")) {
					result.setText(String.valueOf(n.calcularArea()));
				}
				else if (opCalcular.getSelectedItem().equals("perimetro")) {
					result.setText(String.valueOf(n.calcularPerimetro()));
				}
			}
			
			
			restablecer();
			
		}
		
		else if (e.getSource() == opTipoFig) {
			if (opTipoFig.getSelectedItem().equals("3D")) {
				tipoFig = 3;
				opFig.removeAllItems();
				opCalcular.removeAllItems();
				opCalcular.addItem("ninguna");
				opCalcular.addItem("Area");
				opFig.addItem("ninguna");
				for (int i = 0; i< opFig3d.length; i++) {
					opFig.addItem(opFig3d[i]);
				}
				opCalcular.addItem("volumen");
			}
			else if (opTipoFig.getSelectedItem().equals("2D")) {
				tipoFig = 2;
				opFig.removeAllItems();
				opCalcular.removeAllItems();
				opCalcular.addItem("ninguna");
				opCalcular.addItem("Area");
				opFig.addItem("ninguna");
				for (int i = 0; i< opFig2d.length; i++) {
					opFig.addItem(opFig2d[i]);
				}
				opCalcular.addItem("perimetro");
			}
			else {
				tipoFig = 0;
				opFig.removeAllItems();
				opFig.addItem("ninguna");
				opCalcular.removeAllItems();
				opCalcular.addItem("ninguna");
			}
		}
		else if (e.getSource() == opFig) {
			figura = (String) opFig.getSelectedItem();
		}
		else if (e.getSource() == opCalcular) {
			calcula = (String) opCalcular.getSelectedItem();
			System.out.println(calcula);
		}
		else if (e.getSource() == llenarCampos) {
				//	 	Dimension de la figura			
				if(opTipoFig.getSelectedItem().equals("ninguno")) {
					JFrame jFrame = new JFrame();
	    			JOptionPane.showMessageDialog(jFrame, "Selecciona en que dimension esta la figura");
				}
				
				// 		Seleccion de la figura
				else if(opFig.getSelectedItem().equals("ninguna")) {
					JFrame jFrame = new JFrame();
	    			JOptionPane.showMessageDialog(jFrame, "no hay ninguna figura seleccionada");
				}
				
				// 		Lo que se va a calcular
				else if(opCalcular.getSelectedItem().equals("ninguna")) {
					JFrame jFrame = new JFrame();
	    			JOptionPane.showMessageDialog(jFrame, "Selecciona lo que quieres calcular de la figura");
				}
				else {
					calcular.setEnabled(true);
					if(opFig.getSelectedItem().equals("piramide")){
						cambiarLabels("Base", "Altura", "Apotema");
						trueFalseTextFiend(true, true, true);
					}
					else if (opFig.getSelectedItem().equals("Cono")) {
						cambiarLabels("Radio", "Altura", "No aplica");
						trueFalseTextFiend(true, true, false);
						PTXT3.setText("0");
					}
					else if (opFig.getSelectedItem().equals("Circulo")) {
						cambiarLabels("Radio", "No aplica", "No aplica");
						trueFalseTextFiend(true, false, false);
						PTXT2.setText("0");
						PTXT3.setText("0");
					}
					else if (opFig.getSelectedItem().equals("Elipce")) {
						cambiarLabels("Semi eje mayor", "Semi eje menor", "No aplica");
						trueFalseTextFiend(true, true, false);
						PTXT3.setText("0");
					}
					else if (opFig.getSelectedItem().equals("Rombo")) {
						if (opCalcular.getSelectedItem().equals("Area")){
							cambiarLabels("Diagonal menor", "Diagonal mayor", "No aplica");
							trueFalseTextFiend(true, true, false);
							PTXT3.setText("0");
						}
						else if (opCalcular.getSelectedItem().equals("perimetro")) {
							cambiarLabels("Lado", "No aplica", "No aplica");
							trueFalseTextFiend(true, false, false);
							PTXT3.setText("0");
						}
						
					}
				}
		}
		else if (e.getSource() == Dudas) {
			NuevaVentana dudasVentana = new NuevaVentana();
			dudasVentana.setVisible(true);
		}
	}
}

class NuevaVentana extends JFrame implements ActionListener{
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	JMenuItem rombo, circulo, elipce, piramide, cono;
	JInternalFrame Rombo, Circulo, Elipce, Piramide, Cono;
	
    public NuevaVentana() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Dudas");
		setSize(800,800);
		setLocationRelativeTo(null);
		
		
		
		JMenuBar menu = new JMenuBar();
			JMenu fig2D = new JMenu("Figuras en 2D");
				rombo = new JMenuItem("Rombo");
				rombo.addActionListener(this);
			fig2D.add(rombo);
			
				circulo = new JMenuItem("Circulo");
				circulo.addActionListener(this);
			fig2D.add(circulo);
			
				elipce = new JMenuItem("Elipce");
				elipce.addActionListener(this);
			fig2D.add(elipce);
			
		menu.add(fig2D);
			JMenu fig3D = new JMenu("Figuras en 3D");
				piramide = new JMenuItem("Piramide");
				piramide.addActionListener(this);
			fig3D.add(piramide);
			
				cono = new JMenuItem("Cono");
				cono.addActionListener(this);
			fig3D.add(cono);
		
		menu.add(fig3D);
		setJMenuBar(menu);
		
		JDesktopPane panel = new JDesktopPane();
			Rombo = new JInternalFrame();
			Rombo.setSize(500, 600);
			Rombo.setClosable(true);
			Rombo.setMaximizable(true);
			Rombo.setIconifiable(true);
			Rombo.setResizable(true);
			Rombo.setDefaultCloseOperation(HIDE_ON_CLOSE);
			Rombo.setLayout(gbl);
				ImageIcon imgRombo = new ImageIcon("imagenes/rombo.png");
				Image img = imgRombo.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
				ImageIcon imgRo = new ImageIcon(img);
				JLabel romboAreaPeri = new JLabel(imgRo);
				agregarComponente(Rombo, romboAreaPeri, 0, 0, 1, 1);
				
				JLabel l1 = new JLabel("Diagonal mayor es la 'D'");
				agregarComponente(Rombo, l1, 0, 1, 1, 1);
				
				JLabel l2 = new JLabel("Mientras 'd' es la diagonal menor");
				agregarComponente(Rombo, l2, 0, 2, 1, 1);
				
				JLabel l3 = new JLabel("'L' es el valor de uno de los lados");
				agregarComponente(Rombo, l3, 0, 3, 1, 1);
				
				JLabel l4 = new JLabel("(Este dato se necesitara para calcular el perimetro)");
				agregarComponente(Rombo, l4, 0, 4, 1, 1);
				
			panel.add(Rombo);
			
			Circulo = new JInternalFrame();
			Circulo.setSize(500, 600);
			Circulo.setClosable(true);
			Circulo.setMaximizable(true);
			Circulo.setIconifiable(true);
			Circulo.setResizable(true);
			Circulo.setDefaultCloseOperation(HIDE_ON_CLOSE);
			Circulo.setLayout(gbl);
				ImageIcon imgCirculo = new ImageIcon("imagenes/circulo.png");
				Image img1 = imgCirculo.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
				ImageIcon imgCi = new ImageIcon(img1);
				JLabel circuloAreaPeri = new JLabel(imgCi);
				agregarComponente(Circulo, circuloAreaPeri, 0, 0, 1, 1);
				
				JLabel Cl1 = new JLabel("Para sacar area y perimetro no se necesita");
				agregarComponente(Circulo, Cl1, 0, 1, 1, 1);
				
				JLabel Cl2 = new JLabel("mas que el radio del circulo");
				agregarComponente(Circulo, Cl2, 0, 2, 1, 1);
				
			panel.add(Circulo);
			
			Elipce = new JInternalFrame();
			Elipce.setSize(500, 600);
			Elipce.setClosable(true);
			Elipce.setMaximizable(true);
			Elipce.setIconifiable(true);
			Elipce.setResizable(true);
			Elipce.setDefaultCloseOperation(HIDE_ON_CLOSE);
			Elipce.setLayout(gbl);
				ImageIcon imgElipce = new ImageIcon("imagenes/elipce.png");
				Image img2 = imgElipce.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
				ImageIcon imgEl = new ImageIcon(img2);
				JLabel elipceAreaPeri = new JLabel(imgEl);
				agregarComponente(Elipce, elipceAreaPeri, 0, 0, 1, 1);
				
				JLabel El1 = new JLabel("Para sacar area y perimetro no se necesita");
				agregarComponente(Elipce, El1, 0, 1, 1, 1);
				
				JLabel El2 = new JLabel("mas que el semi eje mayor y semi eje menor");
				agregarComponente(Elipce, El2, 0, 2, 1, 1);
			
			panel.add(Elipce);
			
			Piramide = new JInternalFrame();
			Piramide.setSize(600, 700);
			Piramide.setClosable(true);
			Piramide.setMaximizable(true);
			Piramide.setIconifiable(true);
			Piramide.setResizable(true);
			Piramide.setDefaultCloseOperation(HIDE_ON_CLOSE);
			Piramide.setLayout(gbl);
				ImageIcon imgPiramide = new ImageIcon("imagenes/piramide.png");
				Image img3 = imgPiramide.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
				ImageIcon imgPi = new ImageIcon(img3);
				JLabel piramideAreaPeri = new JLabel(imgPi);
				agregarComponente(Piramide, piramideAreaPeri, 0, 0, 1, 1);
				
				JLabel Pl1 = new JLabel("Para sacar el area se necesita el valor de la base, el cual se saca con el valor de uno de los lados 'L'");
				agregarComponente(Piramide, Pl1, 0, 1, 1, 1);
				
				JLabel Pl2 = new JLabel("lo cual es lo que se pide en el campo de base.");
				agregarComponente(Piramide, Pl2, 0, 2, 1, 1);
				
				JLabel Pl3 = new JLabel("'h' es la altura la cual va desde la base hasta el punto mas alto de la piramide");
				agregarComponente(Piramide, Pl3, 0, 3, 1, 1);
				
				JLabel Pl4 = new JLabel("El apotema es la distancia entre la punta de la piramide y la base de uno de los triangulos de la piramide");
				agregarComponente(Piramide, Pl4, 0, 4, 1, 1);
				
				JLabel Pl5 = new JLabel("(La imagen es solo representativa, las formulas solo son aplicables para piramides con base cuadrada)");
				agregarComponente(Piramide, Pl5, 0, 5, 1, 1);
			
			panel.add(Piramide);
			
			Cono = new JInternalFrame();
			Cono.setSize(500, 600);
			Cono.setClosable(true);
			Cono.setMaximizable(true);
			Cono.setIconifiable(true);
			Cono.setResizable(true);
			Cono.setDefaultCloseOperation(HIDE_ON_CLOSE);
			Cono.setLayout(gbl);
			ImageIcon imgCono = new ImageIcon("imagenes/cono.png");
			Image img4 = imgCono.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
			ImageIcon imgCo = new ImageIcon(img4);
			JLabel conoAreaPeri = new JLabel(imgCo);
			agregarComponente(Cono, conoAreaPeri, 0, 0, 1, 1);
			
			JLabel Col1 = new JLabel("'r' Es el radio del circulo base, mientras que");
			agregarComponente(Cono, Col1, 0, 1, 1, 1);
			
			JLabel Col2 = new JLabel("'h' Es la altura del cono");
			agregarComponente(Cono, Col2, 0, 2, 1, 1);
			
			panel.add(Cono);
			
		add(panel, BorderLayout.CENTER);
		
		
		
		
    }
    private void agregarComponente(JInternalFrame frame, JComponent componente, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(componente, gbc);
		frame.add(componente, gbc);
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == rombo) {
			Rombo.setVisible(true);
		}
		else if (e.getSource() == circulo) {
			Circulo.setVisible(true);
		}
		else if (e.getSource() == elipce) {
			Elipce.setVisible(true);
		}
		else if (e.getSource() == piramide) {
			Piramide.setVisible(true);
		}
		else if (e.getSource() == cono) {
			Cono.setVisible(true);
		}
		
		// TODO Auto-generated method stub
		
	}
	
	
}

public class ventana {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaInicio();
				
			}
		});
	}
}

/*
public class Main {
    public static void main(String[] args) {
        Circulo c = new Circulo(5);
        System.out.println(c);
        System.out.println("Área: " + c.calcularArea());
        System.out.println("Perímetro: " + c.calcularPerimetro());

        Rombo r = new Rombo(8, 6, 5);
        System.out.println("\n" + r);
        System.out.println("Área: " + r.calcularArea());
        System.out.println("Perímetro: " + r.calcularPerimetro());

        Elipse e = new Elipse(7, 5);
        System.out.println("\n" + e);
        System.out.println("Área: " + e.calcularArea());
        System.out.println("Perímetro (aproximado): " + e.calcularPerimetro());

        Piramide p = new Piramide(4, 6, 5);
        System.out.println("\n" + p);
        System.out.println("Volumen: " + p.calcularVolumen());
        System.out.println("Área Total: " + p.calcularAreaTotal());

        Cono cono = new Cono(3, 5);
        System.out.println("\n" + cono);
        System.out.println("Volumen: " + cono.calcularVolumen());
        System.out.println("Área Total: " + cono.calcularAreaTotal());
    }
*/
