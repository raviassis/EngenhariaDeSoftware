#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include "mbiblioteca.h"

int main()
{ int c,f;
printf("Digite a temperatura em graus Celsius: ");
scanf("%d",&c);
f = fahrenheit(c); // chamada à função
printf("Fahrenheit = %d\n",f);
system ("PAUSE");
return 0;
}
