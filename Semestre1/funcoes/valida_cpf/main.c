#include <stdio.h>
#include <stdlib.h>

int soma_cpf (int, int);
int valida_cpf (int, int);

int main()
{
    int cpf, dig;
    printf("---Valida CPF---\n");
    printf("Informe seu cpf (xxxxxxxxx-xx): ");
    scanf("%d-%d", &cpf, &dig);
    printf("\nRecebida: %d-%d", cpf, dig);

    if (valida_cpf(cpf, dig)) {
        printf("\nCPF OK!");
    }
    else {
        printf("\nCPF inválido!");
    }

    return 0;
}

int soma_cpf (int cpf, int dig) {
    int c, peso, soma, i;
    i = 1;
    peso = 2;
    soma = 0;
    if (dig < 0) {
        while ( i <= 9) {
            c = cpf % 10;
            soma = soma + c*peso;
            cpf = (int)(cpf/10);
            i++;
            peso++;
        }
    }
    else {
        cpf = cpf*10 + dig;
        while ( i <= 10) {
            c = cpf % 10;
            soma = soma + c*peso;
            cpf = (int)(cpf/10);
            i++;
            peso++;
        }
    }
    return soma;
}

int valida_cpf (int cpf, int cpf_dig) {
    printf("\n---Funcao valida_cpf---");
    int somatorio, dig1, dig2, r, dig;
    printf("\nCPF_dig: %d", cpf_dig);
    printf("\nCPF: %d", cpf);
    somatorio = soma_cpf(cpf, -1); printf("\nsomatorio: %d", somatorio);
    dig1 = 11 - (somatorio % 11); printf("\ndig1: %d", dig1);
    if (dig1 > 9) {
        dig1 = 0; printf("\ndig1: %d", dig1);
    }
    somatorio = soma_cpf(cpf , dig1); printf("\nsomatorio: %d", somatorio);
    dig2 = 11 - (somatorio % 11); printf("\ndig2: %d", dig2);
    if (dig2 > 9) {
        dig2 = 0; printf("\ndig2: %d", dig2);
    }
    dig = (dig1*10) + dig2; printf("\ndig: %d", dig);
    if (cpf_dig == dig) {
        r = 1;
    }
    else {
        r = 0;
    }
    printf("\ncpf_dig: %d, dig: %d", cpf_dig, dig);
    return r;
}
