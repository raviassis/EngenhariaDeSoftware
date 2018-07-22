#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
5-g) Pedro comprou um saco de Ração com peso em quilos. Pedro possui 2
(dois) gatos para os quais fornece a quantidade de ração em gramas. Faça
um algoritmo que receba o peso do Saco de ração e a quantidade de ração
fornecida para cada gato. Calcule e mostre quanto restará de ração no saco
após 5 (cinco) dias
*/

int main()
{
    setlocale(LC_ALL,"portuguese");
    float sacoKg, gato1, gato2, gastoGr = 0;
    printf("---Ração dos gatos---\n\n");
    printf("Peso do saco de ração(Kg): ");
    scanf("%f", &sacoKg);
    printf("Quantidade de ração para o gato 1(g): ");
    scanf("%f", &gato1);
    printf("Quantidade de ração para o gato 2(g): ");
    scanf("%f", &gato2);
    gastoGr = (gato1 + gato2)*5.00;
    sacoKg -= gastoGr/1000.00;
    printf("Após cinco dias, restará %4.2fKg de ração.", sacoKg);
    return 0;
}
