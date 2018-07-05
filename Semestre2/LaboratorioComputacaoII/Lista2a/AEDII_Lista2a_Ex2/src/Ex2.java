import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		int lado, perimetro;
		
		System.out.println("Calcula Perímetro do Quadrado");
		System.out.print("Informe o lado do quadrado: ");
		lado = ent.nextInt();
		
		perimetro = lado * 4;
		
		System.out.println("Perímetro do quadrado= " + perimetro);
		ent.close();

	}

}
