////////////////////////////////////////
//Exercicio6.c
//
//@Author  Thelokys
//@Version 03/03/2015
//
////////////////////////////////////////
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
	int hora;
	int minuto;
}HORA;


typedef struct
{
	int dia;
	int mes;
	int ano;
}DATA;

	
void passar_dia(DATA data)
{
//	printf("\nMETODO passar_Dia\n");
	printf("\nEh dia %d/%d/%d, passando dia", data.dia, data.mes, data.ano);
	data.dia += 1;
	printf("\nEh dia %d/%d/%d", data.dia, data.mes, data.ano);
	printf("\n****************************\n");
}

void passar_lote_dias(int qntDatas, DATA datas[])
{
	for(int i = 0; i < qntDatas; i++)
	{	
		passar_dia(datas[i]);
	}	
}

int data_valida(DATA data)
{

//	printf("METODO data_valida\n");
	if((data.ano % 4 == 0)  && ( data.ano % 100 != 0 || data.ano % 400 ==0 ))
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

int calcula_duracao_jogo(HORA horaI,HORA horaT)
{
	printf("METODO calcula_duracao_jogo");
	int duracao_minutos;
	int duracaoTotal =  horaT.hora - horaI.hora;
 	int duracaoTminuto = horaT.minuto - horaI.minuto;
//	printf("duraocaoTminuto -> %d",duracaoTminuto);
	if( ( duracaoTotal > 24 ) && ( duracaoTminuto <= 0  ) ) 
	{
		duracao_minutos = duracaoTotal * 60;
		return duracao_minutos;
	}else{	
		return -1;
	}
	
}

int main(int argc, char *argv[])
{
	HORA hI = {2,20};
	HORA hT = {26,0};
	DATA d = {5,3,2015};
	DATA datas[] ={{2,1,2015},{1,9,2015}};
	


	int qntDatas = 2; //total de datas passadas
//	printf("\nDURACAO JOGO\n");
	if(calcula_duracao_jogo(hI,hT) >= 0 )
	{
		printf("%d minutos\n\n",calcula_duracao_jogo(hI,hT));
	}
	else
	{	
	      printf("\n\tHora incorreta\n\tLembrando que a hora nao passa de 24horas\n");	
	}
	printf("_______________________________");
	printf("\n\tPASSAR DIA");
	passar_dia(d);
	printf("_______________________________");
	printf("\nVerificando se a data e valida...");
	
	if(data_valida(d) == 0)
	{
		printf("\nData Invalida\n");
	}
	else
	{
		printf("\ndata Valida\n");
	}
	printf("_______________________________");	
	printf("\nPassando lote de dias: \n");
	passar_lote_dias(qntDatas, datas);
	printf("__________FIM_______FIM________\n");
	return 0;
}

