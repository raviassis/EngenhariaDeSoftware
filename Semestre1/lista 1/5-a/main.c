#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    int num;
    setlocale(LC_ALL,"portuguese");
    printf("Digite um número: ");
    scanf("%d", &num);
    num = num +1;
    printf("O sucessor é %d", num);
    return 0;
}
