#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int vet[] = {1,2,3,4,5};
    int tam = 5;
    printf("EX5 - Imprime Vetor Recursivo\n\n");
    PrintArrayRec(vet,tam,0);
    printf("\n\n");
    return 0;
}
