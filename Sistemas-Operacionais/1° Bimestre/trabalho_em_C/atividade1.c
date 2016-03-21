////////////////////////////////////////
//Exercicio1.c
//
//@Author  Thelokys
//@Version 28/02/2015
//
///////////////////////////////////////
#include <stdio.h>

double media(int* v1, int* v2, int* v3)
{
	double media = (*v1+*v2+*v3)/3;
return media;
}

int main (int argc,char* argv[] ) 
{
	int v1,v2,v3 ;
		printf("\nInsira 3 valores:  \n");
		scanf("%d",&v1);
		scanf("%d",&v2);
		scanf("%d",&v3);
		printf("\nA media eh: %f\n",media(&v1,&v2,&v3));
return 0;
}

