#include <stdio.h>
#include <stdlib.h>

int main()
{
    int m[3][3];
    int L,C,i;
    i=1;
    for (L=0; L<3; L++)
    {
        for (C=0; C<3; C++)
        {
            m[L][C]=i;
            i++;
        }
    }
    printf("\nValores da matriz m\n");
    for (L=0; L<3; L++)
    {
        for (C=0; C<3; C++)
        {
            printf("m[%d][%d]=%d\t",L,C,m[L][C]);
        }
        printf("\n");
    }
}
