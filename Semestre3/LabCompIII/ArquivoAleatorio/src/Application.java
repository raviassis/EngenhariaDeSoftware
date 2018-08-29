import java.io.IOException;
import java.util.Scanner;

public class Application {
	
	private static Scanner ent = new Scanner (System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Arquivos Aleatórios");
		ConsoleTools.doubleLine();
		String c = "";
		Arquivo a = new Arquivo("arquivo");
		
		System.out.println("\nDeseja instanciar um novo aluno? (S/N)");
		c = ent.nextLine();
		
		while (c.compareToIgnoreCase("S") == 0) {
			Aluno aluno = new Aluno();
			
			System.out.print("Nome: ");
			aluno.setNome(ent.nextLine());
			
			System.out.print("Código: ");
			aluno.setCodigo(ent.nextInt());
			ConsoleTools.clearBuffer(ent);	
			
			try {
				a.salvarRegistro(aluno);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("\nDeseja instanciar um novo aluno? (S/N)");
			c = "";
			c = ent.nextLine();
		}
		
		try {
			a.listarArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
