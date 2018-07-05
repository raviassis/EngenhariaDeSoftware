/*batalha_naval.c*/
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>


/*------------------------------------------------*/
/*           Estrutura dos navios                 */
typedef struct navio1{
	char posicao[5][2]; //posicao[ corpo do navio ] [ coordenada (linha = 0 , colula= 1) ]
}porta_avioes;

typedef struct navio2{
	char posicao[4][2];  
}cruzador;

typedef struct navio3{
	char posicao[3][2];  
}contratorpedo;

typedef struct navio4{
	char posicao[2][2];  
}rebocador;
/*************************************************/

/*Variaveis externas*****************************/
char painel[10][10]; //painel[linha][coluna]
char ocupacao[21][2]; //ocupacao[n ocupação][linha = 0, coluna= 1]
int id_ocp; //numero da ocupação atual
int acertos; //contador de acertos
int jogadas; //contador de jogadas
/****************************************************************************/

/*print_painel() - Printa na tela o painel do jogo com os campos atualizados*/
void print_painel( ){
	int lin, col;
	printf("\t| A | B | C | D | E | F | G | H | I | J |\n");
	printf("     --------------------------------------------\n");
	for (lin = 0; lin <10 ; lin++){
		printf("     %d\t", lin+1);
		for(col = 0; col <10; col ++){
			printf("| %c ", painel[lin][col]);
		}
		printf("|\n");
		printf("     --------------------------------------------\n");
	}	
}
/****************************************************************************/

/****************************************************************************/
/*Inicializa_painel() - inicializa o painel limpando todos os campos*/
void inicializa_painel( ){
	int lin, col;
	for (lin = 0; lin <10 ; lin++){
		for(col = 0; col <10; col ++)	painel[lin][col] = ' ';
	}
}
/*****************************************************************************/

/*verifica(char, char , int)*/
/*verifica se posicao ja foi ocupada por outro navio*/
int verifica (char lin, char col, int dir){
	int id = 0;
	if (dir == 0){	//norte
		for (lin; lin > 0; lin--){
			for (id = 0; id < id_ocp; id++){
				if (ocupacao[id][0] == lin && ocupacao[id][1] == col){	printf("\nfunc verifica retornou zero. lin = %d, c= %c, dir= %d", lin, col, dir) ; return 0;}
			}
		}
	}
	else if (dir == 1){	//sul
		for (lin; lin < 10; lin++){
			for (id = 0; id < id_ocp; id++){
				if (ocupacao[id][0] == lin && ocupacao[id][1] == col){	printf("\nfunc verifica retornou zero. lin = %d, c= %c, dir= %d", lin, col, dir) ; return 0;}		
			}
		}
	}
	else if (dir == 2){
		for (col; col <= 'J'; col++){
			for (id = 0; id < id_ocp; id++){
				if (ocupacao[id][0] == lin && ocupacao[id][1] == col){	printf("\nfunc verifica retornou zero. lin = %d, c= %c, dir= %d", lin, col, dir) ; return 0;}		
			}
		}
	}
	else if (dir == 3){
		for (col; col >= 'A'; col--){
			for (id = 0; id < id_ocp; id++){
				if (ocupacao[id][0] == lin && ocupacao[id][1] == col){	printf("\nfunc verifica retornou zero. lin = %d, c= %c, dir= %d", lin, col, dir) ; return 0;}		
			}
		}
	}
	return 1;
}
/************************************************************/

/*ini_navio1_auto (porta_avioes a)*/
/*posiciona o navio porta_avioes em local aleatório do painel*/
porta_avioes ini_navio1_auto (porta_avioes a){
	int dir, cont = 0; // dir para sentido em que sera posicionado o navio. cont para fazer um limite máximo de loops do while
	char lin, col;
	
	while(cont < 50){
		lin = (rand()%10); //posicao da ponta do navio
		col = (rand()%10)+ 65;
		dir = rand()%4; //sentido em que sera posicionado o resto do navio
		if ( dir == 0 && lin >= 4) {	//dir == norte
			int p;
			for(p = 0; p <5; p++){
				a.posicao[p][0] = lin--;
			}
			for(p = 0; p <5; p++){
				a.posicao[p][1] = col;
			}
			for (p = 0; p <5; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0]; 
				ocupacao[id_ocp][1] = a.posicao[p][1]; 
				printf ("\nocupacao[%d][0] = %d", id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			
			return a;
		}
		else if ( dir == 1 && lin <= 5) { // dir == sul
			int p;
			for(p = 0; p <5; p++) a.posicao[p][0] = lin++;
			for(p = 0; p <5; p++) a.posicao[p][1] = col;
			for (p = 0; p <5; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d", id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			return a;
		}
		else if (dir == 2 && col <= 'F' ) {  // dir == leste
			int p;
			for(p = 0; p <5; p++) a.posicao[p][0] = lin;
			for(p = 0; p <5; p++) a.posicao[p][1] = col++;
			for (p = 0; p <5; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			return a;
		}
		else if (dir == 3 && col >= 'E') {  // dir == Oeste
			int p;
			for(p = 0; p <5; p++) a.posicao[p][0] = lin;
			for(p = 0; p <5; p++) a.posicao[p][1] = col--;
			for (p = 0; p <5; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			return a;
		}
		printf("\nLoop em nav1 cont = %d", cont);
		cont++;
	}
	printf("\nErro: função ini_navio1_auto()\n");
}
/***********************************************************************/

cruzador ini_navio2_auto(cruzador a){
	int dir, cont = 0, test; // dir para sentido em que sera posicionado o navio. cont para fazer um limite máximo de loops do while
	char lin, col;

	
	while(cont < 50){
		lin = (rand()%10); //posicao da ponta do navio
		col = (rand()%10)+ 65;
		dir = rand()%4; //sentido em que sera posicionado o resto do navio
		test = verifica(lin, col, dir);
		printf("\nchamada func verifica() em ini_navio2_auto\n retorno teste = %d", test);
		if ( dir == 0 && lin >= 3 && test ==1) {	//dir == norte
			int p;
			for(p = 0; p <4; p++) a.posicao[p][0] = lin--;
			for(p = 0; p <4; p++) a.posicao[p][1] = col;
			for (p = 0; p <4; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			return a;
		}
		else if ( dir == 1 && lin <= 6 && test==1) { // dir == sul
			int p;
			for(p = 0; p <4; p++) a.posicao[p][0] = lin++;
			for(p = 0; p <4; p++) a.posicao[p][1] = col;
			for (p = 0; p <4; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			return a;
		}
		else if (dir == 2 && col <= 'G' && test==1) {  // dir == leste
			int p;
			for(p = 0; p <4; p++) a.posicao[p][0] = lin;
			for(p = 0; p <4; p++) a.posicao[p][1] = col++;
			for (p = 0; p <4; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			return a;
		}
		else if (dir == 3 && col >= 'D' && test==1) {  // dir == Oeste
			int p;
			for(p = 0; p <4; p++) a.posicao[p][0] = lin;
			for(p = 0; p <4; p++) a.posicao[p][1] = col--;
			for (p = 0; p <4; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
			}
			return a;
		}
		printf("\nLoop em nav2 cont = %d", cont);
		cont++;
	}
	printf("\nErro: função ini_navio2_auto()\n");
}

contratorpedo ini_navio3_auto (contratorpedo a){
	int dir, cont = 0, test; // dir para sentido em que sera posicionado o navio. cont para fazer um limite máximo de loops do while
	char lin, col;

	
	while(cont < 50){
		lin = (rand()%10); //posicao da ponta do navio
		col = (rand()%10)+ 65;
		dir = rand()%4; //sentido em que sera posicionado o resto do navio
		test = verifica(lin, col, dir);
		if(test == 1) { 
			printf("\nFuncao verifica() retornou 1 em ini_navio3_auto");
			if ( dir == 0 && lin >= 2) {	//dir == norte
				int p;
				for(p = 0; p <3; p++) a.posicao[p][0] = lin--;
				for(p = 0; p <3; p++) a.posicao[p][1] = col;
				for (p = 0; p <3; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
			else if ( dir == 1 && lin <= 7) { // dir == sul
				int p;
				for(p = 0; p <3; p++) a.posicao[p][0] = lin++;
				for(p = 0; p <3; p++) a.posicao[p][1] = col;
				for (p = 0; p <3; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
			else if (dir == 2 && col <= 'H' ) {  // dir == leste
				int p;
				for(p = 0; p <3; p++) a.posicao[p][0] = lin;
				for(p = 0; p <3; p++) a.posicao[p][1] = col++;
				for (p = 0; p <3; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
			else if (dir == 3 && col >= 'C') {  // dir == Oeste
				int p;
				for(p = 0; p <3; p++) a.posicao[p][0] = lin;
				for(p = 0; p <3; p++) a.posicao[p][1] = col--;
				for (p = 0; p <3; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
		}
		printf("\nLoop em nav3 cont = %d", cont);
		cont++;
	}
	printf("\nErro: função ini_navio3_auto()\n");
}

rebocador ini_navio4_auto (rebocador a){
	int dir, cont = 0, test; // dir para sentido em que sera posicionado o navio. cont para fazer um limite máximo de loops do while
	char lin, col;

	
	while(cont < 50){
		lin = (rand()%10); //posicao da ponta do navio
		col = (rand()%10)+ 65;
		dir = rand()%4; //sentido em que sera posicionado o resto do navio
		test = verifica(lin, col, dir);
		if(test == 1){
			printf("\nFuncao verifica() retornou 1 em ini_navio4_auto");
			if ( dir == 0 && lin >= 1) {	//dir == norte
				int p;
				for(p = 0; p <2; p++) a.posicao[p][0] = lin--;
				for(p = 0; p <2; p++) a.posicao[p][1] = col;
				for (p = 0; p <2; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
			else if ( dir == 1 && lin <= 8) { // dir == sul
				int p;
				for(p = 0; p <2; p++) a.posicao[p][0] = lin++;
				for(p = 0; p <2; p++) a.posicao[p][1] = col;
				for (p = 0; p <2; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
			else if (dir == 2 && col <= 'I' ) {  // dir == leste
				int p;
				for(p = 0; p <2; p++) a.posicao[p][0] = lin;
				for(p = 0; p <2; p++) a.posicao[p][1] = col++;
				for (p = 0; p <2; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
			else if (dir == 3 && col >= 'B') {  // dir == Oeste
				int p;
				for(p = 0; p <2; p++) a.posicao[p][0] = lin;
				for(p = 0; p <2; p++) a.posicao[p][1] = col--;
				for (p = 0; p <2; p++){
				ocupacao[id_ocp][0] = a.posicao[p][0];
				ocupacao[id_ocp][1] = a.posicao[p][1];
				printf ("\nocupacao[%d][0] = %d" , id_ocp, ocupacao[id_ocp][0]);
				printf ("	ocupacao[%d][0] = %c", id_ocp, ocupacao[id_ocp][1]);
				printf("	id_ocp = %d", id_ocp );
				id_ocp++;
				}
				return a;
			}
		}printf("\nLoop em nav4 cont = %d", cont);
		cont++;
	}
	printf("\nErro: função ini_navio4_auto()\n");
}

void ataque(char in_col, int in_lin){
	int id;
	int col, lin;
	col = in_col - 65; //converte alfabeto para inteiro. ex: A->0, b->1, c->2 .......
	lin = in_lin ; //converte contagem de 1 a 10 para 0 a 9.
	printf("\n\nFunc ataque - Col = %d, Lin = %d\n", col, lin);
	
	for (id= 0; id < id_ocp; id++){ 
		
		if (in_lin == ocupacao[id][0] && in_col == ocupacao[id][1]){  //verificar se foi posicionado algum navio em in_lin e in_col
			painel[lin][col] = 'X';
			acertos ++;
			print_painel();
			printf("\n###Alvo atingido###\n");
			return;					
		}		
	}
	
	painel[lin][col] = '@';
	print_painel();
	printf("\nVoce errou o alvo!\n\n");
	return;	
}


int main () {
	id_ocp=0;  //inicia o contador de ocupações
	acertos=0; //inicia o contador de acertos
	jogadas=0; //inicia o contador de jogadas
	/* declara as variaveis navios*/
	porta_avioes a;
	cruzador b;
	contratorpedo c1, c2;
	rebocador d1, d2, d3;
	/********************************/
	
	int p, in_lin;  // in_lin = linha dada pelo usuário
	char in_col;	// in_col = coluna dada pelo usuário
	char ch;
	
	do {
		/*Posiciona os navios*/
		a = ini_navio1_auto (a);
		b = ini_navio2_auto (b);
		c1 = ini_navio3_auto (c1);
		c2 = ini_navio3_auto (c2);
		d1 = ini_navio4_auto (d1);
		d2 = ini_navio4_auto (d2);
		d3 = ini_navio4_auto (d3);
		/************************/
	
		/*teste dos valores preenchidos nos navios*/
		printf("\n\nPortaAvioes\n");
		for (p = 0; p< 5; p++){
			printf("a.posicao[%d][0] = %d  ",p, a.posicao[p][0]); printf("a.posicao[%d][1] = %c\n", p, a.posicao[p][1]);
		}
		
		printf("\n\nCruzador\n");
		for (p = 0; p< 4; p++){
			printf("b.posicao[%d][0] = %d  ",p, b.posicao[p][0]); printf("b.posicao[%d][1] = %c\n", p, b.posicao[p][1]);
		}
	
		printf("\n\nContratorpedo C1\n");
		for (p = 0; p< 3; p++){
			printf("c1.posicao[%d][0] = %d  ",p, c1.posicao[p][0]); printf("c1.posicao[%d][1] = %c\n", p, c1.posicao[p][1]);
		}
	
		printf("\n\nContratorpedo C2\n");
		for (p = 0; p< 3; p++){
			printf("c2.posicao[%d][0] = %d  ",p, c2.posicao[p][0]); printf("c2.posicao[%d][1] = %c\n", p, c2.posicao[p][1]);
		}
		
		printf("\n\nRebocador D1\n");
		for (p = 0; p< 2; p++){
			printf("d1.posicao[%d][0] = %d  ",p, d1.posicao[p][0]); printf("d1.posicao[%d][1] = %c\n", p, d1.posicao[p][1]);
		}
		
		printf("\n\nRebocador D2\n");
		for (p = 0; p< 2; p++){
			printf("d2.posicao[%d][0] = %d  ",p, d2.posicao[p][0]); printf("d2.posicao[%d][1] = %c\n", p, d2.posicao[p][1]);
		}
		
		printf("\n\nRebocador D3\n");
		for (p = 0; p< 2; p++){
			printf("d3.posicao[%d][0] = %d  ",p, d3.posicao[p][0]); printf("d3.posicao[%d][1] = %c\n", p, d3.posicao[p][1]);
		}
		/******************************************************************************************************************/
		
		/*Inicia tela do jogo*/
		inicializa_painel();
		print_painel();
		/********************/
		
		/*inicio do jogo*/
		do {
			printf("\n\nDe as coordenadas para o ataque.\nColuna: "); 
			in_col = getche();
			if(in_col >= 'a' && in_col <= 'j') {  //converte de minusculo para maisculo
				in_col -= 'a';
				in_col += 'A';
			}
			printf("	Linha: ");
			scanf("%d%*c", &in_lin);
			in_lin--;
			//in_lin = getche();
		
			if(in_col >= 'A' && in_col <= 'J' && in_lin >=0 && in_lin <=9) { //confere dados
				ataque(in_col, in_lin);
				jogadas++;
			}
			else printf("\n###Dados invalidos###\n");
		} while ( acertos < 21 );
		
		printf("\nTodos os navios foram abatidos.");
		printf("\nFim de jogo.");
		printf("\nQuantidade de jogadas: %d", jogadas);
		printf("\n\nDeseja jogar uma nova partida? (s/n)");
		for (;;){
			ch = getche();
			if(ch == 's' || ch == 'S' || ch == 'n' || ch == 'N'){
				break;
			}else {
				printf ("\nDado invalido.\nDeseja jogar uma nova partida? (s/n)");
			}
		}
	} while(ch == 's' || ch == 'S');	
	
	
	system("pause");
	return 0 ;	
}
