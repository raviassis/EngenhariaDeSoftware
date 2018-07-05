
public class Ex3_Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] vet = {
				"Ravi",
				"Theo",
				"Leticia",
				"Antonio",
				"Matheus",
				"Gustavo",
				"Julia",
				"Renata",
				"Sara",
				"Alison"
		};
		String [] vet2;
		
		System.out.println("Ex3");
		
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
