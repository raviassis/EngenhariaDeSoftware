
public class Funcionario {
	private String cargo;
	private double salario;
	PessoaFisica pessoaFisica;
	
	public Funcionario (PessoaFisica pf, String cargo, double salario) {
		setPessoaFisica(pf);
		setSalario(salario);
		setCargo(cargo);
	}

	public String getCargo() {
		return cargo;
	}
	public double getSalario() {
		return salario;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
}
