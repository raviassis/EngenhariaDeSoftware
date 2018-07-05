
public class Funcionario extends PessoaFisica {
	private String cargo;
	private double salario;
	
	public Funcionario(String nome, int idade, String genero, String cpf, String cargo, double salario) {
		super(nome, idade, genero, cpf);
		setCargo(cargo);
		setSalario(salario);
	}
	
	public String getCargo() {
		return cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
