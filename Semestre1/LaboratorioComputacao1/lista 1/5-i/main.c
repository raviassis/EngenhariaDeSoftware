#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
5-i) Leia um número e imprima o resto da divisão por 7. Utilize o comando
resto (a,b).
*/

int main()
{
    setlocale(LC_ALL, "portuguese");
    int num;
    printf("---Imprime resto de divisão por 7----\n\n");
    printf("Informe o número: ");
    scanf("%d", &num);
    printf("O resto da divisão de %d por 7 é %d", num, num%7);

    return 0;
}
