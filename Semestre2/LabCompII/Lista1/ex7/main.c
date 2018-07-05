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
    printf("EX7 - Imprime Diagonal Matriz Rec\n\n");
    printf("Matriz:\n");

    for (i=0; i < tamLin; i++) {
        PrintArrayRec(mat[i], tamCol, 0);
        printf("\n");
    }

    printf("\nDiagonal:\n");

    PrintMatrizRec(tamLin, tamCol, mat, 0);

    return 0;

}
