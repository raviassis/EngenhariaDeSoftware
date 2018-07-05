#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

const int MAX_VETOR = 1000;

struct dados_pessoa {
    char nome [50];
    int idade;
    int altura;
    float peso;
    float imc;
    char sexo;
};

typedef struct dados_pessoa people;

float imc (int altura, float peso) {
    double altura_metros = (double)altura / 100.00;
    return peso/ pow( altura_metros, 2) ;
}

people ler_dados (people pessoa) {
    setbuf(stdin, NULL);
    printf("Nome: ");
    gets( pessoa.nome );

    setbuf(stdin, NULL);
    printf("Idade: ");
    scanf("%d", &pessoa.idade);

    setbuf(stdin, NULL);
    printf("Sexo: ");
    scanf("%c", &pessoa.sexo);

    setbuf(stdin, NULL);
    printf("Altura (cm): ");
    scanf("%d", &pessoa.altura );

    setbuf(stdin, NULL);
    printf("Peso (kg): ");
    scanf("%f", &pessoa.peso);

    pessoa.imc = imc(pessoa.altura, pessoa.peso);

    printf("IMC: %.2f\n", pessoa.imc);

    return pessoa;
}

int idadeMedia (people pessoas[MAX_VETOR], int op) {
    int soma= 0, i= 0, cont= 0;
    int media;

    if (op == 0) {
        while (pessoas[i].idade != -1 ) {
            soma += pessoas[i].idade;
            cont++;
            i++;
        }
    }
    else if (op == 1) {
        while (pessoas[i].idade != -1 ) {
            if (pessoas[i].sexo == 'M' || pessoas[i].sexo == 'm') {
                soma += pessoas[i].idade;
                cont++;
            }
            i++;
        }
    }
    else if (op == 2) {
        while (pessoas[i].idade != -1 ) {
            if (pessoas[i].sexo == 'F' || pessoas[i].sexo == 'f') {
                soma += pessoas[i].idade;
                cont++;
            }
            i++;
        }
    }

    if (soma !=0 && cont != 0){
        media = soma/cont;
    }
    else {
        media = 0;
    }

    return media;
}

int contPeople (people pessoas[MAX_VETOR], int op) {
    int i=0, cont= 0;

    if (op == 0) {
        while (pessoas[i].idade != -1) {
            cont++;
            i++;
        }
    }else if ( op == 1) {
        while (pessoas[i].idade != -1) {
            if ( pessoas[i].sexo == 'M' || pessoas[i].sexo == 'm' ) {
               cont++;
            }
            i++;
        }
    }
    else if ( op == 2) {
        while (pessoas[i].idade != -1) {
            if ( pessoas[i].sexo == 'F' || pessoas[i].sexo == 'f' ) {
               cont++;
            }
            i++;
        }
    }

    return cont;
}

float percentIMCBaixo (people pessoas[MAX_VETOR], int op) {
    int i = 0 , cont = 0, m = 0;
    float result;

    while (pessoas[i].idade != -1) {
        if (pessoas[i].sexo == 'F' || pessoas[i].sexo == 'f' ) {
            if (pessoas[i].imc < 20.0) {
                cont++;
            }
            m++;
        }
        i++;
    }

    if (cont != 0) {
        result = ( (float)cont/(float)m )*100.00;
    }
    else {
        result = 0.00;
    }

    return result;
}

people oldPeople (people pessoas[MAX_VETOR], int op) {
    int i= 0;
    people oldest;
    oldest.idade = 0;

    if (op == 1) {
        while (pessoas[i].idade != -1) {
            if (pessoas[i].sexo == 'M' || pessoas[i].sexo == 'm' ) {
                if (pessoas[i].idade > oldest.idade) {
                    oldest = pessoas[i];
                }
            }
            i++;
        }
    }else if (op == 2) {
        while (pessoas[i].idade != -1) {
            if (pessoas[i].sexo == 'F' || pessoas[i].sexo == 'f' ) {
                if (pessoas[i].idade > oldest.idade) {
                    oldest = pessoas[i];
                }
            }
            i++;
        }
    }
    else {
        while (pessoas[i].idade != -1) {

            if (pessoas[i].idade > oldest.idade) {
                oldest = pessoas[i];
            }

            i++;
        }
    }

    return oldest;

}

int main()
{
    people pessoas[MAX_VETOR];
    people oldest;
    int i=0;
    char flag='s';

    while (i < MAX_VETOR) {
        pessoas[i].idade = -1;
        pessoas[i].sexo = 'x';
        i++;
    }

    i=0;
    printf("Pesquisa Dados Pessoais.\n");
    printf("Informe os dados solicitados de cada pessoa.\n\n");
    //loop
    do{
        printf("Entrevista %d\n", (i+1) );

        pessoas[i] = ler_dados(pessoas[i]);

        printf("Deseja continuar?(s/n)\n\n");
        flag = getch();
        i++;
    }while ( (flag == 's' || flag == 'S') && i<MAX_VETOR);

    system("cls");
    printf("Idade Media Geral: %d\n", idadeMedia(pessoas, 0) );
    printf("Idade Media de Homens: %d\n", idadeMedia(pessoas, 1) );
    printf("Idade Media de Mulheres: %d\n\n", idadeMedia(pessoas, 2) );

    printf("Quantidade de entrevistados\n");
    printf("Homens: %d   Mulheres: %d\n\n", contPeople(pessoas, 1), contPeople(pessoas, 2) );

    printf("Percentual de mulheres com IMC abaixo de 20: %.2f%%\n\n", percentIMCBaixo(pessoas, 2));

    oldest = oldPeople(pessoas, 1);
    printf("Homem mais velho: %s Idade: %d anos.\n", oldest.nome, oldest.idade);
    oldest = oldPeople(pessoas, 2);
    printf("Mulher mais velha: %s Idade: %d anos.\n\n", oldest.nome, oldest.idade);

    system("pause");
    return 0;
}
