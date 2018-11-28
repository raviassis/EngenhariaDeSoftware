package exercicios;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Escolha {
	int lin;
	int col;
	int pontuacao;
}

public class Ex2 {

	static String [][] tabuleiro;
	
	static final int MOVIMENTO_O = 1;
	static final int MOVIMENTO_X = 2;
	
	public static void start() {
		System.out.println("\nQuestao 2");
		System.out.println("Jogo da velha com backtracking");
		System.out.println();		
		
		int jogadas = 10;
		int vitoriasX = 0;
		int vitoriasO = 0;
		int empates = 0;
		
		for (int i = 0; i < jogadas; i++) {
			tabuleiro = factory();
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
				
				
			} while( !xGanhou() && !oGanhou() && !empate());
			
			show();
			
			if(xGanhou()) {
				System.out.println("Jogador X Ganhou!");
				vitoriasX++;
			}
			else if (oGanhou()) {
				System.out.println("Jogador O Ganhou!");
				vitoriasO++;
			}
			else {
				System.out.println("Empate");
				empates++;
			}
		}
		
		System.out.println("Vitorias Jogador X: " + vitoriasX);
		System.out.println("Vitorias Jogador O: " + vitoriasO);
		System.out.println("Empates: " + empates);
		
		
		
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
		String [][] cloneTabuleiro = clonaTabuleiro(tabuleiro);
		List<Escolha> escolhas = escolhasDisponiveis(cloneTabuleiro);
		
		for (Escolha e : escolhas) {
			e.pontuacao = testaEscolha(cloneTabuleiro, e, true);
		}
		
		escolhas.sort( (x , y) -> y.pontuacao - x.pontuacao);
		
		Escolha escolha = escolhas.get(0);
		tabuleiro[escolha.lin][escolha.col] = "X";
	}
	
	private static int testaEscolha(String[][] tab, Escolha e, boolean jogadaX) {
		
		if (jogadaX) {
			tab[e.lin][e.col] = "X";
			if ( xGanhou(tab) ) return 10;
			else if ( terminou(tab) ) return 0;
			else {
				String [][] cloneTabuleiro = clonaTabuleiro(tab);
				List<Escolha> escolhas = escolhasDisponiveis(cloneTabuleiro);
				for (Escolha esc : escolhas) {
					return testaEscolha(cloneTabuleiro, esc, false);
				}
					
				return 0;
				
			}
			
		}
		else {
			tab[e.lin][e.col] = "O";
			if(oGanhou(tab)) return -10;
			else if (terminou(tab)) return 0;
			else {
				String [][] cloneTabuleiro = clonaTabuleiro(tab);
				List<Escolha> escolhas = escolhasDisponiveis(cloneTabuleiro);
				for (Escolha esc : escolhas) {
					return testaEscolha(cloneTabuleiro, esc, true);
				}
				return 0;
			}
		}
	}

	private static boolean terminou(String[][] tab) {
		
		if (oGanhou(tab) || xGanhou(tab)) return true;
		
		for(int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if(livre(tab[i][j]) ) return false;
			}
		}
		
		return true;
	}

	private static List<Escolha> escolhasDisponiveis(String[][] tab) {
		// TODO Auto-generated method stub
		List<Escolha> escolhas = new ArrayList<Escolha>();
		for (int lin = 0; lin < tab.length; lin++) {
			for (int col = 0; col < tab[lin].length; col++) {
				if( livre(tab[lin][col]) ) {
					Escolha e = new Escolha();
					e.lin = lin;
					e.col = col;
					escolhas.add(e);
				}
			}
		}
		return escolhas;
	}

	private static boolean livre(String s) {
		// TODO Auto-generated method stub
		return " ".equals(s);
	}


	private static String[][] clonaTabuleiro(String [][] tab){
		String [][] clone = new String[tab.length][];
		
		for (int i = 0; i < clone.length; i++) {
			clone[i] = new String[tab[i].length];
			for (int j = 0; j < clone[i].length; j++) {
				clone[i][j] = new String(tab[i][j]);
			}
		}
		
		return clone;
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
			}
		}while( !colocou);
		
	}
	
	private static boolean xGanhou(String[][] tab) {
		// TODO Auto-generated method stub
		return tab[0][0].equals("X") && tab[1][0].equals("X") && tab[2][0].equals("X") ||
				tab[0][1].equals("X") && tab[1][1].equals("X") && tab[2][1].equals("X") ||
				tab[0][2].equals("X") && tab[1][2].equals("X") && tab[2][2].equals("X") ||
			   
				tab[0][0].equals("X") && tab[0][1].equals("X") && tab[0][2].equals("X") ||
				tab[1][0].equals("X") && tab[1][1].equals("X") && tab[1][2].equals("X") ||
				tab[2][0].equals("X") && tab[2][1].equals("X") && tab[2][2].equals("X") ||
			   
				tab[0][0].equals("X") && tab[1][1].equals("X") && tab[2][2].equals("X") ||
				tab[2][0].equals("X") && tab[1][1].equals("X") && tab[0][2].equals("X") ;
	}

	private static boolean xGanhou() {
		// TODO Auto-generated method stub
		return xGanhou(tabuleiro);
	}
	
	private static boolean oGanhou(String[][] tab) {
		// TODO Auto-generated method stub
		return tab[0][0].equals("O") && tab[1][0].equals("O") && tab[2][0].equals("O") ||
				tab[0][1].equals("O") && tab[1][1].equals("O") && tab[2][1].equals("O") ||
				tab[0][2].equals("O") && tab[1][2].equals("O") && tab[2][2].equals("O") ||
				   
				tab[0][0].equals("O") && tab[0][1].equals("O") && tab[0][2].equals("O") ||
				tab[1][0].equals("O") && tab[1][1].equals("O") && tab[1][2].equals("O") ||
				tab[2][0].equals("O") && tab[2][1].equals("O") && tab[2][2].equals("O") ||
				   
				tab[0][0].equals("O") && tab[1][1].equals("O") && tab[2][2].equals("O") ||
				tab[2][0].equals("O") && tab[1][1].equals("O") && tab[0][2].equals("O") ;
	}
	
	private static boolean oGanhou() {
		// TODO Auto-generated method stub
		return oGanhou(tabuleiro);
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
