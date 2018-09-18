package quickSort;

public class QuickSort {
	
	public static void sort(int [] vetor){
		sort(vetor, 0, vetor.length-1);
	}
	
	public static void sort(int [] vetor, int inicio, int fim){
		if (inicio < fim) {
            int posicaoPivo = split(vetor, inicio, fim);
            sort(vetor, inicio, posicaoPivo - 1);
            sort(vetor, posicaoPivo + 1, fim);
		}
	}
	
	private static int split(int [] vetor, int inicio, int fim){
		int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
               if (vetor[i] <= pivo)
                      i++;
               else if (pivo < vetor[f])
                      f--;
               else {
                      int troca = vetor[i];
                      vetor[i] = vetor[f];
                      vetor[f] = troca;
                      i++;
                      f--;
               }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
	}
}
