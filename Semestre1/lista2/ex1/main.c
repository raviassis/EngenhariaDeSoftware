#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
ex1 - Fazer um algoritmo que leia um numero inteiro e mostre uma mensagem
indicando se este numero e par ou impar
*/
int main()
{
    setlocale(LC_ALL,"portuguese");
    int num;
    printf("---Par ou Impar---\n");
    printf("Digite um número: ");
    scanf("%d", &num);
    if (num%2==0){
        printf("\nNúmero par.");
    }
    else {
        printf("\nNúmero impar.");
    }
    return 0;
}
