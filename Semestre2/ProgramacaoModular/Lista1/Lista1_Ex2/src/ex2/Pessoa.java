package ex2;

public class Pessoa {
	private String nome;
	private String cpf;
	private int idade;
	private String genero;
	
	Pessoa (String nome, String cpf, int idade, String genero) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setGenero(genero);
	}
	
	Pessoa () {
		setNome(null);
		setCpf(null);
		setIdade(0);
		setGenero(null);
	}
	
	public String getNome() {return nome;}
	
	public String getCpf() {return cpf;	}
	
	public int getIdade() {	return idade;}
	
	public String getGenero() {	return genero;}
	
	public void setNome (String name) {
		this.nome = name;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setIdade (int idade) {
		this.idade = idade;
	}
	
	public void setGenero (String genero) {
		this.genero = genero;
	}

	
	public boolean eMaior() {
		// TODO Auto-generated method stub
		return (this.idade >= 18) ? true: false;
	}
}
