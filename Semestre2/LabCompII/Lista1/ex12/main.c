#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet[] = {1,2,6,4,6,6};
    int tam = 6;
    int elem = 6;
    printf("EX12 - Conta ocorrencias de um elemento num vetor\n\n");
    printf("Vetor: ");
    PrintArray(vet,tam);
    printf("\n\nOcorrencias do elemento %d no vetor: %d", elem, CountElementsArray(vet, tam, elem) );
    printf("\n\n");
    return 0;
}
