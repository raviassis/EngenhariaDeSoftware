#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int n1, n2;
    printf("EX15 - MDC Recursivo\n\n");
    printf("Informe o primeiro numero: ");
    scanf("%d", &n1 );
    printf("Informe o segundo numero: ");
    scanf("%d", &n2);

    printf("\nO MDC de %d e %d e igual a %d.\n\n", n1, n2, MDCRec(n1, n2));


    return 0;
}
