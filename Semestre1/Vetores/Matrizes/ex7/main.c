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
    int lin, col, inicio = 15, fim = 50, maior, menor ;

    for (lin = 0; lin < 10; lin++) {
        for (col=0; col < 10; col++) {
            mat[lin][col] = num_rand(inicio, fim);
        }
    }

    maior = menor = mat[0][0];

    for (lin = 0; lin < 10; lin++) {
        for (col = 0; col < 10; col++) {
            if (mat[lin][col] > maior) {
                maior = mat[lin][col];
            }
            if (mat[lin][col] < menor) {
                menor = mat[lin][col];
            }
        }
    }

    printf("Maior: %d\n", maior);
    printf("Posicoes: ");
    for (lin = 0; lin < 10; lin++) {
        for (col = 0; col < 10; col++) {
            if (mat[lin][col] == maior) {
                printf("mat[%d][%d] ", lin, col);
            }
        }
    }

    printf("\n\nMenor: %d\n", menor);
    printf("Posicoes: ");
    for (lin = 0; lin < 10; lin++) {
        for (col = 0; col < 10; col++) {
            if (mat[lin][col] == menor) {
                printf("mat[%d][%d] ", lin, col);
            }
        }
    }

    return 0;
}
