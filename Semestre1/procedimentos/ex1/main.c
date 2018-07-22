#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
Criar programa com as seguintes operações
 -fatorial de N
 -somatório de 1 a N
*/

void mostraMenu (void) {
    system("cls");
    printf("Escolha: 1- Fatorial\n");
    printf("         2- Somatório\n");
    printf("         9- Sair\n");
}

void fatorial (void){
    int fat, aux, n;
    system("cls");
    printf("Digite o número: ");
    scanf("%d", &n);
    fat = n;
    aux = fat-1;
    while(aux>0){
        fat = fat*aux;
        aux--;
    }
    printf("Fatorial de %d é %d\n", n, fat);
}

void somatorio (void){
    int sum = 0, n, cont =1;
    system("cls");
    printf("Digite um número: ");
    scanf("%d", &n);
    while (cont <= n){
        sum += cont;
        cont++;
    }
    printf("O somatório é %d\n", sum);
}

int main(){
    setlocale(LC_ALL, "portuguese");
    int opcao = 0;
    while (opcao !=9){
        mostraMenu();
        scanf("%d", &opcao);
        switch (opcao) {
            case 1:
                fatorial();
                break;
            case 2:
                somatorio();
                break;
            case 9:
                exit(0);
                break;
            default:
                printf("Comando inválido\n");
        }
        printf("\n---Tecle enter para continuar---\n");
        system("pause");
    }

    return 0;
}
