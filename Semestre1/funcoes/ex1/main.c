#include <stdio.h>
#include <stdlib.h>

int fatorial ( int n ){
    int i, fat =1;
    for (i = 1; i<=n; i++) {
        fat *= i;
    }
    return fat;
}

int comb ( int n, int p ) {
    return (fatorial(n))/(fatorial(p)*fatorial(n-p));
}

int main()
{
    int n, p,c;
    printf("Digite o valor para n: ");
    scanf("%d", &n);
    printf("Digite o valor para p: ");
    scanf("%d", &p);
    c = comb(n, p);
    printf("A combinação de %d, %d a %d é: %d\n", n, p, p, c);
    return 0;
}
