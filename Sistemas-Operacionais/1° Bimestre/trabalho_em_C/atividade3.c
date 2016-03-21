////////////////////////////////////////
//Exercicio3.c
//
//@Author  Thelokys
//@Version 02/03/2015
//
///////////////////////////////////////
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void reversePolarity(char *palavra)
{
	//variavel 'aux' com o mesmo tamanho da palavra recebida
	char aux[50];
	int j = strlen(palavra) - 1; //strlen, qnt de caracteres total
	int i = 0; 
	for(i = 0; palavra[i] != '\0' ;i++)
	//vai repertir ate chegar no final da palavra
	{
		
		aux[j] = palavra[i];
		if(j < 0)break;
		j--;		
	}
	aux[i] = '\0'; //coloca '\0' para mostrar que é o final
	strcpy(palavra, aux); //copia o conteudo da variavel 'aux'
	printf("Sua palavra : %s\n\n",palavra);	
}

int main(int argc, char * argv[])
{
	if(argc < 2)
	{
		printf("\nModo de uso: ./atividade3 <palavra>\n");
		exit(0);
	}
	char palavra;
	strcpy(&palavra,argv[1]);
	reversePolarity(&palavra);
	return 0;
}

