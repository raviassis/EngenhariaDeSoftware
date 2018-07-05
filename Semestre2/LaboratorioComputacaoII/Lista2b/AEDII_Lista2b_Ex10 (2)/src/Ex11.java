import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		double compra, desconto= 0.08, total;
		
		System.out.println("Calcula valor compra a vista");
		System.out.print("Informe o valor da compra: ");
		compra = ent.nextDouble();
		
		total = compra - (compra * desconto);
		
		System.out.println("Valor a pagar: " + total);
		
		ent.close();
	}

}
