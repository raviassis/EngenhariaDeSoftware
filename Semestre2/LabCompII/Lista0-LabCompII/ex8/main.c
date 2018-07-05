#include <stdio.h>
#include <stdlib.h>

int fatorial (int n) {
    if (n== 1) {
        return 1;
    }
    else {
        return n * fatorial(n-1);
    }
}

int main()
{
    int n;

    printf("Ex. 8 - Fatorial\n\n");
    printf("Informe o valor de n: "); scanf("%d", &n);
    printf("Fatorial de %d: %d\n", n, fatorial(n));
    return 0;
}
