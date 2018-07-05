import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Ex_Stream {
	
	public static void main(String args[]) {
		List<Integer> numeros = Arrays.asList(1,2,3,4,5);
		
		numeros.stream()
				.filter( n -> n > 2)
				.forEach(System.out::println);
		
		//Equivalente
		/*for (Integer n : numeros) {
			if( n > 2) System.out.println(n);
		}*/
	}
	
}
