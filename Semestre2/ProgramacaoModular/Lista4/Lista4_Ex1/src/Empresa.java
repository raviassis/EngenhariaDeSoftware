
public class Empresa {
	private static final int MAX_LIST = 100;
	private String nome;
	private Cliente [] listaDeClientes;
	private Funcionario [] listaDeFuncionarios;
	private int numDeClientes;
	private int numDeFuncionarios;
	private Dados dados;
	
	public Empresa (String nome) {
		setNome(nome);
		setDados(null);
		this.listaDeClientes = new Cliente[Empresa.MAX_LIST];
		this.listaDeFuncionarios = new Funcionario[Empresa.MAX_LIST];
		this.numDeClientes = 0;
		this.numDeFuncionarios = 0;
	}
	
	public Empresa (Dados d) {
		setNome(d.getNome());
		setDados(d);
		this.listaDeClientes = new Cliente[Empresa.MAX_LIST];
		this.listaDeFuncionarios = new Funcionario[Empresa.MAX_LIST];
		this.numDeClientes = 0;
		this.numDeFuncionarios = 0;
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
	
	
	
	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados dados) {
		this.dados = dados;
	}

	public void cadastrarCliente(Cliente novo) {
		// TODO Auto-generated method stub
		if (this.numDeClientes < Empresa.MAX_LIST) {
			this.listaDeClientes[this.numDeClientes] = novo;
			this.numDeClientes ++;
		}		
	}	
	
	public void cadastrarFuncionario(Funcionario novo) {
		// TODO Auto-generated method stub
		if (this.numDeFuncionarios < Empresa.MAX_LIST) {
			this.listaDeFuncionarios[this.numDeFuncionarios] = novo;
			this.numDeFuncionarios++;
		}
	}
	
	public boolean contem(Cliente cl) {
		for (int i = 0; i < this.listaDeClientes.length; i++) {
			if ( cl.equals(listaDeClientes[i])) return true ;
		}
		return false;
	}

	public boolean contem(Funcionario dev) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.listaDeFuncionarios.length; i++) {
			if (dev.equals(listaDeFuncionarios[i])) return true;
		}
		return false;
	}
	
	
}
