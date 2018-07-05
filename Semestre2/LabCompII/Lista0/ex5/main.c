#include <stdio.h>
#include <stdlib.h>

const float PI = 3.14;

float areaCirculo (float raio) {
    return raio*raio*PI;
}

int main()
{
    float x=1.0, y=10.0, p=0.1;

    printf("Programa Areas de Circunferencias.\n\n");


    for (x; x < y; x += p) {
        printf("Raio: %.2f\tArea: %.2f\n", x, areaCirculo(x) );
    }

    return 0;
}
