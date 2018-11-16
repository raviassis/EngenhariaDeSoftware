package exercicios;

import java.util.Scanner;

public class Ex1 {
	
	private static Scanner ext = new Scanner(System.in);
	
	public static void start() {
		System.out.println("\nQuestao 1");
		System.out.println("Digite uma sequencia de inteiros para montar o vetor.");
		System.out.println("Obs.: Separe os números por espaços");
		System.out.print("> ");
		
		String expressao = ext.nextLine();
		int [] vet = Ex1.tratarExpressao(expressao);
		Ex1.quickSort(vet);
		
		
		show(vet);
	}

	private static void show(int[] vet) {
		System.out.println("\nResultado");
		for(int i = 0; i < vet.length; i++) {
			System.out.print(vet[i] + " ");
		}
		System.out.println();
	}

	private static void quickSort(int[] vet) {
		Ex1.quickSort(vet, 0, vet.length -1);
	}

	private static void quickSort(int[] v, int esquerda, int direita) {
		int esq = esquerda;
		int dir = direita;
		int pivo = v[(esq + dir) / 2];
		int troca;
		while (esq <= dir) {
			while (v[esq] < pivo) {
				esq = esq + 1;
			}
			while (v[dir] > pivo) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if (dir > esquerda)
			quickSort(v, esquerda, dir);
		if (esq < direita)
			quickSort(v, esq, direita);
	}

	private static int[] tratarExpressao(String expressao) {
		
		String [] vetS = expressao.split(" ");
		int [] vet = new int[vetS.length];
		
		for(int i = 0; i < vet.length; i++) {
			vet[i] = Integer.parseInt(vetS[i]);
		}
		
		return vet;
	}

}
