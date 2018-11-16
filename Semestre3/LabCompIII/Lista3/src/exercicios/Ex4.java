package exercicios;

import java.util.Scanner;

public class Ex4 {

	private static Scanner ext = new Scanner(System.in);
	
	public static void start() {
		System.out.println("\nQuestao 4");
		System.out.println("Jogo Apagando e ganhando");
		
		System.out.print("Informe um número: ");
		String numero = ext.next();
		
		
		
		System.out.print("Informe o número de digitos a serem deletados: ");
		int digitos = ext.nextInt(); clearBuffer();
		
		if (numero.length()>digitos) {
			int indiceMaiorUnidade = indiceMaiorUnidadeValor(numero, digitos);
			
			String premio = deletarDigitos(numero, digitos, indiceMaiorUnidade);
			
			System.out.println("Premio: " + premio);
		}
		else {
			System.out.println("Quantidade de digitos a serem deletados maior ou igual ao numero.");
		}
		
		
		
	}
	
	private static String deletarDigitos(String numero, int digitos, int maior) {
		// TODO Auto-generated method stub
		char [] vet = numero.toCharArray();		
		int tamanhoNovoVetor = vet.length - digitos;
		char [] novoVet = new char[tamanhoNovoVetor];
		
		novoVet[0] = vet[maior];
		
		for (int i = digitos+1; i < vet.length ; i++) {
			novoVet[i-digitos] = vet[i];
		}
		
		
		return String.copyValueOf(novoVet);
	}

	private static int indiceMaiorUnidadeValor(String numero, int digitos) {
		// TODO Auto-generated method stub
		
		char [] vet = numero.toCharArray();
		int iMaior = 0;
		
		for (int i = 0; i < digitos; i++) {
			int nV = Integer.parseInt(String.valueOf(vet[i]));
			int nMaior = Integer.parseInt(String.valueOf(vet[iMaior]));
			
			if (nV > nMaior) iMaior = i;
		}
		
		return iMaior;
	}

	private static void clearBuffer() {
		// TODO Auto-generated method stub
		ext.nextLine();		
	}

}
