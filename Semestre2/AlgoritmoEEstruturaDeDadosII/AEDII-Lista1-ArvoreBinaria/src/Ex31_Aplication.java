import java.util.Scanner;

public class Ex31_Aplication {
	public static void main (String[] args) {
		CDicionario gc = new CDicionario();
		Scanner ext = new Scanner(System.in);
		String [] comands;
		
		gc.adiciona("UUU", "Fenilalanina");
		gc.adiciona("UUC", "Fenilalanina");
		gc.adiciona("UUA", "Leucina");
		gc.adiciona("UUG", "Leucina");
		gc.adiciona("CUU", "Leucina");
		gc.adiciona("CUC", "Leucina");
		gc.adiciona("CUA", "Leucina");
		gc.adiciona("CUG", "Leucina");
		gc.adiciona("AUU", "Isoleucina");
		gc.adiciona("AUC", "Isoleucina");
		gc.adiciona("AUA", "Isoleucina");
		gc.adiciona("AUG", "Metionina");
		gc.adiciona("GUU", "Valina");
		gc.adiciona("GUC", "Valina");
		gc.adiciona("GUA", "Valina");
		gc.adiciona("GUG", "Valina");
		gc.adiciona("UCU", "Serina");
		gc.adiciona("UCC", "Serina");
		gc.adiciona("UCA", "Serina");
		gc.adiciona("UCG", "Serina");
		gc.adiciona("CCU", "Prolina");
		gc.adiciona("CCC", "Prolina");
		gc.adiciona("CCA", "Prolina");
		gc.adiciona("CCG", "Prolina");
		gc.adiciona("ACU", "Treonina");
		gc.adiciona("ACC", "Treonina");
		gc.adiciona("ACA", "Treonina");
		gc.adiciona("ACG", "Treonina");
		gc.adiciona("GCU", "Alanina");
		gc.adiciona("GCC", "Alanina");
		gc.adiciona("GCA", "Alanina");
		gc.adiciona("GCG", "Alanina");
		gc.adiciona("UAU", "Tirosina");
		gc.adiciona("UAC", "Tirosina");
		gc.adiciona("UAA", "Parada");
		gc.adiciona("UAG", "Parada");
		gc.adiciona("CAU", "Histidina");
		gc.adiciona("CAC", "Histidina");
		gc.adiciona("CAA", "Glutamina");
		gc.adiciona("CAG", "Glutamina");
		gc.adiciona("AAU", "Asparagina");
		gc.adiciona("AAC", "Asparagina");
		gc.adiciona("AAA", "Lisina");
		gc.adiciona("AAG", "Lisina");
		gc.adiciona("GAU", "Aspartato");
		gc.adiciona("GAC", "Aspartato");
		gc.adiciona("GAA", "Glutamato");
		gc.adiciona("GAG", "Glutamato");
		gc.adiciona("UGU", "Cisteína");
		gc.adiciona("UGC", "Cisteína");
		gc.adiciona("UGA", "Parada");
		gc.adiciona("UGG", "Triptofano");
		gc.adiciona("CGU", "Arginina");
		gc.adiciona("CGC", "Arginina");
		gc.adiciona("CGA", "Arginina");
		gc.adiciona("CGG", "Arginina");
		gc.adiciona("AGU", "Serina");
		gc.adiciona("AGC", "Serina");
		gc.adiciona("AGA", "Arginina");
		gc.adiciona("AGG", "Arginina");
		gc.adiciona("GGU", "Glicina");
		gc.adiciona("GGC", "Glicina");
		gc.adiciona("GGA", "Glicina");
		gc.adiciona("GGG", "Glicina");
		
		System.out.println("Welcome to the Genect Code Dictionary");
		System.out.println("Type the command or --h for help screen.");
		
		do {
			comands = null;
			
			System.out.print("c-> ");
			comands = ext.nextLine().split(" ");
			
			switch(comands[0]) {
				case "--h":
					help();
					break;
				case "code":
					System.out.println(search(comands[1], gc));
					System.out.println();
					break;
				case "exit":
					break;
				default:
					comandoErrado(comands[0]);
					break;
			}
			
		} while( comands[0].compareToIgnoreCase("exit") != 0);
		
		ext.close();
	}

	private static String search(String trinca, CDicionario gc) {
		Object val = gc.recebeValor(trinca.toUpperCase());
		if ( val != null) {
			return "Amino acid " + (String)val;
		}
		return "Could not find the name of the amino acid of the requested genetic code";
	}

	public static void printLine() {
		System.out.println("---------------------------------------------------------------------------");
	}
	
	public static void help() {
		printLine();
		System.out.println("Command's list:");
		System.out.println("Command: code");
		System.out.println("\tUse: code \"Genect Code\"\tEx:code UUU");
		System.out.println("\tDescription: Return the amino acid name of the code requested.");
		System.out.println();
		System.out.println("Command: exit");
		System.out.println("\tUse: exit");
		System.out.println("\tDescription: Close the program.");
		printLine();
		System.out.println();
		
	}
	
	public static void comandoErrado(String comando) {
		System.out.println("\'" + comando + "\' is not recognized as an internal command.");
		System.out.println();
	}
}
