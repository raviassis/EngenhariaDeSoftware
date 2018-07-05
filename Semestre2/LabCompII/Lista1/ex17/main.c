#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet1[] = {2,1,1,2};
    int vet2[] = {1,2,4,5};
    int tam = 4;

    printf("EX17 - Palindromo Recursivo\n\n");

    printf("Vetor 1: ");
    PrintArrayRec(vet1, tam, 0);
    printf("\nVetor 2: ");
    PrintArrayRec(vet2, tam, 0);

    printf("\n\nVetor 1 e palindromo? ");
    if ( IsPalindromeRec(vet1, tam, 0) ) printf("Sim!");
    else printf("Nao!");

    printf("\n\nVetor 2 e palindromo? ");
    if ( IsPalindromeRec(vet2, tam, 0) ) printf("Sim!");
    else printf("Nao!");

    printf("\n\n");

    return 0;
}
