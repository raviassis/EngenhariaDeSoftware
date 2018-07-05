
public class ConcatenaCListaDupAplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CListaDup A = new CListaDup();
		CListaDup B = new CListaDup();
		CListaDup AmaisB;
		A.insereFim(19);
		A.insereFim(33);
		A.insereFim(2);
		A.insereFim(4);
		for (int i = 1; i <= 5; i++) B.insereFim(i);
		AmaisB = ConcatenaArrayList(A,B);
		AmaisB.imprime();
		
	}
	
	/*Ex4*/
	private static CListaDup ConcatenaArrayList(CListaDup a, CListaDup b) {
		// TODO Auto-generated method stub
		CListaDup x = new CListaDup();
		
		for (int i = 1; i <= a.quantidade(); i++) 
			x.insereFim( a.retornaIndice(i) );
		
		for (int i = 1; i <= b.quantidade(); i++) 
			x.insereFim(b.retornaIndice(i));		
		
		return x;				
	}

}
