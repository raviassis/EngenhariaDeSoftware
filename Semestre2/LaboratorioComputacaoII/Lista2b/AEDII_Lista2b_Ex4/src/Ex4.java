import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		int x, y, z;
		
		System.out.println("Ex4");
		System.out.print("Informe o numero x: ");
		x = ent.nextInt();
		System.out.print("Informe o numero y: ");
		y = ent.nextInt();
		System.out.print("Informe o numero z: ");
		z = ent.nextInt();
		
		if ( x % y == 0 && x % z == 0 ) {
			System.out.println("x � divis�vel por y e por z");
		}
		else if ( x % y == 0) {
			System.out.println("x � divis�vel por y");
		}
		else if ( x % z == 0) {
			System.out.println("x � divis�vel por z");
		}
		else System.out.println("x n�o � divisivel por y nem por z");
		
		ent.close();
		
	}

}
