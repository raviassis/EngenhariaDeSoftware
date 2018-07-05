#include <stdio.h>
#include <stdlib.h>
#include "..\functions\hanoi.h"

int main()
{
    hanDisk disk1, disk2, disk3, *diskteste;
    hanTower tower1, tower2, tower3;
    int i, test, tam = 3;

    startDisks(&disk1, &disk2, &disk3);
    startTowers (&tower1, &tower2, &tower3, tam);
    putDisk ( &tower1, &disk3);
    putDisk ( &tower1, &disk2);
    putDisk ( &tower1, &disk1);

    printHanoi(&tower1, &tower2, &tower3);
    //HanoiRec2(&tower1, &tower3, &tower2, 3);
    diskTransfer(&tower1, &tower2);
    printHanoi(&tower1, &tower2, &tower3);

    return 0;
}
