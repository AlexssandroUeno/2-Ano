////////////////////////////////////////
//Exercicio5.c
//
//@Author  Thelokys
//@Version 03/03/2015
//
///////////////////////////////////////
#include <stdio.h> 
#include <stdlib.h>
#include <time.h>
#include <string.h>

//variaveis globais
int numSorteado ;
int tentativas=0;
int  acertou= 1;

/** Metodo de limpeza da tela*/
void clearS()
{
//	printf("\e[H\e[2J");
//	printf("\033[2J");
	system( "clear" );
}

/** Metodo que gera aleatoriamente o numero para o sorteio*/ 
void setNumber()
{
	srand( (unsigned)time(NULL));//srand funcao responsavel por alimentar
				     //o rand, assim gerando numeros diferentes
	
	numSorteado = rand() % 101; // para gerar numeros de 0-100;
}

/** Metodo do menu*/
void menu()
{
	printf("\n\t*** Sorteio de numeros ***\n");
	printf("\n\tIremos sortear um numero 0~100");
	printf("\nE ao longo de cada tentativas iremos dando dicas");
	printf("\n\n\tPRESSIONE [ENTER] PARA COMECAR\n\n");
	getchar();
	setNumber();
}

/** Metodo de pergunta para se jogar novamente*/	
void jogarNovamente()
{
	tentativas = 0;//zeramos o numero de tentativas
	int resp; //variavel que auxilia se vai ou nao jogar novamente
	printf("\n\tDeseja jogar novamente\n");
	printf("1 -  sim\n0 - nao\n");
	scanf(" %d",&resp);
	switch(resp)
	{
		case 0:
		/**seNAO for jogar novamente*/
			acertou = 0;
			break;
		case 1:
		/**se for jogar novamente*/
			acertou = 1;
			setNumber();//damos random novamente do numero sorteado
			printf("\nOK, VAMOS LA DENOVO !!\n");
			break;
	}
}

/** Metodo que verifica se o numero chutado eh o mesmo que o numero do sorteio*/
int checkNumber(int number)
{
	printf("\n");
	tentativas += 1; //como ele chegou aqui ja, entao significa que
			// o usuario tentou, assim incrementado a [tentativas]
	if( number == numSorteado )
/**Verificacao logica se o numero chutado eh igual ao do numero sorteado*/
	{
		printf("\nParabens você acertou o numero sorteado\n");		
		printf("\n\tTotal de tentativas: %d\n\n",tentativas);
		acertou = 0; // coloca a variavel acertou para 0 assim paramos o loop feito la no metodo main();
		jogarNovamente();//metodo de pergunta se quer jogar denovo
	}
	else if( number > numSorteado )
/** Verificacao logica se o numero chutado eh maior do que o sorteado*/
	{
		printf("\n\tNumero de tentativas: %d\n",tentativas);
		printf("\nO numero sorteado eh menor do que %d\n",number);
	}
	else if( number < numSorteado )
/** Verificacao logica se o numero chutado eh menor do que o sorteado*/
	{
		printf("\n\tNumero de tentativas: %d\n",tentativas);
		printf("\nO numero sorteado eh maior do que %d\n", number);
	}
	//retorna o status do jogando sendo ele acertou ou nao,
	// assim continuando ou nao, o loop do metodo main();
	return acertou;	
}

//Metodo main
int main(int argc, char *argv[])
{
	int number;
	menu();//Mostamos o menu, com as explicacoes do 'game'
		while( acertou != 0 )
	//temos um loop que para quando ele acerta,
		{
			printf("\nInsira um numero: \n");
			scanf(" %d",&number);//numero chutado	
			checkNumber(number);//verificamos o numero chutado
		}
	printf("\n");	
	return 0;
}

