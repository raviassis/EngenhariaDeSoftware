#include <stdio.h>
#include <stdlib.h>
#include <string.h>
main()
{
    char ch, buffer[128];
    int posicao;
    FILE *arquivo;
    if ((arquivo = fopen("teste.txt","r+")) == NULL)
    {
        printf("Erro de abertura! \n");
    }
    else
    {
        fseek(arquivo,0, SEEK_SET);
        printf("Digite a posição = ");
        scanf("%d%*c", &posicao);

        printf("Digite o caracter para ser gravado= ");
        ch = getchar();

        fseek(arquivo,posicao, SEEK_SET);
        fwrite(&ch,sizeof(ch),1,arquivo);

        fseek(arquivo,0, SEEK_SET);

        fgets(buffer, 80, arquivo);

        while (!feof(arquivo))
        {
            printf("%s", buffer);
            fgets(buffer, 80, arquivo);
        }

        /*printf("\nAntes da modificacao:\n");
        fseek(arquivo,10, SEEK_SET);
        fread(&ch,sizeof(ch),1,arquivo);
        printf("Valor lido:%c\n\n",ch);
        printf("\nAlterando o valor do arquivo...\n");
        ch='9';
        fseek(arquivo,10 , SEEK_SET);

        printf("Apos a modificacao:\n");
        fseek(arquivo,10, SEEK_SET);
        fread(&ch,sizeof(ch),1,arquivo);
        printf("Valor lido:%c\n\n",ch);*/
        fclose(arquivo);
    }
    system("pause");
}
