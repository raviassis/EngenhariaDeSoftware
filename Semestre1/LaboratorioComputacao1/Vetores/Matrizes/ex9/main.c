#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int num_rand (int i, int f) {
    return (rand() % (f-i)) + i;

}

int main()
{
    srand( (unsigned)time(0) );
    int mat[10][10];
    int lin, col, inicio = 15, fim = 50 ;
    for (lin = 0; lin < 10; lin++) {
        for (col=0; col < 10; col++) {
            mat[lin][col] = num_rand(inicio, fim);
        }
    }

    do {
        printf("Informe a posicao desejada.\n");
        printf("Lin = ");
        scanf("%d", &lin);
        if (lin != -1) {
            printf("Col = ");
            scanf("%d", &col);
            if (col != -1) {
                printf("mat[%d][%d] = %d\n", lin, col, mat[lin][col]);
            }
        }

    } while ( lin != -1 && col != -1);

    return 0;
}
