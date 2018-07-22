#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
5-j) Calcular a soma dos termos de uma P.A. lendo os valores do primeiro
termo, do segundo termo e do n�mero de termos. formulas:
    Sn=n*(a1+an)/2, onde Sn � a soma dos termos, a1 o primeiro termo e an o
    �ltimo termo. O n-�simo termo de uma progress�o aritm�tica, pode ser obtido por
    meio da formula: an=a1+(n-1).r, onde r � a raz�o da P.A.
*/
int main()
{
    setlocale(LC_ALL, "portuguese");
    int a1, a2, r, sn, n, an;
    printf("---Calcula soma dos termos de uma PA---\n\n");
    printf("Informe o primeiro termo (a1): ");
    scanf("%d", &a1);
    printf("Informe o segundo termo (a2): ");
    scanf("%d", &a2);
    printf("Informe o n�mero de termos (n): ");
    scanf("%d", &n);
    r= a2-a1;
    an = a1+(n-1)*r;
    sn = n*(a1+an)/2;
    printf("A soma dos termos � (sn) = %d", sn);
    return 0;
}
