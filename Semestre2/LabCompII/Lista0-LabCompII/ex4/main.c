#include <stdio.h>
#include <stdlib.h>

const float PI = 3.14;

float areaCirculo (float raio) {
    return raio*raio*PI;
}

int main()
{
    int x, y, p;

    printf("Programa Areas de Circunferencias.\n\n");
    printf("Informe o valor inicial do raio(x): "); scanf("%d", &x);
    printf("Informe o valor final do raio(x): "); scanf("%d", &y);
    printf("Passo: "); scanf("%d", &p);

    for (x; x < y; x += p) {
        printf("Raio: %d\tArea: %.2f\n", x, areaCirculo(x) );
    }

    return 0;
}
