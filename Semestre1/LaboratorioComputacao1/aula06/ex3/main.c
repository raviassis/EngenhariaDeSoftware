#include <stdio.h>
#include <stdlib.h>

int ordena(int *a, int *b){
    int aux, resp;
    if (*a > *b) {
        aux = *a;
        *a = *b;
        *b = aux;
        resp = 1;
    }
    else if (*a<*b){
        resp = 2;
    }
    else {
        resp = 0;
    }
    return resp;
}

int main()
{
    int a,b, resp;
    printf("Digite o valor de a: ");
    scanf("%d", &a);
    printf("Digite o valor de b: ");
    scanf("%d", &b);

    resp = ordena(&a,&b);

    printf("a: %d, b: %d, resp: %d", a,b,resp);
    return 0;
}
