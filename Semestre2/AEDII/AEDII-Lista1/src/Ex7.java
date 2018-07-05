
public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10, 11, 12}
		};
		
		int vetDiagonal[] = ArrayMethods.alingArray(mat);
		
		System.out.println("Ex7");
		System.out.println("Matriz: ");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print("["+mat[i][j]+"]");
			}
			System.out.println("");
		}
		
		System.out.print("Matriz linearizada: ");
		for (int i = 0; i < vetDiagonal.length; i++) {
			System.out.print("[" + vetDiagonal[i] + "]");
		}
		
	}

}
