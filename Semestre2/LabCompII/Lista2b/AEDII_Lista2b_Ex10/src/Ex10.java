import java.util.Scanner;

public class Ex10 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		String ERROR = "Data inválida!";
		int diaMes[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31	};
		int dia, mes, ano;
		
		System.out.println("Ex10");
		System.out.println("Insira a data");
		System.out.print("Dia: ");
		dia = ent.nextInt();
		System.out.print("Mes: ");
		mes = ent.nextInt();
		System.out.print("Ano: ");
		ano = ent.nextInt();
		ent.close();
		
		if ( ano < 1900) {
			System.out.println(ERROR);
		}
		else if ( mes < 1 || mes > 12) {
			System.out.println(ERROR);
		}
		else {
			if( dia < 1 || dia > diaMes[mes-1]) {
				System.out.println(ERROR);
			}
			else System.out.println(dia + " / " + mes + " / " + ano);
		}
		
	}

}
