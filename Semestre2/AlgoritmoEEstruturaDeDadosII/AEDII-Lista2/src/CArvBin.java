public class CArvBin {
  private CNo raiz;
  
  public CArvBin()
  {
	  raiz = null;
  }
  
  public void inserir(int item)
  {
	  insere(item, raiz);
  }

  private void insere(int item, CNo no)
  {
     // insere um item na arvore a partir da raiz
	  if(this.vazia())
		  this.raiz = new CNo(item);
	  else { // arvore não vazia
		  
		  if(item < no.item) {
			  if(no.esq == null) no.esq = new CNo(item);
			  else insere(item, no.esq);
		  }
		  else if (item > no.item) {
			  if(no.dir == null) no.dir = new CNo(item);
			  else insere(item, no.dir);
		  }
	  }
	  
  }  
  
  private boolean vazia() {
	// TODO Auto-generated method stub
	return this.raiz == null;
}

public void imprimir(int Ordem)
  {
      // Ordem = 1 => EmOrdem
      // Ordem = 2 => PreOrdem
      // Ordem = 3 => PosOrdem   
	  // Ordem = 4 => PreOrdem com Filhos
      switch (Ordem)
      {
          case 1: System.out.println("\n\nImpressao em ordem");
                  emOrdem(raiz);
                  break;
          case 2: System.out.println("\n\nImpressao pre ordem");
                  preOrdem(raiz);
                  break;
          case 3: System.out.println("\n\nImpressao pos ordem");
                  posOrdem(raiz);
                  break;
          case 4: System.out.println("\n\nImpressão pre ordem com quantidade de filhos por nó");
          			preOrdemComFilhos(raiz);
          			break;
          case 5: System.out.println("\n\nImpressão em ordem com quantidade de filhos por nó");
					emOrdemComFilhos(raiz);
					break;
          case 6: System.out.println("\n\nImpressão pos ordem com quantidade de filhos por nó");
					posOrdemComFilhos(raiz);
					break;
          case 7: System.out.println("\n\nImpressão pre ordem com filhos");
					preOrdemComFilhos2(raiz);
					break;
          case 8: System.out.println("\n\nImpressão em ordem com filhos");
					emOrdemComFilhos2(raiz);
					break;
          case 9: System.out.println("\n\nImpressão pos ordem com filhos");
					posOrdemComFilhos2(raiz);
					break;
          default: System.out.println("Opcao invalida!!!\n\n");
                  break;
      }
  }
  
  private void emOrdem(CNo no)
  {
      // percorre em ordem crescente
      if (no != null) {
          emOrdem(no.esq);
          System.out.println("Chave = "+no.item);
          emOrdem(no.dir);
      }
  }

  private void preOrdem(CNo no)
  {
      // percorre previlegiando a raiz sobre 
      // seus descendentes
      if (no != null) {
          System.out.println("Chave = "+no.item);          
          preOrdem(no.esq);
          preOrdem(no.dir);
      }     
  }

  private void posOrdem(CNo no)
  {
      // percorre previlegiando os descendentes 
      // sobre a raiz 
      if (no != null) {
          posOrdem(no.esq);
          posOrdem(no.dir);
          System.out.println("Chave = "+no.item);
      }
  }  

  /*Ex3*/
  public void preOrdemComFilhos(CNo no) {
	  if (no != null) {
		  int filhos = 0;
		  if (no.esq != null) filhos++;
		  if (no.dir != null) filhos++;
		  System.out.println("Chave= " + no.item + " Filhos= " + filhos);
		  preOrdemComFilhos(no.esq);
		  preOrdemComFilhos(no.dir);
	  }
  }
  
  /*Ex4*/
  public void emOrdemComFilhos(CNo no) {
	  if (no != null) {
		  int filhos = 0;
		  if (no.esq != null) filhos++;
		  if (no.dir != null) filhos++;
		  emOrdemComFilhos(no.esq);
		  System.out.println("Chave= " + no.item + " Filhos= " + filhos);		  
		  emOrdemComFilhos(no.dir);
	  }
  }
  
  /*Ex5*/
  public void posOrdemComFilhos(CNo no) {
	  if (no != null) {
		  int filhos = 0;
		  if (no.esq != null) filhos++;
		  if (no.dir != null) filhos++;
		  posOrdemComFilhos(no.esq);
		  posOrdemComFilhos(no.dir);
		  System.out.println("Chave= " + no.item + " Filhos= " + filhos);		  
		  
	  }
  }
  
  /*Ex6*/
  public void preOrdemComFilhos2(CNo no) {
	  if (no != null) {
		  System.out.print("Chave= " + no.item);
		  if (no.esq != null) System.out.print(" Filho esquerdo= " + no.esq.item);
		  if (no.dir != null) System.out.print(" Filho esquerdo= " + no.dir.item);
		  System.out.println();
		  preOrdemComFilhos2(no.esq);
		  preOrdemComFilhos2(no.dir);
	  }
  }
  
  /*Ex7*/
  public void emOrdemComFilhos2(CNo no) {
	  if (no != null) {
		  emOrdemComFilhos2(no.esq);
		  
		  System.out.print("Chave= " + no.item);
		  if (no.esq != null) System.out.print(" Filho esquerdo= " + no.esq.item);
		  if (no.dir != null) System.out.print(" Filho esquerdo= " + no.dir.item);
		  System.out.println();
		  
		  emOrdemComFilhos2(no.dir);
	  }
  }
  
  /*Ex8*/
  public void posOrdemComFilhos2(CNo no) {
	  if (no != null) {
		  posOrdemComFilhos2(no.esq);
		  posOrdemComFilhos2(no.dir);
		  System.out.print("Chave= " + no.item);
		  if (no.esq != null) System.out.print(" Filho esquerdo= " + no.esq.item);
		  if (no.dir != null) System.out.print(" Filho esquerdo= " + no.dir.item);
		  System.out.println();	  
	  }
  }
  
  /*Ex9*/
  public int altura(int item) {
	  return altura(item, retornaNo(item, this.raiz), 1);
  }
  
  private int altura(int item, CNo no, int alt) {
	  if(this.vazia()) return 0;
	  else if (no == null) return alt;
	  else {
		  int altEsq = altura(item, no.esq, alt+1);
		  int altDir = altura(item, no.dir, alt+1);
		  return (altEsq > altDir) ? altEsq : altDir;
	  }
	  
  }

  /*Ex10*/
 public int profundidade(int item) {
	 return profundidade(item, this.raiz, 1);
 }

  private int profundidade(int item, CNo no, int prof) {
	// TODO Auto-generated method stub
	  if(this.vazia() || no == null) return 0;
	  else if (no.item == item) return prof;
	  else if (item < no.item) return profundidade(item, no.esq, prof+1);
	  else if (item > no.item) return profundidade(item, no.dir, prof+1);
	  return 0;
  }
  
  private CNo retornaNo(int item, CNo no) {
	  if(this.vazia() || no == null) return null;
	  else if (no.item == item) return no;
	  else if (item < no.item) return retornaNo(item, no.esq);
	  else if (item > no.item) return retornaNo(item, no.dir);
	  return null;
  }
  
  public int fb(int item) {
	  CNo subArv = retornaNo(item, this.raiz);
	  if(this.vazia() || subArv == null) return 0;
	  else {
		 int altE, altD;
		 altE = altD = 0;
		 if(subArv.esq != null) altE = altura(subArv.esq.item);
		 if(subArv.dir != null) altD = altura(subArv.dir.item);
		 return altE - altD;
	  }
	  	  
  }
  
  public void imprimeInfoNo() {
	  imprimeInfoNo(this.raiz, 1);
  }
  
  private void imprimeInfoNo(CNo no, int nivel) {
	  if (no != null) {
		  int filhos = 0;
		  filhos = (no.esq != null) ? filhos+1 : filhos;
		  filhos = (no.dir != null) ? filhos+1 : filhos;
		  System.out.print("* Nó " + no.item + " - Nível " + nivel 
				  			+ " - " + filhos + " filho(s) " );
		  if( no.esq != null && no.dir != null) 
			  System.out.println(": " + no.esq.item + " e " + no.dir.item);
		  else if (no.esq != null) 
			  System.out.println(": " + no.esq.item);
		  else if (no.dir != null)
			  System.out.println(": " + no.dir.item);
		  else System.out.println();
		  imprimeInfoNo(no.esq, nivel+1);
		  imprimeInfoNo(no.dir, nivel+1);
		  
	  }
  }
  
}
