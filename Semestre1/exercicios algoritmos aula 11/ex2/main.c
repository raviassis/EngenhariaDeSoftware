#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num[10], soma=0, i, op;

    for(i=0;i<10;i++){
        printf("Digite um numero: ");
        scanf("%d", &num[i]);
    }
    printf("Qual operacao? 1 - Soma indices pares  2- Soma indices impares");
    scanf("%d", &op);
    if (op == 1) {
        for (i = 0; i< 10; i=i+2) {
            soma = soma + num[i];
        }
    }
    else if ( op == 2) {
       for (i = 1; i< 10; i=i+2) {
            soma = soma + num[i];
        }
    }
    else {
        printf("Opcao não eceita\n");
    }
    printf("Soma: %d", soma);
    return 0;
}
