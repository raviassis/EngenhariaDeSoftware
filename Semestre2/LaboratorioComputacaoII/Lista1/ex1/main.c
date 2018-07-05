#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int num;
    printf("EX1 - Fibonacci Recursivo\n");
    printf("Informe a posicao desejada: ");
    scanf("%d", &num);

    printf("O elemento da posicao %d e %d", num, fiboRec(num));

    return 0;
}
