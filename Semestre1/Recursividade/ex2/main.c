#include <stdio.h>
void cont (int);
main()
{
    cont(1);
}
void cont(int n)
{

    if (n < 10) cont(n+1);
    printf("%d\n", n);
}

