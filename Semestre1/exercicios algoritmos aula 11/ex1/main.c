#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet[10], i, soma= 0;
    for (i=0; i<10; i++) {
        printf("Digite um numero: ");
        scanf("%d", &vet[i]);
        soma = soma + vet[i];
    }
    printf("Soma total do vetor: %d", soma);
    return 0;
}
