import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest {

	@Test
	public void test1Contador() {
		int numConta = 2244;
		String titular = "Ravi Assis";
		
		assertEquals(0, Conta.getContador() );
		Conta cc = new Conta(numConta, titular);
		assertEquals(1, Conta.getContador() );
	}

	@Test
	public void testConstrutor() {
		int numConta = 2244;
		String titular = "Ravi Assis";
		Conta cc = new Conta(numConta, titular);
		construtorHelper(cc, numConta, titular);
	}
	
	@Test
	public void testDepositar_DepositoPositivo() {
		int numConta = 2244;
		String titular = "Ravi Assis";
		Conta cc = new Conta(numConta, titular);
		double deposito = 100.00;
		
		depositarHelper_Positivo(cc, deposito);		
	}
	
	@Test
	public void testDepositar_DepositoNegativo() {
		int numConta = 2244;
		String titular = "Ravi Assis";
		Conta cc = new Conta(numConta, titular);
		double deposito = -100.00;
		
		depositarHelper_Negativo(cc, deposito);
	}
	
	@Test
	public void testSacar_SaquePositivo() {
		int numConta = 2244;
		String titular = "Ravi Assis";
		Conta cc = new Conta(numConta, titular);
		double saque = 100.00;
		cc.depositar(100.00);
		
		sacarHelper_Positivo(cc, saque);
	}
	
	@Test
	public void testSacar_SaqueNegativo() {
		int numConta = 2244;
		String titular = "Ravi Assis";
		Conta cc = new Conta(numConta, titular);
		double saque = -100.00;
		cc.depositar(100.00);
		
		sacarHelper_Negativo(cc, saque);
	}
	
	@Test
	public void testSacar_SemSaldo() {
		int numConta = 2244;
		String titular = "Ravi Assis";
		Conta cc = new Conta(numConta, titular);
		double saque = 100.00;
		cc.depositar(50.00);
		
		sacarHelper_SemSaldo(cc, saque);
	}
	


	/*Helpers*/
	
	private void sacarHelper_SemSaldo(Conta cc, double saque) {
		double saldoAnt = cc.getSaldo();
		assertFalse("Error: Saque em conta sem saldo foi realizado",cc.sacar(saque));
		assertFalse("Error: Proibido saque negativo",saldoAnt < cc.getSaldo());
		assertEquals("Error: Saldo posterior não condiz com o anterior", saldoAnt, cc.getSaldo(), 0);			
	}
	
	private void sacarHelper_Negativo(Conta cc, double saque) {
		double saldoAnt = cc.getSaldo();
		assertFalse("Error: Saque negativo foi realizado",cc.sacar(saque));
		assertFalse("Error: Proibido saque negativo",saldoAnt < cc.getSaldo());
		assertEquals("Error: Saldo posterior não condiz com o anterior", saldoAnt, cc.getSaldo(), 0);		
	}
	
	private void sacarHelper_Positivo(Conta cc, double saque) {
		double saldoAnt = cc.getSaldo();
		assertTrue("Error: Saque não realizado",cc.sacar(saque));
		assertFalse("Error: Realizado saque de Conta sem saldo suficiente", cc.getSaldo() < 0.00);
		assertEquals("Error: Saldo posterior não condiz com o valor sacado", saldoAnt - saque, cc.getSaldo(), 0);
	}
	
	public void construtorHelper(Conta cc, int numConta, String titular) {
		assertEquals(numConta, cc.getNumero());
		assertEquals(titular, cc.getTitular());
		assertEquals(0, cc.getSaldo(), 0);
	}
	
	public void depositarHelper_Positivo (Conta cc, double deposito) {
		double saldoAnt = cc.getSaldo();
		assertTrue("Error: Deposito não realizado",cc.depositar(deposito));
		assertFalse("Error: Saldo anterior nao pode ser maior que o saldo atual", saldoAnt > cc.getSaldo());
		assertEquals("Error: Saldo posterior não condiz com o valor depositado ",deposito + saldoAnt, cc.getSaldo(), 0);
	}
	
	public void depositarHelper_Negativo (Conta cc, double deposito) {
		double saldoAnt = cc.getSaldo();
		assertFalse("Error: Deposito foi realizado",cc.depositar(deposito));
		assertFalse("Error: Saldo anterior nao pode ser maior que o saldo atual", saldoAnt > cc.getSaldo());
		assertEquals("Error: Saldo posterior não condiz com o anterior", saldoAnt, cc.getSaldo(), 0);
	}
	

}
