#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
5-f)Fa�a um algoritmo que pe�a ao usu�rio a base e a altura e calcule a
�rea de um triangulo.
*/

int main()
{
    setlocale(LC_ALL, "portuguese");
    float base, altura, area;
    printf("---Area do Triangulo---\n\n");
    printf("Informe a base do triangulo: ");
    scanf("%f", &base);
    printf("Informe a altura do triangulo: ");
    scanf("%f", &altura);
    area = base*altura/2.00;
    printf("A �rea do triangulo � %4.2f", area);

    return 0;
}
