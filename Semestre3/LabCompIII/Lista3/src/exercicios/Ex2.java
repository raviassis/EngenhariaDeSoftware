package exercicios;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Escolha {
	int lin;
	int col;
}

public class Ex2 {

	static String [][] tabuleiro;
	static Stack<Escolha> escolhasX;
	static Stack<Escolha> escolhasO;
	
	static final int MOVIMENTO_O = 1;
	static final int MOVIMENTO_X = 2;
	
	public static void start() {
		System.out.println("\nQuestao 2");
		System.out.println("Jogo da velha com backtracking -- incompleto");
		System.out.println();		
		tabuleiro = factory();
		escolhasX = new Stack<Escolha>();
		escolhasO = new Stack<Escolha>();
		
		int jogada = MOVIMENTO_O;
		
		do {
			
			if(jogada == MOVIMENTO_O) {
				jogarO();
				jogada = MOVIMENTO_X;
			}
			else {
				jogarX();
				jogada = MOVIMENTO_O;
			}
			
			show();
			
		} while( !xGanhou() && !oGanhou() && !empate());
		
		
	}

	private static void show() {
		for(int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void jogarX() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				
			}
		}
	}

	private static void jogarO() {
		int l, c, r;
		boolean colocou = false;
		do {
			r = (int)(Math.random() * 100);
			l = r % 3;
			r = (int)(Math.random() * 100);
			c = r % 3;
			
			if(tabuleiro[l][c] == " ") {
				colocou = true;
				tabuleiro[l][c] = "O";
				Escolha e = new Escolha();
				e.lin = l;
				e.col = c;
				escolhasO.push(e);
			}
		}while( !colocou);
		
	}

	private static boolean xGanhou() {
		// TODO Auto-generated method stub
		return tabuleiro[0][0] == "X" && tabuleiro[1][0] == "X" && tabuleiro[2][0] == "X" ||
			   tabuleiro[0][1] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][1] == "X" ||
			   tabuleiro[0][2] == "X" && tabuleiro[1][2] == "X" && tabuleiro[2][2] == "X" ||
			   
			   tabuleiro[0][0] == "X" && tabuleiro[0][1] == "X" && tabuleiro[0][2] == "X" ||
			   tabuleiro[1][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X" ||
			   tabuleiro[2][0] == "X" && tabuleiro[2][1] == "X" && tabuleiro[2][2] == "X" ||
			   
			   tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X" ||
			   tabuleiro[2][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[0][2] == "X" ;
	}
	
	private static boolean oGanhou() {
		// TODO Auto-generated method stub
		return tabuleiro[0][0] == "O" && tabuleiro[1][0] == "O" && tabuleiro[2][0] == "O" ||
			   tabuleiro[0][1] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][1] == "O" ||
			   tabuleiro[0][2] == "O" && tabuleiro[1][2] == "O" && tabuleiro[2][2] == "O" ||
			   
			   tabuleiro[0][0] == "O" && tabuleiro[0][1] == "O" && tabuleiro[0][2] == "O" ||
			   tabuleiro[1][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O" ||
			   tabuleiro[2][0] == "O" && tabuleiro[2][1] == "O" && tabuleiro[2][2] == "O" ||
			   
			   tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O" ||
			   tabuleiro[2][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[0][2] == "O" ;
	}
	
	private static boolean empate() {
		boolean tabuleiroCheio = true;
		
		for(int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if(tabuleiro[i][j] == " ") tabuleiroCheio = false;
			}
		}
		
		return tabuleiroCheio && !xGanhou() && !oGanhou();
		
	}

	private static String[][] factory() {
		// TODO Auto-generated method stub
		return new String [][] {
			{" ", " ", " "},
			{" ", " ", " "},
			{" ", " ", " "}
		};
	}
	
	
}
