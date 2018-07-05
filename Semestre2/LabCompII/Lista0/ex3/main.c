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
    float base, altura, area, perimetro, somatorio=0;

    printf("Programa dos Retangulos.\n");
    do {
        printf("Informe a base: ");
        scanf("%f", &base);
        if (base > 0) {
            printf("Informe a altura: ");
            scanf("%f", &altura);
            area = areaRetangulo (base, altura);
            perimetro = perimetroRetangulo (base, altura);
            somatorio += area;
            printf("Area: %.2f\tPerimetro: %.2f\n\n", area, perimetro );
        }
    }while (base > 0);

    printf("\nSomatorio das areas: %.2f\n", somatorio);

    return 0;
}
