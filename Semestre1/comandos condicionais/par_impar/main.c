#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");
    int n;
    printf("---Par ou Impar---\n");
    printf("Digite um n�mero:");
    scanf("%d", &n);

    if( (n%2) == 0) {
        printf("N�mero par.");
    }
    else {
        printf("N�mero impar.");
    }
    return 0;
}
