package edu.tecjerez.topicos.figuras;

import edu.tecjerez.topicos.geometria.*;




public class dosDimensiones {
	
	public class Rombo implements Figura2D{
		private double diagonalMayor;
	    private double diagonalMenor;
	    private double lado;
	    
		
	    public void setvarsRombo(double diagonalMayor, double diagonalMenor, double lado) {
	        this.diagonalMayor = diagonalMayor;
	        this.diagonalMenor = diagonalMenor;
	        this.lado = lado;
	    }

		@Override
		public double calcularArea() {
			return (diagonalMayor * diagonalMenor) / 2;
		}

		@Override
		public double calcularPerimetro() {
			return 4 * lado;
		}

		
	}

	public class Circulo implements Figura2D{
		private double radio;
		
		public void setRadio(double radio) {
			this.radio = radio;
		}

		@Override
		public double calcularArea() {
			return Math.PI * Math.pow(radio, 2);
		}

		@Override
		public double calcularPerimetro() {
			return 2 * Math.PI * radio;
		}
		
	}
	
	public class Elipce implements Figura2D{
		private double semiEjeMayor;
	    private double semiEjeMenor;
		
	    public void  setVarsElipce(double semiEjeMayor, double semiEjeMenor) {
	        this.semiEjeMayor = semiEjeMayor;
	        this.semiEjeMenor = semiEjeMenor;
	    }
	    
		@Override
		public double calcularArea() {
			// TODO Auto-generated method stub
			return Math.PI * semiEjeMayor * semiEjeMenor;
		}

		@Override
		public double calcularPerimetro() {
			// TODO Auto-generated method stub
			return Math.PI * (3 * (semiEjeMayor + semiEjeMenor) - Math.sqrt((3 * semiEjeMayor + semiEjeMenor) * (semiEjeMayor + 3 * semiEjeMenor)));
		}
		
	}
	
	
}
