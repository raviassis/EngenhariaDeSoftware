#include <stdio.h>
#include <stdlib.h>

int potencia (int b, int exp){
    if (exp == 0) {
        return 1;
    }
    else {
        return b * potencia (b, exp-1);
    }
}

int main()
{
    int x,y;
    printf("Digite a base: ");
    scanf("%d", &x);
    printf("Digite o expoente: ");
    scanf("%d", &y);
    printf("\nResultado: %d", potencia(x,y));
    return 0;
}
