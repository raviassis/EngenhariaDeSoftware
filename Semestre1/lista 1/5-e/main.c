#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
5-e) Faca um algoritmo que receba o sal�rio de um funcion�rio e o percentual de aumento, calcule e mostre o novo sal�rio.
*/
int main()
{
    setlocale(LC_ALL,"portuguese");
    float salario, aumento;
    printf("Sal�rio: ");
    scanf("%f", &salario);
    printf("Aumento(%%): ");
    scanf("%f",&aumento);
    salario += salario*aumento/100.00;
    printf("O novo sal�rio � %4.2f", salario);

    return 0;
}
