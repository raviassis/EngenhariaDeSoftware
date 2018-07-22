#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex5 -  Construa um algoritmo que receba como entrada três valores (A,B e C). Após o
processamento o menor valor deverá estar em A e o maior valor em C, e o valor
intermediário em B. Imprima A,B e C.
*/

//funcao troca: troca o endereco de memoria entre duas variaveis
void troca (int *x, int *y){
    int au;
    au = *y;
    *y = *x;
    *x = au;
}

int main()
{
    setlocale(LC_ALL, "portuguese");
    int a,b,c,aux;
    printf("Informe valor de a: ");
    scanf("%d", &a);
    printf("Informe valor de b: ");
    scanf("%d", &b);
    printf("Informe valor de c: ");
    scanf("%d", &c);

    if (a > b) {
        troca(&a,&b);
    }
    if (a > c) {
        troca(&a,&c);
    }
    if (b > c) {
        troca(&b,&c);
    }
    printf("\n\na = %d, b = %d, c = %d", a,b,c);
    return 0;
}
