#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
Criar programa com as seguintes opera��es
 -fatorial de N
 -somat�rio de 1 a N
*/

void mostraMenu (void) {
    system("cls");
    printf("Escolha: 1- Fatorial\n");
    printf("         2- Somat�rio\n");
    printf("         9- Sair\n");
}

void fatorial (void){
    int fat, aux, n;
    system("cls");
    printf("Digite o n�mero: ");
    scanf("%d", &n);
    fat = n;
    aux = fat-1;
    while(aux>0){
        fat = fat*aux;
        aux--;
    }
    printf("Fatorial de %d � %d\n", n, fat);
}

void somatorio (void){
    int sum = 0, n, cont =1;
    system("cls");
    printf("Digite um n�mero: ");
    scanf("%d", &n);
    while (cont <= n){
        sum += cont;
        cont++;
    }
    printf("O somat�rio � %d\n", sum);
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
                printf("Comando inv�lido\n");
        }
        printf("\n---Tecle enter para continuar---\n");
        system("pause");
    }

    return 0;
}
