#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/*
ex3 - Fazer um algoritmo que leia a temperatura e mostre se est� no estado solido,
l�quido ou gasoso.
*/
int main()
{
    setlocale(LC_ALL,"portuguese");
    float temp, fusao, ebulicao;
    printf("---Estados Fisicos da mat�ria---\n");
    printf("Temperatura: ");
    scanf("%f", &temp);
    printf("Temp. Fusao: ");
    scanf("%f", &fusao);
    printf("Temp. Ebuli��o: ");
    scanf("%f", &ebulicao);
    if (temp < fusao){
        printf("\nEstado s�lido.");
    }
    else {
        if (temp < ebulicao){
            printf("Estado l�quido.");
        }
        else {
            printf("Estado gasoso");
        }
    }

    return 0;
}
