#include <stdio.h>
#include <stdlib.h>
#include "../funcoes.h"

int main()
{
    int num1=1, num2=0;
    while (num1!= 0 || num2!= 0) {
        num1 = ler_positivo();
        num2 = ler_positivo();
        if ( divisivel(num1, num2) ) {
            printf("\n%d e divisivel por %d", num1, num2);
        }
    }
    return 0;
}
