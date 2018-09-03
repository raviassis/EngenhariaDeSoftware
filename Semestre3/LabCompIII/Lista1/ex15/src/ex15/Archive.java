package ex15;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Archive {
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Archive(String path) {
		this.path = path;
	}
	
	public void gravar(List<Empresa> lista) {
		FileOutputStream arqSaida = null;
		PrintStream saida = null;
		
		try {
			arqSaida = new FileOutputStream(this.getPath(), true);
			saida = new PrintStream(arqSaida);			
			
			for (Empresa e : lista) {
				saida.println(e);
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			if (saida != null) saida.close();
			if (arqSaida != null)
				try {
					arqSaida.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		 
	}
	
	public List<Empresa> listar () {
		
		FileInputStream arqEntrada = null;
		DataInputStream entrada = null;
		List<Empresa> lista = new ArrayList();
		try {
			arqEntrada = new FileInputStream(this.getPath());
			entrada = new DataInputStream(arqEntrada);
			
			while ( entrada.available() != 0) {
				
				String linha = entrada.readLine();
				StringTokenizer listaPalavras = new StringTokenizer(linha); //Pega uma linha e gera um vetor com as palavras desta linha
				String codigo = listaPalavras.nextToken();
				String nome = listaPalavras.nextToken();
				Empresa e = new Empresa( Integer.parseInt(codigo), nome);
				lista.add(e);				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return lista;
	}
	
	public void backup() {
		String path = this.getPath();
		List<Empresa> lista = this.listar();
		this.setPath(path + "bkp");
		this.gravar(lista);
		this.setPath(path);
	}
}
