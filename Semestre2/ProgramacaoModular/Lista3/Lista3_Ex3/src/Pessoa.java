

public class Pessoa {
	private String nome;
	private int idade;
	private String genero;
	private Endereco endereco;

	public Pessoa (String nome, int idade, String genero) {
		setNome(nome);
		setIdade(idade);
		setGenero(genero);
	}
	
	public Pessoa (String nome, int idade, String genero, Endereco endereco) {
		setNome(nome);
		setIdade(idade);
		setGenero(genero);
		setEndereco(endereco);
	}
	
	public Pessoa () {
		setNome(null);
		setIdade(0);
		setGenero(null);
	}
	
	public String getNome() {return nome;}
	
	public int getIdade() {	return idade;}
	
	public String getGenero() {	return genero;}
	
	public void setNome (String name) {
		this.nome = name;
	}
	
	public void setIdade (int idade) {
		this.idade = idade;
	}
	
	public void setGenero (String genero) {
		this.genero = genero;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	public boolean eMaior() {
		// TODO Auto-generated method stub
		return (this.idade >= 18) ? true: false;
	}
}
