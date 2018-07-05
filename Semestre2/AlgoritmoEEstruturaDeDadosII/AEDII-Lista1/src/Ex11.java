
public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat3D [][][] = {
				{
					{1,2,3},
					{4,5,6},
					{7,8,9}
				},
				{
					{11,12,13},
					{14,15,16},
					{17,18,19}
				},
				{
					{21,22,23},
					{24,25,26},
					{27,28,29}
				}
		};
		int mat[][];
		int f = 2, l1 = 1, l2 = 2, c1 = 1, c2 = 2;
		
		System.out.println("Ex11: ");
		System.out.println("Matriz 3D: ");
		for (int i = 0; i < mat3D.length; i++) {
			for (int j = 0; j < mat3D[i].length; j++) {
				for (int k = 0; k < mat3D[i][j].length; k++) {
					System.out.print( "[" + mat3D[i][j][k] + "]");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		
		mat = ArrayMethods.subMatriz(mat3D, f, l1, l2, c1, c2);
		
		System.out.println("SubMatriz: ");
		if ( mat != null) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					System.out.print("[" + mat[i][j] + "]");
				}			
				System.out.println("");
			}
		}
		else System.out.println("Nulo");
		
	}

}
