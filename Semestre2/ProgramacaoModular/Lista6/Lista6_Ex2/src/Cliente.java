
public class Cliente extends Pessoa {
	private String tipo;
	private String numDocumento;
	private double limiteCredito;
	
	public Cliente (String nome, int idade, String genero, String tipo, String numDocumento) throws ExcecaoValorNegativo {
		super(nome, idade, genero);
		setLimiteCredito(0);
		setTipo(tipo);
		setNumDocumento(numDocumento);
	}

	public Cliente(String nome, int idade, String genero, String tipo, String numDocumento, double limite) throws ExcecaoValorNegativo {
		// TODO Auto-generated constructor stub
		super(nome, idade, genero);
		setLimiteCredito(limite);
		setTipo(tipo);
		setNumDocumento(numDocumento);
	}
	
	public Cliente(String nome, int idade, String genero, String numDocumento, double limite) throws ExcecaoValorNegativo {
		// TODO Auto-generated constructor stub
		super(nome, idade, genero);
		setLimiteCredito(limite);
		setNumDocumento(numDocumento);
	}
	
	public Cliente(PessoaFisica novo) throws ExcecaoValorNegativo {
		super(novo.getNome(), novo.getIdade(), novo.getGenero());
		setLimiteCredito(0);
		setTipo("Pessoa Física");
		setNumDocumento(novo.getCpf());
	}
	
	public Cliente(PessoaJuridica novo) throws ExcecaoValorNegativo {
		// TODO Auto-generated constructor stub
		super(novo.getNome(), novo.getIdade(), novo.getGenero());
		setLimiteCredito(0);
		setTipo("Pessoa Jurídica");
		setNumDocumento(novo.getCnpj());		
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	private void setLimiteCredito(double limiteCredito) throws ExcecaoValorNegativo {
		if (limiteCredito < 0) throw new ExcecaoValorNegativo();
		this.limiteCredito = limiteCredito;
	}
	
	public void liberarLimiteCredito(double limite) throws ExcecaoValorNegativo {
		setLimiteCredito(limite);
	}

	public double consultarLimite() {
		// TODO Auto-generated method stub
		return getLimiteCredito();
	}
	
	public String getTipo() {
		return tipo;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	
}
