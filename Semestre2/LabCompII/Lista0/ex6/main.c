#include <stdio.h>
#include <stdlib.h>

float areaRetangulo (float base, float altura) {
    return base * altura;
}

float perimetroRetangulo (float base, float altura) {
    return base * 2 + altura * 2;
}


int main()
{
    int x1, y1, p1, x2, y2, p2, j;

    printf("Programa dos Retangulos.\n");
    printf("Informe a base inicial dos retangulos: "); scanf("%d", &x1);
    printf("Informe a base final dos retangulos: "); scanf("%d", &y1);
    printf("Informe o passo da base: "); scanf("%d", &p1);

    printf("Informe a altura inicial dos retangulos: "); scanf("%d", &x2);
    printf("Informe a altura final dos retangulos: "); scanf("%d", &y2);
    printf("Informe o passo da altura: "); scanf("%d", &p2);

    for (x1; x1 < y1; x1 += p1) {
        for (j = x2; j < y2; j += p2) {
            printf("Retangulo de base: %d, altura: %d, area: %.2f e perimetro: %.2f\n", x1, j, areaRetangulo(x1,j), perimetroRetangulo(x1,j));

        }
    }


    return 0;
}
