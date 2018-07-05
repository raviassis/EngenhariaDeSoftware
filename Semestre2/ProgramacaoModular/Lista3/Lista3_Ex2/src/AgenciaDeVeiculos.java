import javax.swing.JOptionPane;

public class AgenciaDeVeiculos {
	
	public static void exibirAgencia(Carro [] lista) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < lista.length; i++) {
			str.append(lista[i].toString() + "\n");
		}
		JOptionPane.showMessageDialog(null, str, "Agencia de Veículos", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carro [] listaCarros = new Carro[6];
		listaCarros [0] = new Caminhao(90, 90000, "Preto", 1500);
		listaCarros[1] = new Caminhao(80, 90000, "Cinza", 2500);
		listaCarros[2] = new Fiat(120, 45000, "Vermelho", 3000);
		listaCarros[3] = new Fiat(150, 45000, "Amarelo", 4500);
		listaCarros[4] = new Sedan(160, 60000, "Verde", 7);
		listaCarros[5] = new Sedan(160, 60000, "Marrom", 5);
		
		exibirAgencia(listaCarros);
		
	}

}
