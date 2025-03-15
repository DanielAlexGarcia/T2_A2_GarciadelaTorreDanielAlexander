package edu.tecjerez.topicos.figuras;

import edu.tecjerez.topicos.geometria.*;

public class tresDimensiones {
	public class piramide implements Figura3D{
		private double base;
	    private double altura;
	    private double apotema;
	    
	    public void setVarsPiramide(double base, double altura, double apotema) {
	        this.base = base;
	        this.altura = altura;
	        this.apotema = apotema;
	    }
		
	    @Override
	    public double calcularVolumen() {
	        return (Math.pow(base, 2) * altura) / 3;
	    }

	    @Override
	    public double calcularAreaTotal() {
	        double areaBase = Math.pow(base, 2);
	        double areaLateral = (4 * (base * apotema)) / 2;
	        return areaBase + areaLateral;
	    }
		
	}
	
	public class Cono implements Figura3D{
		private double radio;
	    private double altura;
	    
	    public void setVarsCono(double radio, double altura) {
	        this.radio = radio;
	        this.altura = altura;
	    }

	    @Override
	    public double calcularVolumen() {
	        return (1.0 / 3) * Math.PI * Math.pow(radio, 2) * altura;
	    }
	    
	    @Override
	    public double calcularAreaTotal() {
	        double generatriz = Math.sqrt(Math.pow(radio, 2) + Math.pow(altura, 2));
	        return Math.PI * radio * (radio + generatriz);
	    }
		
	}
	
}
