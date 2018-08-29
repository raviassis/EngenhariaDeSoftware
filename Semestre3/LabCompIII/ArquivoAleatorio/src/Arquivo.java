
import java.io.*;

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
	
	public void listarArquivo() throws IOException{
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "r");
		
		while (file.getFilePointer() < file.length()) {
			int size = file.readInt(); // tam registro
			byte b [] = new byte[size]; // vetor de bytes do tam do registro		
			file.read(b); //preenchendo o vetor de bytes com os dados lidos do registro		
			Aluno a = new Aluno();
			a.setByteArray(b); //envia o vetor de bytes para o metodo de alunos		
			System.out.println(a);
		}
		
		
		
		
		file.close();
	}
}
