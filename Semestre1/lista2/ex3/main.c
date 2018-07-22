#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
ex3 - Fazer um algoritmo que leia a temperatura e mostre se está no estado solido,
líquido ou gasoso.
*/
int main()
{
    setlocale(LC_ALL,"portuguese");
    float temp, fusao, ebulicao;
    printf("---Estados Fisicos da matéria---\n");
    printf("Temperatura: ");
    scanf("%f", &temp);
    printf("Temp. Fusao: ");
    scanf("%f", &fusao);
    printf("Temp. Ebulição: ");
    scanf("%f", &ebulicao);
    if (temp < fusao){
        printf("\nEstado sólido.");
    }
    else {
        if (temp < ebulicao){
            printf("Estado líquido.");
        }
        else {
            printf("Estado gasoso");
        }
    }

    return 0;
}
