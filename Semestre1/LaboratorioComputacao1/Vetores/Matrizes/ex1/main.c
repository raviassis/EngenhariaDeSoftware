#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet[10], num,i;
    printf("Digite um número: ");
    scanf("%d", &num);
    for (i = 0; i<10; i++) {
        vet[i] = num;
    }
    for (i=0; i<10; i++) {
        printf("vet[%d]= %d\n", i, vet[i]);
    }
    return 0;
}
