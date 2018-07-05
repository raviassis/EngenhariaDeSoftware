import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void testIniciarClienteSemCredito() {
		Cliente cl = new Cliente("Ravi", 24, "Masculino", "Pessoa Física", "98765432158");
		double limite = 0;
		assertEquals(limite, cl.consultarLimite(), 0);
	}

	@Test
	public void testIniciarClienteComCredito() {
		double limite = 800;
		Cliente cl = new Cliente("Ravi", 24, "Masculino", "Pessoa Física", "98765432158", limite);
		assertEquals(limite, cl.consultarLimite(), 0);		
	}
	
	@Test
	public void test_menorQue() {
		Cliente c1 = new Cliente("Ravi Assis", 24, "Masculino", "Pessoa Física", "98765432158", 800);
		Cliente c2 = new Cliente("Antônio Nunes", 50, "Masculino", "Pessoa Física", "9123456787", 800);
				
		assertTrue("Expected true",c2.menorQue(c1));
		assertFalse("Expected false",c1.menorQue(c2));
	}
	
	
}
