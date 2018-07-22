#include <stdio.h>
#include <stdlib.h>
#include <string.h>




int main()
{
    int a;
    float b;
    char c, nome[10];
    a = 10;
    b = 3.14;
    c='x';
    strcpy(nome, "maria");
    printf("Valor de a:%d\n",a);
    printf("Valor de b:%4.2f\n", b);
    printf("Valor de c:%c\n", c);
    printf("Valor de nome:%s\n", nome);
    return 0;
}
