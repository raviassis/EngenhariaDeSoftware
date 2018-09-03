package ex16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

	String nomeArquivo;
	
	Arquivo(String nomeArquivo){
		this.nomeArquivo = nomeArquivo;
	}
	
	Arquivo(){
		this.nomeArquivo = "";
	}
	
	public void salvarRegistro(Registro r) throws IOException{
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "rw");
		file.seek(file.length());
		file.writeInt(r.getByteArray().length);
		file.write(r.getByteArray());
		file.close();
	}
	
	public List<Aluno> listarArquivo() throws IOException{
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "r");
		List<Aluno> lista = new ArrayList();
		
		while (file.getFilePointer() < file.length()) {
			int size = file.readInt(); // tam registro
			byte b [] = new byte[size]; // vetor de bytes do tam do registro		
			file.read(b); //preenchendo o vetor de bytes com os dados lidos do registro		
			Aluno a = new Aluno();
			a.setByteArray(b); //envia o vetor de bytes para o metodo de alunos		
			lista.add(a);
			//System.out.println(a);
		}
		
		
		
		
		file.close();
		
		return lista;
	}

	public Aluno pesquisar(String pesquisa) throws IOException {
		// TODO Auto-generated method stub
		List<Aluno> lista = this.listarArquivo();
		
		for (Aluno a : lista) {
			if( a.toString().contains(pesquisa) ) return a;
		}
		
		return null;
	}
}
