#include<windows.h> // cabe�alho para a fun��o SetConsoleCursorPosition
#include <stdio.h> //cabe�alho para i/o
COORD coord= {0,0}; // variavel global
//O centro do eixo � o canto esquerdo da tela
void gotoxy(int x,int y)
{
    coord.X=x;
    coord.Y=y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),coord);
}
int main()
{
//chamando a fun��o
    char tcl = 0;
    int x=0, y=0;
    while (tcl != 27) {
        if (tcl == 'w' && y>0) {
            y--;
        }
        else if (tcl == 's') {
            y++;
        }
        else if ( tcl == 'a' && x>0 ){
            x--;
        }
        else if (tcl == 'd') {
            x++;
        }
        gotoxy(x,y);
        tcl = getch();
    }
    return 0;
}
