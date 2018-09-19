
public class Application {

	private static int quantidade = 100000;	

	private static double[] expQuickSort = new double[10];
	private static double[] expHeapSort = new double[10];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start, end;
		int [] vetor;        
		for (int i = 1; i <= 10; i++) {			

			vetor = factoryRandomArray(quantidade);
			start = System.currentTimeMillis();
	        QuickSort.sort(vetor);
	        end = System.currentTimeMillis();		        
	        
	        expQuickSort[i-1] = end - start;
	        
	        vetor = factoryRandomArray(quantidade);
			start = System.currentTimeMillis();
	        HeapSort.sort(vetor);
	        end = System.currentTimeMillis();		        
	 
	        expHeapSort[i-1] = end -start;

		}
		

		System.out.println("Média do Quick Sort = " + media(expQuickSort));

		System.out.println("Desvio padrão Quick Sort = " + desvioPadrao(expQuickSort));		

		System.out.println("\nMédia do Heap Sort = " + media(expHeapSort));

		System.out.println("Desvio padrão Heap Sort = " + desvioPadrao(expHeapSort));
		
	}
	
	private static int [] factoryRandomArray(int tam){

		int [] vet = new int[tam];

		

		for (int i = 0; i < vet.length; i++) {

			vet[i] = (int) ( Math.random() * tam);

            

		}

		

		return vet;

	}

	

	private static double media(double [] vet){

		

		double soma = 0;

		

		for (int i = 0; i < vet.length; i++) {

			soma += vet[i]; 

		}

		

		return soma / vet.length;

	}

	

	private static double desvioPadrao(double [] vet){

		double media = media(vet);

		double desvio = 0;

		int tam = vet.length;

		

		for (double vlr : vet) {

	        double aux = vlr - media;

	        desvio += aux * aux;

	    }

	    return Math.sqrt(desvio / (tam - 1));

	}

}
