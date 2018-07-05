
public class Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceMatriz mf = new MatrizAdapter();
		double [][] m1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
		double [][] m2 = {
				{9,8,7},
				{6,5,4},
				{3,2,1}
		};
		System.out.println(mf.somar(new Matriz(m1), new Matriz(m2)));
		System.out.println(mf.subtrair(new Matriz(m1), new Matriz(m2)));
	}

}
