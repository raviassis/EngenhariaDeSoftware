#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    int num;
    setlocale(LC_ALL,"portuguese");
    printf("Digite um n�mero: ");
    scanf("%d", &num);
    num = num +1;
    printf("O sucessor � %d", num);
    return 0;
}
