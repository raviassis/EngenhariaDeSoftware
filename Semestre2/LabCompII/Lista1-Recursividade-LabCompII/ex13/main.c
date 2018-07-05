#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet[] = {1,2,6,4,6,6};
    int tam = 6;
    int elem = 4;
    printf("EX13 - Indice da primeira ocorrencia de um valor - Recursivo\n\n");
    printf("Vetor: ");
    PrintArrayRec(vet,tam, 0);
    printf("\n\nIndex da primeira ocorrencia de %d no vetor: %d", elem, IndexOfRec(vet, tam, 0, elem) );
    printf("\n\n");
    return 0;
}
