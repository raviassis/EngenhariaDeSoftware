package ex15;

public class Empresa {
	private int codigo;
	private String nome;
	
	public Empresa () {
		
	}
	
	public Empresa (int codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return codigo + " " + nome;
	}
	
	
}
