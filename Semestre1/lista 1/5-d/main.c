#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
5-d) Leia uma temperatura dada na escala Celsius (C) e imprima o equivalente em Fahrenheit (F).
*/

int main()
{
    setlocale(LC_ALL, "portuguese");
    float c, f;
    printf("Informe a temperatura em C�:");
    scanf("%f", &c);
    f = (9.00/5.00)*c+32.00;
    printf("%4.2f�C equivale a %4.2f�F", c, f);

    return 0;
}
