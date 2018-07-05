
public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia, mes, ano, tam=10;
		Data [] lista = new Data[tam];
		Data [] listaAux = new Data[tam];
		
		System.out.println("Lista Original");
		for (int i = 0; i < lista.length; i++) {
			
			do {
				dia = (int)(Math.random() * 28);
				mes = (int)(Math.random() * 12);
				ano = 2000 + (int)(Math.random() * 100);
			} while (dia == 0 || mes == 0 || ano == 0);			
			
			lista[i] = new Data(ano, mes, dia);
			System.out.println(lista[i].porExtenso());
		}
		System.out.println("---------------------------");
		System.out.println();
		listaAux = (Data[]) Ordenador.crescente(lista);
		
		System.out.println("Lista crescente");
		for (int i = 0; i < listaAux.length; i++) {
			System.out.println(  listaAux[i].porExtenso() );
		}
		System.out.println("---------------------------");
		System.out.println();
		
		listaAux = (Data[]) Ordenador.decrescente(lista);
		System.out.println("Lista decrescente");
		for (int i = 0; i < listaAux.length; i++) {
			System.out.println( listaAux[i].porExtenso() );
		}
		System.out.println("---------------------------");
		System.out.println();
		
	}

}
