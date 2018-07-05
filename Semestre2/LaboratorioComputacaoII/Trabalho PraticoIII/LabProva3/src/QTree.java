
public class QTree {
	private QNode root;
	
	public QTree() {
		this.root = null;
	}
	
	public boolean empty() {
		return this.root == null;
	}
	
	public void insert(int item) {
		insert(item, this.root);
	}

	private void insert(int item, QNode node) {
		// TODO Auto-generated method stub
		if (this.empty()) {
			this.root = new QNode();
			this.root.insertElement(item);
		}
		else {
			if ( node.insertElement(item) ) return;
			else if ( item < node.e1) {
				if (node.n1 == null) { 
					node.n1 = new QNode();
					node.n1.insertElement(item);
				}
				else this.insert(item, node.n1);
			}
			else if (item < node.e2) {
				if (node.n2 == null) {
					node.n2 = new QNode();
					node.n2.insertElement(item);
				}
				else this.insert(item, node.n2);
			}
			else if (item < node.e3) {
				if (node.n3 == null) {
					node.n3 = new QNode();
					node.n3.insertElement(item);
				}
				else this.insert(item, node.n3);
			}
			else {
				if (node.n4 == null) {
					node.n4 = new QNode();
					node.n4.insertElement(item);
				}
				else this.insert(item, node.n4);
			}
		}
	}
	
	
	public void printInOrder() {
		printInOrder(this.root);
	}

	private void printInOrder(QNode node) {
		// TODO Auto-generated method stub
		if (node != null) {
			printInOrder(node.n1);
			if (node.e1 != QNode.EMPTY) System.out.print("["+node.e1+"]");
			printInOrder(node.n2);
			if (node.e2 != QNode.EMPTY) System.out.print("["+node.e2+"]");
			printInOrder(node.n3);
			if (node.e3 != QNode.EMPTY) System.out.print("["+node.e3+"]");
			printInOrder(node.n4);
		}
	}
	
	public void printInLevels() {
		
		int hTree = 0;
		if ( !this.empty())
			hTree = this.height(this.root.e1);
		for (int i = 1; i <= hTree; i++) {
			printLevel(i);
		}
	}

	public void printLevel(int lvl) {
		// TODO Auto-generated method stub
		printLevel(this.root, lvl);
		System.out.println();
	}

	private void printLevel(QNode node, int lvl) {
		// TODO Auto-generated method stub
		if (node != null) {
			int depth = depth(node.e1);
			if( depth == lvl) {
				System.out.print(node + " ");
			}
			else if (depth < lvl) {
				printLevel(node.n1, lvl);
				printLevel(node.n2, lvl);
				printLevel(node.n3, lvl);
				printLevel(node.n4, lvl);
			}
		}
	}

	public boolean contains(int item) {
		return contains(item, this.root);
	}

	private boolean contains(int item, QNode node) {
		// TODO Auto-generated method stub
		if(node != null) {
			if(item == node.e1) return true;
			else if (item == node.e2) return true;
			else if (item == node.e3) return true;
			else if (item < node.e1) return contains(item, node.n1);
			else if (item < node.e2) return contains(item, node.n2);
			else if (item < node.e3) return contains(item, node.n3);
			else return contains(item, node.n4);
		}
		return false;
	}
	
	public int depth(int item) {
		return depth(item, this.root, 1);
	}
	
	private int depth(int item, QNode node, int depth) {
		// TODO Auto-generated method stub
		if(this.empty()) return 0;
		else if(node.contains(item)) return depth;
		else if (item < node.e1) return depth(item, node.n1, depth+1);
		else if (item < node.e2) return depth(item, node.n2, depth+1);
		else if (item < node.e3) return depth(item, node.n3, depth+1);
		else if (item > node.e3) return depth(item, node.n4, depth+1);
		return 0;
	}
	
	public int height(int item) {
		return height(searchNode(item), 0);
	}
	
	private int height(QNode node, int height) {
		// TODO Auto-generated method stub
		if(this.empty()) return 0;
		else if (node == null) return height;
		else {
			int [] vetH =  new int[4];
			vetH[0] = height(node.n1, height+1);
			vetH[1] = height(node.n2, height+1);
			vetH[2] = height(node.n3, height+1);
			vetH[3] = height(node.n4, height+1);
			int bigger = vetH[0];
			
			for (int i= 0; i < vetH.length; i++) {
				bigger = (bigger < vetH[i]) ? vetH[i] : bigger;
			}			
			return bigger;
		}
	}
	
	public QNode searchNode(int item) {
		return searchNode(item, this.root);
	}

	private QNode searchNode(int item, QNode node) {
		// TODO Auto-generated method stub
		if (this.empty() || node == null)
			return null;
		else if (node.contains(item))
			return node;
		else if (item < node.e1) return searchNode(item, node.n1);
		else if (item < node.e2) return searchNode(item, node.n2);
		else if (item < node.e3) return searchNode(item, node.n3);
		else if (item > node.e3) return searchNode(item, node.n4);
		return null;
	}
	
}
