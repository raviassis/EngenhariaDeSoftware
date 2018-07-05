
public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vet[] = {1,2,3,4,5,6,7,8,9};
		int esq = 2;
		int dir = 6;
		
		System.out.println("Ex9");
		System.out.println("Vetor: ");
		for (int i = 0; i < vet.length; i++) {
			System.out.print("["+vet[i]+"]");
		}
		System.out.println("");
		vet = ArrayMethods.arrayPart(vet, esq, dir);
		
		System.out.print("Parte vetor: ");
		if (vet != null) {
			for (int i = 0; i < vet.length; i++) {
				System.out.print("["+vet[i]+"]");
			}
		}
		else System.out.println("nulo");
		
	}

}
