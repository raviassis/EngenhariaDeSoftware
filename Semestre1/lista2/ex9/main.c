#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex 9 -  Números palíndromos são aqueles que escritos da direita para esquerda ou da esquerda
para direita tem o mesmo valor. Exemplo:929, 44, 97379. Fazer um algoritmo que dado um
numero de 5 dígitos; calcule e escreva se este e ou não palíndromo.
*/

//ler_palin : ler número inteiro de 5 digitos
int ler_palin (){
    int a = 0;

    while ( (a < 10000) || (a > 99999) ) {
        printf("Digite um número de 5 digitos: ");
        scanf("%d", &a);
    }
    return a;
}

int main()
{
    setlocale(LC_ALL,"portuguese");
    int num,p1, p2, aux;
    printf("---Palíndromo---\n\n");
    num = ler_palin();
    p1 = (int)(num/1000);
    p2 = (int)( (num%10)*10 );
    aux = (int)(num%100);
    aux = (int)(aux/10);
    p2 = p2 + aux;
    if (p1==p2) {
        printf("Número palíndromo");
    }
    else {
        printf("Número não palíndromo");
    }
    return 0;
}
