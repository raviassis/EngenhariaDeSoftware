
public class Cliente {
	Pessoa pessoa;
	private double limiteCredito;
	
	public Cliente (Pessoa p) {
		setPessoa(p);
		setLimiteCredito(0);
	}
	
	public Cliente (Pessoa p, double limite) {
		setPessoa(p);
		setLimiteCredito(limite);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setPessoa(Pessoa p) {
		this.pessoa = p;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	

}
