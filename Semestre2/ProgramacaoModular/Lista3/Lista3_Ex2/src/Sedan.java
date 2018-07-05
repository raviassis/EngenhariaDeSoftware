
public class Sedan extends Carro {
	private int comprimento;
	private static String tipo = "Sedan";
	
	public Sedan(int vel, double p, String c, int comp) {
		super(vel, p, c);
		// TODO Auto-generated constructor stub
		
		comp = (comp < 0) ? 0 : comp;
		setComprimento(comp);
	}
	
	public int getComprimento() {return comprimento;}

	public void setComprimento(int comprimento) {this.comprimento = comprimento;}
	
	public static String getTipo() {return tipo;}

	@Override
	public double getPrecoVenda() {
		// TODO Auto-generated method stub
		if (getComprimento() > 6) {
			return super.getPrecoVenda() * 0.95;
		}
		else return super.getPrecoVenda() * 0.9;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tipo de veículo: " + getTipo() + "   Cor: " + getCor() +
				"   Velocidade: " + getVelocidade() + "   Preco: " + getPrecoVenda() + "   Comprimento do carro: " + getComprimento(); 
	}
	
	
}
