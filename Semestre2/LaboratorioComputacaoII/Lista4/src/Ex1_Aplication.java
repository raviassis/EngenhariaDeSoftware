
public class Ex1_Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vet[] = new int[100];
		int vet2[];
		
		for (int i = 0; i < vet.length; i++) 
			vet[i] = (int)(Math.random() * 100);
		
		System.out.println("Ex1");
		
		System.out.println("Vetor Original");
		Methods.printArray(vet);
		
		
		System.out.println("\nVetor Ordenado - BBSortClassic");
		vet2 = Methods.BBSortClassic(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - BBSortAdap1");
		vet2 = Methods.BBSortAdap1(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - BBSortAdap2");
		vet2 = Methods.BBSortAdap2(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - BBSortAdap3");
		vet2 = Methods.BBSortAdap3(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - SelectionSort");
		vet2 = Methods.SelectionSort(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - InsertionSort");
		vet2 = Methods.insertionSort(vet);
		Methods.printArray(vet2);
		
		
		
	}	
	

}
