#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex6 - Desenvolver um algoritmo que leia três números inteiros: X, Y, Z e verifique se o
número X é divisível por Y e por Z. O algoritmo deverá mostrar as possíveis
mensagens:
- o número é divisível por Y e Z.
- o número é divisível por Y mas não por Z.
- o número é divisível por Z mas não por Y.
- o número não é divisível nem Y nem por Z.
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
            printf("Divisível por Y e Z");
        }
        else {
            printf("Divisível por Y mas não por Z");
        }
    }
    else {
        if(x%z==0){
            printf("Divisível por Z mas não por Y");
        }
        else {
            printf("Não é divisível por Y e nem por Z");
        }
    }
    return 0;
}
