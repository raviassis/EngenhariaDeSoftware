import static org.junit.Assert.*;

import org.junit.Test;


public class DataTest {

	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeConstrutor() {
		//fail("Not yet implemented");
		Data d = new Data();
		Data d2 = new Data(2018, 03, 3);
		
		assertEquals(d2.getDia(), d.getDia());
		assertEquals(d2.getMes(), d.getMes());
		assertEquals(d2.getAno(), d.getAno());
		
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeGetDia() {
		Data d = new Data(2018, 02, 03);
		assertEquals(3, d.getDia());		
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeGetMes() {
		Data d = new Data(2018, 02, 03);
		assertEquals( 2, d.getMes() );
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeGetAno() {
		Data d = new Data(2018, 02, 03);
		assertEquals( 2018, d.getAno() );
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeAdicionaDias() {
		Data d = new Data(2018, 03, 22);
		Data d2 = new Data(2018, 04, 1);
		int dias = 10;
		
		//avanço de mes
		d.adicionaDias(dias);
		assertEquals(d2.getDia(), d.getDia());
		assertEquals(d2.getMes(), d.getMes() );
		assertEquals(d2.getAno(), d.getAno());
		
		// avanxo de ano
		d = new Data(2018,12,22);
		d2 = new Data(2019,01,01);
		d.adicionaDias(dias);		
		assertEquals(d2.getDia(), d.getDia());
		assertEquals(d2.getMes(), d.getMes() );
		assertEquals(d2.getAno(), d.getAno());
		
		//bissexto
		d = new Data(2016,02,28);
		d2 = new Data(2016,02,29);
		d.adicionaDias(1);
		assertEquals(d2.getDia(), d.getDia());
		assertEquals(d2.getMes(), d.getMes() );
		assertEquals(d2.getAno(), d.getAno());
		
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeDiasNoMes() {
		Data d1 = new Data(2018, 03, 01);
		Data d2 = new Data(2018, 04, 01);
		Data d3 = new Data(2018, 02, 01);
		Data d4 = new Data(2016, 02, 01);
		
		assertEquals(31, d1.diasNoMes());
		assertEquals(30, d2.diasNoMes());
		assertEquals(28, d3.diasNoMes());
		assertEquals(29, d4.diasNoMes());
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeDiaDaSemana() {
		Data d = new Data(2018, 02, 18);
		String diaSemana[] = {
				"Domingo",
				"Segunda-Feira",
				"Terça-Feira",
				"Quarta-Feira",
				"Quinta-Feira",
				"Sexta-Feira",
				"Sábado"
				};		
		for (int i=0; i<diaSemana.length; i++) {
			assertEquals(diaSemana[i], d.diaDaSemana());
			d.adicionaDias(1);
		}
		
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void teste_eBissexto() {
		int anos[] = {2000, 1600, 1992};
		int i;
		Data d;
		for (i = 0; i < anos.length; i++) {
			d = new Data(anos[i], 02, 02);
			assertTrue(d.eBissexto());
		}
		d = new Data(1900, 02, 02);
		assertFalse(d.eBissexto());
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeProximoDia() {
		Data d = new Data(2018,03,30);
		Data d2 = new Data(2018,03,31);
		
		//Avança dia
		d.proximoDia();
		assertEquals(d2.getDia(), d.getDia());
		assertEquals(d2.getMes(), d.getMes());
		assertEquals(d2.getAno(), d.getAno());
		
		//avanca mes
		d2 = new Data(2018,04,01);
		d.proximoDia();
		assertEquals(d2.getDia(), d.getDia());
		assertEquals(d2.getMes(), d.getMes());
		assertEquals(d2.getAno(), d.getAno());
		
		//avanca ano
		d = new Data(2018,12,31);
		d2 = new Data(2019,01,01);
		d.proximoDia();
		assertEquals(d2.getDia(), d.getDia());
		assertEquals(d2.getMes(), d.getMes());
		assertEquals(d2.getAno(), d.getAno());
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testeDataExtenso() {
		Data d = new Data(2018, 03, 03);
		
		assertEquals("3 de março de 2018", d.porExtenso());
	}
	
	private static final int DEFAULT_TIMEOUT = 4000;

}
