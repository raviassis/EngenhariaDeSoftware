#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <locale.h>

/*
Quest�o 1: Escreva um programa que pe�a ao usu�rio os valores de x1,y1,x2 e y2 e devolva a dist�ncia entre esses pontos
*/

int main()
{
    setlocale(LC_ALL,"portuguese");
    int x1, x2, y1, y2;
    float d;
    printf("---Dist�ncia entre pontos---\n");
    printf("Digite o valor de x1: ");
    scanf("%d", &x1);
    printf("Digite o valor de y1: ");
    scanf("%d", &y1);
    printf("Digite o valor de x2: ");
    scanf("%d", &x2);
    printf("Digite o valor de y2: ");
    scanf("%d", &y2);
    d = (pow( (x2-x1) , 2) + pow( (y2-y1) ,2));
    d = pow(d, 0.5);
    printf("\nA dist�ncia entre os pontos �: %4.2f.", d);
    return 0;
}
