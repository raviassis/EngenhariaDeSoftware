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
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void test_menorQue() {
		Pessoa p1 = new Pessoa("Ravi Assis", 24, "Masculino");
		Pessoa p2 = new Pessoa("Antônio Nunes", 50, "Masculino");
				
		assertTrue("Expected true",p2.menorQue(p1));
		assertFalse("Expected false",p1.menorQue(p2));
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
