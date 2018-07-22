#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");
    float valor, maior, menor;
    printf("Digite os números: \n");
    scanf("%f", &valor);
    maior = menor = valor;
    while ( valor >=0) {
        if (valor > maior) {
            maior  = valor;
        }
        else {
            if ( valor < menor){
                menor = valor;
            }
        }
        scanf("%f", &valor);
    }
    printf("\nMaior valor: %4.2f\nMenor valor: %4.2f", maior, menor);

    return 0;
}
