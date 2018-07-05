
public class Aluno {
	public int matricula;
	public String nome;
	public int serie;
	public boolean aprovado;
	
	public Aluno(int mat, String nome, int serie, boolean aprov) {
		this.matricula = mat;
		this.nome = nome;
		this.serie = serie;
		this.aprovado = aprov;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String resp = this.nome + " - matricula: " + this.matricula + " - " + this.serie + "� s�rie";
		if (this.aprovado) return resp + " - Situa��o: Aprovado";
		else return resp + " - Situa��o: Reprovado";
	}	
	
}
