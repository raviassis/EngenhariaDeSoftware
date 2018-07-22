#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
5-h) Ler dois números inteiros para variáveis a e b. Trocar o valor de b com o
de a, e imprimi-los.
*/

int main()
{
    setlocale(LC_ALL,"portuguese");
    int a, b, aux;
    printf("Informe o valor de a: ");
    scanf("%d", &a);
    printf("Informe o valor de b: ");
    scanf("%d", &b);
    aux = a;
    a = b;
    b = aux;
    printf("Invertendo a e b\n");
    printf("a=%d e b=%d", a, b);

    return 0;
}
