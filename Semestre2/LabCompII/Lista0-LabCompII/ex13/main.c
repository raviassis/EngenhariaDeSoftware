#include <stdio.h>
#include <stdlib.h>

void printSpace (int n) {
    char space = ' ';
    int i;
    int x, vezes = 3;

    for (i=0; i < n; i++) {

        printf("\t");

    }
}

int main()
{
    int mat[5][5];
    int lin, col;

    printf("Ex. 13\n\n");
    printf("Informe os elementos da matriz 5x5\n");
    for (lin=0; lin < 5; lin++) {
        for (col=0; col < 5; col++) {
            printf("mat[%d][%d] = ", lin, col); scanf("%d", &mat[lin][col]);
        }
    }
    printf("\n\n");
    for (lin = 0; lin < 5; lin++) {
        printSpace(lin);
        printf("%d\n", mat[lin][lin]);
    }


    return 0;
}
