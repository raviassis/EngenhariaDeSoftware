

import java.io.FileOutputStream;
import java.io.PrintStream;

public class GravaDados {
	
	public static String getStringTamanhoFixo(String texto, int tamanho) {
		StringBuffer s1 = new StringBuffer(texto);
		s1.setLength(tamanho);
		return s1.toString();
	}
	
	public static void main(String[] args) {
		
		try {
			
			//Define o nome do arquivo a ser trabalhado
			System.out.print("Informe o nome do Arquivo a ser gravado: ");
			String nomeArquivo = Teclado.readLine();			
			
			//Objetos utilizados na manipula��o do arquivo e seus dados
			FileOutputStream arqSaida = new FileOutputStream(nomeArquivo);
			PrintStream saida = new PrintStream(arqSaida);
			
			System.out.print("Informe o n�mero de registros a serem gravados: ");
			int numRegistros = Teclado.readInt();			
			
			//Adiciona os registros desejados
			for(int i=0;i<numRegistros;i++) {
				System.out.print("Informe o c�digo do Ve�culo: ");
				int codigo = Teclado.readInt();
				
				System.out.print("Nome Veiculo: ");
				String nomeVeiculo = Teclado.readLine();
				
				String linha = codigo + " " + nomeVeiculo;
				saida.println(linha);
				
				// >>> E se a duas linhas a seguir substituissem as 2 linhas anteriores? O que aconteceria com os registros?
				// >>> String linha2 = getStringTamanhoFixo(codigo+"", 5) + " " + getStringTamanhoFixo(nomeVeiculo, 15); 
				// >>> saida.println(linha2);

			}

			//Finaliza��o da manipula��o dos dados no arquivo
			saida.flush();
			saida.close();
			arqSaida.close();
			
			System.out.println("Dados Gravados com sucesso");
			
		}
		catch(Exception e) { //Tratamento gen�rico da excess�o ocorrida
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}
		
	}
}
