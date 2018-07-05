import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		int dia, mes;
		
		System.out.println("Ex12");
		System.out.print("Informe o dia: ");
		dia = ent.nextInt();
		System.out.print("Informe o mês: ");
		mes = ent.nextInt();
		ent.close();
		
		if ( mes >= 3 && mes <= 5 ) {
			//outono
			System.out.println("Estação de outono");
		}
		else if (mes >= 6 && mes <= 8) {
			//inverno
			System.out.println("Estação de inverno");
		}
		else if (mes >= 9 && mes <= 11) {
			//primavera
			System.out.println("Estação de primavera");
		}
		else {
			//verão
			System.out.println("Estação de verão");
		}
	}

}
