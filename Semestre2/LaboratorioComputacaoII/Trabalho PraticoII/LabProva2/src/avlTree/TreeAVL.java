package avlTree;

/**
 * @author Ravi Assis
 * 
 */

public class TreeAVL {
	private KNode root;
	
	public TreeAVL() {
		this.root = null;
	}
	
	public void insert(int key, Object value) {
		KNode newNode = new KNode(key, value);
		insert(newNode, this.root);
		this.checkBalancing();
	}

	private void insert(KNode newNode, KNode iNode) {
		// TODO Auto-generated method stub
		if( this.empty() ) this.root = newNode;
		else {
			if(newNode.key < iNode.key) {
				if(iNode.left == null) iNode.left = newNode;
				else insert(newNode, iNode.left);
			}
			else if(newNode.key > iNode.key) {
				if(iNode.right == null) iNode.right = newNode;
				else insert(newNode, iNode.right);
			}
		}
	}
	
	public Object remove(int key) {
		Object item = remove(key, null, this.root);
		this.checkBalancing();
		return item;
	}

	private Object remove(int key, KNode nFather, KNode nSon) {
		// TODO Auto-generated method stub
		if (nSon == null) return null;
		else if(key == nSon.key) {
			if(nFather == null) {
				if(nSon.right != null && nSon.left != null) {
					KNode nMostLeft = nSon.right;
					KNode nFMLeft = nSon;
					while(nMostLeft.left != null) {
						nFMLeft = nMostLeft;
						nMostLeft = nMostLeft.left;
					}
					nMostLeft.left = nSon.left; 
					this.root = nMostLeft;
					nFMLeft.left = nMostLeft.right;
					nMostLeft.right = nSon.right;
					nSon.left = nSon.right = null;
					return nSon.value;
				}
				else if (nSon.left != null) {
					this.root = nSon.left;
					return nSon.value;
				}
				else if (nSon.right != null) {
					this.root = nSon.right;
					return nSon.value;
				}
				else {
					this.root = null;
					return nSon.value;
				}
			}
			else if (nFather.left != null && nFather.left.key == nSon.key) {
				if(nSon.right != null && nSon.left != null) {  // node with two descendants
					KNode nMostLeft = nSon.right;
					KNode nFMLeft = nSon;
					while(nMostLeft.left != null) {
						nFMLeft = nMostLeft;
						nMostLeft = nMostLeft.left;
					}
					nMostLeft.left = nSon.left; 
					nFather.left = nMostLeft;
					nFMLeft.left = nMostLeft.right;
					nMostLeft.right = nSon.right;
					nSon.left = nSon.right = null;
					return nSon.value;
				}
				else if (nSon.left != null) { // node with left son
					KNode nr = nSon;
					nFather.left = nSon.left;
					nSon.right = nSon.left = null;
					return nr.value;
				}
				else if (nSon.right != null) { // node with right son
					KNode nr = nSon;
					nFather.left = nSon.right;
					nSon.left = nSon.right = null;
					return nr.value;
				}
				else { // node without descendants
					nFather.left = null;
					return nSon.value;
				}
			}
			else if(nFather.right != null && nFather.right.key == nSon.key) {
				if(nSon.right != null && nSon.left != null) {  // node with two descendants
					KNode nMostLeft = nSon.right;
					KNode nFMLeft = nSon;
					while(nMostLeft.left != null) {
						nFMLeft = nMostLeft;
						nMostLeft = nMostLeft.left;
					}
					nMostLeft.left = nSon.left; 
					nFather.right = nMostLeft;
					nFMLeft.left = nMostLeft.right;
					nMostLeft.right = nSon.right;
					nSon.left = nSon.right = null;
					return nSon.value;
				}
				else if (nSon.left != null) { // node with left son
					KNode nr = nSon;
					nFather.right = nSon.left;
					nSon.right = nSon.left = null;
					return nr.value;
				}
				else if (nSon.right != null) { // node with right son
					KNode nr = nSon;
					nFather.right = nSon.right;
					nSon.left = nSon.right = null;
					return nr.value;
				}
				else { // node without descendants
					nFather.right = null;
					return nSon.value;
				}
			}
		}
		else if (key < nSon.key) {
			remove(key, nSon, nSon.left);
		}
		else if(key > nSon.key) {
			remove(key, nSon, nSon.right);
		}
		return null;
	}

	private boolean empty() {
		// TODO Auto-generated method stub
		return this.root == null;
	}
	
	public int height(int key) {
		return height(searchNode(key), 0);
	}
	
	private int height(KNode node, int height) {
		// TODO Auto-generated method stub
		if(this.empty()) return 0;
		else if (node == null) return height;
		else {
			int hLeft = height(node.left, height+1);
			int hRight = height(node.right, height+1);
			return (hLeft > hRight) ? hLeft : hRight;
		}
	}

	public int depth(int key) {
		return depth(key, this.root, 1);
	}
	
	private int depth(int key, KNode node, int depth) {
		// TODO Auto-generated method stub
		if(this.empty()) return 0;
		else if(node.key == key) return depth;
		else if(key < node.key) return depth(key, node.left, depth+1);
		else if(key > node.key) return depth(key, node.left, depth+1);
		return 0;
	}

	public int balancingFactor(int key) {
		KNode subTree = this.searchNode(key);
		if(this.empty() || subTree == null) return 0; 
		else {
			int hLeft, hRight;
			hLeft = hRight = 0;
			if(subTree.left != null) hLeft = height(subTree.left.key);
			if(subTree.right != null) hRight = height(subTree.right.key);
			return hLeft - hRight;
		}
	}
	
	public int search(int key) {
		return (int)searchNode(key).value;
	}
	
	public KNode searchNode(int key) {
		return searchNode(key, this.root);
	}

	private KNode searchNode(int key, KNode node) {
		// TODO Auto-generated method stub
		if (this.empty() || node == null)
			return null;
		else if (node.key == key)
			return node;
		else if (key < node.key)
			return searchNode(key, node.left);
		else if (key > node.key)
			return searchNode(key, node.right);
		return null;
	}
	
	public void printNodeInfo() {
		printNodeInfo(this.root, 1);
	}

	private void printNodeInfo(KNode node, int level) {
		// TODO Auto-generated method stub
		if (node != null) {
			  int descending = 0;
			  descending = (node.left != null) ? descending + 1 : descending;
			  descending = (node.right != null) ? descending + 1 : descending;
			  System.out.print("* Node key: " + node.key + " value: " + node.value + " - Level " + level 
					  			+ " - " + descending + " descendants " );
			  if( node.left != null && node.right != null) 
				  System.out.println(": " + node.left.key + " and " + node.right.key);
			  else if (node.left != null) 
				  System.out.println(": " + node.left.key);
			  else if (node.right != null)
				  System.out.println(": " + node.right.key);
			  else System.out.println();
			  printNodeInfo(node.left, level+1);
			  printNodeInfo(node.right, level+1);
			  
		  }
	}
	
	private void checkBalancing() {
		checkBalancing(null, this.root);
	}
	
	private void checkBalancing(KNode nFather, KNode node) {
		// TODO Auto-generated method stub
		
		if ( node == null ) return;
		else {
			checkBalancing(node, node.left);
			checkBalancing(node, node.right);
			int bf = balancingFactor(node.key);
			if (bf > 1) {
				int bfs = balancingFactor(node.left.key);
				if (bfs > 0) SRR(nFather, node, node.left);
				else DRR(nFather, node, node.left);
			}
			else if (bf < -1) {
				int bfs = balancingFactor(node.right.key);
				if ( bfs < 0) SLR(nFather, node, node.right);
				else DLR(nFather, node, node.right);
			}
		}
	}

	//single rigth rotation
	private void SRR(KNode nFather, KNode n1, KNode n2) {
		if(nFather == null) {
			this.root = n2;
			n1.left = n2.right;
			n2.right = n1;
		}
		else {
			if(nFather.left != null && nFather.left.key == n1.key) {
				nFather.left = n2;
				n1.left = n2.right;
				n2.right = n1;
			}
			else if(nFather.right != null && nFather.right.key == n1.key) {
				nFather.right = n2;
				n1.left = n2.right;
				n2.right = n1;
			}
		}
	}
	
	//single left rotation
	private void SLR(KNode nFather, KNode n1, KNode n2) {
		if(nFather == null) {
			this.root = n2;
			n1.right = n2.left;
			n2.left = n1;			
		}
		else {
			if(nFather.left != null && nFather.left.key == n1.key) {
				nFather.left = n2;
				n1.right = n2.left;
				n2.left = n1;
			}
			else if(nFather.right != null && nFather.right.key == n1.key) {
				nFather.right = n2;
				n1.right = n2.left;
				n2.left = n1;				
			}
		}
	}
	
	//double right rotation
	private void DRR(KNode nFather, KNode n1, KNode n2) {
		SLR(n1, n2, n2.right);
		SRR(nFather, n1, n1.left);
	}
	
	//double left rotation
	private void DLR(KNode nFather, KNode n1, KNode n2) {
		SRR(n1, n2, n2.left);
		SLR(nFather, n1, n1.right);
	}
	
	public void drop() {
		this.root = null;
	}
	
}
