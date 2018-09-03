package ex16;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

	private static Scanner ext = new Scanner(System.in);
	private static Arquivo dados = new Arquivo("alunos");
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int op = 0;
		
		do {
			menu();
			op = ext.nextInt();
			clearBuffer();
			
			switch(op) {
			case 1: 
				addAluno();
				break;
			case 2:
				listarAlunos();
				break;
			case 3: 
				pesquisar();
				break;
			case 4:
				bye();
				break;
			default:
				System.out.println("Entrada inválida!");						
		}
			
		} while (op != 4) ;
	}
	
	private static void pesquisar() throws IOException {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("---Pesquisar Aluno---");
		System.out.println("Informe o nome ou código do aluno: ");
		String pesquisa = ext.nextLine();
		
		Aluno a = dados.pesquisar(pesquisa);
		
		if (a != null) {
			System.out.println(a.toString());
		}
		else System.out.println("Resgitro não encontrado.");
		
	}

	private static void listarAlunos() throws IOException {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("---Listar Alunos---");
		
		List<Aluno> lista = dados.listarArquivo();
		
		for (Aluno a : lista) {
			System.out.println(a);
		}
		
		System.out.println();
	}

	private static void addAluno() throws IOException {
		// TODO Auto-generated method stub
		Aluno novo = new Aluno();
		System.out.println("---Adicionar Aluno---");
		System.out.println("Informe o código do aluno: ");
		novo.setCodigo(ext.nextInt()); clearBuffer();
		System.out.println("Informe o nome do aluno: ");
		novo.setNome(ext.nextLine());
		
		dados.salvarRegistro(novo);
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Menu");
		System.out.println("1 - Adicionar Aluno");
		System.out.println("2 - Listar Alunos");
		System.out.println("3 - Pesquisar Aluno");
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
