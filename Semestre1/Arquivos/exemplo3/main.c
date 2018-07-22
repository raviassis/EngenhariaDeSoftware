#include <stdio.h>
#include <stdlib.h>
#include <string.h>
main()
{
    char ch;
    FILE *arquivo;
    if ((arquivo = fopen("teste.txt","r+")) == NULL)
    {
        printf("Erro de abertura! \n");
    }
    else
    {
        char ch;
        printf("\nAntes da modificacao:\n");
        fseek(arquivo,10, SEEK_SET);
        fread(&ch,sizeof(ch),1,arquivo);
        printf("Valor lido:%c\n\n",ch);
        printf("\nAlterando o valor do arquivo...\n");
        ch='9';
        fseek(arquivo,10 , SEEK_SET);
        fwrite(&ch,sizeof(ch),1,arquivo);
        printf("Apos a modificacao:\n");
        fseek(arquivo,10, SEEK_SET);
        fread(&ch,sizeof(ch),1,arquivo);
        printf("Valor lido:%c\n\n",ch);
        fclose(arquivo);
    }
    system("pause");
}
