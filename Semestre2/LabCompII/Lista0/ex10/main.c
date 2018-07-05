#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet1 [10], vet2[10];
    int i, j=0;

    printf("Ex. 10 - Vetor inverso\n\n");
    printf("Preencha o vetor abaixo:\n");
    for (i=0; i<10; i++) {
        printf("Vet[%d] = ", i);
        scanf("%d", &vet1[i]);
    }
    printf("\n");
    i--;
    while (i>=0) {
        vet2[j] = vet1[i];
        i--;
        j++;
    }

    for (i = 0; i < 10; i++) {
        printf("Vet[%d] = %d\n", i, vet2[i]);
    }
    return 0;
}
