#ifndef HANOI_H_INCLUDED
#define HANOI_H_INCLUDED

/*hanDisk: estrutura do disco de hanoi*/
struct hanoiDisks {
    int size;
    int positionedTower;
};
typedef struct hanoiDisks hanDisk;

/*hanTower: Estrutura das torres de hanoi*/
struct hanoiTowers {
    int numTower;
    char name;
    int tam;
    hanDisk *disks[3];
};
typedef struct hanoiTowers hanTower;

/*Disco vazio*/
hanDisk Empty;

/*putDisk: coloca disco na torre*/
int putDisk ( hanTower *tower, hanDisk *disk) {
    int position;
    int tamDiskPrev= 4;

    for (position = 0; position < (*tower).tam; position++) {

        if ( (*tower).disks[position]->size == 0) {
            if (tamDiskPrev > disk->size) {
                disk->positionedTower = tower->numTower;
                tower->disks[position] = disk;
                return 1;
            }
            else return 0;
        }
        else tamDiskPrev = tower->disks[position]->size;
    }
    return 0;
}

/*removeDisk: Remove um disco da torre*/
hanDisk * removeDisk ( hanTower *tower) {
    int i;
    hanDisk *disk;

    for (i = 2; i >=0; i--) {
        if ( tower->disks[i]->size != 0 ) {
            disk = tower->disks[i];
            disk->positionedTower = 0;
            tower->disks[i] = &Empty;
            return disk;
        }
    }
    return &Empty;
}

/*diskTransfer: transferencia de disco entre torres*/
int diskTransfer (hanTower *origin, hanTower *destiny) {
    hanDisk *disk;
    disk = removeDisk(origin);
    //printf("DiskTransfer\n");
    //printf("Disk.size = %d\nDisk.positionedTower = %d\n&Disk = %x\n", disk->size, disk->positionedTower, disk);

    if (disk->size != 0) {
        if ( putDisk(destiny, disk) ) {

            return 1;
        }
        else {
            putDisk(origin, disk);
            return 0;
        }
    }
    else return 0;
}

/*Inicializa Discos*/
void startDisks (hanDisk *disk1, hanDisk *disk2, hanDisk *disk3) {
    disk1->size = 1;
    disk2->size = 2;
    disk3->size = 3;
    disk1->positionedTower = 0;
    disk2->positionedTower = 0;
    disk3->positionedTower = 0;
}

/*Inicializa torres*/
void startTowers (hanTower *t1, hanTower *t2, hanTower *t3, int tam) {
    int i;
    t1->numTower = 1;
    t1->name = 'O';
    t2->numTower = 2;
    t2->name = 'T';
    t3->numTower = 3;
    t3->name = 'D';
    t1->tam = t2->tam = t3->tam = tam;
    for (i = 0; i < t1->tam; i++) t2->disks[i] = t3->disks[i] = t1->disks[i] = &Empty;
}

/**/
void HanoiRec1 (hanTower *O, hanTower *D, hanTower *T, int n) {
    if (n > 0) {
        HanoiRec(O, T, D, n-1);
        if (diskTransfer(O, D)) printf("%c -> %c\n", O->name, D->name);
        HanoiRec(T,D,O, n-1);
    }
}

/**/
void HanoiRec (char O, char D, char T, int n) {
    if (n > 0) {
        HanoiRec(O, T, D, n-1);
        printf("%c -> %c\n", O, D);
        HanoiRec(T,D,O, n-1);
    }
}

void HanoiRec2 (hanTower *O, hanTower *D, hanTower *T, int n) {
    if (n > 0) {
        HanoiRec2(O, T, D, n-1);
        if (diskTransfer(O, D)) printHanoi(O,T,D);
        HanoiRec2(T,D,O, n-1);
    }
}

void printHanoi (hanTower *O, hanTower *T, hanTower *D) {
    int i;
    for (i = 0; i < 3; i++) {
        printT();
    }
    printf("\n");
    for (i = 2; i >=0; i--) {
        if (O->disks[i] != &Empty) {
            if (O->disks[i]->size == 3) {
                printD3();
            }else if (O->disks[i]->size == 2) {
                printD2();
            }
            else if (O->disks[i]->size == 1) {
                printD1();
            }
        }
        else {
           printT();
        }

        if (T->disks[i] != &Empty) {
            if (T->disks[i]->size == 3) {
                printD3();
            }else if (T->disks[i]->size == 2) {
                printD2();
            }
            else if (T->disks[i]->size == 1) {
                printD1();
            }
        }
        else {
           printT();
        }

        if (D->disks[i] != &Empty) {
            if (D->disks[i]->size == 3) {
                printD3();
            }else if (D->disks[i]->size == 2) {
                printD2();
            }
            else if (D->disks[i]->size == 1) {
                printD1();
            }
        }
        else {
           printT();
        }
        printf("\n");
    }
    for (i = 0; i < 3; i++) printT();printf("\n");
    for (i = 0; i < 3; i++) printB();printf("\n");
}

void printT(){
    printf("   |   ");
}

void printD1() {
    printf("   =   ");
}

void printD2() {
    printf("  ===  ");
}

void printD3() {
    printf(" ===== ");
}

void printB() {
    printf("-------");
}


#endif // HANOI_H_INCLUDED
