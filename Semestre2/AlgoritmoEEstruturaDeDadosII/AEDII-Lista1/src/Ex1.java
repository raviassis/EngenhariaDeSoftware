
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vet[] = {1,2,3,4,5,6,7,8,9};
		
		System.out.println("Ex1");
		System.out.print("Vetor: ");
		for (int i = 0; i < vet.length; i++) System.out.print( "[" + vet[i] + "]");
		System.out.println("");
		System.out.println("Soma: " + ArrayMethods.sum(vet));
	}

}
