import static org.junit.Assert.*;

import org.junit.Test;

public class FiatTest {

	@Test
	public void testConstrutor() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		int desconto = 5000;
		Fiat carro = new Fiat(vel, preco, cor, desconto );
		assertEquals(vel, carro.getVelocidade());
		assertEquals(preco, carro.getPreco(), 0);
		assertEquals(cor, carro.getCor());
		
	}
	
	@Test
	public void testPrecoVenda() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		int desconto = 5000;
		double preco_desconto = 30000;
		Fiat carro = new Fiat(vel, preco, cor, desconto );
		
		assertEquals(preco_desconto, carro.getPrecoVenda(), 0);
	}
	
	@Test
	public void testDescontoNegativo() {
		int vel = 100;
		double preco = 35000;
		String cor = "Black";
		int desconto = -50;
		
		Fiat carro = new Fiat(vel, preco, cor, desconto );
		
		assertEquals(preco, carro.getPrecoVenda(), 0);
	}

}
