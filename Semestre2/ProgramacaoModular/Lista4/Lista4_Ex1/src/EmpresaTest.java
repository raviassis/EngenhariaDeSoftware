import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTest {

	@Test
	public void testConstrutor() {
		String nome = "X S/A";
		Empresa x = new Empresa(nome);
		assertEquals(nome, x.getNome());
		assertEquals(0, x.getNumDeClientes());
		assertEquals(0, x.getNumDeFuncionarios());
	}
	
	@Test
	public void testCadastrarCliente_PessoaFisica() {
		String nome = "Ravi";
		int idade = 24;
		String genero = "Masculino";
		String cpf = "98765432125";
		PessoaFisica tal = new PessoaFisica(nome, idade, genero, cpf);
		Empresa x = new Empresa("Empresa X");
		Cliente cl = new Cliente(tal);
		x.cadastrarCliente(cl);
		
		assertTrue(x.contem(cl));
	}
	
	@Test
	public void testCadastrarCliente_PessoaJuridica() {
		String nome = "Byte Comércio de Software";
		String cnpj = "20474130000173";
		PessoaJuridica byteComercio = new PessoaJuridica(nome, cnpj);
		Empresa x = new Empresa("Empresa X");
		Cliente cl = new Cliente(byteComercio);
		x.cadastrarCliente(cl);
		
		assertTrue(x.contem(cl));
	}
	
	@Test
	public void testCadastrarFuncionario() {
		String nome = "Ravi";
		int idade = 24;
		String genero = "Masculino";
		String cpf = "98765432125";
		String cargo = "Engenheiro de Software";
		double salario = 10000;
		PessoaFisica pessoa = new PessoaFisica(nome, idade, genero, cpf);
		Funcionario dev = new Funcionario(pessoa, cargo, salario);
		Empresa google = new Empresa("Google");
		google.cadastrarFuncionario(dev);
		
		assertTrue( google.contem(dev) );
	}

}
