#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
5-i) Leia um n�mero e imprima o resto da divis�o por 7. Utilize o comando
resto (a,b).
*/

int main()
{
    setlocale(LC_ALL, "portuguese");
    int num;
    printf("---Imprime resto de divis�o por 7----\n\n");
    printf("Informe o n�mero: ");
    scanf("%d", &num);
    printf("O resto da divis�o de %d por 7 � %d", num, num%7);

    return 0;
}
