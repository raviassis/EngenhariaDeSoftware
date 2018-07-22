#include <stdio.h>
#include <stdlib.h>

void zera_vetor (int n, int *vet)
{
    int i;
    for (i=0; i<n; i++)
    {
        vet[i]=0;
    }
}
int main()
{
    int a[5] ;
    int i;
    zera_vetor(5,a);
    printf("\nValores do vetor a\n");
    for (i=0; i<5; i++)
    {
        printf("a[%d]=%d\n",i,a[i]);
    }
}
