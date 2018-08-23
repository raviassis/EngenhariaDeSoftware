import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class BackupDados {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Define o nome do arquivo a ser trabalhado		
				System.out.print("Informe o nome do Arquivo que será feito o Backup: ");
				String nomeArquivo = Teclado.readLine();	
				String nomeBkp = "bkp_" + nomeArquivo;

				int numReg = 0;		
				
				try {
					
					//Objetos utilizados na manipulação do arquivo e seus dados			
					FileInputStream arqEntrada = new FileInputStream(nomeArquivo);
					DataInputStream entrada = new DataInputStream(arqEntrada);
					
					FileOutputStream arqSaida = new FileOutputStream(nomeBkp);
					PrintStream saida = new PrintStream(arqSaida);
					
					//conta numero de registros
					while(entrada.available() != 0) {
						entrada.readLine();
						numReg++;
					}
					
					//entrada.reset();
					entrada.close();
					arqEntrada.close();
					arqEntrada = new FileInputStream(nomeArquivo);
					entrada = new DataInputStream(arqEntrada);
					
					saida.println(numReg);
					
					//Realiza bkp
					while (entrada.available() != 0) {
						saida.println(entrada.readLine());						
					}
					
					entrada.close();
					arqEntrada.close();
					
					saida.close();
					arqSaida.close();
					
				}
				catch(FileNotFoundException e) {
					System.out.println("O Arquivo informado não existe.\n" + e.toString());
				}		

				System.out.println("Registros salvos: " + numReg );
	}

}
