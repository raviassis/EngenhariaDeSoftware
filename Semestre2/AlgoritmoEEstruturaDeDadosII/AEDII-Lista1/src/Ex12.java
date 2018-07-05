
public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int vet[];
		
		vet = ArrayMethods.fillArray(n, 0);
		
		System.out.println("Ex12");
		System.out.print("Vetor: ");
		for (int i = 0; i < vet.length; i++) {
			System.out.print("[" + vet[i] + "]");
		}
		System.out.println("");
		vet = ArrayMethods.fillArray(n, 1);
		System.out.print("Vetor: ");
		for (int i = 0; i < vet.length; i++) {
			System.out.print("[" + vet[i] + "]");
		}
		System.out.println("");
		
		vet = ArrayMethods.fillArray(n, 2);
		System.out.print("Vetor: ");
		for (int i = 0; i < vet.length; i++) {
			System.out.print("[" + vet[i] + "]");
		}
		System.out.println("");
	}

}
