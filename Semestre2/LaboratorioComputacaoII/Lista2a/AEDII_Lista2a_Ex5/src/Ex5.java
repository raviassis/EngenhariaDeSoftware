import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		double raio, comprimento;
		
		System.out.println("Calcula o comprimento de uma circunferência");
		System.out.println("Informe o raio: ");
		raio = ent.nextDouble();
		
		comprimento = 2 * Math.PI * raio;
		
		System.out.println("Comprimento = " + comprimento);
		
		ent.close();

	}

}
