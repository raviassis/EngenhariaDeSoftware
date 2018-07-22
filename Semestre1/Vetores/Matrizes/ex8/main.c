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
    int lin, col, inicio = 15, fim = 50, soma=0 ;
    for (lin = 0; lin < 10; lin++) {
        for (col=0; col < 10; col++) {
            mat[lin][col] = num_rand(inicio, fim);
        }
    }

    for (lin = 0; lin < 10; lin++) {
        soma += mat[lin][lin];
    }

    printf("Soma da diagonal = %d", soma);

    return 0;
}
