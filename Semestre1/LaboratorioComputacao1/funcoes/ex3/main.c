#include <stdio.h>
#include <stdlib.h>
#include "../funcoes.h"

int main()
{
    int num = 1, cont_par=0, cont_impar=0;
    while (num!=0) {
        num = ler_positivo();
        if ( num != 0) {
            if ( par(num) ) {
                printf("\nNumero par");
                cont_par++;
            }
            else {
                printf("\nNumero impar");
                cont_impar++;
            }
        }

    }

    printf("\nValores pares: %d", cont_par);
    printf("\nValores impares: %d", cont_impar);
    return 0;
}
