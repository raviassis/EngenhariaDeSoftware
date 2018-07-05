
public class QNode {
	public static final int EMPTY = 9999998;
	
	public int e1;
	public int e2;
	public int e3;
	
	public QNode n1;
	public QNode n2;
	public QNode n3;
	public QNode n4;
	
	public QNode() {
		this.e1 = this.e2 = this.e3 = this.EMPTY;
		this.n1 = this.n2= this.n3 = this.n4 = null;
	}
	
	public boolean insertElement(int item) {
		
		if(this.nodeFull()) {
			return false;
		}
		else {
			if (this.e1 == this.EMPTY) this.e1 = item;
			else if (this.e2 == this.EMPTY) this.e2 = item;
			else if (this.e3 == this.EMPTY) this.e3 = item;
			int [] vet = {this.e1, this.e2, this.e3};
			vet = Methods.SelectionSort(vet);
			this.e1 = vet[0];
			this.e2 = vet[1];
			this.e3 = vet[2];
			return true;
		}
	}

	private int nItens() {
		// TODO Auto-generated method stub
		int i = 0;
		if(this.e1 != this.EMPTY)i++;
		if(this.e2 != this.EMPTY)i++;
		if(this.e3 != this.EMPTY)i++;
		
		return i;
	}
	
	public boolean nodeFull() {
		return this.nItens() == 3;
	}
	
	public boolean empty() {
		return this.nItens() == 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		if(this.empty()) str.append("[][][]");
		else {
			if(this.e1 != this.EMPTY) str.append("["+this.e1+"]");
			else str.append("[]");
			if(this.e2 != this.EMPTY) str.append("["+this.e2+"]");
			else str.append("[]");
			if(this.e3 != this.EMPTY) str.append("["+this.e3+"]");
			else str.append("[]");
		}
		
		return str.toString();
	}
	
	public boolean contains(int item) {
		return (this.e1 == item) || (this.e2 == item) || (this.e3 == item);
	}
	
	
}
