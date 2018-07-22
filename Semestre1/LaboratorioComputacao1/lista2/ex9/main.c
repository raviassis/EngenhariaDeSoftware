#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*
ex 9 -  N�meros pal�ndromos s�o aqueles que escritos da direita para esquerda ou da esquerda
para direita tem o mesmo valor. Exemplo:929, 44, 97379. Fazer um algoritmo que dado um
numero de 5 d�gitos; calcule e escreva se este e ou n�o pal�ndromo.
*/

//ler_palin : ler n�mero inteiro de 5 digitos
int ler_palin (){
    int a = 0;

    while ( (a < 10000) || (a > 99999) ) {
        printf("Digite um n�mero de 5 digitos: ");
        scanf("%d", &a);
    }
    return a;
}

int main()
{
    setlocale(LC_ALL,"portuguese");
    int num,p1, p2, aux;
    printf("---Pal�ndromo---\n\n");
    num = ler_palin();
    p1 = (int)(num/1000);
    p2 = (int)( (num%10)*10 );
    aux = (int)(num%100);
    aux = (int)(aux/10);
    p2 = p2 + aux;
    if (p1==p2) {
        printf("N�mero pal�ndromo");
    }
    else {
        printf("N�mero n�o pal�ndromo");
    }
    return 0;
}
