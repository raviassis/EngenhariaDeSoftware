#include <stdio.h>
#include <conio.h>
// calcula o valor absoluto de um número
int abs (int num) {
if (num<0) num = - num;
return num;
}
int main()
{ int num=10,b;
printf("\nvalor original:%d",num);
b=abs(num); // chamando a função;
printf("\nvalor de dado apos a execucao:%d ",num);
printf("\nvalor de b apos a execucao:%d ",b);
num = -10;
printf("\nvalor original:%d",num);
b=abs(num); // chamando a função;
printf("\nvalor de dado apos a execucao:%d ",num);
printf("\nvalor de b apos a execucao:%d\n ",b);
system ("PAUSE");
return 0;
}
