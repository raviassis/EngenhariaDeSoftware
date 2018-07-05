
public class Ex2_Aplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vet[] = new int[100];
		int vet2[];
		
		for (int i = 0; i < vet.length; i++) 
			vet[i] = (int)(Math.random() * 100);
		
		System.out.println("Ex2");
		
		System.out.println("Vetor Original");
		Methods.printArray(vet);
		
		System.out.println("\nVetor Ordenado - BBSortClassicDesc");
		vet2 = Methods.BBSortClassicDesc(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - BBSortAdap1Desc");
		vet2 = Methods.BBSortAdap1Desc(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - BBSortAdap2Desc");
		vet2 = Methods.BBSortAdap2Desc(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - BBSortAdap3Desc");
		vet2 = Methods.BBSortAdap3Desc(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - SelectionSortDesc");
		vet2 = Methods.SelectionSortDesc(vet);
		Methods.printArray(vet2);
		
		System.out.println("\nVetor Ordenado - InsertionSortDesc");
		vet2 = Methods.insertionSortDesc(vet);
		Methods.printArray(vet2);
	}

}
