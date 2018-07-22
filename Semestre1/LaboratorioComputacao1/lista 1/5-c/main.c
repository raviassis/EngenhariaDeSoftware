#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
5-c) Faca um algoritmo que receba 3 notas e seus respectivos pesos, calcule e mostre a média ponderada
     dessas notas.
*/
int main()
{
    float n1,n2,n3,p1,p2,p3,mp;
    setlocale(LC_ALL, "portuguese");
    printf("Escreva nota 1: ");
    scanf("%f", &n1);
    printf("\tPeso 1: ");
    scanf("%f", &p1);

    printf("Escreva nota 2: ");
    scanf("%f", &n2);
    printf("\tPeso 2: ");
    scanf("%f", &p2);

    printf("Escreva nota 3: ");
    scanf("%f", &n3);
    printf("\tPeso 3: ");
    scanf("%f", &p3);

    mp = (n1*p1+n2*p2+n3*p3)/(p1+p2+p3);

    printf("A média ponderada é %4.2f", mp);
    return 0;
}
