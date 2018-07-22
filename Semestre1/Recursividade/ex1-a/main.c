#include <stdio.h>
#include <stdlib.h>

int somatorio(int max) {
    int soma=0, n=1;
    while (n<=max) {
        soma = soma + n;
        n++;
    }
    return soma;
}

int main()
{
    int num, soma;
    printf("Digite um numero inteiro: ");
    scanf("%d", &num);
    soma = somatorio(num);
    printf("\nSomatorio: %d", soma);
    return 0;
}
