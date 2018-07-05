import static org.junit.Assert.*;

import org.junit.Test;

public class CDicionarioTest {

	@Test
	public void testIsEmpty() {
		
		CDicionario dc = new CDicionario();
		assertTrue("Expected True", dc.vazio());
	}
	
	@Test
	public void testIsNotEmpty() {
		CDicionario dc = new CDicionario();
		dc.adiciona(1, "A");
		assertFalse("Expected False", dc.vazio());
	}
	
	@Test
	public void testReceberValor() {
		CDicionario dc = new CDicionario();
		int key = 10;
		int value = 10;
		dc.adiciona(key, value);
		dc.adiciona(key-1, value);
		assertEquals(value, dc.recebeValor(key-1));
	}

}
