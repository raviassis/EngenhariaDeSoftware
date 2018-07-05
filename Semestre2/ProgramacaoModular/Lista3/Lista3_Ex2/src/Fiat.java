
public class Fiat extends Carro {
	private int descontoDeFabrica ;
	private static String tipo = "Fiat";
	
	public Fiat(int vel, double p, String c, int descontoFabrica) {
		super(vel, p, c);
		
		descontoFabrica = (descontoFabrica < 0) ? 0 : descontoFabrica ;
		setDescontoDeFabrica(descontoFabrica);
	}

	public int getDescontoDeFabrica() {	return descontoDeFabrica;	}

	public void setDescontoDeFabrica(int descontoDeFabrica) {this.descontoDeFabrica = descontoDeFabrica;}
	
	public static String getTipo() {return tipo;}

	@Override
	public double getPrecoVenda() {
		// TODO Auto-generated method stub
		return super.getPrecoVenda() - (double) this.descontoDeFabrica;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tipo de veículo: " + getTipo() + "   Cor: " + getCor() +
				"   Velocidade: " + getVelocidade() + "   Preco: " + getPrecoVenda() + "   Valor do desconto de Fábrica: " + getDescontoDeFabrica(); 
	}
	
}
