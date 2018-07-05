
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

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		PessoaFisica a = (PessoaFisica) arg0;
		if ( super.equals(a) && getCpf().equals(a.getCpf()) ) {
			return true;
		}
		else return false;
	} 
}
