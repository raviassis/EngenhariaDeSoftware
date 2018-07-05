
public class Cliente extends Pessoa {
	private String tipo;
	private String numDocumento;
	private double limiteCredito;
	
	public Cliente (String nome, int idade, String genero, String tipo, String numDocumento) {
		super(nome, idade, genero);
		setLimiteCredito(0);
		setTipo(tipo);
		setNumDocumento(numDocumento);
	}

	public Cliente(String nome, int idade, String genero,  double limite) {
		// TODO Auto-generated constructor stub
		super(nome, idade, genero);
		setLimiteCredito(limite);
		setTipo(tipo);
		setNumDocumento(numDocumento);
	}
	
	public Cliente(PessoaFisica novo) {
		super(novo.getNome(), novo.getIdade(), novo.getGenero());
		setLimiteCredito(0);
		setTipo("Pessoa Física");
		setNumDocumento(novo.getCpf());
	}
	
	public Cliente(PessoaJuridica novo) {
		// TODO Auto-generated constructor stub
		super(novo.getNome(), novo.getIdade(), novo.getGenero());
		setLimiteCredito(0);
		setTipo("Pessoa Jurídica");
		setNumDocumento(novo.getCnpj());		
	}

	private double getLimiteCredito() {
		return limiteCredito;
	}

	private void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	public void liberarLimiteCredito(double limite) {
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
