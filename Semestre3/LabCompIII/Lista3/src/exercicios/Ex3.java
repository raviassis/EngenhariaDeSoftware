package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
	int valor;
	int peso;
	double valorPorPeso;
	
	Item (int valor, int peso){
		this.valor = valor;
		this.peso = peso;
		this.valorPorPeso = (double)valor / (double)peso;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Valor: " + valor + " - Peso: " + peso;
	}	
	
}

class Mochila{
	int cargaMaxima;
	List<Item> itens;
	
	Mochila(int cargaMaxima){
		this.cargaMaxima = cargaMaxima;
		itens = new ArrayList<Item>();
	}

	public void preencher(List<Item> itensParaEscolher) {
		// TODO Auto-generated method stub
		itensParaEscolher.sort((x,y) -> (int)(y.valorPorPeso * 1000) - (int)(x.valorPorPeso * 1000));
		
		for (Item item : itensParaEscolher) {
			if(carga() + item.peso < cargaMaxima) itens.add(item);
		}		
		
	}

	public int carga() {
		// TODO Auto-generated method stub
		int c = 0;
		for(Item i : itens) {
			c += i.peso;
		}
		return c;
	}

	public int valor() {
		// TODO Auto-generated method stub
		int valor = 0;
		for(Item i : itens) {
			valor += i.valor;
		}
		return valor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String s = "";
		
		for(Item i : itens) {
			s += i.toString() + "\n";
		}
		
		return s;
	}
	
	
}

public class Ex3 {
	
	private static Scanner ext = new Scanner(System.in);

	public static void start() {
		System.out.println("\nQuestao 3");
		System.out.println("Problema da mochila do ladrão");
		System.out.println();		
		List<Item> itens = new ArrayList<Item>();
		Mochila mochila;
		
		do {
			int v, p;
			System.out.print("Informe o valor do item: ");
			v = ext.nextInt(); clearBuffer();
			System.out.print("Informe o peso do item: ");
			p = ext.nextInt(); clearBuffer();
			
			itens.add(new Item(v,p));
			System.out.print("Deseja inserir mais algum item?(s/n): ");
		}while(ext.nextLine().compareToIgnoreCase("s") == 0);		
		
		System.out.print("\nInforme a carga maxima da mochila: ");
		mochila = new Mochila(ext.nextInt()); clearBuffer();
		
		mochila.preencher(itens);
		
		
		System.out.println("Carga preenchida: " + mochila.carga());
		System.out.println("Valor total dos items: " + mochila.valor());
		System.out.println("Itens escolhidos: ");
		System.out.println(mochila);
		
	}
	
	

	private static void clearBuffer() {
		// TODO Auto-generated method stub
		ext.nextLine();		
	}
}
