import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CListaTest {

	@Test
	public void testInsereAntesDe() {
		int a =5, b=6, c=7;
		CLista lista = new CLista();
		lista.insereFim(a);
		lista.insereFim(c);
		lista.InsereAntesDe(b, c);
		lista.removeRetornaFim();
		assertEquals(b,lista.removeRetornaFim());		
	}
	
	@Test
	public void testInsereDepoisDe() {
		int a =5, b=6, c=7;
		CLista lista = new CLista();
		lista.insereFim(a);
		lista.insereFim(c);
		lista.InsereDepoisDe(b, a );
		lista.removeRetornaFim();
		assertEquals(b, lista.removeRetornaFim());
	}
	
	@Test
	public void testInsereOrdenado() {
		int a=5, b=6, c=7, d=8;
		CLista lista = new CLista();
		lista.InsereOrdenado(d);
		lista.InsereOrdenado(b);
		lista.InsereOrdenado(c);
		lista.InsereOrdenado(a);
		
		assertEquals(a,lista.removeRetornaComeco());
		assertEquals(b,lista.removeRetornaComeco());
		assertEquals(c,lista.removeRetornaComeco());
		assertEquals(d,lista.removeRetornaComeco());
		
	}
	
	@Test 
	public void testRetornaVetorRecursivo() {
		CLista lista = new CLista();
		int [] vetor = {0,1,2,3,4,5,6,7,8,9};
		int [] vetorInverso = {9,8,7,6,5,4,3,2,1,0};
		int [] vetor2;
		for (int i = 0; i < vetor.length; i++) lista.insereFim(vetor[i]);
		vetor2 = lista.retornaVetorInvertidoRecursivo();
		Assert.assertArrayEquals(vetorInverso, vetor2);
	}
	
	@Test
	public void testRetornaIndice() {
		CLista lista = new CLista();
		for (int i= 0; i < 5; i++) {
			lista.insereFim(i);
		}
		
		assertEquals(0, lista.retornaIndice(1));
		assertEquals(2, lista.retornaIndice(3));
		assertEquals(4, lista.retornaIndice(5));
	}
	
	@Test
	public void testRemovePos() {
		CLista lista = new CLista();
		for (int i= 0; i < 5; i++) {
			lista.insereFim(i);
		}
		lista.removePos(2);
		lista.removePos(3);
		assertEquals(4,lista.removeRetornaFim());
		assertEquals(2,lista.removeRetornaFim());
	}

}
