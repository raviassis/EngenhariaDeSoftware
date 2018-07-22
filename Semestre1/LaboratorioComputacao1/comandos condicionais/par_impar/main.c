#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");
    int n;
    printf("---Par ou Impar---\n");
    printf("Digite um número:");
    scanf("%d", &n);

    if( (n%2) == 0) {
        printf("Número par.");
    }
    else {
        printf("Número impar.");
    }
    return 0;
}
