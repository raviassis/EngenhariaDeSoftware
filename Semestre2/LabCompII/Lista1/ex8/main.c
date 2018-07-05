#include <stdio.h>
#include <stdlib.h>
#include "..\functions\functions.h"

int main()
{
    int mat[5][5] = {
        {1,2,3,4,5},
        {5,4,3,2,1},
        {4,2,3,5,1},
        {3,5,1,2,4},
        {5,1,4,2,3}
    };
    int tamLin , tamCol, i;
    tamLin = tamCol = 5;
    printf("EX8 - Imprime Diagonal Matriz\n\n");
    printf("Matriz:\n");

    for (i=0; i < tamLin; i++) {
        PrintArray(mat[i], tamCol);
        printf("\n");
    }

    printf("\nDiagonal:\n");

    PrintMatriz(tamLin, tamCol, mat);

    return 0;
}
