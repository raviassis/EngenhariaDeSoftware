import java.util.Scanner;

public class Aplication {
	
	private static Cliente [] clientList = new Cliente[100];
	private static Funcionario [] employeeList = new Funcionario[100];
	private static Scanner ext = new Scanner(System.in);
	
	public static void imprimir(Cliente [] lista) {
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i].getNome());
		}
		System.out.println("--------------------");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String [] command;		
		welcome();		
		do {
			command = null;
			System.out.print("c-> ");
			command = ext.nextLine().split(" ");			
			switch(command[0].toLowerCase()) {
				case "--h":
					help();
					break;
				case "register":
					if(command[1].compareToIgnoreCase("client") == 0) registerClient();
					else if(command[1].compareToIgnoreCase("employee") == 0) registerEmployee();
					else wrongCommand(command.toString());					
					break;
				case "print":
					if(command[1].compareToIgnoreCase("client") == 0) printClient();
					else if(command[1].compareToIgnoreCase("employee") == 0) printEmployee();
					else wrongCommand(command.toString());	
					break;
				case "exit":
					bye();
					break;
				default:
					wrongCommand(command[0]);
					break;
			}
			
		} while(command[0].compareToIgnoreCase("exit") != 0);
		ext.close();
	}

	private static void printEmployee() {
		// TODO Auto-generated method stub
		System.out.println("--- Employee List ---");
		for (int i = 0; i < employeeList.length; i++) {
			if(employeeList[i] != null) {
				Funcionario a = employeeList[i];
				System.out.print(i + " - Name: " + a.getNome());
				System.out.print(", Age: " + a.getIdade());
				System.out.print(", Genre: " + a.getGenero());
				System.out.print(", Cpf: " + a.getCpf());
				System.out.println(", Earnings: " + a.getSalario());
			}
		}
		System.out.println("---------------------");
	}

	private static void printClient() {
		// TODO Auto-generated method stub
		System.out.println("--- Client List ---");
		for (int i = 0; i < clientList.length; i++) {
			if(clientList[i] != null) {
				Cliente a = clientList[i];
				System.out.print((i+1) + " - Name: " + a.getNome());
				System.out.print(", Age: " + a.getIdade());
				System.out.print(", Genre: " + a.getGenero());
				System.out.print(", Document: " + a.getNumDocumento());
				System.out.println(", Credit Limit: " + a.getLimiteCredito());
			}
		}
		System.out.println("---------------------");
	}

	private static void registerEmployee() {
		// TODO Auto-generated method stub
		String name, genre, document, career;
		int age;
		double earnings;
		
		System.out.println("--- Register Employee ---");
		System.out.print("Name: "); name = ext.nextLine();
		System.out.print("Age: "); age = ext.nextInt(); ext.nextLine();
		System.out.print("Genre: "); genre = ext.nextLine();
		System.out.print("Cpf: "); document = ext.nextLine();
		System.out.print("Career: "); career = ext.nextLine();
		System.out.print("Earnings: "); earnings = ext.nextDouble();ext.nextLine();
		
		try {
			Funcionario novo = new Funcionario(name, age, genre, document, career, earnings);
			for (int i = 0; i < employeeList.length; i++) {
				if (employeeList[i] == null) {
					employeeList[i] = novo;
					System.out.println("Register Employee Successful!");
					return;
				}
			}
		} catch (ExcecaoValorNegativo e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Can not register a employee with negative earnings");
		}
	}

	private static void registerClient() {
		// TODO Auto-generated method stub
		String name;
		int age;
		String genre, document;
		double credLimit;
		System.out.println("--- Register Cliente ---");
		System.out.print("Name: "); name = ext.nextLine();
		System.out.print("Age: "); age = ext.nextInt(); ext.nextLine();
		System.out.print("Genre: "); genre = ext.nextLine();
		System.out.print("Document: "); document = ext.nextLine();
		System.out.print("Credit limit: "); credLimit = ext.nextDouble();ext.nextLine();
		try {
			Cliente novo = new Cliente(name, age, genre, document, credLimit);
			for (int i = 0; i < clientList.length; i++) {
				if (clientList[i] == null) {
					clientList[i] = novo;
					System.out.println("Register Client Successful!");
					return;
				}				
			}
				
		} catch (ExcecaoValorNegativo e) {
			// TODO Auto-generated catch block
			System.out.println("Error: Can not register a customer with negative credit limite!");
		}
	}

	private static void bye() {
		// TODO Auto-generated method stub
		System.out.println("### See ya! ###");
	}

	private static void welcome() {
		// TODO Auto-generated method stub
		System.out.println("### Welcome! ###");
		System.out.println("Type the command or --h for the help screen.");
	}

	private static void wrongCommand(String command) {
		// TODO Auto-generated method stub
		System.out.println("\'" + command + "\' is not recognized as an internal command.");
		System.out.println();
	}

	private static void help() {
		// TODO Auto-generated method stub
		printLine();
		System.out.println("Command's list:");
		System.out.println("Command: register client");
		System.out.println("Command: register employee");
		System.out.println("Command: print client");
		System.out.println("Command: print employee");
		System.out.println("Command: exit");
		printLine();
		System.out.println();
	}
	
	public static void printLine() {
		System.out.println("---------------------------------------------------------------------------");
	}
	
	public static void clearBuffer() {
		String c;
		do {
			c = ext.next();
		} while( c != null);
	}

}
