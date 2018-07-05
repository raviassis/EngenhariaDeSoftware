import static org.junit.Assert.*;

import org.junit.Test;


public class PessoaTest {

	@Test(timeout = DEFAULT_TIMEOUT)
	public void test_ConstrutorVazio() {
		Pessoa p = new Pessoa();		
		construtorHelper(p, null, 0, null);
	}
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void test_ConstrutorComArgumentos() {
		String nome = "Ravi";
		int idade = 23;
		String genero = "Masculino";
		Pessoa p = new Pessoa( nome, idade, genero);		
		construtorHelper(p, nome, idade, genero);
	}
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void test_eMaior() {
		String nome = "Ravi";
		int idade = 23;
		String genero = "Masculino";		
		eMaiorHelper_MaiorIdade(nome, idade, genero);
		
		idade = 10;
		
		eMaiorHelper_MenorIdade(nome, idade, genero);		
	}
	
	@Test
	public void testEquals() {
		String nome1 = "Ravi";
		int idade1 = 23;
		String genero1 = "Masculino";
		String nome = "Ravi";
		int idade = 23;
		String genero = "Masculino";
		Pessoa p1 = new Pessoa(nome1, idade1, genero1);
		Pessoa p2 = new Pessoa(nome, idade, genero);
		
		assertEquals(p1,p2);		
	}
	
	
	
	/*Helpers***********************************************************************************/
	public void construtorHelper (Pessoa p, String nome,int idade, String genero ) {
		assertEquals(nome, p.getNome());
		assertEquals(genero, p.getGenero());
		assertEquals(idade, p.getIdade());
	}

	public void eMaiorHelper_MaiorIdade(String nome, int idade, String genero) {
		Pessoa p = new Pessoa(nome, idade, genero);
		assertTrue(p.eMaior());
	}
	
	public void eMaiorHelper_MenorIdade(String nome, int idade, String genero) {
		Pessoa p = new Pessoa(nome, idade, genero);
		assertFalse(p.eMaior());
	}
	
	private static final int DEFAULT_TIMEOUT = 4000;

}
