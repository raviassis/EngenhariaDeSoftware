#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet[10], num,i, tst=0;

    for (i = 0; i<10; i++) {
        printf("Digite um número para vet[%d]: ", i);
        scanf("%d", &vet[i]);
    }

    printf("Valor a ser pesquisado: ");
    scanf("%d", &num);

    for (i = 0; i<10 ;i++ ) {
        if (num == vet[i] ) {
            printf("vet[%d]\n", i);
            tst = 1;
        }
    }
    if (!(tst)) {
        printf("Valor não encontrado");
    }

    return 0;
}
