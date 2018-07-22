#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
Questão 2: Dado a quantidade vendida e o preco unitário do produto, calcular o valor a pagar, que considere a política de descontos.
Descontos:
até 200,00              = sem desconto
de 200,00 até 1000,00   = 5%
acima de 1000,00        = 10%
*/
int main()
{
    setlocale(LC_ALL, "portuguese");
    int quant;
    float preco, total;
    printf("---Descontos---\n");
    printf("Quantidade de produtos: ");
    scanf("%d", &quant);
    printf("Preço unitário: ");
    scanf("%f", &preco);
    total = ((float)quant)*preco;
    if (total>1000.0){
        total = total * 0.9;
    }
    else{
        if (total > 200.0){
            total = total * 0.95;
        }
    }
    printf("Valor a pagar: R$%.2f", total);
    return 0;
}
