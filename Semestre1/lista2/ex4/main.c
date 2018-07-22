#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex4 - Leia um valor X e se ele for menor que 0 avalie Y = x2 + 4. Se ele for maior que 0
avalie x3 -3 e se ele for igual a 0 de uma mensagem de erro.
*/


//ler_x: x deve ser diferente de 0
float ler_x (){
    float a;
    scanf("%f", &a);
    while (a==0) {
        printf("\nInforme um número diferente de 0\n");
        printf("Valor de x: ");
        scanf("%f", &a);
    }
    return a;
}

int main()
{
    setlocale(LC_ALL,"portuguese");
    float x,y;
    printf("Valor de x: ");
    x = ler_x();
    if (x < 0.0) {
        y = pow(x,2) + 4;
        printf("y = x2 + 4\ny = %.2f", y);
    }
    else {
        y = pow(x,3) -3;
        printf("y = x3 - 3\ny = %.2f", y);
    }
    return 0;
}
