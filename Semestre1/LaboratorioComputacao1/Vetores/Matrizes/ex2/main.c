#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet[10], num,i;

    for (i = 0; i<10; i++) {
        printf("Digite um número para vet[%d]: ", i);
        scanf("%d", &vet[i]);
    }


    for (i=0; i<10; i++) {
        printf("vet[%d]= %d\n", i, vet[i]);
    }
    return 0;
}
