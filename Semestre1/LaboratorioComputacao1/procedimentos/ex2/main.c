#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
Recebe um valor e imprime se o valor é par ou impar
*/

void parOuImpar (int a) {
    if (a%2 == 0) {
        printf("\nNúmero par.\n\n");
    }
    else {
        printf("\nNúmero impar.\n\n");
    }
}

int main()
{
    setlocale(LC_ALL, "portuguese");
    int num;
    printf("---Par ou Impar---\n\n");
    printf("Informe o número: ");
    scanf("%d", &num);
    parOuImpar(num);
    return 0;
}
