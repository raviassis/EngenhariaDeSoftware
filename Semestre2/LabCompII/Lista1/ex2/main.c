#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"


int main()
{
    int num;
    printf("EX2 - Serie Fibonacci\n");
    printf("Informe a posicao desejada: ");
    scanf("%d", &num);

    printf("O elemento da posicao %d e %d", num, fibo(num));

    return 0;
}
