import static org.junit.Assert.*;

import org.junit.Test;

public class SedanTest {

	@Test
	public void testConstrutor() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		int comprimento = 5;
		Sedan car = new Sedan(vel, preco, cor, comprimento);
		
		assertEquals(vel, car.getVelocidade());
		assertEquals(preco, car.getPreco(), 0);
		assertEquals(cor, car.getCor());
		assertEquals(comprimento, car.getComprimento());
	}
	
	@Test
	public void testPrecoVenda() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		int comprimento = 5;
		double preco_desc1 = 33250;
		double preco_desc2 = 31500;
		Sedan car = new Sedan(vel, preco, cor, comprimento);		
		assertEquals(preco_desc2, car.getPrecoVenda(), 0);		
		car.setComprimento(7);
		assertEquals(preco_desc1, car.getPrecoVenda(), 0);
	}
	
	@Test
	public void testComprimentoMenorQueZero() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		int comprimento = -1;
		Sedan car = new Sedan(vel, preco, cor, comprimento);		
		assertEquals(0, car.getComprimento());
		
	}

}
