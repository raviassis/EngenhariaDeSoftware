
public class Matriz {
	
	private double [][] matriz;
	
	public Matriz(double [][] m) {
		this.matriz = m;
	}
	
	public Matriz() {
		
	}
	
	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}
	
	public static Matriz mais(Matriz a, Matriz b) {	
		double [][] m1 = a.getMatriz();
		double [][] m2 = b.getMatriz();
		double [][] m3;
		
		if (m1.length == m2.length && m1[0].length == m2[0].length) {
			m3 = new double[m1.length][m1[0].length];
			for (int l = 0; l < m3.length; l++) 
				for (int c = 0; c < m3[0].length; c++) {
					m3[l][c] = m1[l][c] + m2[l][c];
				}
				
			return new Matriz(m3);
		}
		else return null;		
	}

	public static Matriz menos(Matriz a, Matriz b) {
		double [][] m1 = a.getMatriz();
		double [][] m2 = b.getMatriz();
		double [][] m3;
		
		if (m1.length == m2.length && m1[0].length == m2[0].length) {
			m3 = new double[m1.length][m1[0].length];
			for (int l = 0; l < m3.length; l++) 
				for (int c = 0; c < m3[0].length; c++) {
					m3[l][c] = m1[l][c] - m2[l][c];
				}
				
			return new Matriz(m3);
		}
		else return null;	
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		for (int l = 0; l < this.matriz.length; l++) {
			for (int c= 0; c < this.matriz[0].length; c++) {
				str.append("[" + this.matriz[l][c] + "]");
			}
			str.append("\n");
		}
		return str.toString();
	}
	
	
}
