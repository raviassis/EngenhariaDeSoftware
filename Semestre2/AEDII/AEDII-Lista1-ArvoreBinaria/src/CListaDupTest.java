import static org.junit.Assert.*;

import org.junit.Test;

public class CListaDupTest {

	@Test
	public void testPrimeiraOcorrencia() {
		CListaDup lista = new CListaDup();
		for (int i = 0; i < 10; i++) {
			lista.insereFim(i);
		}
		assertEquals(1,lista.primeiraOcorrenciaDe(0));
		assertEquals(5,lista.primeiraOcorrenciaDe(4));
		assertEquals(9,lista.primeiraOcorrenciaDe(8));
	}
	
	@Test
	public void testUltimaOcorrencia() {
		CListaDup lista = new CListaDup();
		for (int i = 0; i < 5; i++) {
			lista.insereFim(i);
		}
		for (int i = 0; i < 5; i++) {
			lista.insereFim(i);
		}
		assertEquals(6,lista.ultimaOcorrenciaDe(0));
		assertEquals(8,lista.ultimaOcorrenciaDe(2));
		assertEquals(10,lista.ultimaOcorrenciaDe(4));
		
	}
	
	@Test
	public void testRemovePos() {
		CListaDup lista = new CListaDup();
		for (int i = 0; i < 5; i++) {
			lista.insereFim(i);
		}
		int index = lista.primeiraOcorrenciaDe(3);
		lista.removePos(index);
		index = lista.primeiraOcorrenciaDe(4);
		lista.removePos(index);
		
		assertEquals(2,lista.removeRetornaFim());
		assertEquals(1,lista.removeRetornaFim());
		assertEquals(0,lista.removeRetornaFim());
	}

}
