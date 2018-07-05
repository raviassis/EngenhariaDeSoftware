import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		int a, b, c;
		double delta;
		System.out.println("Calcula Delta equação 2º");
		System.out.print("Informe o a = ");
		a = ent.nextInt();
		System.out.print("Informe o b = ");
		b = ent.nextInt();
		System.out.print("Informe o c = ");
		c = ent.nextInt();
		
		delta = Math.pow( (double)b, 2.0) - 4 * a * c;
		
		System.out.println("Valor do delta = " + delta);
		ent.close();
	}

}
