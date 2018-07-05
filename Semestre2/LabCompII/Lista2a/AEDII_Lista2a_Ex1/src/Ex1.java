import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		int lado, area;
		
		System.out.println("Calcula Area Quadrado");
		System.out.print("Informe o lado do quadrado: ");
		lado = ent.nextInt();
		
		area = lado * lado;
		
		System.out.println("Area do quadrado= " + area);
		ent.close();

	}

}
