#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
Questão 3: Peça ao usuário um número e imprima todos os divisores deste número e ao final imprima se esse número é primo ou não.
*/
int main()
{
    setlocale(LC_ALL,"portuguese");
    int num, cont = 0, divisor = 1;
    printf("---Divisores---\n");
    printf("Digite um número: ");
    scanf("%d", &num);
    while ( divisor <= num ){
        if (num % divisor == 0) {
            printf("\n%d", divisor);
            cont++;
        }
        divisor++;
    }
    if (cont == 2){
        printf("\nEsse número é primo.");
    }
    else {
        printf("\nEsse número não é primo.");
    }
    return 0;
}
