import java.util.Scanner;

public class Ex10 {
	public static void main (String [] args) {
		Scanner ent = new Scanner(System.in);
		double valor, rendimento, taxa;
		System.out.println("Calcula investimento");
		System.out.print("Informe a taxa de rendimento: ");
		taxa = ent.nextDouble();
		
		System.out.print("Informe o valor aplicado: ");
		valor = ent.nextDouble();
		
		rendimento = valor * ( taxa/100.0 );
		
		System.out.println("Rendimento = " + rendimento);
		
		ent.close();
	}
}
