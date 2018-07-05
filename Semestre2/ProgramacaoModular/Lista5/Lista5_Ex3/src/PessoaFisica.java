
public class PessoaFisica extends Pessoa {
	private String cpf;
	
	public PessoaFisica (String nome, int idade, String genero, String cpf) {
		super(nome, idade, genero);
		setCpf(cpf);
	}
	
	public PessoaFisica() {
		super();
		setCpf(null);
	}
	
	public String getCpf() {return cpf;	}
	
	public void setCpf(String cpf) {this.cpf = cpf;	}
}
