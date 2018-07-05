import java.util.Scanner;

public class Aplication {
	static QTree qTree = new QTree();;
	private static Scanner ext = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op = 0;
		System.out.println("�rvore quarten�ria");
		System.out.println();
		do {
			menu();
			op = ext.nextInt();
			clearBuffer();
			
			switch(op) {
				case 1:
					screenAdd();
					break;
				case 2:
					screenSearch();
					break;
				case 3:
					
					screenPrint1();
					break;
				case 4:
					screenPrint2();
					break;
				case 5:
					bye();
					break;
				default:
					System.out.println("Entrada inv�lida!");	
			}
		}while (op != 5);
		
		
		
	}
	private static void screenPrint2() {
		// TODO Auto-generated method stub
		System.out.println("Imprimir por n�vel");
		qTree.printInLevels();
	}
	private static void screenPrint1() {
		// TODO Auto-generated method stub
		System.out.println("Imprimir em Ordem");
		qTree.printInOrder();
		System.out.println("\n");
	}
	private static void screenSearch() {
		// TODO Auto-generated method stub
		boolean b;
		System.out.print("Pesquisar item: ");
		b = qTree.contains(ext.nextInt());
		clearBuffer();
		if (b) System.out.println("Item encontrado");
		else System.out.println("Item n�o encontrado");
	}
	private static void screenAdd() {
		// TODO Auto-generated method stub
		System.out.print("Inserir item: ");
		qTree.insert(ext.nextInt());
		clearBuffer();
	}
	private static void bye() {
		// TODO Auto-generated method stub
		System.out.println("");
		System.out.println("### At� mais! ###");
	}
	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Menu");
		System.out.println("1 - Adicionar elemento");
		System.out.println("2 - Procurar elemento");
		System.out.println("3 - Imprimir conte�do em Ordem");
		System.out.println("4 - Imprimir conte�do por n�veis");
		System.out.println("5 - Sair");
	}
	
	private static void clearBuffer() {
		// TODO Auto-generated method stub
		ext.nextLine();		
	}

}
