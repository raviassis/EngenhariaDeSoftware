import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void testEquals_PessoaFisica() {
		PessoaFisica pf = new PessoaFisica("Ravi", 24, "Masculino", "98765432121");
		Cliente cl = new Cliente(pf);
		assertEquals(pf, cl.getPessoa());
	}
	
	@Test
	public void testEquals_PessoaJuridica() {
		PessoaJuridica pj = new PessoaJuridica("Ravi", 24, "Masculino", "122344350001");
		Cliente cl = new Cliente(pj);
		assertEquals(pj, cl.getPessoa());
	}
	
	@Test
	public void testIniciarClienteSemCredito() {
		Pessoa p = new Pessoa("Ravi", 24, "Masculino");
		Cliente cl = new Cliente(p);
		assertEquals(0, cl.getLimiteCredito(), 0);
	}
	
	@Test
	public void testIniciarClienteComCredito() {
		Pessoa p = new Pessoa("Ravi", 24, "Masculino");
		double limite = 5000;
		Cliente cl = new Cliente(p, limite);
		assertEquals(limite, cl.getLimiteCredito(), 0);
	}

}
