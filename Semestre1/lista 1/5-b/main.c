#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    int n1, n2, n3, n4;
    float media;
    setlocale(LC_ALL,"portuguese");
    printf("Digite nota n1: ");
    scanf("%d", &n1);
    printf("\nDigite nota n2: ");
    scanf("%d", &n2);
    printf("\nDigite nota n3: ");
    scanf("%d", &n3);
    printf("\nDigite nota n4: ");
    scanf("%d", &n4);

    media= (n1+n2+n3+n4)/4.0;

    printf("\nA média é %4.2f\n", media);

    return 0;
}
