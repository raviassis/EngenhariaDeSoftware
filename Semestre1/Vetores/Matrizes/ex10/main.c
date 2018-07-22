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
    int lin, col, inicio = 15, fim = 50, num, test=0 ;
    for (lin = 0; lin < 10; lin++) {
        for (col=0; col < 10; col++) {
            mat[lin][col] = num_rand(inicio, fim);
        }
    }

    printf("Valor a ser procurado: ");
    scanf("%d", &num);

    for (lin = 0; lin < 10; lin++) {
        for (col = 0; col < 10; col++) {
            if ( mat[lin][col] == num) {
                test =1;
                printf("mat[%d][%d]\n", lin, col);
            }
        }
    }

    if (!test) {
        printf("Valor não encontrado!!");
    }


    return 0;
}
