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
	
	
}
