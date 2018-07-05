#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vet1[] = {8,6,2,3,4,5,5,1,9,7};
    int vet2[5];
    int i, j=0;

    for (i=0; i<10; i++) {
        if (i%2 == 0 || i == 0) {
            vet2[j] = vet1[i];
            j++;
        }
    }

    for (i = 0; i < 10; i++) {
        printf("vet1[%d] = %d\n", i, vet1[i]);
    }
    for (i = 0; i < 5; i++) {
        printf("vet2[%d] = %d\n", i, vet2[i]);
    }

    return 0;
}
