////////////////////////////////////////
//Exercicio4.c
//@Author Thelokys
//@Version 03/03/2015
//
///////////////////////////////////////
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void showPali(char *antes , char *palavra)
{
      //ao chegar nesse metodo temos a palavra invertida(antes) e o argv[i](palavra)
       
	//OBS: A funcao strcmp()Retorna zero se forem igual as palavra enviadas.
	if(strcmp(antes,palavra) == 0)
		printf("\nA palavra %s eh um palidromo\n\n",palavra);
	else
		printf("\nA palavra %s nao eh um palidromo\n\n",palavra);
}
void reversePolarity(char *palavra)
{
	char *aux = (char*) malloc(strlen(palavra)  * sizeof (char)); // alocao de memoria dinamicamente
//	char aux[strlen(palavra)];
	int j = strlen(palavra) - 1;//pegamos o tamanho da palavra recebido
	int i = 0;

	for(i = 0; palavra[i] != '\0'; i++)
	//loop que vai ate chegar no final da string
	{
		aux[j] = palavra[i]; //invertemos a palavra
		if(j < 0) break;     //verificamos se j terminou a palavra;   
		j--;
	}
//Obs: todo final de "string" contem '\0'
	aux [j] = '\0'; // colocar '\0' para mostrar no final da string 
	showPali(aux, palavra);
	free(aux); // Ao final temos que liberarmos 
			// memoria da alocao de memoria [malloc]
}
int main(int argc, char *argv[])
{
	if(argc < 2)
	{	
		printf("\nModo de uso: ./atividade4 <palavra>\n");
		exit(0);
	}
	printf("\n\t***RESULTADO***\n");
	for(int i = 1; i < argc; i++)
	//enviamos palavra por palavra e no final mostramos uma por cada se eh ou
	//nao palidromo
	{	
		reversePolarity(argv[i]);
	}	
	return 0;
}
