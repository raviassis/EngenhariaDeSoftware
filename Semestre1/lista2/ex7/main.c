#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <math.h>

/*
ex7 - O numero 3025 possui a seguinte caracter�stica:
        30 + 25 = 55
        55^2 = 3025
Fazer um algoritmo que dado um numero de 4 d�gitos calcule e escreva se ele
possui ou n�o esta caracter�stica.
*/

int main()
{
    setlocale(LC_ALL, "portuguese");
    int num, dig1, dig2, sdig;
    double sdouble;
    printf("Informe um n�mero: ");
    scanf("%d", &num);
    dig1 = (int)(num/100);
    dig2 = (int)(num % 100);
    sdig = dig1 + dig2;
    sdouble = dig1 + dig2;
    printf("sdig antes: %f\n", (float)sdig);
    //sdig = sdig*sdig;
    sdig = pow((float)sdig, 2);
    sdouble = pow(sdouble, 2);
    printf("dig1: %f\n", (float)dig1);
    printf("dig2: %f\n", (float)dig2);
    printf("sdig: %f\n", (float)sdig);
    printf("sdouble: %f\n", sdouble);
    if (num==sdig) {
        printf("Caracteristica OK");
    }
    else {
        printf("Caracteristica NOK");
    }
    return 0;
}
