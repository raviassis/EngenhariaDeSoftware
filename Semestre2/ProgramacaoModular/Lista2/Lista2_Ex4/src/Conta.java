
public class Conta {
	private static int contador = 0;
	private int numConta;
	private String titular;
	private double saldo;

	public Conta(int numConta, String titular) {
		this.numConta = numConta;
		this.titular = titular;
		this.saldo = 0.00;
		contador = contador + 1;
	}

	public int getNumero() {return this.numConta;}

	public String getTitular() {return this.titular;}

	public double getSaldo() {return this.saldo;}

	public boolean depositar(double deposito) {
		if(deposito < 0) {
			return false;
		}
		this.saldo += deposito;
		return true;
	}

	public boolean sacar(double saque) {
		// TODO Auto-generated method stub
		if(saque < 0 || saque > this.saldo) {
			return false;
		}
		this.saldo -= saque;
		return true;
	}

	public static int getContador() {
		// TODO Auto-generated method stub
		return contador;
	}
	

}
