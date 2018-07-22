#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[10],b[10],c[10], i;

    for (i=0; i<10 ; i++) {
        printf("Digite valor para a[%d]: ", i);
        scanf("%d", &a[i]);
    }
    for (i=0; i<10 ; i++) {
        printf("Digite valor para b[%d]: ", i);
        scanf("%d", &b[i]);
        c[i] = a[i] + b[i];
    }
    for (i=0; i<10; i++) {
        printf("c[%d]: %d\n", i, c[i]);
    }
    return 0;
}
