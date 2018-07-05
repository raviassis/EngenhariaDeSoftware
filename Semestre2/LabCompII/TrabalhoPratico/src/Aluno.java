
/**
* @(#)Aluno.java
*
*
* @author Ravi Assis
* @version 1.00 2018/5/1
*/

public class Aluno {
	public int matricula;
	public String nome;
	public String telefone;
	public Endereco endereco;
	public String nomeMae;
	public String nomePai;
	
	public Aluno() {
		this.endereco = new Endereco();
	}

	//Compara dois objetos do tipo Aluno
	@Override
	public boolean equals(Object arg) {
		// TODO Auto-generated method stub
		return this.matricula == ((Aluno)arg).matricula;
	}
	
	//Retorna uma string contendo nome e matricula do Aluno
	public String stringSimple(){
		return "Matrícula: " + this.matricula + " - Nome: " + this.nome;
	}
	
	//Retorna string contendo todos os dados do aluno
	public String stringComplete() {
		return "Matricula: " + this.matricula + "   Nome: " + this.nome + "\n" +
				"Nome da Mãe: " + this.nomeMae + " - Nome do Pai: " + this.nomePai + "\n" +
				"Telefone: " + this.telefone + "\n" +
				this.endereco.toString();
	}
	
	
	
}
