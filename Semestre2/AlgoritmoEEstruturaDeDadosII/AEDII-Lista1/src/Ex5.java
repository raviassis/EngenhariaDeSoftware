
public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vet[] = {1,2,3,-4,5,6,7,5,9};
		int n = 5;
		int x = 10;
		
		System.out.println("Ex5");
		System.out.print("Vetor: ");
		for (int i = 0; i < vet.length; i++) System.out.print( "[" + vet[i] + "]");
		System.out.println("");
		
		System.out.println("Quantidade de elementos " + n + " tem no vetor: " + ArrayMethods.countElements(vet, n));
		System.out.println("Quantidade de elementos " + x + " tem no vetor: " + ArrayMethods.countElements(vet, x));
	}

}
