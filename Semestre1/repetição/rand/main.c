#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");
    int i;
    printf("Intervalo de rand: 0 a %d\n", RAND_MAX);
    i = 1;
    srand((unsigned)time(NULL));
    while (i <= 10){
        printf("Número: %d\n", rand());
        i++;
    }
    return 0;
}
