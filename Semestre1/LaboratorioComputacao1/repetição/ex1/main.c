#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");
    int i = 1, op = 0, cont = 0;
    printf("---Cara ou Coroa---\n");
    while (i <=10){
        printf("Digite 0 - cara e 1 - coroa: ");
        scanf("%d", &op);
        srand((unsigned)time(NULL));
        if (op == (rand()%2)){
            printf("Acertou\n");
            cont++;
        }
        else {
            printf("Errou\n");
        }
        i++;
    }
    printf("\nFim de jogo\nAcertos: %d", cont);
    return 0;
}
