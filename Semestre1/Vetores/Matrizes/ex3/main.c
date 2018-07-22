#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet[10], i, menor, maior;

    for (i = 0; i<10; i++) {
        printf("Digite um número para vet[%d]: ", i);
        scanf("%d", &vet[i]);
    }
    maior = menor = vet[0];

    for (i= 0; i<10; i++) {
        if (menor > vet[i]) {
            menor = vet[i];
        }
        else if (maior < vet[i]) {
            maior = vet[i];
        }
    }
    printf("Maior: %d\nMenor: %d", maior, menor);


    return 0;
}
