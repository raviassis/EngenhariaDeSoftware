#include <stdio.h>
#include <stdlib.h>

int soma_valores (int);
int soma;
int main()
{
    int n;
    printf("Informe um numero\n");
    scanf("%d", &n);
    soma_valores(n);
    printf("Valor da soma e: %d", soma);
    return 0;
}

int soma_valores (int num) {
    int cont;
    cont = 1;
    soma=0;
    while (cont <= num) {
        soma = soma+cont;
        cont ++;
    }
    return;
}
