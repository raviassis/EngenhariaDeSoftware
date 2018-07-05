
public class Aplication {
	
	public static void imprimir(Cliente [] lista) {
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i].getNome());
		}
		System.out.println("--------------------");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String doc = "99999999999";
		String tipo = "Pessoa Física";
		Cliente [] listaClientes = {
				new Cliente("Ravi Assis", 15 + (int)(Math.random()*50) , "Masculino", tipo, doc ),
				new Cliente("Theo Assis", 15 + (int)(Math.random()*50) , "Masculino", tipo, doc ),
				new Cliente("Julio", 15 + (int)(Math.random()*50) , "Masculino", tipo, doc ),
				new Cliente("Leticia Rodrigues", 15 + (int)(Math.random()*50) , "Feminino", tipo, doc ),
				new Cliente("Elizabety Lemos", 15 + (int)(Math.random()*50) , "Feminino", tipo, doc ),
				new Cliente("Lucilene Gonçalves", 15 + (int)(Math.random()*50) , "Feminino", tipo, doc ),
				new Cliente("Matheus Medeiros", 15 + (int)(Math.random()*50) , "Masculino", tipo, doc ),
				new Cliente("Roger Henrique", 15 + (int)(Math.random()*50) , "Masculino", tipo, doc ),
				new Cliente("Antonio Nunes", 15 + (int)(Math.random()*50) , "Masculino", tipo, doc ),
				new Cliente("Gabriela", 15 + (int)(Math.random()*50) , "Feminino", tipo, doc )	
		};
		Cliente [] listaAux = new Cliente[listaClientes.length];

		System.out.println("Lista Original");
		imprimir(listaClientes);
		
		System.out.println("Lista Crescente");
		listaAux = (Cliente[]) Ordenador.crescente(listaClientes);
		imprimir( listaAux);
		
		System.out.println("Lista Decrescente");
		listaAux = (Cliente[]) Ordenador.decrescente(listaClientes);
		imprimir(listaAux);
	}

}
