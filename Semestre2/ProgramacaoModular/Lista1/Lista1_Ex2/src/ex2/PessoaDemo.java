package ex2;

public class PessoaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p = new Pessoa();
		Pessoa p2 = new Pessoa("Ravi", "99988844485", 23, "Masculino");
		
		System.out.println("Aplicação Classe Pessoa");
		System.out.println();
		System.out.println("Declaração vazia");
		System.out.println("Nome: " + p.getNome());
		System.out.println("CPF: " + p.getCpf());
		System.out.println("Idade: " + p.getIdade());
		System.out.println("Genero: " + p.getGenero());
		System.out.print("É maior? ");
		if (p.eMaior()) System.out.println("Sim");
		else System.out.println("Não");
		System.out.println();
		System.out.println("Declarando pessoa");
		System.out.println("Nome: " + p2.getNome());
		System.out.println("CPF: " + p2.getCpf());
		System.out.println("Idade: " + p2.getIdade());
		System.out.println("Genero: " + p2.getGenero());
		System.out.print("É maior? ");
		if (p2.eMaior()) System.out.println("Sim");
		else System.out.println("Não");
		System.out.println();
		
	}

}
