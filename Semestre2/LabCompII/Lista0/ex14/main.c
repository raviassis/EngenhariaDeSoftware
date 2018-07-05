#include <stdio.h>
#include <stdlib.h>

int main()
{
    int mat[5][5];
    int lin, col;
    int soma = 0;

    printf("Ex. 14\n\n");
    printf("Informe os elementos da matriz 5x5\n");
    for (lin=0; lin < 5; lin++) {
        for (col=0; col < 5; col++) {
            printf("mat[%d][%d] = ", lin, col); scanf("%d", &mat[lin][col]);
        }
    }

    for (lin = 0; lin < 5; lin++) {
        for (col = 0; col < 5; col++) {
            if (lin < col) {
               soma += mat[lin][col];
            }
        }
    }

    printf("\n\nSomatorio dos elementos acima da diagonal principal: %d\n\n", soma);

    return 0;
}
