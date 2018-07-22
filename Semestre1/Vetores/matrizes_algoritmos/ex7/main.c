#include <stdio.h>
#include <stdlib.h>

void lerMatriz (int lin, int col, int m[][col]) {
    printf("Digite os valores da matriz\n");
    int l,c;
    for (l=0; l<lin; l++) {
        for (c=0; c<col; c++) {
            printf("m[%d][%d]= ", l, c);
            scanf("%d", &m[l][c]);
        }
    }
}

int main()
{
    int lin=3, col=4;
    int a[lin][col], b[lin][col], c[lin][col];
    lerMatriz(lin, col, a);
    lerMatriz(lin, col, b);
   // produtoMatriz(lin,col,a,b,c);
   // printMatriz(lin,col,c);
    return 0;
}
