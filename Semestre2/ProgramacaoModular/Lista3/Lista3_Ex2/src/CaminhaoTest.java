import static org.junit.Assert.*;

import org.junit.Test;

public class CaminhaoTest {

	@Test
	public void testConstrutor() {
		int vel = 100;
		double preco = 80000;
		String cor = "Black";
		int carga = 2500;
		Caminhao topic = new Caminhao(vel, preco, cor, carga);
		assertEquals(vel, topic.getVelocidade());
		assertEquals(preco, topic.getPreco(), 0);
		assertEquals(cor, topic.getCor());
		assertEquals(carga, topic.getCarga());
	}
	
	@Test
	public void testPrecoVenda() {
		int vel = 100;
		double preco = 80000;
		String cor = "Black";
		int carga1 = 2000;
		int carga2 = 2500;
		double preco_desc1 = 64000;
		double preco_desc2 = 72000;
		Caminhao topic = new Caminhao(vel, preco, cor, carga1);
		Caminhao camMaior = new Caminhao(vel, preco, cor, carga2);
		assertEquals(preco_desc1, topic.getPrecoVenda(),0);
		assertEquals(preco_desc2, camMaior.getPrecoVenda(), 0);
	}
	
	@Test
	public void testCargaNegativa () {
		int vel = 100;
		double preco = 80000;
		String cor = "Black";
		int carga1 = -2000;
		Caminhao topic = new Caminhao(vel, preco, cor, carga1);
		assertEquals(0, topic.getCarga());
	}

}
