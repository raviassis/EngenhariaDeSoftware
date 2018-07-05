#include <stdio.h>
#include <stdlib.h>
#include "..\functions\hanoi.h"

int main()
{
    char o = 'O';
    char d = 'D';
    char t = 'T';
    int n = 3;
    HanoiRec(o,d,t,n);

    return 0;
}
