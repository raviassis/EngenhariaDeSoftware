import java.io.IOException;
import java.util.Scanner;

public class Ex30_Aplication {
	
	public static void comandoErrado(String comando) {
		System.out.println("\'" + comando + "\' is not recognized as an internal command.");
		System.out.println();
	}
	
	public static void printLine() {
		System.out.println("---------------------------------------------------------------------------");
	}
	
	public static void help() {
		printLine();
		System.out.println("Command's list:");
		System.out.println("Command: ping");
		System.out.println("\tUse: ping URL\tEx:ping www.google.com.br");
		System.out.println("\tDescription: Return the IP adress of the URL requested.");
		System.out.println();
		System.out.println("Command: exit");
		System.out.println("\tUse: exit");
		System.out.println("\tDescription: Close the program.");
		printLine();
		System.out.println();
		
	}

	public static String [] trataComando(String comando) {
		return comando.split(" ");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CDicionario dc = new CDicionario();
		Scanner ext = new Scanner(System.in);
		String [] comands;
		
		dc.adiciona("www.google.com.br", "172.217.28.67");
		dc.adiciona("www.pucminas.br", "200.229.32.27");
		dc.adiciona("www.gmail.com", "172.217.28.69");
		dc.adiciona("www.youtube.com", "216.58.202.14");
		dc.adiciona("www.capes.gov.br", "200.130.18.222");
		dc.adiciona("www.yahoo.com", "98.136.96.140");
		dc.adiciona("www.microsoft.com", "23.37.248.39");
		dc.adiciona("www.twitter.com", "104.244.42.129");
		dc.adiciona("www.brasil.gov.br", "170.246.252.243");
		dc.adiciona("www.wikipedia.com", "208.80.154.224");
		dc.adiciona("www.amazon.com", "52.85.163.111");
		
		dc.adiciona("research.microsoft.com", "13.67.218.189");
		dc.adiciona("www.facebook.com", "31.13.74.35");
		dc.adiciona("www.whitehouse.gov", "23.44.178.233");
		dc.adiciona("www.answers.com", "151.101.176.203");
		dc.adiciona("www.uol.com.br", "200.221.2.45");
		dc.adiciona("www.hotmail.com", "204.79.197.212");
		dc.adiciona("www.cplusplus.com", "167.114.170.15");
		dc.adiciona("www.nyt.com", "151.101.177.164");
		dc.adiciona("www.apple.com", "23.44.189.23");
		dc.adiciona("www.gamespot.com", "64.30.228.81");
		dc.adiciona("pt.stackoverflow.com", "151.101.193.69");
		dc.adiciona("github.com", "192.30.253.113");
		dc.adiciona("www.w3schools.com", "192.229.173.207");
		dc.adiciona("bitcoin.org", "138.68.248.245");
		
		System.out.println("Welcome to the URL's Dictionary");
		System.out.println("Type the command or --h for help screen.");
		
		do {
			comands = null;
			
			System.out.print("c-> ");
			comands = ext.nextLine().split(" ");
			
			switch(comands[0]) {
				case "--h":
					help();
					break;
				case "ping":
					System.out.println(pesquisarUrl(comands[1], dc));
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

	private static String pesquisarUrl(String url, CDicionario dc) {
		// TODO Auto-generated method stub
		Object val = dc.recebeValor(url);
		if ( val != null) {
			return "IP " + (String)val;
		}
		return "Could not find Host IP \'" + url + "\'";
	}

}
