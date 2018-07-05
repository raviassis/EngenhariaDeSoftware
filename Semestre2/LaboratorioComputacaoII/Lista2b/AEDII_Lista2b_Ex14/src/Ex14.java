import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		double imc, peso, altura, alturaMetros, pesoIdeal;
		String [] MSG = {
				"Magreza severa",
				"Magreza moderada",
				"Magreza leve",
				"Peso ideal",
				"Sobrepeso (pré-obesidade)",
				"Obesidade grau I",
				"Obesidade grau II (severa)",
				"Obesidade grau III (mórbida)"
		};
		
		System.out.println("Ex14");
		System.out.println("Informe a altura(cm): ");
		altura = ent.nextDouble();
		System.out.println("Informe o peso: ");
		peso = ent.nextDouble();
		ent.close();
		alturaMetros = altura / 100.00;
		imc = peso / Math.pow(alturaMetros, 2);
		
		if ( imc < 16) {
			pesoIdeal = Math.pow(alturaMetros, 2) * 18.5;
			System.out.println(MSG[0]);
			System.out.println("Peso mínimo ideal: " + pesoIdeal + "kg");
			System.out.println("Necessário ganhar " + (pesoIdeal - peso) + "kg");
		}
		else if (imc < 17) {
			pesoIdeal = Math.pow(alturaMetros, 2) * 18.5;
			System.out.println(MSG[1]);
			System.out.println("Peso mínimo ideal: " + pesoIdeal + "kg");
			System.out.println("Necessário ganhar " + (pesoIdeal - peso) + "kg");
		}
		else if (imc < 18.5) {
			pesoIdeal = Math.pow(alturaMetros, 2) * 18.5;
			System.out.println(MSG[2]);
			System.out.println("Peso mínimo ideal: " + pesoIdeal + "kg");
			System.out.println("Necessário ganhar " + (pesoIdeal - peso) + "kg");
		}
		else if (imc < 25) {
			System.out.println(MSG[3]);
		}
		else if (imc < 30) {
			pesoIdeal = Math.pow(alturaMetros, 2) * 24.99;
			System.out.println(MSG[4]);
			System.out.println("Peso máximo ideal: " + pesoIdeal + "kg");
			System.out.println("Necessário perder " + (peso - pesoIdeal) + "kg");
		}
		else if ( imc < 35 ) {
			pesoIdeal = Math.pow(alturaMetros, 2) * 24.99;
			System.out.println(MSG[5]);
			System.out.println("Peso máximo ideal: " + pesoIdeal + "kg");
			System.out.println("Necessário perder " + (peso - pesoIdeal) + "kg");
		}
		else if ( imc < 40) {
			pesoIdeal = Math.pow(alturaMetros, 2) * 24.99;
			System.out.println(MSG[6]);
			System.out.println("Peso máximo ideal: " + pesoIdeal + "kg");
			System.out.println("Necessário perder " + (peso - pesoIdeal) + "kg");
		}
		else {
			pesoIdeal = Math.pow(alturaMetros, 2) * 24.99;
			System.out.println(MSG[7]);
			System.out.println("Peso máximo ideal: " + pesoIdeal + "kg");
			System.out.println("Necessário perder " + (peso - pesoIdeal) + "kg");
		}
		
	}

}
