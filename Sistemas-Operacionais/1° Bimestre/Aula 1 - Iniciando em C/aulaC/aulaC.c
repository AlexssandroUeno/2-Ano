
#include <stdio.h>
#include <string.h>
int main(int charc, char* argv[] )
{
	char nome[] = "teste";
	int caracteres = strlen(nome);
	
	printf("o tamanho e: %d. \n", caracteres);
	printf("%s\n", nome);
	return (0);
}
