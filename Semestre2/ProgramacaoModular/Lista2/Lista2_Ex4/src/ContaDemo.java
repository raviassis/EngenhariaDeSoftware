
public class ContaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aplicação Clase Conta");
		
		System.out.print("Contas existentes no momento: ");
		System.out.println(Conta.getContador());
		
		
		Conta cc = new Conta(2234, "Ravi Assis");
				
		System.out.println("Conta nova Criada");
		System.out.println("Titular: " + cc.getTitular());
		System.out.println("Numero da conta: " + cc.getNumero());
		System.out.println("Saldo atual: " + cc.getSaldo());
		System.out.println();
		
		System.out.println("Realizar deposito de 100 reais.");
		cc.depositar(100.00);
		System.out.println("Saldo atual: " + cc.getSaldo());
		System.out.println("Sacar 40 reais");
		cc.sacar(40.00);
		System.out.println("Saldo atual: " + cc.getSaldo());
		System.out.println();
		System.out.print("Contas existentes no momento: ");
		System.out.println(Conta.getContador());
	}

}
