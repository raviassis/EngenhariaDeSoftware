import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		int idade;
		
		System.out.println("Ex9");
		System.out.println("Informe a idade do eleitor: ");
		idade = ent.nextInt();
		ent.close();
		
		if ( idade < 16 ) {
			System.out.println("Não eleitor.");
		}
		else if (idade < 18 || idade >= 65) {
			System.out.println("Eleitor facultativo.");
		}
		else System.out.println("Eleitor obrigatório.");
	}

}
