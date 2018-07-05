import java.util.Scanner;

/**
* @(#)SorteiaBolsa.java
*
*
* @author Ravi Assis
* @version 1.00 2018/5/1
*/

public class Aplication {
	
	public static int M; //Maximo Lista
	public static int N; //Maximo Fila
	private static CLista studentsList; //Lista de Alunos
	private static CFila queue; //Fila de alunos
	private static CLista winners; //Lista dos sorteados.
	private static Scanner ext = new Scanner(System.in); //Entrada teclado

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner ext = new Scanner(System.in);
		
		setParameters();
		welcome();
		
		int op;
		do {
			op=0;
			menu();
			op = ext.nextInt();	
			clearBuffer();		
			switch(op) {
				case 1:
					screenRegister();
					break;
				case 2:
					subMenuList();
					op = ext.nextInt();
					clearBuffer();
					switch(op) {
						case 1:
							toListSimple();
							break;
						case 2:
							toListComplete();
							break;
					}					
					break;
				case 3:
					/*subMenuQueue();
					op = ext.nextInt();
					clearBuffer();
					switch(op) {
						case 1:
							toQueueSimple();
							break;
						case 2:
							toQueueComplete();
							break;
					}*/
					toQueueSimple();
					break;
				case 4:
					screenSearch();
					break;
				case 5:
					screenQuit(); 
					break;
				case 6:
					raffleBag(); 
					break;
				case 7:
					showParameters();
					break;
				case 8:
					bye();
					break;
			}
		}while(op != 8);
		
		ext.close();
	}

	/*Telas***************************************************************/
	
	//Configurar quantidade maxima de alunos na lista e na fila.
	private static void setParameters() {
		// TODO Auto-generated method stub
		System.out.println("--- Definir Parametros ---");
		System.out.print("Quantidade máxima da Lista: ");
		M = ext.nextInt(); clearBuffer();
		System.out.print("Quantidade máxima da Fila: ");
		N = ext.nextInt(); clearBuffer();
		studentsList = new CLista(M);
		queue = new CFila(N);
		
	}

	// Mostrar Parametros configurados
	private static void showParameters() {
		// TODO Auto-generated method stub
		System.out.println("--- Parametros ---");
		System.out.println("Quantidade maxima de alunos na lista: " + M);
		System.out.println("Quantidade maxima de alunos na fila: " + N);
		pause();
	}

	//Sorteia as bolsas
	private static void raffleBag() {
		// TODO Auto-generated method stub
		int bolsas;
		CLista lista = (CLista) studentsList.clone();
		System.out.println("--- Sorteio ---");
		System.out.print("Informe o número de bolsas que serão sorteadas: ");
		bolsas = ext.nextInt();
		clearBuffer();
		winners = new CLista(bolsas);
		for (int i = 1; i <= lista.quantidade() && i <= winners.getMAX(); i++) {
			winners.insereFim( lista.removeRandom() );
		}
		toRaffleListComplete();
		
	}
	

	//realiza a desistencia de um aluno pela sua matricula. 
	private static void screenQuit() {
		// TODO Auto-generated method stub
		int matricula;
		Aluno aux;
		String op;
		System.out.println("--- Desistencia ---");
		System.out.print("Informe o número de matrícula: ");
		matricula = ext.nextInt();
		clearBuffer();
		aux = (Aluno) studentsList.search(matricula);
		if(aux == null) {
			System.out.println(Messages.ALUNO_NAO_ENCONTRADO);
		}
		else {
			doubleLine();
			System.out.println(aux.stringComplete());
			doubleLine();
			System.out.println("Confirma a desistência?(S/N)");
			op = ext.next(); 
			clearBuffer();
			if( op.compareToIgnoreCase("S") == 0 ) {
				studentsList.remove(aux);
				System.out.println(Messages.DESISTENCIA_CONFIRMADA);
				if ( !queue.vazia() )
					studentsList.insereFim(queue.desenfileira());
			}
		}
		pause();
	}

	//Pesquisa aluno pela matricula. 
	//Retorna os dados do aluno se encontrar na lista. 
	//Se aluno estiver na fila somente informa que se encontra na fila
	//Retorna mensagem de erro se não encontrar o aluno
	private static void screenSearch() {
		// TODO Auto-generated method stub
		int matricula;
		Aluno aux;
		System.out.println("--- Pesquisar Aluno ---");
		System.out.print("Informe o número de matrícula: ");
		matricula = ext.nextInt();
		clearBuffer();
		aux = (Aluno) studentsList.search(matricula);
		if(aux != null) System.out.println(aux.stringComplete());
		else {
			if( queue.search(matricula) != null ) System.out.println(Messages.ALUNO_NA_FILA);
			else System.out.println(Messages.ALUNO_NAO_ENCONTRADO);
		}
		pause();
		
	}	
	

	//Cadastra um aluno
	private static void screenRegister() {
		// TODO Auto-generated method stub
		System.out.println("--- Cadastrar Aluno ---");
		Aluno student;
		if ( !studentsList.isFull() ) {
			// register in the studentList
			student = registerForm();
			if ( !studentsList.contem(student) && !queue.contem(student) )
				studentsList.insereFim(student);
			else
				System.out.println("Usuário já cadastrado!");
		}
		else if ( !queue.isFull() ) {
			// register in the queue
			student = registerForm();
			if ( !studentsList.contem(student) && !queue.contem(student)) 
				queue.enfileira(student);
			else 
				System.out.println("Usuário já cadastrado!");
		}
		else {
			// print error
			System.out.println("Não é possivel cadastrar mais alunos!");
		}
	}

	//Formulario de cadastro do aluno
	private static Aluno registerForm() {
		// TODO Auto-generated method stub
		Aluno student = new Aluno();
		System.out.print("Nome: "); 
		student.nome = ext.nextLine();
		System.out.print("Matricula: ");
		student.matricula = ext.nextInt(); 
		clearBuffer();
		System.out.print("Nome da Mãe: ");
		student.nomeMae = ext.nextLine();
		System.out.print("Nome do Pai: ");
		student.nomePai = ext.nextLine();
		System.out.print("Telefone: ");
		student.telefone = ext.nextLine();
		
		System.out.println("\nEndereco");
		System.out.print("Rua: ");
		student.endereco.rua = ext.nextLine();
		System.out.print("Número: ");
		student.endereco.numero = ext.nextLine();
		System.out.print("Complemento: ");
		student.endereco.complemento = ext.nextLine();
		System.out.print("Bairro: ");
		student.endereco.bairro = ext.nextLine();
		System.out.print("Cidade: ");
		student.endereco.cidade = ext.nextLine();
		System.out.print("Estado: ");
		student.endereco.estado = ext.nextLine();
		System.out.print("Cep: ");
		student.endereco.cep = ext.nextLine();
		return student;
	}

	

	//Tela de despedida
	private static void bye() {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("### Até mais! ###");
	}

	//Tela de boas-vindas
	private static void welcome() {
		// TODO Auto-generated method stub
		System.out.println("### Bem Vindo! ###");
		System.out.println();
	}
	
	/*******************************************************************/
	

	/*Menu e submenus**************************************************/
	
	//Tela de menu
	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Menu");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Imprimir Lista de Alunos");
		System.out.println("3 - Imprimir Lista de Espera");
		System.out.println("4 - Pesquisar aluno");
		System.out.println("5 - Desistência");
		System.out.println("6 - Sorteio");
		System.out.println("7 - Parâmetros");
		System.out.println("8 - Sair");
		System.out.println();
	}
	
	//SubMenu do item 3
	private static void subMenuQueue() {
		// TODO Auto-generated method stub
		System.out.println("--- Lista de Espera ---");
		System.out.println("\t1 - Listagem simples");
		System.out.println("\t2 - Listagem completa");
	}
		
	//Submenu do item 2
	private static void subMenuList() {
		// TODO Auto-generated method stub
		System.out.println("--- Lista de Alunos ---");
		System.out.println("\t1 - Listagem simples");
		System.out.println("\t2 - Listagem completa");
	}
	/**************************************************************/
	
	
	/*Listagem*****************************************************/
	
	//Lista os alunos sorteados.
	private static void toRaffleListComplete() {
		// TODO Auto-generated method stub
		int pag = 1;
		System.out.println("LISTAGEM DE ALUNOS CONTEMPLADOS (PÁGINA "+pag+")");
		doubleLine();
		for(int i = 1; i <= winners.quantidade(); i++) {
			Aluno aux = (Aluno) winners.retornaIndice(i);
			System.out.println(aux.stringComplete());
			if(i == (3*pag) ) {
				pause();
				pag++;
				System.out.println("LISTAGEM DE ALUNOS CONTEMPLADOS (PÁGINA "+ pag +")");
				doubleLine();
			}
		}
		doubleLine();
		pause();
	}

	//Lista dados completos dos alunos na fila de espera
	private static void toQueueComplete() {
		// TODO Auto-generated method stub
		int pag = 1;
		System.out.println("LISTAGEM DE ALUNOS COMPLETA (PÁGINA "+pag+")");
		doubleLine();
		for(int i = 1; i <= queue.quantidade(); i++) {
			Aluno aux = (Aluno) queue.getItem(i);
			System.out.println(aux.stringComplete());
			if(i == (3*pag) ) {
				pause();
				pag++;
				System.out.println("LISTAGEM DE ALUNOS COMPLETA (PÁGINA "+ pag +")");
				doubleLine();
			}
		}
		doubleLine();
		pause();
	}

	//Lista nome e matricula dos alunos na fila de espera
	private static void toQueueSimple() {
		// TODO Auto-generated method stub
		int pag = 1;
		System.out.println("LISTAGEM DE ALUNOS (PÁGINA "+ pag +")");
		doubleLine();
		for(int i = 1; i <= queue.quantidade(); i++) {
			Aluno aux = (Aluno) queue.getItem(i);
			System.out.println(aux.stringSimple());
			if(i == (20*pag) ) {
				pause();
				pag++;
				System.out.println("LISTAGEM DE ALUNOS (PÁGINA "+ pag +")");
				doubleLine();
			}
		}
		doubleLine();		
		pause();
	}
	
	//Lista os dados completos dos alunos na lista
	private static void toListComplete() {
		// TODO Auto-generated method stub
		int pag = 1;
		System.out.println("LISTAGEM DE ALUNOS COMPLETA (PÁGINA "+pag+")");
		doubleLine();
		for(int i = 1; i <= studentsList.quantidade(); i++) {
			Aluno aux = (Aluno) studentsList.retornaIndice(i);
			System.out.println(aux.stringComplete());
			if(i == (3*pag) ) {
				pause();
				pag++;
				System.out.println("LISTAGEM DE ALUNOS COMPLETA (PÁGINA "+ pag +")");
				doubleLine();
			}
		}
		doubleLine();
		pause();
	}
	
	//Lista nome e matricula dos alunos na lista
	private static void toListSimple() {
		// TODO Auto-generated method stub
		int pag = 1;
		System.out.println("LISTAGEM DE ALUNOS (PÁGINA "+ pag +")");
		doubleLine();
		for(int i = 1; i <= studentsList.quantidade(); i++) {
			Aluno aux = (Aluno) studentsList.retornaIndice(i);
			System.out.println(aux.stringSimple());
			if(i == (20*pag) ) {
				pause();
				pag++;
				System.out.println("LISTAGEM DE ALUNOS (PÁGINA "+ pag +")");
				doubleLine();
			}
		}
		doubleLine();		
		pause();
	}

	/**************************************************************/
	
	
	/*Cool Tools********************************************************/
	
	//Pausa o programa e aguarda usuário pressionar uma tecla
	private static void pause() {
		// TODO Auto-generated method stub
		System.out.println("Digite uma tecla para continuar...");
		ext.nextLine();
	}
	
	//Imprime uma linha dupla
	private static void doubleLine() {
		// TODO Auto-generated method stub
		System.out.println("==============================");
		System.out.println();
	}
	
	//Limpa buffer do teclado após leitura de um valor int ou double
	private static void clearBuffer() {
		// TODO Auto-generated method stub
		ext.nextLine();		
	}
	
	/*******************************************************************/
	
}
