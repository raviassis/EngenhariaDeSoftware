#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num[10], i, maior, menor;

    for (i=0; i<10; i++) {
        printf("Digite o valor de num[%d]: ", i);
        scanf("%d", &num[i]);
    }
    maior = menor = num[0];

    for (i=0; i<10; i++) {
        if (maior < num[i]) {
            maior = num[i];
        }
        else {
            if ( menor > num[i]) {
                menor = num[i];
            }
        }
    }

    printf("\nMaior: %d - Posicao ", maior);
    for (i=0; i<10; i++) {
        if (num[i]==maior) {
            printf("num[%d] ", i);
        }
    }
    printf("\nMenor: %d - Posicao ", menor);
    for (i=0; i<10; i++) {
        if (num[i]==menor) {
            printf("num[%d] ", i);
        }
    }

    return 0;
}
