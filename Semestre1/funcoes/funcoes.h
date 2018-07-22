#ifndef FUNCOES_H_INCLUDED
#define FUNCOES_H_INCLUDED

int ler_positivo () {
    int a;
    printf("\nDigite um número positivo: ");
    scanf("%d", &a);

    while ( a < 0){
        printf("\nNúmero inválido!");
        printf("\nDigite um número positivo: ");
        scanf("%d", &a);
    }
    return a;
}

int par (int num) {
    int r;

    if (num%2==0) {
        r = 1;
    }
    else {
        r=0;
    }
    return r;
}

int divisivel (int dividendo, int divisor){
    int r;
    if ( divisor != 0 ) {
        if ( dividendo%divisor==0 ) {
            int r=1;
        }
        else {
            r=0;
        }
    }
    else {
        printf("\nDivisao invalida");
        r=0;
    }
    return r;
}


#endif // FUNCOES_H_INCLUDED
