#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet[] = {1,2,3,4,6};
    int tam = 5;
    printf("EX10 - Soma Elementos de um vetor\n\n");
    printf("Vetor: ");
    PrintArray(vet,tam);
    printf("\n\nSoma dos elementos dos vetores: %d", SumArrayElements(vet, tam) );
    printf("\n\n");
    return 0;
}
