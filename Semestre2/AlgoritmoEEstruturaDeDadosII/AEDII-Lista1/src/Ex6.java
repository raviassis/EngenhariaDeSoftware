
public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {
				{1,2,3, 4},
				{4,5,6, 7},
				{7,8,9, 10},
				{11, 12, 13}
		};
		
		int vetDiagonal[] = ArrayMethods.mainDiagonal(mat);
		
		System.out.println("Ex6");
		System.out.println("Matriz: ");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print("["+mat[i][j]+"]");
			}
			System.out.println("");
		}
		
		System.out.print("Diagonal principal: ");
		for (int i = 0; i < vetDiagonal.length; i++) {
			System.out.print("[" + vetDiagonal[i] + "]");
		}
	}

}
