package console;
import java.util.Scanner;

public class ConsoleTools {
	
	//Pausa o programa e aguarda usuário pressionar uma tecla
	public static void pause() {
		// TODO Auto-generated method stub
		Scanner ext = new Scanner(System.in);
		System.out.println("Digite uma tecla para continuar...");
		ext.nextLine();
	}
	
		//Imprime uma linha dupla
	public static void doubleLine() {
		// TODO Auto-generated method stub
		System.out.println("==============================");
		System.out.println();
	}
	
	//Limpa buffer do teclado após leitura de um valor int ou double
	public static void clearBuffer() {
		// TODO Auto-generated method stub
		Scanner ext = new Scanner(System.in);
		ext.nextLine();		
	}
}
