#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex10 -  Desenvolver um algoritmo para calcular a conta de água para a SANEAGO. O custo da
água varia dependendo do tipo do consumidor - residencial, comercial ou industrial. A
regra para calcular a conta e:
    • Residencial: R$ 15,00 de taxa mais R$ 0,50 por m3 gastos;
    • Comercial: R$ 500,00 para os primeiros 80 m3 gastos mais R$ 2,50 por m3 gastos
    acima dos 80 m3;
    • Industrial: R$ 800,00 para os primeiros 100 m3 gastos mas R$ 4,00 por m3 gastos
    acima dos 100 m3;
O algoritmo devera ler a conta do cliente, seu tipo (residencial, comercial e industrial) e o seu
consumo de água em metros cubos. Como resultado imprimir o valor a ser pago pelo mesmo
*/

int main()
{
    setlocale(LC_ALL,"portuguese");
    int tipo;
    float consumo, valor;
    printf("---Conta de Água---\n\n");
    printf("Digite: 1 - residencial\n ");
    printf("        2 - comercial\n ");
    printf("        3 - residencial\n ");
    scanf("%d", &tipo);
    printf("\nConsumo: ");
    scanf("%f", &consumo);
    switch (tipo){
        case 1:
            valor = 15.00 + consumo*0.5;
            break;
        case 2:
            valor = 500;
            if(consumo <= 80){
                consumo = 0;
            }
            else {
                consumo = consumo -80;
                valor = valor + consumo *2.5;
            }
            break;
        case 3:
            valor = 800;
            if (consumo <= 800) {
                consumo = 0;
            }
            else {
                consumo = valor = consumo -100;
                valor = valor + consumo*4;
            }
            break;

    }
    printf("Valor a pagar: %f", valor);
    return 0;
}
