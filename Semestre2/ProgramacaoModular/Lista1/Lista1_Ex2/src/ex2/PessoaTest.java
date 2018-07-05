package ex2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PessoaTest {

	@Test(timeout = DEFAULT_TIMEOUT)
	public void test_ConstrutorVazio() {
		Pessoa p = new Pessoa();		
		construtorHelper(p, null, null, null, 0);
	}
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void test_ConstrutorComArgumentos() {
		String nome = "Ravi";
		String cpf = "99988844484";
		int idade = 23;
		String genero = "Masculino";
		Pessoa p = new Pessoa( nome, cpf, idade, genero);		
		construtorHelper(p, nome, cpf, genero, idade);
	}
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void test_eMaior() {
		String nome = "Ravi";
		String cpf = "99988844484";
		int idade = 23;
		String genero = "Masculino";		
		eMaiorHelper_MaiorIdade(nome, cpf, idade, genero);
		
		idade = 10;
		
		eMaiorHelper_MenorIdade(nome, cpf, idade, genero);		
	}
	
	
	
	/*Helpers***********************************************************************************/
	public void construtorHelper (Pessoa p, String nome, String cpf, String genero, int idade) {
		assertEquals(nome, p.getNome());
		assertEquals(cpf, p.getCpf());
		assertEquals(genero, p.getGenero());
		assertEquals(idade, p.getIdade());
	}

	public void eMaiorHelper_MaiorIdade(String nome, String cpf, int idade, String genero) {
		Pessoa p = new Pessoa(nome, cpf, idade, genero);
		assertTrue(p.eMaior());
	}
	
	public void eMaiorHelper_MenorIdade(String nome, String cpf, int idade, String genero) {
		Pessoa p = new Pessoa(nome, cpf, idade, genero);
		assertFalse(p.eMaior());
	}
	
	private static final int DEFAULT_TIMEOUT = 4000;
}
