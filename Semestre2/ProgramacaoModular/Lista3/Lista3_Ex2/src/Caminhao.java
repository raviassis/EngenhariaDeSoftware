
public class Caminhao extends Carro {
	private int carga;
	private static String tipo = "Caminhao";
	
	public Caminhao(int vel, double preco, String cor, int carga2) {
		// TODO Auto-generated constructor stub
		super(vel, preco, cor);
		carga2 = (carga2 < 0) ? 0 : carga2 ;
		setCarga(carga2);
	}

	public int getCarga() {	return carga;	}

	public void setCarga(int carga) {this.carga = carga;}
	
	public static String getTipo() {return tipo;}
	
	@Override
	public double getPrecoVenda() {
		// TODO Auto-generated method stub
		if (carga > 2000 ) {
			return super.getPrecoVenda() * 0.9;
		}
		else return super.getPrecoVenda() * 0.8;		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tipo de veículo: " + getTipo() + "   Cor: " + getCor() +
				"   Velocidade: " + getVelocidade() + "   Preco: " + getPrecoVenda() + "   Carga: " + getCarga(); 
	}
	
	
}
