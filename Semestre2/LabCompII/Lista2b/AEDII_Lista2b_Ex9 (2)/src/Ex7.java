import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		double cat1, cat2, hipo;
		
		System.out.println("Calcula Hipotenusa");
		System.out.print("Informe o cateto 1: ");
		cat1 = ent.nextDouble();
		System.out.print("Informe o cateto 2: ");
		cat2 = ent.nextDouble();
		
		hipo = Math.sqrt( Math.pow(cat1, 2.0) + Math.pow(cat2, 2.0) );
		
		System.out.println("Hipotenusa = " + hipo);
		ent.close();	

	}

}
