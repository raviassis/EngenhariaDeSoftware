#include <stdio.h>
#include <stdlib.h>

int main()
{
    int b,a;
    int *p;
    a=5;
    b=2;
    p=&a;
    printf("Valor de a=%d, endere�o de a = %d\n",a,p);
    *p=6;
    printf("Valor de a=%d, endere�o de a = %d\n",a,p);
    printf("Valor de b=%d, endere�o de b = %d\n",b,&b);
    printf("tamanho alocado a vari�vel b = %d\n",sizeof(b));
    p=p+1;
    *p=10;
    printf("Valor de b=%d, endere�o de b = %d\n",b,p);
    return 0;
}
