
public class Empresa {
	private static final int MAX_LIST = 100;
	private String nome;
	private Cliente [] listaDeClientes;
	private Funcionario [] listaDeFuncionarios;
	private int numDeClientes;
	private int numDeFuncionarios;
	private Endereco endereco;
	
	public Empresa (String nome) {
		setNome(nome);
		this.listaDeClientes = new Cliente[Empresa.MAX_LIST];
		this.listaDeFuncionarios = new Funcionario[Empresa.MAX_LIST];
		this.numDeClientes = 0;
		this.numDeFuncionarios = 0;
	}
	
	public Empresa (String nome, Endereco endereco) {
		setNome(nome);
		this.listaDeClientes = new Cliente[Empresa.MAX_LIST];
		this.listaDeFuncionarios = new Funcionario[Empresa.MAX_LIST];
		this.numDeClientes = 0;
		this.numDeFuncionarios = 0;
		setEndereco(endereco);
	}

	public String getNome() {
		return nome;
	}

	public int getNumDeClientes() {
		return numDeClientes;
	}

	public int getNumDeFuncionarios() {
		return numDeFuncionarios;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void cadastrarCliente(PessoaFisica tal) throws ExcecaoValorNegativo {
		// TODO Auto-generated method stub
		if (this.numDeClientes < Empresa.MAX_LIST) {
			this.listaDeClientes[this.numDeClientes] = new Cliente(tal);
			this.numDeClientes ++;
		}		
	}
	
	public void cadastrarCliente(PessoaJuridica novo) throws ExcecaoValorNegativo {
		// TODO Auto-generated method stub
		if (this.numDeClientes < Empresa.MAX_LIST) {
			this.listaDeClientes[this.numDeClientes] = new Cliente(novo);
			this.numDeClientes ++;
		}
	}

	public Cliente buscarClientePorDocumento(String numDoc) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.listaDeClientes.length; i++) {
			if (this.listaDeClientes[i].getNumDocumento() == numDoc) return this.listaDeClientes[i];
		}
		
		return null;
	}

	public void cadastrarFuncionario(Funcionario novo) {
		// TODO Auto-generated method stub
		if (this.numDeFuncionarios < Empresa.MAX_LIST) {
			this.listaDeFuncionarios[this.numDeFuncionarios] = novo;
			this.numDeFuncionarios++;
		}
	}

	public Funcionario buscarFuncionarioPorDocumento(String cpf) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.listaDeFuncionarios.length; i++) {
			if (this.listaDeFuncionarios[i].getCpf() == cpf) return this.listaDeFuncionarios[i] ;
		}
		return null;
	}

		
	
	
	
	
}
