package exercicios;

import java.util.Scanner;

public class Ex8 {

	private static Scanner ext = new Scanner(System.in);
	
	public static void start() {
		System.out.println("\nQuestao 8");
		System.out.println("Escolha uma das opções abaixo resolvidas em programação dinâmica.");
		
		int opcao = 0;	
		
		do {
			menu();
			opcao = ext.nextInt(); clearBuffer();
			
			switch(opcao) {
				case 1:
					problemaFibonacci();
					break;
				case 2:
					problemaTroco();
					break;
				case 9 :
					System.out.println("--- Até mais ---");
					break;
				default:
					System.out.println("Opção inválida");
					
			}
			
		}while(opcao != 9);
		
	}

	private static void problemaTroco() {
		System.out.println("Troco utilizando programação dinâmica.");
		int [] moedas = {1,5,10,25,50,100};
		
		System.out.print("Sistema de moedas utilizado: ");
		
		for (int i = 0 ; i < moedas.length; i++) {
			if(i == 0) System.out.print("(");
			System.out.print(moedas[i]);
			if(i == (moedas.length - 1)) System.out.println(")");
			else System.out.print(", ");
		}
		
		System.out.print("Informe o valor do troco: ");
		int troco = ext.nextInt(); clearBuffer();
		
		System.out.println("Número de moedas: " + numMoedasPD(troco, moedas));
		
	}

	private static int numMoedasPD(int n, int[] moedas) {
		int [] dp = new int [n+1];
		
		//caso base
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			dp[i] = 100000;
			
			for(int j = 0; j < moedas.length; j++) {
				if(i - moedas[j] >= 0) {
					dp[i] = min(dp[i], dp[i - moedas[j]] +1);
				}
			}
		}
		
		return dp[n];
	}

	private static int min(int x, int y) {
		// TODO Auto-generated method stub
		return (x < y) ? x : y;
	}

	private static void problemaFibonacci() {
		System.out.println("Fibonacci utilizando programação dinâmica.");
		System.out.print("Informe o termo desejado da série de fibonacci: ");
		int termo = ext.nextInt(); clearBuffer();
		
		System.out.println("Resultado: " + fibonacciPD(termo));
		
	}

	private static int fibonacciPD(int n) {
		int [] vet = new int[n + 2];
		vet[0] = vet[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			vet[i] = vet[i-1] + vet[i-2];
		}
		
		return vet[n];
	}

	private static void menu() {
		System.out.println("--- Opções ---");
		System.out.println("1 - Sequêcia de Fibonacci");
		System.out.println("2 - Problema do troco");
		System.out.println("9 - Sair\n");
		System.out.print("> ");
		
	}
	
	private static void clearBuffer() {
		// TODO Auto-generated method stub
		ext.nextLine();		
	}

}
