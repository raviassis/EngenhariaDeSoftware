#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet[10], num,i, resp;

    for (i = 0; i<10; i++) {
        printf("Digite um número para vet[%d]: ", i);
        scanf("%d", &vet[i]);
    }

    printf("\nDigite a posicao do vetor de 1 a 10: ");
    scanf("%d", &resp);
    while (resp != -1) {
        printf("vet[%d]= %d", resp, vet[resp-1]);
        printf("\nDigite a posicao do vetor de 1 a 10: ");
        scanf("%d", &resp);
    }

    return 0;
}
