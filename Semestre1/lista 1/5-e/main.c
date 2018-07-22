#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
5-e) Faca um algoritmo que receba o salário de um funcionário e o percentual de aumento, calcule e mostre o novo salário.
*/
int main()
{
    setlocale(LC_ALL,"portuguese");
    float salario, aumento;
    printf("Salário: ");
    scanf("%f", &salario);
    printf("Aumento(%%): ");
    scanf("%f",&aumento);
    salario += salario*aumento/100.00;
    printf("O novo salário é %4.2f", salario);

    return 0;
}
