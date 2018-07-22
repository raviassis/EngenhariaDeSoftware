#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
5-g) Pedro comprou um saco de Ra��o com peso em quilos. Pedro possui 2
(dois) gatos para os quais fornece a quantidade de ra��o em gramas. Fa�a
um algoritmo que receba o peso do Saco de ra��o e a quantidade de ra��o
fornecida para cada gato. Calcule e mostre quanto restar� de ra��o no saco
ap�s 5 (cinco) dias
*/

int main()
{
    setlocale(LC_ALL,"portuguese");
    float sacoKg, gato1, gato2, gastoGr = 0;
    printf("---Ra��o dos gatos---\n\n");
    printf("Peso do saco de ra��o(Kg): ");
    scanf("%f", &sacoKg);
    printf("Quantidade de ra��o para o gato 1(g): ");
    scanf("%f", &gato1);
    printf("Quantidade de ra��o para o gato 2(g): ");
    scanf("%f", &gato2);
    gastoGr = (gato1 + gato2)*5.00;
    sacoKg -= gastoGr/1000.00;
    printf("Ap�s cinco dias, restar� %4.2fKg de ra��o.", sacoKg);
    return 0;
}
