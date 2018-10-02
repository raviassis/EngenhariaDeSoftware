import java.util.Random;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int [] vet = factoryArray(100);		
		int[] subVet = subMaxArray(vet);		
		
		System.out.println("--- Vetor Original ---");
		System.out.println("Soma: " + somaArray(vet));	
		System.out.println("Media: " + mediaArray(vet));
		System.out.println("Tamanho: " + vet.length);
		
		System.out.println("\n--- SubVetor ---");
		System.out.println("Soma: " + somaArray(subVet));	
		System.out.println("Media: " + mediaArray(subVet));
		System.out.println("Tamanho: " + subVet.length);
		
		if ( somaArray(subVet) >= somaArray(vet)) System.out.println("Subvetor é maior");
		else System.out.println("SubVetor é menor");
		
		
	}
	
	private static int[] subMaxArray(int[] vet) {
		// TODO Auto-generated method stub
		double media = mediaArray(vet);
		int somaVet = somaArray(vet);
		int tam = contMaiorQue(media, vet);
		int [] subVet = new int[tam];
		
		for (int i = 0, j = 0; (i < vet.length) && (j < subVet.length); i++) {
			if (vet[i] > media) {
				subVet[j] = vet[i];
				j++;
			}
		}
		
		return subVet;
	}

	private static int contMaiorQue(double media, int[] vet) {
		// TODO Auto-generated method stub
		int cont = 0;
		
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] > media) cont++;
		}
		
		return cont;
	}

	private static int somaArray(int[] vet) {
		// TODO Auto-generated method stub
		int soma = 0;
		
		for (int i = 0; i < vet.length; i++) {
			soma += vet[i];
		}
		
		return soma;
	}

	private static double mediaArray(int[] vet) {
		// TODO Auto-generated method stub
		int soma = 0;
		for (int i = 0; i < vet.length; i++){
			soma+= vet[i];
		}
		return (double)soma / (double)vet.length;
	}

	private static int [] factoryArray(int n){
		int [] vet = new int[n];
		Random r = new Random();
		
		for(int i = 0; i < vet.length; i++){
			vet[i] = r.nextInt() % 10000;
			//vet[i] = r.nextInt(10000);
		}
		
		return vet;
	}
	
	private static int [] factoryArray2(){
		int [] vet = {-3, 15, 2, 10, 8, -6, 20, -30, 10};
		return vet;
	}
	
}
