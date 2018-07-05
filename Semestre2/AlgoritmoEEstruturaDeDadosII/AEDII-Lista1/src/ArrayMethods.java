
public class ArrayMethods {
	
	public static int sum(int[] vet) {
		int soma = 0;
		for (int i = 0; i < vet.length; i++) soma += vet[i];
		return soma;
	}
	
	public static int lessElement(int[] vet) {
		// TODO Auto-generated method stub
		int menor = vet[0];
		for (int i = 0; i < vet.length; i++) menor = ( menor > vet[i] ) ? vet[i] : menor ;
		return menor;
	}
	
	public static int indexOf(int[] vet, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < vet.length; i++) {
			if (n == vet[i]) return i;
		}
		return -1;
	}

	public static int lastIndexOf(int[] vet, int n) {
		// TODO Auto-generated method stub
		for (int i = vet.length -1; i >= 0; i--) {
			if (n == vet[i]) return i;
		}
		return -1;
	}

	public static int countElements(int[] vet, int n) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < vet.length; i++) {
			if(n == vet[i]) count++;
		}
		return count;
	}

	public static int[] mainDiagonal(int[][] mat) {
		// TODO Auto-generated method stub
		int vetDiagonal[] = new int[mat.length];
		for (int i = 0; i < mat.length; i++) {
			if (mat.length != mat[i].length) return vetDiagonal;;
		}			
		
		for (int i = 0; i < mat.length; i++) vetDiagonal[i] = mat[i][i];
		return vetDiagonal;
				
	}

	public static int[] alingArray(int[][] mat) {
		// TODO Auto-generated method stub
		int tam = 0;
		int aux = 0;
		for (int i = 0; i < mat.length; i++) {
			tam += mat[i].length;
		}
		int vet[] = new int[tam];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				vet[aux] = mat[i][j];
				aux++;
			}
		}
		
		return vet;		
	}

	public static int[] invertArray(int[] vet) {
		// TODO Auto-generated method stub
		int tam = vet.length;
		int vetInvert[] = new int[tam];
		for (int i = 0, j = tam-1; i < vet.length; i++, j--) {
			vetInvert[i] = vet[j];
		}
		return vetInvert;
	}

	public static int[] arrayPart(int[] vet, int esq, int dir) {
		// TODO Auto-generated method stub
		
		
		if (esq > dir || esq < 0 || esq >= vet.length || dir < 0 || dir >= vet.length) return null ;
		else {
			int partVet[] = new int[dir - esq +1];
			for (int i = 0; i < partVet.length; i++ ) {
				partVet[i] = vet[esq+i];
			}			
			
			return partVet;
		}
	}

	public static int[][] subMatriz(int[][] mat, int l1, int l2, int c1, int c2) {
		// TODO Auto-generated method stub
		int subMatriz[][];
		if (l1 > l2 || l1 < 0 || l2 < 0 || l1 >= mat.length || l2 >= mat.length ) 
			return null; 
		else {
			for (int i = 0; i < mat.length; i++) {
				if ( arrayPart(mat[i], c1, c2) == null) return null;
			}
			subMatriz = new int[l2 - l1 + 1][c2 - c1 + 1];
			for (int i = 0; i < subMatriz.length; i++) {
				subMatriz[i] = arrayPart(mat[i + l1], c1, c2);
			}
			
			return subMatriz;
		}
	}

	public static int[][] subMatriz(int[][][] mat3d, int f, int l1, int l2, int c1, int c2) {
		// TODO Auto-generated method stub
		if (f < 0 || f >= mat3d.length) {
			return null;
		}
		else return subMatriz(mat3d[f], l1, l2, c1, c2);
	}

	public static int[] fillArray(int n, int op) {
		// TODO Auto-generated method stub
		int vet[] = new int[n];
		if (op == 0) {
			for (int i = 0; i < vet.length; i++) {
				vet[i] = i;
			}
			return vet;
		}
		else if (op == 1) {
			int num = n-1;
			for (int i = 0; i < vet.length; i++, num--) {
				vet[i] = num;
			}
			return vet;
		}
		else if (op == 2) {
			for (int i = 0; i < vet.length; i++) {
				vet[i] = (int)( Math.random() * 10 );
			}
			return vet;
		}
		else return null;
	}
}
