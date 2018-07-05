import java.util.Scanner;

public class Ex11 {
	public static boolean eBissexto(int ano) {
		if ( (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)) ) return true ;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		int ano;
		
		System.out.println("Ex11");
		System.out.print("Informe o ano: ");
		ano = ent.nextInt();
		ent.close();
		if ( eBissexto(ano) ) System.out.println("Ano bissexto");
		else System.out.println("Ano não bissexto");
			
		
	}

}
