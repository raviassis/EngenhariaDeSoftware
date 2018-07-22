#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex8 - Suponha que um caixa disponha apenas de notas de 1, 10 e 100 reais. Considerando que
alguém está pagando uma compra, escreva um algoritmo que mostre o número mínimo de
notas que o caixa deve fornecer como troco. Mostre também: o valor da compra, o valor
do troco e a quantidade de cada tipo de nota do troco. Suponha que o sistema monetário
não utilize moedas.
*/

int main()
{
    setlocale(LC_ALL,"portuguese");
    int compra, notas100,notas10,notas1, valor_pago, troco;
    printf("---Troco---\n\n");
    printf("Valor da compra: ");
    scanf("%d", &compra);
    printf("Valor pago: ");
    scanf("%d", &valor_pago);
    troco = valor_pago - compra;
    notas100 = (int)(troco/100);
    troco -= notas100 * 100;
    notas10 = (int)(troco/10);
    troco -= notas10 * 10;
    notas1 = troco;
    troco = notas100*100+notas10*10+notas1;
    printf("\nValor da compra: %d", compra);
    printf("\nTroco: %d", troco);
    printf("\nNotas de 100: %d", notas100);
    printf("\nNotas de 10: %d", notas10);
    printf("\nNotas de 1: %d", notas1);
    return 0;
}
