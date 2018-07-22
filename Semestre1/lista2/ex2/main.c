#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>
/*
ex2 - Fazer um algoritmo peça o nome e as 3 notas de um aluno e mostre, além do
nome e do valor da media do aluno, uma mensagem de "Aprovado", caso a media
seja igual ou superior a 6, ou a mensagem "reprovado", caso contrario.
*/

int main()
{
    setlocale(LC_ALL,"portuguese");
    float n1, n2, n3, media;
    char nome[30];
    printf("---Notas---\n");
    printf("Nome: ");
    gets(nome);
    printf("Nota 1: ");
    scanf("%f", &n1);
    printf("Nota 2: ");
    scanf("%f", &n2);
    printf("Nota 3: ");
    scanf("%f", &n3);
    media = (n1+n2+n3)/3.0;
    if (media >= 6.0) {
        printf("\nAluno: %s\nMédia: %.2f --- Aprovado", nome,media);
    }
    else {
        printf("\nAluno: %s\nMédia: %.2f --- Reprovado", nome,media);
    }
    return 0;
}
