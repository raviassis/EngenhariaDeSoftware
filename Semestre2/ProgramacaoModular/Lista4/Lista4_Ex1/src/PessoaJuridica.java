
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

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		PessoaJuridica p = (PessoaJuridica) arg0;
		if ( super.equals(p) && getCnpj().equals(p.getCnpj()) ) return true;
		else return false;
	}
	
	
}
