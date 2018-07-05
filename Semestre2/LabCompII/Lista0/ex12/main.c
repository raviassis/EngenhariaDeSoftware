#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i=1, f=500, cont=0;
    int vet[100];

    printf("Ex. 12\n\n");

    for (i=1; i <= 500; i++ ) {
        if (i%5==0) {
            vet[cont] = i;
            printf("Vet[%d] = %d\n", cont, vet[cont]);
            cont ++;
        }
    }


    return 0;
}
