package ex16;
import java.io.*;

public class Aluno implements Registro {
	protected int codigo;
	protected String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getString() {
		return nome;
	}

	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream registro = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(registro);
		saida.writeInt(codigo);
		saida.writeUTF(nome);
		return registro.toByteArray();
	}

	public void setByteArray(byte[] b) throws IOException {
		ByteArrayInputStream registro = new ByteArrayInputStream(b);
		DataInputStream entrada = new DataInputStream(registro);
		codigo = entrada.readInt();
		nome = entrada.readUTF();
	}

	public int compareTo(Object b) {
		return codigo - ((Aluno) b).getCodigo();
	}

	public Aluno clone() throws CloneNotSupportedException {
		return ((Aluno) super.clone());
	}

	@Override
	public String toString() {
		return codigo + " - " + nome ;
	}
	
	

}
