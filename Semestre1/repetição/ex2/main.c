#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    int maior = 1023, menor = 1, meio, cont = 0;
    char resp;
    meio= (maior+menor)/2;
    setlocale(LC_ALL,"portuguese");
    printf("---Adivinha número---\n");
    printf("Pense em um número entre 1 a 1023\n");
    printf("Digite <(menor), >(maior) ou =(igual) para os números que aparecerão\n");

    while ( cont < 10) {
        printf("%d\n", meio);
        scanf("%c", &resp);

        if (resp == '<') {
            maior = meio;
            meio = (maior+menor)/2;
        }
        else if (resp == '>'){
            menor = meio;
            meio = (maior+menor)/2;
        }
        else {
            printf("Acertei!!!\n");
            printf("Quantidade de tentativas %d\n", cont);
            break;
        }
        cont++;
    }

    return 0;
}
