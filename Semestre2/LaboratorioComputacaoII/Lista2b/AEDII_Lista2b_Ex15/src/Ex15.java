import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		double massa;
		double gRelativo[] = { 0.376, 0.903, 0.38, 2.34, 1.16, 1.15, 1.19};
		String nomesPlanetas[] = {
				"Mercúrio",
				"Vênus",
				"Marte",
				"Júpiter",
				"Saturno",
				"Urano",
				"Netuno"
		};
		
		System.out.println("Ex15");
		System.out.print("Informe a sua massa: ");
		massa = ent.nextDouble();
		ent.close();
		
		System.out.println("Massa relativa em outros planetas: ");
		for (int i = 0; i < gRelativo.length; i++) {
			System.out.print(nomesPlanetas[i] + " - ");
			System.out.println( ( massa * gRelativo[i] ) );
		}
	}

}
