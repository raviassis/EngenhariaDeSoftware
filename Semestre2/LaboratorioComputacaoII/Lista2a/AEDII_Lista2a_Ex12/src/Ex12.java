import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		double compra, parcelas, valorParcelas, juros = 0.12, total;
		
		System.out.println("Calcula valor compra parcelada");
		System.out.print("Informe o valor da compra: ");
		compra = ent.nextDouble();
		
		System.out.print("Informe o número de parcelas: ");
		parcelas = ent.nextDouble();
		
		total = compra * (1 + juros);
		
		valorParcelas = total / parcelas;
		
		System.out.println("Valor das parcelas: " + valorParcelas);
		
		ent.close();

	}

}
