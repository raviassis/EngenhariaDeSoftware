#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet[] = {1,2,6,4,6,6};
    int tam = 6;
    int elem = 1;
    printf("EX14 - Indice da primeira ocorrencia de um valor\n\n");
    printf("Vetor: ");
    PrintArray(vet,tam);
    printf("\n\nIndex da primeira ocorrencia de %d no vetor: %d", elem, IndexOf(vet, tam, elem) );
    printf("\n\n");
    return 0;
}
