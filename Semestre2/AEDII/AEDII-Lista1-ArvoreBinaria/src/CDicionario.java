
public class CDicionario {
	 private CCelulaDicionario primeira, ultima; 
	 
     public CDicionario(){
    	 this.primeira = this.ultima = new CCelulaDicionario();
     } 

     public boolean vazio(){
    	 return this.primeira == this.ultima;
     } 

     public void adiciona(Object chave, Object valor){
    	 this.ultima.prox = new CCelulaDicionario(chave, valor);
    	 this.ultima = this.ultima.prox;
     } 

     public Object recebeValor(Object chave){
    	 CCelulaDicionario aux = primeira.prox;
    	 while(aux != null) {
    		 if( aux.key.equals(chave) ) return aux.value;
        	 else { 
        		 aux = aux.prox;
        	 }    		 
    	 }
    	 
    	 return null;
     }
}
