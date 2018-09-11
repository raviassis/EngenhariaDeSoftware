import java.io.*;
import java.util.ArrayList;

// MODIFICAÃ‡Ã•ES FUTURAS: 
// 1. Mudar as chaves para objetos ao invÃ©s de inteiros
// 2. Reaproveitar os espaÃ§os de pÃ¡ginas excluÃ­das nas novas inclusÃµes
// 3. Criar mÃ©todo de reorganizaÃ§Ã£o (para eliminaÃ§Ã£o de espaÃ§os excluÃ­dos)

public class ArvoreBMais {

    private int  ordem;                 // NÃºmero mÃ¡ximo de filhos que uma pÃ¡gina pode conter
    private int  maxElementos;          // VariÃ¡vel igual a ordem - 1 para facilitar a clareza do cÃ³digo
    private int  maxFilhos;             // VariÃ¡vel igual a ordem para facilitar a clareza do cÃ³digo
    private RandomAccessFile arquivo;   // Arquivo em que a Ã¡rvore serÃ¡ armazenada
    private String nomeArquivo;
    
    // VariÃ¡veis usadas nas funÃ§Ãµes recursivas (jÃ¡ que nÃ£o Ã© possÃ­vel passar valores por referÃªncia)
    private int  chave1Extra;
    private int  chave2Extra;
    private long paginaExtra;
    private boolean cresceu;
    private boolean diminuiu;
    
    // Esta classe representa uma pÃ¡gina da Ã¡rvore. A Ã¡rvore Ã© armazenada em disco,
    // assim, apenas poucas pÃ¡ginas serÃ£o necessÃ¡rias para os processos de inclusÃ£o,
    // alteraÃ§Ã£o, exclusÃ£o e consulta. 
    class ArvoreBMais_Pagina {

        protected int    ordem;                 // NÃºmero mÃ¡ximo de pÃ¡ginas que uma pÃ¡gina pode conter
        protected int    maxElementos;          // VariÃ¡vel igual a ordem - 1 para facilitar a clareza do cÃ³digo
        protected int    maxFilhos;             // VariÃ¡vel igual a ordem  para facilitar a clareza do cÃ³digo
        protected int    n;                     // NÃºmero de elementos presentes na pÃ¡gina
        protected int[]  chaves1;
        protected int[]  chaves2;
        protected long[] filhos;                // Vetor de ponteiros para os filhos
        protected long   proxima;               // PrÃ³xima folha, quando a pÃ¡gina for uma folha
        private   int    TAMANHO_REGISTRO = 8;  // Os elementos sÃ£o de tamanho fixo
        protected int    TAMANHO_PAGINA;        // A pÃ¡gina serÃ¡ de tamanho fixo, calculado a partir da ordem

        // Construtor da pÃ¡gina
        public ArvoreBMais_Pagina(int o) {

            // InicializaÃ§Ã£o dos atributos
            n = 0;
            ordem = o;
            maxFilhos = o;
            maxElementos = o-1;
            chaves1 = new int[maxElementos];
            chaves2 = new int[maxElementos];
            filhos = new long[maxFilhos];
            proxima = -1;
            
            // CriaÃ§Ã£o de uma pÃ¡gina vÃ¡zia
            for(int i=0; i<maxElementos; i++) {  
                chaves1[i] = 0;
                chaves2[i] = 0;
                filhos[i] = -1;
            }
            filhos[maxFilhos-1] = -1;
            
            // CÃ¡lculo do tamanho (fixo) da pÃ¡gina
            TAMANHO_PAGINA = 4 + maxElementos*8 + maxFilhos*8 + 8;
        }
        
        // Retorna o vetor de bytes que representa a pÃ¡gina para armazenamento em arquivo
        protected byte[] getBytes() throws IOException {
            
            // Um fluxo de bytes Ã© usado para construÃ§Ã£o do vetor de bytes
            ByteArrayOutputStream ba = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(ba);
            
            // Quantidade de elementos presentes na pÃ¡gina
            out.writeInt(n);
            
            // Escreve todos os elementos
            int i=0;
            while(i<n) {
                out.writeLong(filhos[i]);
                out.writeInt(chaves1[i]);
                out.writeInt(chaves2[i]);
                i++;
            }
            out.writeLong(filhos[i]);
            
            // Completa o restante da pÃ¡gina com registros vazios
            byte[] registroVazio = new byte[TAMANHO_REGISTRO];
            while(i<maxElementos){
                out.write(registroVazio);
                out.writeLong(filhos[i+1]);
                i++;
            }
            out.writeLong(proxima);
            
            // Retorna o vetor de bytes que representa a pÃ¡gina
            return ba.toByteArray();
        }

        
        // ReconstrÃ³i uma pÃ¡gina a partir de um vetor de bytes lido no arquivo
        public void setBytes(byte[] buffer) throws IOException {
            
            // Usa um fluxo de bytes para leitura dos atributos
            ByteArrayInputStream ba = new ByteArrayInputStream(buffer);
            DataInputStream in = new DataInputStream(ba);
            
            // LÃª a quantidade de elementos da pÃ¡gina
            n = in.readInt();
            
            // LÃª todos os elementos (reais ou vazios)
            int i=0;
            while(i<maxElementos) {
                filhos[i] = in.readLong();
                chaves1[i] = in.readInt();
                chaves2[i] = in.readInt();
                i++;
            }
            filhos[i] = in.readLong();
            proxima = in.readLong();
        }
    }
    
    // ------------------------------------------------------------------------------
        
    public ArvoreBMais(int o, String na) throws IOException {
        
        // Inicializa os atributos da Ã¡rvore
        ordem = o;
        maxElementos = o-1;
        maxFilhos = o;
        nomeArquivo = na;
        
        // Abre (ou cria) o arquivo, escrevendo uma raiz vazia, se necessÃ¡rio.
        arquivo = new RandomAccessFile(nomeArquivo,"rw");
        if(arquivo.length()<8) 
            arquivo.writeLong(-1);  // raiz vazia
    }
    
    // Testa se a Ã¡rvore estÃ¡ vazia. Uma Ã¡rvore vazia Ã© identificada pela raiz == -1
    public boolean vazia() throws IOException {
        long raiz;
        arquivo.seek(0);
        raiz = arquivo.readLong();
        return raiz == -1;
    }
    
        
    // Busca recursiva por um elemento a partir da chave. Este metodo invoca 
    // o mÃ©todo recursivo lista1, passando a raiz como referÃªncia.
    // O mÃ©todo retorna a lista de elementos que possuem a chave (considerando
    // a possibilidade chaves repetidas)
    public int[] lista(int c1) throws IOException {
        
        // Recupera a raiz da Ã¡rvore
        long raiz;
        arquivo.seek(0);
        raiz = arquivo.readLong();
        
        // Executa a busca recursiva
        if(raiz!=-1)
            return lista1(c1,raiz);
        else
            return new int[0];
    }
    
    // Busca recursiva. Este mÃ©todo recebe a referÃªncia de uma pÃ¡gina e busca
    // pela chave na mesma. A busca continua pelos filhos, se houverem.
    private int[] lista1(int chave1, long pagina) throws IOException {
        
        // Como a busca Ã© recursiva, a descida para um filho inexistente
        // (filho de uma pÃ¡gina folha) retorna um vetor vazio.
        if(pagina==-1)
            return new int[0];
        
        // ReconstrÃ³i a pÃ¡gina passada como referÃªncia a partir 
        // do registro lido no arquivo
        arquivo.seek(pagina);
        ArvoreBMais_Pagina pa = new ArvoreBMais_Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);
 
        // Encontra o ponto em que a chave deve estar na pÃ¡gina
        // Nesse primeiro passo, todas as chaves menores que a chave buscada
        // sÃ£o ultrapassadas
        int i=0;
        while(i<pa.n && chave1>pa.chaves1[i]) {
            i++;
        }
        
        // Chave encontrada (ou pelo menos o ponto onde ela deveria estar).
        // Segundo passo - testa se a chave Ã© a chave buscada e se estÃ¡ em uma folha
        // Obs.: em uma Ã¡rvore B+, todas as chaves vÃ¡lidas estÃ£o nas folhas
        if(i<pa.n && pa.filhos[0]==-1 && chave1==pa.chaves1[i]) {

            // Cria a lista de retorno e insere as chaves secundÃ¡rias encontradas
            ArrayList lista = new ArrayList();
            while(chave1<=pa.chaves1[i]) {
                
                if(chave1==pa.chaves1[i])
                    lista.add(pa.chaves2[i]);
                i++;

                // Se chegar ao fim da folha, entÃ£o avanÃ§a para a folha seguinte
                if(i==pa.n) {
                    if(pa.proxima==-1)
                        break;
                    arquivo.seek(pa.proxima);
                    arquivo.read(buffer);
                    pa.setBytes(buffer);
                    i=0;
                }
            }
            
            // ConstrÃ³i o vetor de resposta
            int[] resposta = new int[lista.size()];
            for(int j=0; j<lista.size(); j++)
                resposta[j] = (int)lista.get(j);
            return resposta;

        }
        
        // Terceiro passo - se a chave nÃ£o tiver sido encontrada nesta folha, 
        // testa se ela estÃ¡ na prÃ³xima folha. Isso pode ocorrer devido ao 
        // processo de ordenaÃ§Ã£o. 
        else if(i==pa.n && pa.filhos[0]==-1) { 
            
            // Testa se hÃ¡ uma prÃ³xima folha. Nesse caso, retorna um vetor vazio
            if(pa.proxima==-1)
                return new int[0];
            
            // LÃª a prÃ³xima folha
            arquivo.seek(pa.proxima);
            arquivo.read(buffer);
            pa.setBytes(buffer);
            
            // Testa se a chave Ã© a primeira da prÃ³xima folha
            i=0;
            if(chave1<=pa.chaves1[0]) {
                
                // Cria a lista de retorno
                ArrayList lista = new ArrayList();
                
                // Testa se a chave foi encontrada, e adiciona todas as chaves
                // secundÃ¡rias
                while(chave1<=pa.chaves1[i]) {
                    if(chave1==pa.chaves1[i])
                        lista.add(pa.chaves2[i]);
                    i++;
                    if(i==pa.n) {
                        if(pa.proxima==-1)
                            break;
                        arquivo.seek(pa.proxima);
                        arquivo.read(buffer);
                        pa.setBytes(buffer);
                        i=0;
                    }
                }
                
                // ConstrÃ³i o vetor de respostas
                int[] resposta = new int[lista.size()];
                for(int j=0; j<lista.size(); j++)
                    resposta[j] = (int)lista.get(j);
                return resposta;
            }
            
            // Se nÃ£o houver uma prÃ³xima pÃ¡gina, retorna um vetor vazio
            else
                return new int[0];
        }
        
        // Chave ainda nÃ£o foi encontrada, continua a busca recursiva pela Ã¡rvore
        if(i==pa.n || chave1<=pa.chaves1[i])
            return lista1(chave1, pa.filhos[i]);
        else
            return lista1(chave1, pa.filhos[i+1]);
    }
        
    
    // InclusÃ£o de novos elementos na Ã¡rvore. A inclusÃ£o Ã© recursiva. A primeira
    // funÃ§Ã£o chama a segunda recursivamente, passando a raiz como referÃªncia.
    // Eventualmente, a Ã¡rvore pode crescer para cima.
    public boolean inserir(int c1, int c2) throws IOException {

        // ValidaÃ§Ã£o das chaves
        if(c1<0 || c2<0) {
            System.out.println( "Chaves nÃ£o podem ser negativas" );
            return false;
        }
            
        // Carrega a raiz
        arquivo.seek(0);       
        long pagina;
        pagina = arquivo.readLong();

        // O processo de inclusÃ£o permite que os valores passados como referÃªncia
        // sejam substituÃ­dos por outros valores, para permitir a divisÃ£o de pÃ¡ginas
        // e crescimento da Ã¡rvore. Assim, sÃ£o usados os valores globais chave1Extra 
        // e chave2Extra. Quando hÃ¡ uma divisÃ£o, as chaves promovidas sÃ£o armazenadas
        // nessas variÃ¡veis.
        chave1Extra = c1;
        chave2Extra = c2;
        
        // Se houver crescimento, entÃ£o serÃ¡ criada uma pÃ¡gina extra e serÃ¡ mantido um
        // ponteiro para essa pÃ¡gina. Os valores tambÃ©m sÃ£o globais.
        paginaExtra = -1;
        cresceu = false;
                
        // Chamada recursiva para a inserÃ§Ã£o do par de chaves
        boolean inserido = inserir1(pagina);
        
        // Testa a necessidade de criaÃ§Ã£o de uma nova raiz.
        if(cresceu) {
            
            // Cria a nova pÃ¡gina que serÃ¡ a raiz. O ponteiro esquerdo da raiz
            // serÃ¡ a raiz antiga e o seu ponteiro direito serÃ¡ para a nova pÃ¡gina.
            ArvoreBMais_Pagina novaPagina = new ArvoreBMais_Pagina(ordem);
            novaPagina.n = 1;
            novaPagina.chaves1[0] = chave1Extra;
            novaPagina.chaves2[0] = chave2Extra;
            novaPagina.filhos[0] = pagina;
            novaPagina.filhos[1] = paginaExtra;
            
            // Acha o espaÃ§o em disco. Nesta versÃ£o, todas as novas pÃ¡ginas
            // sÃ£o escrita no fim do arquivo.
            arquivo.seek(arquivo.length());
            long raiz = arquivo.getFilePointer();
            arquivo.write(novaPagina.getBytes());
            arquivo.seek(0);
            arquivo.writeLong(raiz);
        }
        
        return inserido;
    }
    
    
    // FunÃ§Ã£o recursiva de inclusÃ£o. A funÃ§Ã£o passa uma pÃ¡gina de referÃªncia.
    // As inclusÃµes sÃ£o sempre feitas em uma folha.
    private boolean inserir1(long pagina) throws IOException {
        
        // Testa se passou para o filho de uma pÃ¡gina folha. Nesse caso, 
        // inicializa as variÃ¡veis globais de controle.
        if(pagina==-1) {
            cresceu = true;
            paginaExtra = -1;
            return false;
        }
        
        // LÃª a pÃ¡gina passada como referÃªncia
        arquivo.seek(pagina);
        ArvoreBMais_Pagina pa = new ArvoreBMais_Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);
        
        // Busca o prÃ³ximo ponteiro de descida. Como pode haver repetiÃ§Ã£o
        // da primeira chave, a segunda tambÃ©m Ã© usada como referÃªncia.
        // Nesse primeiro passo, todos os pares menores sÃ£o ultrapassados.
        int i=0;
        while(i<pa.n && (chave1Extra>pa.chaves1[i] || (chave1Extra==pa.chaves1[i] && chave2Extra>pa.chaves2[i]))) {
            i++;
        }
        
        // Testa se o registro jÃ¡ existe em uma folha. Se isso acontecer, entÃ£o 
        // a inclusÃ£o Ã© cancelada.
        if(i<pa.n && pa.filhos[0]==-1 && chave1Extra==pa.chaves1[i] && chave2Extra==pa.chaves2[i]) {
            cresceu = false;
            return false;
        }
        
        // Continua a busca recursiva por uma nova pÃ¡gina. A busca continuarÃ¡ atÃ© o
        // filho inexistente de uma pÃ¡gina folha ser alcanÃ§ado.
        boolean inserido;
        if(i==pa.n || chave1Extra<pa.chaves1[i] || (chave1Extra==pa.chaves1[i] && chave2Extra<pa.chaves2[i]))
            inserido = inserir1(pa.filhos[i]);
        else
            inserido = inserir1(pa.filhos[i+1]);
        
        // A partir deste ponto, as chamadas recursivas jÃ¡ foram encerradas. 
        // Assim, o prÃ³ximo cÃ³digo sÃ³ Ã© executado ao retornar das chamadas recursivas.

        // A inclusÃ£o jÃ¡ foi resolvida por meio de uma das chamadas recursivas. Nesse
        // caso, apenas retorna para encerrar a recursÃ£o.
        // A inclusÃ£o pode ter sido resolvida porque o par de chaves jÃ¡ existia (inclusÃ£o invÃ¡lida)
        // ou porque o novo elemento coube em uma pÃ¡gina existente.
        if(!cresceu)
            return inserido;
        
        // Se tiver espaÃ§o na pÃ¡gina, faz a inclusÃ£o nela mesmo
        if(pa.n<maxElementos) {

            // Puxa todos elementos para a direita, comeÃ§ando do Ãºltimo
            // para gerar o espaÃ§o para o novo elemento
            for(int j=pa.n; j>i; j--) {
                pa.chaves1[j] = pa.chaves1[j-1];
                pa.chaves2[j] = pa.chaves2[j-1];
                pa.filhos[j+1] = pa.filhos[j];
            }
            
            // Insere o novo elemento
            pa.chaves1[i] = chave1Extra;
            pa.chaves2[i] = chave2Extra;
            pa.filhos[i+1] = paginaExtra;
            pa.n++;
            
            // Escreve a pÃ¡gina atualizada no arquivo
            arquivo.seek(pagina);
            arquivo.write(pa.getBytes());
            
            // Encerra o processo de crescimento e retorna
            cresceu=false;
            return true;
        }
        
        // O elemento nÃ£o cabe na pÃ¡gina. A pÃ¡gina deve ser dividida e o elemento
        // do meio deve ser promovido (sem retirar a referÃªncia da folha).
        
        // Cria uma nova pÃ¡gina
        ArvoreBMais_Pagina np = new ArvoreBMais_Pagina(ordem);
        
        // Copia a metade superior dos elementos para a nova pÃ¡gina,
        // considerando que maxElementos pode ser Ã­mpar
        int meio = maxElementos/2;
        for(int j=0; j<(maxElementos-meio); j++) {    
            
            // copia o elemento
            np.chaves1[j] = pa.chaves1[j+meio];
            np.chaves2[j] = pa.chaves2[j+meio];   
            np.filhos[j+1] = pa.filhos[j+meio+1];  
            
            // limpa o espaÃ§o liberado
            pa.chaves1[j+meio] = 0;
            pa.chaves2[j+meio] = 0;
            pa.filhos[j+meio+1] = -1;
        }
        np.filhos[0] = pa.filhos[meio];
        np.n = maxElementos-meio;
        pa.n = meio;
        
        // Testa o lado de inserÃ§Ã£o
        // Novo registro deve ficar na pÃ¡gina da esquerda
        if(i<=meio) {   
            
            // Puxa todos os elementos para a direita
            for(int j=meio; j>0 && j>i; j--) {
                pa.chaves1[j] = pa.chaves1[j-1];
                pa.chaves2[j] = pa.chaves2[j-1];
                pa.filhos[j+1] = pa.filhos[j];
            }
            
            // Insere o novo elemento
            pa.chaves1[i] = chave1Extra;
            pa.chaves2[i] = chave2Extra;
            pa.filhos[i+1] = paginaExtra;
            pa.n++;
            
            // Se a pÃ¡gina for folha, seleciona o primeiro elemento da pÃ¡gina 
            // da direita para ser promovido, mantendo-o na folha
            if(pa.filhos[0]==-1) {
                chave1Extra = np.chaves1[0];
                chave2Extra = np.chaves2[0];
            }
            
            // caso contrÃ¡rio, promove o maior elemento da pÃ¡gina esquerda
            // removendo-o da pÃ¡gina
            else {
                chave1Extra = pa.chaves1[pa.n-1];
                chave2Extra = pa.chaves2[pa.n-1];
                pa.chaves1[pa.n-1] = 0;
                pa.chaves2[pa.n-1] = 0;
                pa.filhos[pa.n] = -1;
                pa.n--;
            }
        } 
        
        // Novo registro deve ficar na pÃ¡gina da direita
        else {
            int j=0;
            for(j=maxElementos-meio; j>0 && (chave1Extra<np.chaves1[j-1] || (chave1Extra==np.chaves1[j-1]&&chave2Extra<np.chaves2[j-1]) ); j--) {
                np.chaves1[j] = np.chaves1[j-1];
                np.chaves2[j] = np.chaves2[j-1];
                np.filhos[j+1] = np.filhos[j];
            }
            np.chaves1[j] = chave1Extra;
            np.chaves2[j] = chave2Extra;
            np.filhos[j+1] = paginaExtra;
            np.n++;

            // Seleciona o primeiro elemento da pÃ¡gina da direita para ser promovido
            chave1Extra = np.chaves1[0];
            chave2Extra = np.chaves2[0];
            
            // Se nÃ£o for folha, remove o elemento promovido da pÃ¡gina
            if(pa.filhos[0]!=-1) {
                for(j=0; j<np.n-1; j++) {
                    np.chaves1[j] = np.chaves1[j+1];
                    np.chaves2[j] = np.chaves2[j+1];
                    np.filhos[j] = np.filhos[j+1];
                }
                np.filhos[j] = np.filhos[j+1];
                
                // apaga o Ãºltimo elemento
                np.chaves1[j] = 0;
                np.chaves2[j] = 0;
                np.filhos[j+1] = -1;
                np.n--;
            }

        }
        
        // Se a pÃ¡gina era uma folha e apontava para outra folha, 
        // entÃ£o atualiza os ponteiros dessa pÃ¡gina e da pÃ¡gina nova
        if(pa.filhos[0]==-1) {
            np.proxima=pa.proxima;
            pa.proxima = arquivo.length();
        }

        // Grava as pÃ¡ginas no arquivos arquivo
        paginaExtra = arquivo.length();
        arquivo.seek(paginaExtra);
        arquivo.write(np.getBytes());

        arquivo.seek(pagina);
        arquivo.write(pa.getBytes());
        
        return true;
    }

    
    // RemoÃ§Ã£o elementos na Ã¡rvore. A remoÃ§Ã£o Ã© recursiva. A primeira
    // funÃ§Ã£o chama a segunda recursivamente, passando a raiz como referÃªncia.
    // Eventualmente, a Ã¡rvore pode reduzir seu tamanho, por meio da exclusÃ£o da raiz.
    public boolean excluir(int chave1, int chave2) throws IOException {
                
        // Encontra a raiz da Ã¡rvore
        arquivo.seek(0);       
        long pagina;                
        pagina = arquivo.readLong();

        // variÃ¡vel global de controle da reduÃ§Ã£o do tamanho da Ã¡rvore
        diminuiu = false;  
                
        // Chama recursivamente a exclusÃ£o de registro (na chave1Extra e no 
        // chave2Extra) passando uma pÃ¡gina como referÃªncia
        boolean excluido = excluir1(chave1, chave2, pagina);
        
        // Se a exclusÃ£o tiver sido possÃ­vel e a pÃ¡gina tiver reduzido seu tamanho,
        // por meio da fusÃ£o das duas pÃ¡ginas filhas da raiz, elimina essa raiz
        if(excluido && diminuiu) {
            
            // LÃª a raiz
            arquivo.seek(pagina);
            ArvoreBMais_Pagina pa = new ArvoreBMais_Pagina(ordem);
            byte[] buffer = new byte[pa.TAMANHO_PAGINA];
            arquivo.read(buffer);
            pa.setBytes(buffer);
            
            // Se a pÃ¡gina tiver 0 elementos, apenas atualiza o ponteiro para a raiz,
            // no cabeÃ§alho do arquivo, para o seu primeiro filho.
            if(pa.n == 0) {
                arquivo.seek(0);
                arquivo.writeLong(pa.filhos[0]);  
            }
        }
         
        return excluido;
    }
    

    // FunÃ§Ã£o recursiva de exclusÃ£o. A funÃ§Ã£o passa uma pÃ¡gina de referÃªncia.
    // As exclusÃµes sÃ£o sempre feitas em folhas e a fusÃ£o Ã© propagada para cima.
    private boolean excluir1(int chave1, int chave2, long pagina) throws IOException {
        
        // InicializaÃ§Ã£o de variÃ¡veis
        boolean excluido=false;
        int diminuido;
        
        // Testa se o registro nÃ£o foi encontrado na Ã¡rvore, ao alcanÃ§ar uma folha
        // inexistente (filho de uma folha real)
        if(pagina==-1) {
            diminuiu=false;
            return false;
        }
        
        // LÃª o registro da pÃ¡gina no arquivo
        arquivo.seek(pagina);
        ArvoreBMais_Pagina pa = new ArvoreBMais_Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);

        // Encontra a pÃ¡gina em que o par de chaves estÃ¡ presente
        // Nesse primeiro passo, salta todas os pares de chaves menores
        int i=0;
        while(i<pa.n && (chave1>pa.chaves1[i] || (chave1==pa.chaves1[i] && chave2>pa.chaves2[i]))) {
            i++;
        }

        // Chaves encontradas em uma folha
        if(i<pa.n && pa.filhos[0]==-1 && chave1==pa.chaves1[i] && chave2==pa.chaves2[i]) {

            // Puxa todas os elementos seguintes para uma posiÃ§Ã£o anterior, sobrescrevendo
            // o elemento a ser excluÃ­do
            int j;
            for(j=i; j<pa.n-1; j++) {
                pa.chaves1[j] = pa.chaves1[j+1];
                pa.chaves2[j] = pa.chaves2[j+1];
            }
            pa.n--;
            
            // limpa o Ãºltimo elemento
            pa.chaves1[pa.n] = 0;
            pa.chaves2[pa.n] = 0;
            
            // Atualiza o registro da pÃ¡gina no arquivo
            arquivo.seek(pagina);
            arquivo.write(pa.getBytes());
            
            // Se a pÃ¡gina contiver menos elementos do que o mÃ­nimo necessÃ¡rio,
            // indica a necessidade de fusÃ£o de pÃ¡ginas
            diminuiu = pa.n<maxElementos/2;
            return true;
        }

        // Se a chave nÃ£o tiver sido encontrada (observar o return true logo acima),
        // continua a busca recursiva por uma nova pÃ¡gina. A busca continuarÃ¡ atÃ© o
        // filho inexistente de uma pÃ¡gina folha ser alcanÃ§ado.
        // A variÃ¡vel diminuÃ­do mantem um registro de qual pÃ¡gina eventualmente 
        // pode ter ficado com menos elementos do que o mÃ­nimo necessÃ¡rio.
        // Essa pÃ¡gina serÃ¡ filha da pÃ¡gina atual
        if(i==pa.n || chave1<pa.chaves1[i] || (chave1==pa.chaves1[i] && chave2<pa.chaves2[i])) {
            excluido = excluir1(chave1, chave2, pa.filhos[i]);
            diminuido = i;
        } else {
            excluido = excluir1(chave1, chave2, pa.filhos[i+1]);
            diminuido = i+1;
        }
        
        
        // A partir deste ponto, o cÃ³digo Ã© executado apÃ³s o retorno das chamadas
        // recursivas do mÃ©todo
        
        // Testa se hÃ¡ necessidade de fusÃ£o de pÃ¡ginas
        if(diminuiu) {

            // Carrega a pÃ¡gina filho que ficou com menos elementos do 
            // do que o mÃ­nimo necessÃ¡rio
            long paginaFilho = pa.filhos[diminuido];
            ArvoreBMais_Pagina pFilho = new ArvoreBMais_Pagina(ordem);
            arquivo.seek(paginaFilho);
            arquivo.read(buffer);
            pFilho.setBytes(buffer);
            
            // Cria uma pÃ¡gina para o irmÃ£o (da direita ou esquerda)
            long paginaIrmao;
            ArvoreBMais_Pagina pIrmao;
            
            // Tenta a fusÃ£o com irmÃ£o esquerdo
            if(diminuido>0) {
                
                // Carrega o irmÃ£o esquerdo
                paginaIrmao = pa.filhos[diminuido-1];
                pIrmao = new ArvoreBMais_Pagina(ordem);
                arquivo.seek(paginaIrmao);
                arquivo.read(buffer);
                pIrmao.setBytes(buffer);
                
                // Testa se o irmÃ£o pode ceder algum registro
                if(pIrmao.n>maxElementos/2) {
                    
                    // Move todos os elementos do filho aumentando uma posiÃ§Ã£o
                    // Ã  esquerda, gerando espaÃ§o para o elemento cedido
                    for(int j=pFilho.n; j>0; j--) {
                        pFilho.chaves1[j] = pFilho.chaves1[j-1];
                        pFilho.chaves2[j] = pFilho.chaves2[j-1];
                        pFilho.filhos[j+1] = pFilho.filhos[j];
                    }
                    pFilho.filhos[1] = pFilho.filhos[0];
                    pFilho.n++;
                    
                    // Se for folha, copia o elemento do irmÃ£o, jÃ¡ que o do pai
                    // serÃ¡ extinto ou repetido
                    if(pFilho.filhos[0]==-1) {
                        pFilho.chaves1[0] = pIrmao.chaves1[pIrmao.n-1];
                        pFilho.chaves2[0] = pIrmao.chaves2[pIrmao.n-1];
                    }
                    
                    // Se nÃ£o for folha, rotaciona os elementos, descendo o elemento do pai
                    else {
                        pFilho.chaves1[0] = pa.chaves1[diminuido-1];
                        pFilho.chaves2[0] = pa.chaves2[diminuido-1];
                    }

                    // Copia o elemento do irmÃ£o para o pai (pÃ¡gina atual)
                    pa.chaves1[diminuido-1] = pIrmao.chaves1[pIrmao.n-1];
                    pa.chaves2[diminuido-1] = pIrmao.chaves2[pIrmao.n-1];
                        
                    
                    // Reduz o elemento no irmÃ£o
                    pFilho.filhos[0] = pIrmao.filhos[pIrmao.n];
                    pIrmao.n--;
                    diminuiu = false;
                }
                
                // Se nÃ£o puder ceder, faz a fusÃ£o dos dois irmÃ£os
                else {

                    // Se a pÃ¡gina reduzida nÃ£o for folha, entÃ£o o elemento 
                    // do pai deve ser copiado para o irmÃ£o
                    if(pFilho.filhos[0] != -1) {
                        pIrmao.chaves1[pIrmao.n] = pa.chaves1[diminuido-1];
                        pIrmao.chaves2[pIrmao.n] = pa.chaves2[diminuido-1];
                        pIrmao.filhos[pIrmao.n+1] = pFilho.filhos[0];
                        pIrmao.n++;
                    }
                    
                    
                    // Copia todos os registros para o irmÃ£o da esquerda
                    for(int j=0; j<pFilho.n; j++) {
                        pIrmao.chaves1[pIrmao.n] = pFilho.chaves1[j];
                        pIrmao.chaves2[pIrmao.n] = pFilho.chaves2[j];
                        pIrmao.filhos[pIrmao.n+1] = pFilho.filhos[j+1];
                        pIrmao.n++;
                    }
                    pFilho.n = 0;   // aqui o endereÃ§o do filho poderia ser incluido em uma lista encadeada no cabeÃ§alho, indicando os espaÃ§os reaproveitÃ¡veis
                    
                    // Se as pÃ¡ginas forem folhas, copia o ponteiro para a folha seguinte
                    if(pIrmao.filhos[0]==-1)
                        pIrmao.proxima = pFilho.proxima;
                    
                    // puxa os registros no pai
                    int j;
                    for(j=diminuido-1; j<pa.n-1; j++) {
                        pa.chaves1[j] = pa.chaves1[j+1];
                        pa.chaves2[j] = pa.chaves2[j+1];
                        pa.filhos[j+1] = pa.filhos[j+2];
                    }
                    pa.chaves1[j] = 0;
                    pa.chaves2[j] = 0;
                    pa.filhos[j+1] = -1;
                    pa.n--;
                    diminuiu = pa.n<maxElementos/2;  // testa se o pai tambÃ©m ficou sem o nÃºmero mÃ­nimo de elementos
                }
            }
            
            // Faz a fusÃ£o com o irmÃ£o direito
            else {
                
                // Carrega o irmÃ£o
                paginaIrmao = pa.filhos[diminuido+1];
                pIrmao = new ArvoreBMais_Pagina(ordem);
                arquivo.seek(paginaIrmao);
                arquivo.read(buffer);
                pIrmao.setBytes(buffer);
                
                // Testa se o irmÃ£o pode ceder algum elemento
                if(pIrmao.n>maxElementos/2) {
                    
                    // Se for folha
                    if( pFilho.filhos[0]==-1 ) {
                    
                        //copia o elemento do irmÃ£o
                        pFilho.chaves1[pFilho.n] = pIrmao.chaves1[0];
                        pFilho.chaves2[pFilho.n] = pIrmao.chaves2[0];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[0];
                        pFilho.n++;

                        // sobe o prÃ³ximo elemento do irmÃ£o
                        pa.chaves1[diminuido] = pIrmao.chaves1[1];
                        pa.chaves2[diminuido] = pIrmao.chaves2[1];
                        
                    } 
                    
                    // Se nÃ£o for folha, rotaciona os elementos
                    else {
                        
                        // Copia o elemento do pai, com o ponteiro esquerdo do irmÃ£o
                        pFilho.chaves1[pFilho.n] = pa.chaves1[diminuido];
                        pFilho.chaves2[pFilho.n] = pa.chaves2[diminuido];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[0];
                        pFilho.n++;
                        
                        // Sobe o elemento esquerdo do irmÃ£o para o pai
                        pa.chaves1[diminuido] = pIrmao.chaves1[0];
                        pa.chaves2[diminuido] = pIrmao.chaves2[0];
                    }
                    
                    // move todos os registros no irmÃ£o para a esquerda
                    int j;
                    for(j=0; j<pIrmao.n-1; j++) {
                        pIrmao.chaves1[j] = pIrmao.chaves1[j+1];
                        pIrmao.chaves2[j] = pIrmao.chaves2[j+1];
                        pIrmao.filhos[j] = pIrmao.filhos[j+1];
                    }
                    pIrmao.filhos[j] = pIrmao.filhos[j+1];
                    pIrmao.n--;
                    diminuiu = false;
                }
                
                // Se nÃ£o puder ceder, faz a fusÃ£o dos dois irmÃ£os
                else {

                    // Se a pÃ¡gina reduzida nÃ£o for folha, entÃ£o o elemento 
                    // do pai deve ser copiado para o irmÃ£o
                    if(pFilho.filhos[0] != -1) {
                        pFilho.chaves1[pFilho.n] = pa.chaves1[diminuido];
                        pFilho.chaves2[pFilho.n] = pa.chaves2[diminuido];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[0];
                        pFilho.n++;
                    }
                    
                    // Copia todos os registros do irmÃ£o da direita
                    for(int j=0; j<pIrmao.n; j++) {
                        pFilho.chaves1[pFilho.n] = pIrmao.chaves1[j];
                        pFilho.chaves2[pFilho.n] = pIrmao.chaves2[j];
                        pFilho.filhos[pFilho.n+1] = pIrmao.filhos[j+1];
                        pFilho.n++;
                    }
                    pIrmao.n = 0;   // aqui o endereÃ§o do irmÃ£o poderia ser incluido em uma lista encadeada no cabeÃ§alho, indicando os espaÃ§os reaproveitÃ¡veis
                    
                    // Se a pÃ¡gina for folha, copia o ponteiro para a prÃ³xima pÃ¡gina
                    pFilho.proxima = pIrmao.proxima;
                    
                    // puxa os registros no pai
                    for(int j=diminuido; j<pa.n-1; j++) {
                        pa.chaves1[j] = pa.chaves1[j+1];
                        pa.chaves2[j] = pa.chaves2[j+1];
                        pa.filhos[j+1] = pa.filhos[j+2];
                    }
                    pa.n--;
                    diminuiu = pa.n<maxElementos/2;  // testa se o pai tambÃ©m ficou sem o nÃºmero mÃ­nimo de elementos
                }
            }
            
            // Atualiza todos os registros
            arquivo.seek(pagina);
            arquivo.write(pa.getBytes());
            arquivo.seek(paginaFilho);
            arquivo.write(pFilho.getBytes());
            arquivo.seek(paginaIrmao);
            arquivo.write(pIrmao.getBytes());
        }
        return excluido;
    }
    
    
    // Imprime a Ã¡rvore, usando uma chamada recursiva.
    // A funÃ§Ã£o recursiva Ã© chamada com uma pÃ¡gina de referÃªncia (raiz)
    public void print() throws IOException {
        long raiz;
        arquivo.seek(0);
        raiz = arquivo.readLong();
        if(raiz!=-1)
            print1(raiz);
        System.out.println();
    }
    
    // ImpressÃ£o recursiva
    private void print1(long pagina) throws IOException {
        
        // Retorna das chamadas recursivas
        if(pagina==-1)
            return;
        int i;

        // LÃª o registro da pÃ¡gina passada como referÃªncia no arquivo
        arquivo.seek(pagina);
        ArvoreBMais_Pagina pa = new ArvoreBMais_Pagina(ordem);
        byte[] buffer = new byte[pa.TAMANHO_PAGINA];
        arquivo.read(buffer);
        pa.setBytes(buffer);
        
        // Imprime a pÃ¡gina
        String endereco = String.format("%04d", pagina);
        System.out.print(endereco+"  " + pa.n +":"); // endereÃ§o e nÃºmero de elementos
        for(i=0; i<maxElementos; i++) {
            System.out.print("("+String.format("%04d",pa.filhos[i])+") "+String.format("%2d",pa.chaves1[i])+","+String.format("%2d",pa.chaves2[i])+" ");
        }
        System.out.print("("+String.format("%04d",pa.filhos[i])+")");
        if(pa.proxima==-1)
            System.out.println();
        else
            System.out.println(" --> ("+String.format("%04d", pa.proxima)+")");
        
        // Chama recursivamente cada filho, se a pÃ¡gina nÃ£o for folha
        if(pa.filhos[0] != -1) {
            for(i=0; i<pa.n; i++)
                print1(pa.filhos[i]);
            print1(pa.filhos[i]);
        }
    }
    
    
    public static void main(String[] args) {

        ArvoreBMais arvore;
        
        try {
            
            File f = new File("dados.db");
            f.delete();
            arvore = new ArvoreBMais(5,"dados.db");
            
            System.out.println("Ã�rvore B+\n");
            System.out.println("InserÃ§Ã£o de 20,20");
            arvore.inserir( 20, 20 );
            arvore.print();
            System.out.println("InserÃ§Ã£o de 20,21");
            arvore.inserir( 20, 21 );
            arvore.print();
            System.out.println("InserÃ§Ã£o de 30,30");
            arvore.inserir( 30, 30 );
            arvore.print();
            System.out.println("InserÃ§Ã£o de 20,13");
            arvore.inserir( 20, 13 );
            arvore.print();
            System.out.println("InserÃ§Ã£o de 20,28");
            arvore.inserir( 20, 28 );
            arvore.print();
            
            System.out.println("Lista de chaves2 de 20:");
            int[] lista = arvore.lista(20);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+"  ");
            }
            System.out.println("\n");
            
            System.out.println("InserÃ§Ã£o de 10,10");
            arvore.inserir(10,10);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 10,11");
            arvore.inserir(10,11);
            arvore.print();

            System.out.println("InserÃ§Ã£o de 1,10");
            arvore.inserir(1,10);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 1,11");
            arvore.inserir(1,11);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 2,10");
            arvore.inserir(2,10);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 2,11");
            arvore.inserir(2,11);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 3,10");
            arvore.inserir(3,10);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 3,11");
            arvore.inserir(3,11);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 4,10");
            arvore.inserir(4,10);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 4,11");
            arvore.inserir(4,11);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 4,12");
            arvore.inserir(4,12);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 4,13");
            arvore.inserir(4,13);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 4,14");
            arvore.inserir(4,14);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 4,15");
            arvore.inserir(4,15);
            arvore.print();
            System.out.println("InserÃ§Ã£o de 4,16");
            arvore.inserir(4,16);
            arvore.print();

            System.out.println("RemoÃ§Ã£o de 20,20");
            arvore.excluir(20,20);
            arvore.print();
            System.out.println("RemoÃ§Ã£o de 20,13");
            arvore.excluir(20,13);
            arvore.print();


            System.out.println("Lista de chaves2 de 20:");
            lista = arvore.lista(20);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+" ");
            }
            System.out.println("\n");

            
            System.out.println("RemoÃ§Ã£o de 20,21");
            arvore.excluir(20,21);
            arvore.print();
            System.out.println("RemoÃ§Ã£o de 20,28");
            arvore.excluir(20,28);
            arvore.print();
            System.out.println("RemoÃ§Ã£o de 1,10");
            arvore.excluir(1,10);
            arvore.print();

            System.out.println("RemoÃ§Ã£o de 4,12");
            arvore.excluir(4,12);
            arvore.print();

            System.out.println("RemoÃ§Ã£o de 4,13");
            arvore.excluir(4,13);
            arvore.print();

            int chave = 1;
            System.out.print("Lista de chaves2 de "+chave+": ");
            lista = arvore.lista(chave);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+" ");
            }
            System.out.println("\n");

            chave = 2;
            System.out.print("Lista de chaves2 de "+chave+": ");
            lista = arvore.lista(chave);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+" ");
            }
            System.out.println("\n");

            chave = 3;
            System.out.print("Lista de chaves2 de "+chave+": ");
            lista = arvore.lista(chave);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+" ");
            }
            System.out.println("\n");

            chave = 4;
            System.out.print("Lista de chaves2 de "+chave+": ");
            lista = arvore.lista(chave);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+" ");
            }
            System.out.println("\n");

            chave = 10;
            System.out.print("Lista de chaves2 de "+chave+": ");
            lista = arvore.lista(chave);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+" ");
            }
            System.out.println("\n");

            chave = 30;
            System.out.print("Lista de chaves2 de "+chave+": ");
            lista = arvore.lista(chave);
            for(int i=0; i<lista.length; i++) {
                System.out.print(lista[i]+" ");
            }
            System.out.println("\n");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
            
        
    }
    
}
