#include <stdio.h>
#include <stdlib.h>

float produto (float a, int b) {
    int i;
    float soma=0.0;
    for (i=0; i < b; i++) {
        soma+= a;
    }
    return soma;
}

int main()
{
    int b;
    float a;

    printf("Exercicio 7 - Produto de a e b\n");
    printf("Valor de A (real): "); scanf("%f", &a);
    printf("Valor de B (inteiro): "); scanf("%d", &b );
    printf("Produto de A e B: %.2f\n", produto(a,b));

    return 0;
}
