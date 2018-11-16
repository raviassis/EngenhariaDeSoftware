package main;

import java.util.Scanner;

import exercicios.Ex1;
import exercicios.Ex2;
import exercicios.Ex3;
import exercicios.Ex4;
import exercicios.Ex7;

public class Application {
	
	private static Scanner ext = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcao = 0;		
		
		do {
			menu();
			opcao = ext.nextInt(); clearBuffer();
			
			switch (opcao) {
				case 1 :
					Ex1.start();
					break;
				case 2 :
					Ex2.start();
					break;
				case 3 :
					Ex3.start();
					break;
				case 4 :
					Ex4.start();
					break;
				case 7:
					Ex7.start();
					break;
				case 9 :
					System.out.println("--- Até mais ---");
					break;
				default:
					System.out.println("Opção inválida");
			}
			
			
		} while ( opcao != 9);
	}

	private static void menu() {
		System.out.println("--- Menu ---");
		System.out.println("1 - Questão 1");
		System.out.println("2 - Questão 2");
		System.out.println("3 - Questão 3");
		System.out.println("4 - Questão 4");
		System.out.println("7 - Questão 7");
		System.out.println("9 - Sair\n");
		System.out.print("> ");
		
	}
	
	private static void clearBuffer() {
		// TODO Auto-generated method stub
		ext.nextLine();		
	}

}
