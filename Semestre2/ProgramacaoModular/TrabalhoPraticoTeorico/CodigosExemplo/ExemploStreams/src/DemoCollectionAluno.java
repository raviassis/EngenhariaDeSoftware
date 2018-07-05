import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DemoCollectionAluno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Aluno> classe = new ArrayList<Aluno>();
		classe.add(new Aluno(1,"Antônio", 8, true));
		classe.add(new Aluno(2,"Geraldo", 8, false));
		classe.add(new Aluno(3,"Julia", 8, true));
		classe.add(new Aluno(4,"Eliza", 8, true));
		
		System.out.println("### Listando Todos Alunos ###");
		classe.stream().forEach(System.out::println); //Referencia de metodo
		System.out.println();
		
		//Filtrando alunos aprovados
		System.out.println("### Filtrando Alunos Aprovados ###");
		classe.stream()
				.filter( aln -> aln.aprovado)
				.forEach(System.out::println);
		System.out.println();
		
		//Imprimindo os alunos em ordem alfabética
		System.out.println("### Imprimindo os alunos em ordem alfabética ###");
		classe.stream()
				.sorted( (x, y) -> x.nome.compareTo(y.nome) )
				.forEach(System.out::println);
		System.out.println();
		
		
		//Pesquisar aluno pela matrícula
		System.out.println("### Pesquisar aluno pela Matricula 3 ###");
		int mat = 3;
		classe.stream()
				.filter( aln -> aln.matricula == mat)
				.forEach(System.out::println);

	}

}
