
/**
* @(#)Endereco.java
*
*
* @author Ravi Assis
* @version 1.00 2018/5/1
*/

public class Endereco {
	public String rua;
	public String numero;
	public String complemento;
	public String bairro;
	public String cidade;
	public String estado;
	public String cep;
	
	//Retorna o endereco em forma de string
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rua: " + this.rua + ", " + this.numero + ", " + this.complemento + " Bairro: " + this.bairro + "\n" +
				"Cidade: " + this.cidade + " Estado: " + this.estado + " Cep: " + this.cep;
	}
	
	
}
