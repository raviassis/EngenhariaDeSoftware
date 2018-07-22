#include <stdio.h>
#include <stdlib.h>

int soma, produto;

void soma_produto(int x, int y){
    soma = x + y;
    produto = x*y;
}

int main()
{
    int a,b;
    printf("Digite o primeiro valor: ");
    scanf("%d", &a);
    printf("Digite o segundo valor: ");
    scanf("%d", &b);
    soma_produto(a,b);
    printf("Soma: %d, Produto: %d", soma, produto);
    return 0;
}
