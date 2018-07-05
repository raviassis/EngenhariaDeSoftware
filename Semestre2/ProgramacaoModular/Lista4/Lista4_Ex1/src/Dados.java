
public class Dados {
	private String nome;
	private String endereco;
	private String telefone;
	private String cep;
	private String cidade;
	private String uf;
	
	public Dados(String nome, String endereco, String telefone, String cep, String cidade, String uf) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		setCep(cep);
		setCidade(cidade);
		setUf(uf);
	}
	
	public Dados() {
		setNome("");
		setEndereco("");
		setTelefone("");
		setCep("");
		setCidade("");
		setUf("");
		
	}
	
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCep() {
		return cep;
	}
	public String getCidade() {
		return cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}
