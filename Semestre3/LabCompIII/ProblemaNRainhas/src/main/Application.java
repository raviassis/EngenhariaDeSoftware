package main;

public class Application {

	static String [][] tab;
	static int [] linRainhas;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nR = 8;
		tab = factoryTabuleiro(nR);
		linRainhas = factoryVetorAux(nR);
		int contR = 0;	
		
		for(int k = 0; k < nR ; k++) {
			for (int i = 0; i < nR; i++) {
				
				if(podeColocar(k,i)) {
					tab[k][i] = " x ";
					
				}
			}
		}
		
		show(tab);
		
	}

	private static void show(String[][] tab2) {
		// TODO Auto-generated method stub
		for (int l = 0; l < tab.length; l++) {
			for (int c = 0; c < tab[l].length; c++) {
				System.out.print(tab[l][c]);
			}
			System.out.println();
		}
	}

	private static int[] factoryVetorAux(int nR) {
		// TODO Auto-generated method stub
		int [] v = new int[nR];
		
		for (int i = 0; i < v.length; i++) {
			v[i] = -1;
		}
		return v;
	}

	private static boolean podeColocar(int k, int i) {
		// TODO Auto-generated method stub		
		return linhaLivre(k) && colunaLivre(i) && diagonalLivre(k, i);
	}

	private static boolean diagonalLivre(int k, int i) {
		// TODO Auto-generated method stub
		int l = k;
		int c = i;
		boolean p = true;
		
		while (l >= 0 && c >= 0) {
			if (" x ".equals(tab[l][c]) ) p = false;
			l--;
			c--;
		}
		
		l = k;
		c = i;
		
		if (p) {
			while (l >= 0 && c < tab[l].length) {
				if (" x ".equals(tab[l][c]) ) p = false;
				l--;
				c++;
			}
		}
		
		return p;
	}

	private static boolean colunaLivre(int c) {
		// TODO Auto-generated method stub
		
		boolean p = true;
		for (int a = 0; a < tab.length; a++) {
			if(" x ".equals(tab[a][c])) p = false;
		}
		
		return p;
	}

	private static boolean linhaLivre(int k) {
		// TODO Auto-generated method stub
		String [] lin = tab[k];
		boolean p = true;
		for (int a = 0; a < lin.length; a++) {
			if(" x ".equals(lin[a])) p = false;
		}
		
		return p;
	}

	private static void colocaRainha(String[][] tab, int[] linRainhas) {
		// TODO Auto-generated method stub
		
	}

	private static String[][] factoryTabuleiro(int n) {
		// TODO Auto-generated method stub
		String [][] t = new String[n][n];
		
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				t[i][j] = " - ";
			}
		}
		return t;
	}
	
	

}
