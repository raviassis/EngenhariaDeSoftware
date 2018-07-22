#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
Quest�o 2: Dado a quantidade vendida e o preco unit�rio do produto, calcular o valor a pagar, que considere a pol�tica de descontos.
Descontos:
at� 200,00              = sem desconto
de 200,00 at� 1000,00   = 5%
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
    printf("Pre�o unit�rio: ");
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
