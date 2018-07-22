#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    int a,b;
    float m;
    setlocale(LC_ALL, "portuguese");
    printf("Digite o valor para a: ");
    scanf("%d", &a);
    printf("\nDigite o valor para b: ");
    scanf("%d", &b);
    m=(a+b)/2.0;
    printf("A média de %d e %d é igual a %5.2f\n", a, b, m);

    return 0;
}
