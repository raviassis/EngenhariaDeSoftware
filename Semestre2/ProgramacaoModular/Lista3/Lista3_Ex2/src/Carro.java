
public class Carro {
	private int velocidade;
	private double preco;
	private String cor;
	//private static String tipo = "none";
	
	public Carro (int vel, double p, String c){
		vel = (vel < 0) ? 0 : vel; 
		setVelocidade(vel);
		setPreco(p);
		setCor(c);
	}
	
	public int getVelocidade() {return velocidade;	}
	public void setVelocidade(int velocidade) {	this.velocidade = velocidade;	}
	public double getPreco() {return preco;	}
	public void setPreco(double preco) {this.preco = preco;	}
	public String getCor() {return cor;	}
	public void setCor(String cor) {this.cor = cor;	}
	public static String getTipo() {return "none";}

	public double getPrecoVenda() {
		// TODO Auto-generated method stub
		return getPreco();
	}
	
	public String toString() {
		return "Tipo de veículo: " + getTipo() + "   Cor: " + getCor() + "   Velocidade: " + getVelocidade() + "   Preco: " + getPrecoVenda();
	}

		
	
	
}
