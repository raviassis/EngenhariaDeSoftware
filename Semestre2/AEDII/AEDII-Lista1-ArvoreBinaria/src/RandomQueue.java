
public class RandomQueue {
	private CCelula primeira;  // Referencia a célula cabeça
	private CCelula ultima; // Referencia a última célula da lista
	private int qtde;
	
	RandomQueue(){
		this.ultima = this.primeira = new CCelula();
		this.qtde = 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.primeira == this.ultima;
	}

	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		this.ultima.prox = new CCelula(item);
		this.ultima = ultima.prox;
		this.qtde++;
	}

	public Object sample() {
		// TODO Auto-generated method stub
		if ( this.isEmpty() ) return null;
		else if ( this.qtde == 1) return ultima.item;
		else {
			int index = this.indexRandom(); 
			CCelula atual = this.primeira.prox;
			CCelula anterior = this.primeira;
			
			for (int i = 0; i < index; i++) {
				atual = atual.prox; 
				anterior = anterior.prox;
			}			
			return atual.item;
		}
	}

	public Object dequeue() {
		// TODO Auto-generated method stub
		if( this.isEmpty() ) return null;
		else if ( this.qtde == 1) {
			CCelula aux = ultima;
			ultima = primeira;
			this.qtde--;
			aux.prox = null;
			return aux.item;
		}
		else {
			int index = this.indexRandom(); 
			CCelula atual = this.primeira.prox;
			CCelula anterior = this.primeira;
			
			for (int i = 0; i < index; i++) {
				atual = atual.prox; 
				anterior = anterior.prox;
			}			
			anterior.prox = atual.prox;
			if (atual.prox == ultima.prox) ultima = anterior;
			atual.prox = null;
			this.qtde--;
			return atual.item;
			
		}
	}
	
	public int indexRandom() {
		if (this.qtde == 0) return 0;
		else {
			return 1 + (int)(Math.random() * (this.qtde -1));
		}
	}
	   
}
