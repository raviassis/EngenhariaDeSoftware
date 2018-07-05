import java.util.Scanner;

public class Ex8 {
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		double x1, y1, x2, y2, dist;
		
		System.out.println("Calcula distancia euclidiana");
		System.out.print("Informe o x1: ");
		x1 = ent.nextDouble();
		System.out.print("Informe o y1: ");
		y1 = ent.nextDouble();
		System.out.print("Informe o x2: ");
		x2 = ent.nextDouble();
		System.out.print("Informe o y2: ");
		y2 = ent.nextDouble();
		
		dist = Math.sqrt( Math.pow(x1-x2, 2.0) + Math.pow(y1-y2, 2.0) );
		
		System.out.println("Distancia = " + dist);
		ent.close();	

	}
}
