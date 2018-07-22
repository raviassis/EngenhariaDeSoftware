#include <stdio.h>
int main(){
int i,n,p,c,fatn,fatp,fatn_p,cont;
printf("\nDigite o valor para n:");
scanf("%d",&n);
printf("\nDigite o valor para p:");
scanf("%d",&p);
fatn=1; // calculando o fatorial de n
for (i=1; i<=n; i++) {
fatn=fatn*i;
}
fatp=1; // calculando o fatorial de p
for (i=1; i<=p; i++) {
fatp=fatp*i;
}
fatn_p=1; // calculando o fatorial de n-p
for (i=1; i<=(n-p); i++) {
fatn_p=fatn_p*i;
}
c=(fatn)/(fatp*fatn_p); // calculando a combinação
printf(" A combinação de %d, %d a %d e:%d\n",n,p,p,c);
return 0;
}
