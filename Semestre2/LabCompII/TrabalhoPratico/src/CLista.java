 /**
 * @(#)CLista.java
 *
 *
 * @author Rodrigo Richard Gomes
 * @version 1.00 2018/3/16
 */

public class CLista {
    
   private CCelula primeira;  // Referencia a c�lula cabe�a
   private CCelula ultima; // Referencia a �ltima c�lula da lista
   private int qtde; // Contador de itens na lista. Deve ser incrementado sempre que um item for inserido e decrementado quando um item for exclu�do.
   private int MAX;
    
   // Fun��o construtora. Aloca a c�lula cabe�a e faz todas as refer�ncias apontarem para ela.
   public CLista() {
      primeira = new CCelula();
      ultima = primeira;
   }
    
   public CLista(int m) {
	// TODO Auto-generated constructor stub
	   primeira = new CCelula();
	   ultima = primeira;
	   this.setMAX(m);
   }

// Verifica se a lista est� vazia. Retorna TRUE se a lista estiver vazia e FALSE se ela tiver elementos.
   public boolean vazia() {
      return primeira == ultima;
   }
    
   // Insere um novo Item no fim da lista.
   public void insereFim(Object valorItem) {
      ultima.prox = new CCelula(valorItem);
      ultima = ultima.prox;            
      qtde++;
   }
    
   // Insere um novo Item no come�o da lista.
   public void insereComeco(Object valorItem) {
      primeira.prox = new CCelula(valorItem, primeira.prox);
      if (primeira.prox.prox == null)
         ultima = primeira.prox;
      qtde++;
   }
 
   // Insere o Item passado por par�metro na posi��o determinada.
   // O par�metro "valorItem" � o item a ser inserido na lista.
   // O par�metro "posicao" � a posi��o na qual o elemento ser� inserido. O primeiro elemento est� na posi��o 1, e assim por diante.
   // Se a posi��o existir e o m�todo conseguir inserir o elemento, retorna TRUE. Caso a posi��o n�o exista, retorna FALSE.
   public boolean insereIndice(Object valorItem, int posicao) {
      // Exerc�cio
      return true;
   }
   
   public void InsereAntesDe(Object ElementoAInserir, Object Elemento) {
	   CCelula aux = primeira;
	   
	   while (aux != null) {
		   if (aux.prox.item.equals(Elemento)) {
			   aux.prox = new CCelula(ElementoAInserir, aux.prox);
			   this.qtde++;
			   return;
		   }
		   else aux = aux.prox;
	   }
	   
   }
   
   public void InsereDepoisDe(Object ElementoAInserir, Object Elemento) {
	   CCelula atual = primeira.prox;
	   while (atual != null) {
		   if ( atual.item.equals(Elemento) ) {			   
			   atual.prox = new CCelula(ElementoAInserir,atual.prox);
			   if(atual.prox.prox == null) {
				   this.ultima = atual.prox;
			   }
			   this.qtde++;
			   return;
		   }
		   else atual = atual.prox;
	   }
   }
   
   public void InsereOrdenado(int elemento) {
	   CCelula atual = primeira.prox;
	   
	   while (atual != null) {
		   if ( (int) atual.item < elemento) {
			   atual.prox = new CCelula(elemento, atual.prox);
			   if (atual.prox == null) {
				   ultima = atual;
			   }
			   this.qtde++;
			   return;
		   }
		   else atual = atual.prox;
	   }
	   
	   insereComeco(elemento);
	   
   }
   
   // Imprime todos os elementos da lista usando o comando while 
   public void imprime() {
      CCelula aux = primeira.prox;
   
      while (aux != null) {
         System.out.println(aux.item);
         aux = aux.prox;
      }
   }
   
   /*Ex5 */
   public void imprimeInversoRecursivo () {
	   imprimeInversoRecursivo(this.primeira.prox);
   }
   
   private void imprimeInversoRecursivo(CCelula aux) {
	   
	   if (aux != null) {
		   imprimeInversoRecursivo(aux.prox);
		   System.out.println(aux.item);
	   }
	   return;
   }
   
   // Imprime todos os elementos da lista usando o comando for 
   public void imprimeFor() {
      for (CCelula aux = primeira.prox; aux != null; aux = aux.prox)
         System.out.print(aux.item + " ");   		
   }
   
   // Imprime todos os elementos simulando formato de lista: [/]->[7]->[21]->[13]->null 
   public void imprimeFormatoLista() {
      System.out.print("[/]->");
      for (CCelula aux = primeira.prox; aux != null; aux = aux.prox)
         System.out.print("[" + aux.item + "]->");
      System.out.println("null");
   }
   
   // Verifica se o elemento passado como par�metro est� contido na lista.
   // O par�metro "elemento" � o item a ser localizado. O m�todo retorna TRUE caso o Item esteja presente na lista.
   public boolean contem(Object elemento) {
      boolean achou = false;
      CCelula aux = primeira.prox;
      while (aux != null && !achou) {
         achou = aux.item.equals(elemento);			
         aux = aux.prox;
      }			
      return achou;
   }
	    
   // Verifica se o elemento passado como par�metro est� contido na lista. (Obs: usando o comando FOR)
   // O par�metro "elemento" � o item a ser localizado. O m�todo retorna TRUE caso o Item esteja presente na lista.
   public boolean contemFor(Object elemento) {
      boolean achou = false;
      for (CCelula aux = primeira.prox; aux != null && !achou; aux = aux.prox)
         achou = aux.item.equals(elemento);
      return achou;
   }
   
   // Remove e retorna o primeiro item da lista (remo��o f�sica, ou seja, elimina a c�lula que cont�m o elemento).
   // Retorna um Object contendo o Item removido ou null caso a lista esteja vazia.
   public Object removeRetornaComeco() {
      // Verifica se h� elementos na lista
      if (primeira != ultima) {
         CCelula aux = primeira.prox;
         primeira.prox = aux.prox;
         if (primeira.prox == null) // Se a c�lula cabe�a est� apontando para null, significa que o �nico elemento da lista foi removido
            ultima = primeira;
         qtde--;
         return aux.item;
      }
      return null;
   }
	
   // Remove e retorna o primeiro item da lista (remo��o l�gica, ou seja, remove a c�lula cabe�a fazendo com que a c�lula seguinte ela se torne a nova c�lula cabe�a).
   // Retorna um Object contendo o item removido ou null caso a lista esteja vazia.
   public Object removeRetornaComecoSimples() {
      // Verifica se h� elementos na lista
      if (primeira != ultima) { 
         primeira = primeira.prox;
         qtde--;
         return primeira.item;
      }
      return null;
   }

   // Remove o primeiro item da lista fazendo com que a c�lula seguinte � c�lula cabe�a se torne a nova c�lula cabe�a. N�o retorna o item removido.
   public void removeComecoSemRetorno() {
      if (primeira != ultima) {
         primeira = primeira.prox;
         qtde--;
      }
   }
    
   // Remove o �ltimo Item da lista.
   // Retorna um Object contendo o Item removido ou null caso a lista esteja vazia.
   public Object removeRetornaFim() {
      if (primeira != ultima) {
         CCelula aux = primeira;
         while (aux.prox != ultima)
            aux = aux.prox;
      
         CCelula aux2 = aux.prox;
         ultima = aux;
         ultima.prox = null;
         qtde--;
         return aux2.item;
      }
      return null;
   }

   // Remove o �ltimo Item da lista sem retorn�-lo.
   public void removeFimSemRetorno() {
      if (primeira != ultima) {
         CCelula aux = primeira;
         while (aux.prox != ultima)
            aux = aux.prox;
      
         ultima = aux;
         ultima.prox = null;
         qtde--;
      }
   }

   // Localiza o Item passado por par�metro e o remove da Lista
   // O par�metro "valorItem" � o item a ser removido da lista.
   public void remove(Object valorItem) {
      if (primeira != ultima) {
         CCelula aux = primeira;
         boolean achou = false;
         while (aux.prox != null && !achou) {
            achou = aux.prox.item.equals(valorItem);
            if (!achou)
               aux = aux.prox;
         }
         if (achou) { 
            // achou o elemento
            aux.prox = aux.prox.prox;
            if (aux.prox == null)
               ultima = aux;
            qtde--;
         }
      }
   }

   // Remove o elemento na posi��o passada como par�metro.
   // O par�metro "posicao" � a posi��o a ser removida. OBS: o primeiro elemento est� na posi��o 1, e assim por diante.
   // O m�todo retorna TRUE se a posi��o existe e foi removida com sucesso, e FALSE caso a posi��o n�o exista.
   public boolean removeIndice(int posicao) {
      // Verifica se � uma posi��o v�lida e se a lista possui elementos
      if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
         int i = 0;
         CCelula aux = primeira;
         while (i < posicao - 1) {
            aux = aux.prox;
            i++;
         }
         aux.prox = aux.prox.prox;
         if (aux.prox == null)
            ultima = aux;
         qtde--;
         return true;
      }
      return false;
   }

   // Remove e retorna o elemento na posi��o passada como par�metro.
   // O par�metro "posicao" � a  posi��o a ser removida. OBS: o primeiro elemento est� na posi��o 1, e assim por diante.
   // O m�todo retorna um object contendo o elemento removido da lista. Caso a posi��o seja inv�lida, retorna null.
   public Object removeRetornaIndice(int posicao) {
      // Verifica se � uma posi��o v�lida e se a lista possui elementos
      if ((posicao >= 1) && (posicao <= qtde) && (primeira != ultima)) {
         int i = 0;
         CCelula aux = primeira;
         while (i < posicao - 1) {
            aux = aux.prox;
            i++;
         }
         CCelula aux2 = aux.prox;
         aux.prox = aux.prox.prox;
         if (aux.prox == null)
            ultima = aux;
         qtde--;
         return aux2.item;
      }
      return null;
   }

   // Retorna um Object contendo o primeiro Item da lista. Se a lista estiver vazia a fun��o retorna null.
   public Object retornaPrimeiro() {
      if (primeira != ultima)
         return primeira.prox.item;
      else
         return null;
   }

   // Retorna um Object contendo o �ltimo Item da lista. Se a lista estiver vazia a fun��o retorna null.
   public Object retornaUltimo() {
      if (primeira != ultima)
         return ultima.item;
      else
         return null;
   }

   // Retorna o Item contido na posi��o passada por par�metro
   public Object retornaIndice(int posicao) {
      // EXERC�CIO : deve retornar o elemento da posi��o p passada por par�metro
      // [cabe�a]->[7]->[21]->[13]->null
      // retornaIndice(2) deve retornar o elemento 21. retornaIndice de uma posi�ao inexistente deve retornar null.
      // Se � uma posi��o v�lida e a lista possui elementos
	   if ((posicao >= 1) && (posicao <= this.qtde) && (this.primeira != this.ultima)) {
          CCelula aux = this.primeira.prox;
          for (int i = 1; i < posicao; i++, aux = aux.prox) ;
          if (aux != null)
             return aux.item;
	   }
      return null;
   }
   
   /*Ex6*/
   public int [] retornaVetorInvertidoRecursivo() {
	   String str = retornaVetorInvertidoRecursivo(this.primeira.prox);
	   char [] c = str.toCharArray();
	   int [] vetor = new int[c.length];
	   for (int i = 0; i < vetor.length; i++) {
		   vetor[i] = Character.getNumericValue(c[i]);
		   System.out.println(vetor[i]);
	   }	   
	   return vetor;
   }   

   private String retornaVetorInvertidoRecursivo(CCelula aux) {
	// TODO Auto-generated method stub
	if (aux != null) {
		return retornaVetorInvertidoRecursivo(aux.prox) + aux.item;
	}
	return "";
	
}

// M�todo(getter) que retorna a quantidade de itens da lista.
   public int quantidade() {
      return qtde;
   }

	public void removePos(int i) {
		// TODO Auto-generated method stub
		this.remove(this.retornaIndice(i));
	}

	//Author: Ravi Assis
	//Retorna o limite de itens que podem ser inseridos
	public int getMAX() {
		return MAX;
	}
	
	//Author: Ravi Assis
	//Seta o limite de itens que podem ser inseridos
	private void setMAX(int mAX) {
		MAX = mAX;
	}

	//Author: Ravi Assis
	//Verifica se a lista est� cheia
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.getMAX() <= this.quantidade();
	}

	//Author: Ravi Assis
	//Busca um aluno pelo n�mero de matricula
	//Retorna o Objeto Aluno se encontrar
	//Retorna null se n�o encontrar
	public Object search(int matricula) {
		// TODO Auto-generated method stub
		CCelula aux = this.primeira.prox;
		while(aux != null) {
			if ( matricula == ((Aluno)aux.item).matricula ) return aux.item;
			aux = aux.prox;
		}
		return null;
	}

	//Author: Ravi Assis
	//Remove um item da lista de forma aleat�ria
	//Retorna null se estiver vazia
	public Object removeRandom() {
		// TODO Auto-generated method stub
		if ( this.vazia() )	return null;
		else {
			int random;
			random = 1 + (int)( Math.random() * this.quantidade() );
			return this.removeRetornaIndice(random);			
		}
	}

	//Author: Ravi Assis
	//Retorna uma copia dessa Lista
	@Override
	protected Object clone() {
		// TODO Auto-generated method stub
		CLista ret = new CLista(this.MAX);
		
		for (int i = 1; i <= this.quantidade(); i++) {
			ret.insereFim( this.retornaIndice(i) );
		}
		
		return ret;
	}



}