 /**
 * @(#)CLista.java
 *
 *
 * @author Rodrigo Richard Gomes
 * @version 1.00 2018/3/16
 */

public class CLista {
    
   private CCelula primeira;  // Referencia a célula cabeça
   private CCelula ultima; // Referencia a última célula da lista
   private int qtde; // Contador de itens na lista. Deve ser incrementado sempre que um item for inserido e decrementado quando um item for excluído.
    
   // Função construtora. Aloca a célula cabeça e faz todas as referências apontarem para ela.
   public CLista() {
      primeira = new CCelula();
      ultima = primeira;
   }
    
   // Verifica se a lista está vazia. Retorna TRUE se a lista estiver vazia e FALSE se ela tiver elementos.
   public boolean vazia() {
      return primeira == ultima;
   }
    
   // Insere um novo Item no fim da lista.
   public void insereFim(Object valorItem) {
      ultima.prox = new CCelula(valorItem);
      ultima = ultima.prox;            
      qtde++;
   }
    
   // Insere um novo Item no começo da lista.
   public void insereComeco(Object valorItem) {
      primeira.prox = new CCelula(valorItem, primeira.prox);
      if (primeira.prox.prox == null)
         ultima = primeira.prox;
      qtde++;
   }
 
   // Insere o Item passado por parâmetro na posição determinada.
   // O parâmetro "valorItem" é o item a ser inserido na lista.
   // O parâmetro "posicao" é a posição na qual o elemento será inserido. O primeiro elemento está na posição 1, e assim por diante.
   // Se a posição existir e o método conseguir inserir o elemento, retorna TRUE. Caso a posição não exista, retorna FALSE.
   public boolean insereIndice(Object valorItem, int posicao) {
      // Exercício
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
   
   // Verifica se o elemento passado como parâmetro está contido na lista.
   // O parâmetro "elemento" é o item a ser localizado. O método retorna TRUE caso o Item esteja presente na lista.
   public boolean contem(Object elemento) {
      boolean achou = false;
      CCelula aux = primeira.prox;
      while (aux != null && !achou) {
         achou = aux.item.equals(elemento);			
         aux = aux.prox;
      }			
      return achou;
   }
	    
   // Verifica se o elemento passado como parâmetro está contido na lista. (Obs: usando o comando FOR)
   // O parâmetro "elemento" é o item a ser localizado. O método retorna TRUE caso o Item esteja presente na lista.
   public boolean contemFor(Object elemento) {
      boolean achou = false;
      for (CCelula aux = primeira.prox; aux != null && !achou; aux = aux.prox)
         achou = aux.item.equals(elemento);
      return achou;
   }
   
   // Remove e retorna o primeiro item da lista (remoção física, ou seja, elimina a célula que contém o elemento).
   // Retorna um Object contendo o Item removido ou null caso a lista esteja vazia.
   public Object removeRetornaComeco() {
      // Verifica se há elementos na lista
      if (primeira != ultima) {
         CCelula aux = primeira.prox;
         primeira.prox = aux.prox;
         if (primeira.prox == null) // Se a célula cabeça está apontando para null, significa que o único elemento da lista foi removido
            ultima = primeira;
         qtde--;
         return aux.item;
      }
      return null;
   }
	
   // Remove e retorna o primeiro item da lista (remoção lógica, ou seja, remove a célula cabeça fazendo com que a célula seguinte ela se torne a nova célula cabeça).
   // Retorna um Object contendo o item removido ou null caso a lista esteja vazia.
   public Object removeRetornaComecoSimples() {
      // Verifica se há elementos na lista
      if (primeira != ultima) { 
         primeira = primeira.prox;
         qtde--;
         return primeira.item;
      }
      return null;
   }

   // Remove o primeiro item da lista fazendo com que a célula seguinte à célula cabeça se torne a nova célula cabeça. Não retorna o item removido.
   public void removeComecoSemRetorno() {
      if (primeira != ultima) {
         primeira = primeira.prox;
         qtde--;
      }
   }
    
   // Remove o último Item da lista.
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

   // Remove o último Item da lista sem retorná-lo.
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

   // Localiza o Item passado por parâmetro e o remove da Lista
   // O parâmetro "valorItem" é o item a ser removido da lista.
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

   // Remove o elemento na posição passada como parâmetro.
   // O parâmetro "posicao" é a posição a ser removida. OBS: o primeiro elemento está na posição 1, e assim por diante.
   // O método retorna TRUE se a posição existe e foi removida com sucesso, e FALSE caso a posição não exista.
   public boolean removeIndice(int posicao) {
      // Verifica se é uma posição válida e se a lista possui elementos
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

   // Remove e retorna o elemento na posição passada como parâmetro.
   // O parâmetro "posicao" é a  posição a ser removida. OBS: o primeiro elemento está na posição 1, e assim por diante.
   // O método retorna um object contendo o elemento removido da lista. Caso a posição seja inválida, retorna null.
   public Object removeRetornaIndice(int posicao) {
      // Verifica se é uma posição válida e se a lista possui elementos
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

   // Retorna um Object contendo o primeiro Item da lista. Se a lista estiver vazia a função retorna null.
   public Object retornaPrimeiro() {
      if (primeira != ultima)
         return primeira.prox.item;
      else
         return null;
   }

   // Retorna um Object contendo o último Item da lista. Se a lista estiver vazia a função retorna null.
   public Object retornaUltimo() {
      if (primeira != ultima)
         return ultima.item;
      else
         return null;
   }

   // Retorna o Item contido na posição passada por parâmetro
   public Object retornaIndice(int posicao) {
      // EXERCÍCIO : deve retornar o elemento da posição p passada por parâmetro
      // [cabeça]->[7]->[21]->[13]->null
      // retornaIndice(2) deve retornar o elemento 21. retornaIndice de uma posiçao inexistente deve retornar null.
      // Se é uma posição válida e a lista possui elementos
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

// Método(getter) que retorna a quantidade de itens da lista.
   public int quantidade() {
      return qtde;
   }

public void removePos(int i) {
	// TODO Auto-generated method stub
	this.remove(this.retornaIndice(i));
}



}