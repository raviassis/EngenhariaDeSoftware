
public class CListaSimples {
	private CCelulaSimples primeira, ultima;
	
	public CListaSimples() {
		this.primeira = this.ultima = null;
	}
	
	public boolean vazia() {
		return this.primeira == null && this.ultima == null ;
	}
	
	public void insereComeco(int valorItem) {
		if(this.vazia()) {
			this.primeira = new CCelulaSimples();
			this.ultima = this.primeira;
			this.primeira.item = valorItem;
			this.primeira.prox = null;
		}
		else {
			CCelulaSimples tmp = new CCelulaSimples();
			tmp.item = valorItem;
			tmp.prox = this.primeira;
			this.primeira = tmp;
		}
	}
	
	public Object removeComeco() {
		if (this.vazia()) return null;
		else {
			CCelulaSimples resp = new CCelulaSimples();
			resp = this.primeira;
			this.primeira = this.primeira.prox;
			if (this.primeira == null) this.ultima = null;
			return resp.item;
		}
	}
	
	public void insereFim(int valorItem) {
		if (this.vazia()) {
			this.primeira = new CCelulaSimples();
			this.ultima = this.primeira;
			this.primeira.item = valorItem;
			this.primeira.prox = null;
		}
		else {
			CCelulaSimples aux = new CCelulaSimples();
			aux.item = valorItem;
			aux.prox = null;
			this.ultima.prox = aux;
			this.ultima = this.ultima.prox;			
		}
	}
	
	public Object removeFim() {
		if (this.vazia()) return null;
		else if (this.primeira == this.ultima) {			
			CCelulaSimples resp = this.primeira;
			this.primeira = this.ultima = null;
			return resp.item;
		}
		else {
			CCelulaSimples aux = this.primeira;
			CCelulaSimples resp ;
			while (aux.prox != this.ultima) {
				aux = aux.prox;							
			}
			resp = this.ultima;
			this.ultima = aux;
			this.ultima.prox = null;
			return resp.item;
		}
		
	}
	
	public void imprime() {
		CCelulaSimples tmp = this.primeira;
		while (tmp != null) {
			System.out.print(tmp.item + " ");
			tmp = tmp.prox;
		}
	}
	
	public boolean contem(Object elemento) {
		if (this.vazia()) return false;
		else {
			CCelulaSimples tmp = this.primeira;
			while(tmp != null) {
				if (elemento.equals(tmp.item)) return true;
				tmp = tmp.prox;
			}
			return false;
		}
	}
}
