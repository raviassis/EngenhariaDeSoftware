
public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10, 11, 12}
		};
		int l1 = 2, l2 = 2, c1 = 1, c2= 2;
		
		System.out.println("Ex10");
		System.out.println("Matriz: ");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print("["+mat[i][j]+"]");
			}
			System.out.println("");
		}
		
		mat = ArrayMethods.subMatriz(mat, l1, l2, c1, c2);
		
		System.out.println("SubMatriz: ");
		if (mat != null) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					System.out.print("["+mat[i][j]+"]");
				}
				System.out.println("");
			}
		}
		else System.out.println("nulo");
		
		
	}

}
