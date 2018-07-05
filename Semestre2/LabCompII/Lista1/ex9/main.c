#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet[] = {1,2,3,4,5};
    int tam = 5;
    printf("EX9 - Soma Elementos de um vetor Recursivo\n\n");
    printf("Vetor: ");
    PrintArrayRec(vet,tam,0);
    printf("\n\nSoma dos elementos dos vetores: %d", SumArrayElementsRec(vet, tam, 0) );
    printf("\n\n");
    return 0;
}
