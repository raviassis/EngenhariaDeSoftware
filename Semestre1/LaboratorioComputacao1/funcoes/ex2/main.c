#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;
    num = ler_positivo();
    return 0;
}


int ler_positivo () {
    int a;
    printf("\nDigite um número positivo: ");
    scanf("%d", &a);

    while ( a < 0){
        printf("\nNúmero inválido!");
        printf("\nDigite um número positivo: ");
        scanf("%d", &a);
    }
    return a;
}
