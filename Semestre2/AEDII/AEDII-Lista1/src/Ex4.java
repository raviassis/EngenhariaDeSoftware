
public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vet[] = {1,2,3,-4,5,6,7,5,9};
		int n = 5;
		int x = 10;
		
		System.out.println("Ex4");
		System.out.print("Vetor: ");
		for (int i = 0; i < vet.length; i++) System.out.print( "[" + vet[i] + "]");
		System.out.println("");
		
		System.out.println("Posição do elemento " + n + ": " + ArrayMethods.lastIndexOf(vet,n));
		System.out.println("Posição do elemento " + x + ": " + ArrayMethods.lastIndexOf(vet,x));
	}

}
