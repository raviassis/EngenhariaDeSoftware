
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test<Integer> testInt = (m, n) -> m == n;
		if( testInt.igual(5, 5) )
		System.out.println("Numeros iguais");

		Test<String> testStr = (s1, s2) -> s1.compareTo(s2) == 0 ;
		if( testStr.igual("abc", "abc") )
		System.out.println("Frases iguais");

	}

}
