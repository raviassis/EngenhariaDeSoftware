
public class CCelulaDicionario {
	// Atributos       
	public Object key, value;       
	public CCelulaDicionario prox; 
	 
    // Construtora que anula os tr�s atributos da c�lula       
	public CCelulaDicionario(){
		this.key = this.value = null;
		this.prox = null;
	} 

    // Construtora que inicializa key e value com os argumentos passados
	// por par�metro e anula a refer�ncia � pr�xima c�lula
	public CCelulaDicionario(Object chave, Object valor){
		this.key = chave;
		this.value = valor;
		this.prox = null;
	} 

    // Construtora que inicializa todos os atribulos da c�lula com os argumentos
	// passados por par�metro
	public CCelulaDicionario(Object chave, Object valor, CCelulaDicionario proxima){
		this.key = chave;
		this.value = valor;
		this.prox = proxima;
	} 
}
