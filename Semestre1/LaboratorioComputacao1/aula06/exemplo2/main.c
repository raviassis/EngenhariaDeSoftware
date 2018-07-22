#include <stdio.h>
#include <stdlib.h>

int num;
int main()
{
    int resposta;
    printf("Digite um numero: ");
    scanf("%d", &num);
    resposta = sucessor(num);
    printf("num: %d, resposta: %d", num, resposta);
    return 0;
}

int sucessor(int n) {
    n++;
    return n;
}
