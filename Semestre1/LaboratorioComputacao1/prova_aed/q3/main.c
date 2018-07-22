#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
Quest�o 3: Pe�a ao usu�rio um n�mero e imprima todos os divisores deste n�mero e ao final imprima se esse n�mero � primo ou n�o.
*/
int main()
{
    setlocale(LC_ALL,"portuguese");
    int num, cont = 0, divisor = 1;
    printf("---Divisores---\n");
    printf("Digite um n�mero: ");
    scanf("%d", &num);
    while ( divisor <= num ){
        if (num % divisor == 0) {
            printf("\n%d", divisor);
            cont++;
        }
        divisor++;
    }
    if (cont == 2){
        printf("\nEsse n�mero � primo.");
    }
    else {
        printf("\nEsse n�mero n�o � primo.");
    }
    return 0;
}
