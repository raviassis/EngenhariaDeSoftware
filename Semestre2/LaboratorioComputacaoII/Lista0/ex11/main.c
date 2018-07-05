#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet1 [10];
    int i, aux=0;

    printf("Ex. 11 - Vetor inverso\n\n");
    printf("Preencha o vetor abaixo:\n");
    for (i=0; i<10; i++) {
        printf("Vet[%d] = ", i);
        scanf("%d", &vet1[i]);
    }

    for (i = 0; i < 5; i++) {
        aux = vet1[i];
        vet1[i] = vet1[9-i];
        vet1[9-i] = aux;
    }

    for (i = 0; i< 10; i++) {
        printf("Vet[%d] = %d\n", i, vet1[i]);
    }
    return 0;
}
