
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNum igual = (m, n) -> m == n;
	    if( igual.test(5, 5) ) System.out.println("Numeros iguais");
	    if( !igual.test(10, 2) ) System.out.println("Numeros diferentes");

	    TestNum menor = (m, n) -> m > n;
	    if( menor.test(10, 5) ) System.out.println("10 é menor que 5");
	    if( !menor.test(5, 10) ) System.out.println("5 não é menor que 10");

	    TestNum fator = (n, d) -> n % d == 0;
		if( fator.test(10, 2) ) System.out.println("10 é múltiplo de 2");
		if( !fator.test(10, 3) )  System.out.println("10 não é múltiplo de 3");

	}

}
