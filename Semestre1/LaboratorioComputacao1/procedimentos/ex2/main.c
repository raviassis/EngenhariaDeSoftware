#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
Recebe um valor e imprime se o valor � par ou impar
*/

void parOuImpar (int a) {
    if (a%2 == 0) {
        printf("\nN�mero par.\n\n");
    }
    else {
        printf("\nN�mero impar.\n\n");
    }
}

int main()
{
    setlocale(LC_ALL, "portuguese");
    int num;
    printf("---Par ou Impar---\n\n");
    printf("Informe o n�mero: ");
    scanf("%d", &num);
    parOuImpar(num);
    return 0;
}
