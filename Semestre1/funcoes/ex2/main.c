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
    printf("\nDigite um n�mero positivo: ");
    scanf("%d", &a);

    while ( a < 0){
        printf("\nN�mero inv�lido!");
        printf("\nDigite um n�mero positivo: ");
        scanf("%d", &a);
    }
    return a;
}
