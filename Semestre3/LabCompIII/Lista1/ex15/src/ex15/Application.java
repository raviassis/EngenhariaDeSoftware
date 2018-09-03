package ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	private static Scanner ext = new Scanner(System.in);
	private static Archive dados = new Archive("empresas");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int op = 0;
		
		do {
			menu();
			op = ext.nextInt();
			clearBuffer();
			
			switch(op) {
			case 1: 
				addEmpresa();
				break;
			case 2:
				listarEmpresa();
				break;
			case 3: 
				backup();
				break;
			case 4:
				bye();
				break;
			default:
				System.out.println("Entrada inválida!");						
		}
			
		} while (op != 4) ;
	}
	
	private static void backup() {
		// TODO Auto-generated method stub
		dados.backup();
		System.out.println();
		System.out.println("Backup Realizado!");
		System.out.println();
	}

	private static void listarEmpresa() {
		// TODO Auto-generated method stub
		List<Empresa> lista = dados.listar();
		System.out.println();
		System.out.println("---Lista de Empresas---");
		for (Empresa e : lista) {
			System.out.println(e);
		}
		System.out.println();
		
	}

	private static void addEmpresa() {
		// TODO Auto-generated method stub
		Empresa nova = new Empresa();
		List<Empresa> lista = new ArrayList();
		
		System.out.println();
		System.out.println("--- Adicionar Empresa ---");
		System.out.print("Informe o nome da empresa: ");
		nova.setNome(ext.nextLine());
		System.out.print("Informe o código: ");
		nova.setCodigo(ext.nextInt()); clearBuffer();
		System.out.println();
		
		lista.add(nova);
		dados.gravar(lista);
		
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Menu");
		System.out.println("1 - Adicionar Empresa");
		System.out.println("2 - Listar Empresas");
		System.out.println("3 - Realizar backup");
		System.out.println("4 - Sair");
	}
	
	private static void clearBuffer() {
		// TODO Auto-generated method stub
		ext.nextLine();		
	}
	
	private static void bye() {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("### Até mais! ###");
	}

}
