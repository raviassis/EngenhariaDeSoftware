
public class ExemploArvBin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CArvBin ab = new CArvBin();
       ab.inserir(10);
       ab.inserir(15);
       ab.inserir(5);
       ab.inserir(12);
       ab.imprimir(9);
       System.out.println("Profundidade item 12 = " + ab.profundidade(12));
       System.out.println("Altura item 15 = " + ab.altura(15));
       System.out.println("Fator de balanceamento = " + ab.fb(15));
       
       ab.imprimeInfoNo();
       
       
	}

}
