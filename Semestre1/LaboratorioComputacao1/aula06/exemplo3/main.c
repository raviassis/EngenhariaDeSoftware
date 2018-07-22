#include <stdio.h>
#include <conio.h>
void sucessor (int *n)
{ *n=*n+1;
}
int main()
{int num;
num=1;
sucessor(&num);
printf("Sucessor =%d\n",num);
return 0;
}
