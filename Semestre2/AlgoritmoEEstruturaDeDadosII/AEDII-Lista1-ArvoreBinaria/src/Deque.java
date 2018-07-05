
public class Deque {
	private CCelulaDup left;
	private CCelulaDup right;
	private int qntd;
	
	Deque(){
		this.left = this.right = new CCelulaDup();
		this.qntd = 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return this.left == this.right;
	}

	public void pushLeft(Object item) {
		// TODO Auto-generated method stub
		if ( this.isEmpty() ) this.pushRight(item);
		else {
			this.left.prox = new CCelulaDup(item, this.left, this.left.prox);
			this.left.prox.prox.ant = this.left.prox;
			this.qntd++;
		}
		
	}
	
	public void pushRight(Object item) {
		this.right.prox = new CCelulaDup(item, right, null);
		this.right = this.right.prox;
		this.qntd++;
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.qntd;
	}

	public Object popLeft() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			return null;
		}
		else if ( this.left.prox.prox == null) return this.popRight();
		else {
			CCelulaDup cel = this.left.prox;
			this.left.prox = this.left.prox.prox;
			this.left.prox.ant = this.left;
			cel.prox = cel.ant = null;
			this.qntd--;
			return cel.item;
		}
		
	}

	public Object popRight() {
		// TODO Auto-generated method stub
		if( this.isEmpty() ) return null;
		else {
			CCelulaDup cel = this.right;
			this.right = this.right.ant;
			this.right.prox = null;
			cel.prox = cel.ant = null;
			this.qntd--;
			return cel.item;
		}
	}

}
