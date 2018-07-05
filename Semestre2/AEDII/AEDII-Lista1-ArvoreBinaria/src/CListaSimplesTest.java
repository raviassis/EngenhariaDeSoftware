import static org.junit.Assert.*;

import org.junit.Test;

public class CListaSimplesTest {

	@Test
	public void testListaVazia() {
		CListaSimples lista = new CListaSimples();
		assertTrue("Expected True", lista.vazia());
	}
	
	@Test
	public void testRetirarEmOrdemComeco() {
		CListaSimples lista = new CListaSimples();
		int a = 10;
		int b = 15; 
		lista.insereComeco(a);
		lista.insereComeco(b);
		assertEquals(b,lista.removeComeco());
		assertEquals(a,lista.removeComeco());
	}
	
	@Test
	public void testRetirarEmOrdemFim() {
		CListaSimples lista = new CListaSimples();
		int a = 10;
		int b = 15; 
		lista.insereFim(a);
		lista.insereFim(b);
		assertEquals(b,lista.removeFim());
		assertEquals(a,lista.removeFim());
	}
	
	@Test
	public void testContem() {
		CListaSimples lista = new CListaSimples();
		int a = 10;
		int b = 15;
		lista.insereFim(a);
		lista.insereFim(b);
		assertTrue("Expected True", lista.contem(a));
		assertTrue("Expected True", lista.contem(b));
		assertFalse("Expected False", lista.contem(25));
	}
	
	@Test
	public void testImprimir() {
		CListaSimples lista = new CListaSimples();
		for (int i = 0; i < 10; i++) {
			lista.insereFim(i);
		}
		lista.imprime();
	}

}
