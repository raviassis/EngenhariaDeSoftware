#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet[] = {1,2,6,4,6};
    int tam = 5;
    int elem = 6;
    printf("EX11 - Conta ocorrencias de um elemento num vetor - Recursivo\n\n");
    printf("Vetor: ");
    PrintArrayRec(vet,tam, 0);
    printf("\n\nOcorrencias do elemento %d no vetor: %d", elem, CountElementsArrayRec(vet, tam, 0, elem) );
    printf("\n\n");
    return 0;
}
