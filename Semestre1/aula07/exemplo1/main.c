#include <stdio.h>
#include <stdlib.h>

int main()
{
    int b,a;
    int *p;
    a=5;
    b=2;
    p=&a;
    printf("Valor de a=%d, endereço de a = %d\n",a,p);
    *p=6;
    printf("Valor de a=%d, endereço de a = %d\n",a,p);
    printf("Valor de b=%d, endereço de b = %d\n",b,&b);
    printf("tamanho alocado a variável b = %d\n",sizeof(b));
    p=p+1;
    *p=10;
    printf("Valor de b=%d, endereço de b = %d\n",b,p);
    return 0;
}
