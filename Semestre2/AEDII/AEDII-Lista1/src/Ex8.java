
public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vet [] = {1,2,3,4,5,6};
		
		System.out.println("Ex8");
		System.out.print("Vetor: ");
		for (int i = 0; i < vet.length; i++) System.out.print("[" + vet[i] + "]");
		System.out.println("");
		vet = ArrayMethods.invertArray(vet);
		
		System.out.print("Vetor invertido: ");
		for (int i = 0; i < vet.length; i++) System.out.print("[" + vet[i] + "]") ;
	}

}
