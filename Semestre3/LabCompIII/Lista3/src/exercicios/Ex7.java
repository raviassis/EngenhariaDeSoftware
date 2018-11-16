package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tarefa{
	public int tempo;
	
	public Tarefa(int t) {
		tempo = t;
	}

	@Override
	public String toString() {
		return "" + tempo;
	}
	
	
}

public class Ex7 {
	
	private static Scanner ext = new Scanner(System.in);

	public static void start() {
		
		System.out.println("\nQuestão 7");
		System.out.println("Digite o tempo de cada tarefa a ser executada");
		System.out.println("Obs.: Separe os números por espaços");
		System.out.print("> ");
		
		String expressao = ext.nextLine();
		
		System.out.print("Informe o tempo maximo: ");
		int tempo = Integer.parseInt(ext.nextLine());
		
		int cont = 0;
		boolean encheu = false;
		List<Tarefa> fazer = Ex7.tratarExpressao(expressao);
		List<Tarefa> escolhidas = new ArrayList<Tarefa>();
		
		fazer.sort( (x, y) -> x.tempo - y.tempo  );
		
		while(!encheu) {
			
			if(fazer.get(0).tempo + cont >= tempo) encheu = true;
			else {
				Tarefa t = fazer.remove(0);
				cont += t.tempo;
				escolhidas.add(t);
			}
		}
		
		System.out.println("\nTarefas Escolhidas");
		show(escolhidas);
		System.out.println("\nTempo total gasto = " + cont);
		System.out.println();
		
	}

	private static List<Tarefa> tratarExpressao(String expressao) {
		
		String [] vetS = expressao.split(" ");
		List<Tarefa> lista = new ArrayList<Tarefa>();
		
		for(int i = 0; i < vetS.length; i++) {
			lista.add(new Tarefa(Integer.parseInt(vetS[i])));
		}
		
		return lista;
	}

	private static void show(List<Tarefa> escolhidas) {
		escolhidas.forEach( x -> System.out.print(x + " "));
		System.out.println();
	}

}
