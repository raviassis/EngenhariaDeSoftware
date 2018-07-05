

public class Pessoa {
	
	private String nome;
	private int idade;
	private String genero;
	private Dados dadosPessoais;

	public Pessoa (String nome, int idade, String genero) {
		setNome(nome);
		setIdade(idade);
		setGenero(genero);
		setDadosPessoais(null);
	}
	
	public Pessoa () {
		setNome(null);
		setIdade(0);
		setGenero(null);
		setDadosPessoais(null);
	}
	
	public Pessoa(Dados dp, int idade, String genero) {
		setNome(dp.getNome());
		setIdade(idade);
		setGenero(genero);
		setDadosPessoais(dp);
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
	
	public Dados getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(Dados dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}
	
	public boolean eMaior() {
		// TODO Auto-generated method stub
		return (this.idade >= 18) ? true: false;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		Pessoa a = (Pessoa) arg0;
		if ( getNome().equals( a.getNome() ) &&
			 a.getIdade() == getIdade() &&
			 a.getGenero().equals( getGenero() ) ) return true;
		else return false;
	}
}
