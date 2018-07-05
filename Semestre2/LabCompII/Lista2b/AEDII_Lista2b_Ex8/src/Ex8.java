import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia1, mes1, ano1, dia2, mes2, ano2;
		Scanner ent = new Scanner(System.in);
		
		System.out.println("Ex8");
		System.out.println("Insira a primeira data");
		System.out.print("Dia: ");
		dia1 = ent.nextInt();
		System.out.print("Mes: ");
		mes1= ent.nextInt();
		System.out.print("Ano: ");
		ano1 = ent.nextInt();
		
		System.out.println("Insira a segunda data");
		System.out.print("Dia: ");
		dia2 = ent.nextInt();
		System.out.print("Mes: ");
		mes2 = ent.nextInt();
		System.out.print("Ano: ");
		ano2 = ent.nextInt();
		
		if (ano1 < ano2) {
			System.out.println(dia1 + "/" + mes1 + "/" + ano1);
			System.out.println(dia2 + "/" + mes2 + "/" + ano2);
		}
		else if (ano2 < ano1) {
			System.out.println(dia2 + "/" + mes2 + "/" + ano2);
			System.out.println(dia1 + "/" + mes1 + "/" + ano1);
		}
		else {
			if (mes1 < mes2) {
				System.out.println(dia1 + "/" + mes1 + "/" + ano1);
				System.out.println(dia2 + "/" + mes2 + "/" + ano2);
			}
			else if (mes2 < mes1) {
				System.out.println(dia2 + "/" + mes2 + "/" + ano2);
				System.out.println(dia1 + "/" + mes1 + "/" + ano1);
			}
			else {
				if (dia1 < dia2) {
					System.out.println(dia1 + "/" + mes1 + "/" + ano1);
					System.out.println(dia2 + "/" + mes2 + "/" + ano2);
				}
				else if (dia2 < dia1) {
					System.out.println(dia2 + "/" + mes2 + "/" + ano2);
					System.out.println(dia1 + "/" + mes1 + "/" + ano1);
				}
				else {
					System.out.println(dia1 + "/" + mes1 + "/" + ano1);
					System.out.println(dia2 + "/" + mes2 + "/" + ano2);
				}
			}
		}
		ent.close();
	}

}
