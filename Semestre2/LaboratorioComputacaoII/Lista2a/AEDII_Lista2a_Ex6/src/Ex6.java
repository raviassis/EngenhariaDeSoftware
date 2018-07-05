import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		double raio, area;
		
		System.out.println("Calcula o Area de uma circunferência");
		System.out.print("Informe o raio: ");
		raio = ent.nextDouble();
		
		area =  Math.PI * Math.pow(raio, 2.0);
		
		System.out.println("Area = " + area);
		
		ent.close();

	}

}
