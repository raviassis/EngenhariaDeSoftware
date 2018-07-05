import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		double valor, rendimento, taxa = 1.13;
		System.out.println("Calcula investimento");
		System.out.println("Taxa de rendimento: 1,13% ao mês.");
		System.out.print("Informe o valor aplicado: ");
		
		valor = ent.nextDouble();
		rendimento = valor * ( taxa/100.0 );
		
		System.out.println("Rendimento = " + rendimento);
		
		ent.close();

	}

}
