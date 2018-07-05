import java.util.Scanner;

public class Ex3 {
	
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		int base, altura, perimetro, area;
		
		System.out.println("Calcula Area e Perímetro do Retangulo");
		System.out.print("Informe a base do retangulo: ");
		base = ent.nextInt();
		
		System.out.print("Informe a altura do retangulo: ");
		altura = ent.nextInt();
		
		perimetro = base * 2 + altura * 2;
		
		area = base * altura;
		
		System.out.println("Perímetro do retangulo = " + perimetro);
		System.out.println("Área do retangulo = " + area);
		ent.close();

	}
}
