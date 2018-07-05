#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"


int main()
{
    int num;
    printf("EX3 - Somatorio Serie Fibonacci\n");
    printf("Informe a posicao desejada: ");
    scanf("%d", &num);

    printf("O somatorio da serie ate a posicao %d e %d", num, SomaFiboRec(num));

    return 0;
}
