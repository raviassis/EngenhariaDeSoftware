#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
5-f)Faça um algoritmo que peça ao usuário a base e a altura e calcule a
área de um triangulo.
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
    printf("A área do triangulo é %4.2f", area);

    return 0;
}
