import static org.junit.Assert.*;

import org.junit.Test;

public class CarroTest {

	@Test
	public void testConstrutor() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		Carro car = new Carro(vel,preco,cor);
		assertEquals(vel, car.getVelocidade());
		assertEquals(preco, car.getPreco(), 0);
		assertEquals(cor, car.getCor());		
	}
	
	@Test
	public void testPrecoVenda() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		Carro car = new Carro(vel,preco,cor);		
		assertEquals(preco, car.getPrecoVenda(), 0);		
	}
	
	@Test
	public void testVelocidadeNegativa() {
		int vel = -100;
		double preco = 35000;
		String cor = "Black";
		Carro car = new Carro(vel,preco,cor);
		assertEquals(0, car.getVelocidade());
	}
	

}
