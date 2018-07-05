import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		int mediana, amplitude, maior, menor, num[] = new int[3];
		double mediaAritimetica = 0;
		
		System.out.println("Ex13");
		System.out.print("Informe o primeiro número: ");
		num[0] = ent.nextInt();
		System.out.print("Informe o segundo número: ");
		num[1] = ent.nextInt();
		System.out.print("Informe o terceiro número: ");
		num[2] = ent.nextInt();
		ent.close();
		mediana = num[1];
		
		maior = menor = num[0];
		
		for (int i = 0; i < num.length; i++) {
			maior = (maior < num[i]) ? num[i] : maior;
			menor = (menor > num[i]) ? num[i] : menor;
			mediaAritimetica += num[i];
		}
		
		amplitude = maior - menor;
		mediaAritimetica = mediaAritimetica/num.length;
		
		System.out.println("Mediana: " + mediana);
		System.out.println("Amplitude: " + amplitude);
		System.out.println("Media Aritimetica: " + mediaAritimetica);
		
	}

}
