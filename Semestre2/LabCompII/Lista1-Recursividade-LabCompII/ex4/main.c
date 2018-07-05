#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int num;
    printf("EX4 - Somatorio Serie Fibonacci\n");
    printf("Informe a posicao desejada: ");
    scanf("%d", &num);

    printf("O somatorio da serie ate a posicao %d e %d", num, SomaFibo(num));

    return 0;
}
