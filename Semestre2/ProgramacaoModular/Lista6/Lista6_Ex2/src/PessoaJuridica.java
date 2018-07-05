
public class PessoaJuridica extends Pessoa {
	private String cnpj;
	
	public PessoaJuridica (String nome, int idade, String genero, String cnpj) {
		super(nome, idade, genero);
		setCnpj(cnpj);
	}

	public PessoaJuridica() {
		super();
		setCnpj(null);
	}
	
	public PessoaJuridica(String nome, String cnpj) {
		super(nome, 0, null);
		setCnpj(cnpj);
	}

	public String getCnpj() {return cnpj;}

	public void setCnpj(String cnpj) {this.cnpj = cnpj;}
	
}
