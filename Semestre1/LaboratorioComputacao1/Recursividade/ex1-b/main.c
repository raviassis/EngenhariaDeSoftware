#include <stdio.h>
#include <stdlib.h>

int somatorio(int max) {
    if (max == 0) {
        return max;
    }
    else {
        return max + somatorio(max-1);
    }
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
