#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex6 - Desenvolver um algoritmo que leia tr�s n�meros inteiros: X, Y, Z e verifique se o
n�mero X � divis�vel por Y e por Z. O algoritmo dever� mostrar as poss�veis
mensagens:
- o n�mero � divis�vel por Y e Z.
- o n�mero � divis�vel por Y mas n�o por Z.
- o n�mero � divis�vel por Z mas n�o por Y.
- o n�mero n�o � divis�vel nem Y nem por Z.
*/

int main()
{
    setlocale(LC_ALL, "portuguese");
    int x,y,z;
    printf("X= ");
    scanf("%d", &x);
    printf("Y= ");
    scanf("%d", &y);
    printf("Z= ");
    scanf("%d", &z);

    if (x%y==0){
        if(x%z==0){
            printf("Divis�vel por Y e Z");
        }
        else {
            printf("Divis�vel por Y mas n�o por Z");
        }
    }
    else {
        if(x%z==0){
            printf("Divis�vel por Z mas n�o por Y");
        }
        else {
            printf("N�o � divis�vel por Y e nem por Z");
        }
    }
    return 0;
}
