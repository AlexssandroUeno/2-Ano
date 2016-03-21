//
//@author José Ricardo Guidetti Junior
//
//First_fit
//Aplicação básica simulando apenas uma inserção e utilização do first, 
//sendo a idea o primeiro que couber coloca lá e pronto!
//
//Next_fit
//Aplicação básica simulando apenas uma inserção e utilização do nextFit, 
//sendo a idea o próximo que couber coloca lá e pronto! 
//proximo = atual_posicao + 1;
//
#include <stdio.h>	// include para utilização de input e ouput do teclado
#include <stdlib.h>
// include de utilização das "interfaces" 
#include "reg_nos.h" 			
#include "reg_bitmapped.h"

void first_fit(){
    	//Declarações dos campos do método First_Fit
 int i, j, numParticoes, processos, tamanho_particoes[50];
 printf("Número de partições ? {coloque 3 para testar}");
    scanf("%d",&numParticoes);
    
 printf("Agora fale quanto é o processo que vai tentar ser inserido em uma das  partições \n");
 sleep(2);
 printf("Qual tamanho do processo a ser inserido? \n");
    scanf("%d",&processos);
    
 printf("\nAgora diga o tanto de bytes que irão caber em cada partição\n{Coloque pelo menos umas das partições do tamanho do processo a inserido}\n");
 
 sleep(3);
 for(i=0;i<=numParticoes;i++)
 { //percorremos o tanto de particoes,
// perguntando um por um qual o tamanho que cabe em cada pedaco
 printf("A partição do index %d tem quantos bytes de tamanho \n",i);
  scanf("%d",&tamanho_particoes[i]);
  }
 for(j=0;j<=numParticoes;j++)
  {// percorremos agora o numero de particoes, verificando se vai caber o processo
   if(processos<=tamanho_particoes[j])
    {//se caber o processo dentro de cada bloco, então carregamos eles
     tamanho_particoes[j]=tamanho_particoes[j]-processos;
     printf("O processo esta carregado na %d posição\n",j); // mostra que foi carregado e sua posição
     printf("E sobrou %d bytes nessa posição",tamanho_particoes[j]); //mostra a sobra
    break;
    }
  }
}

void next_fit()
{
	//Declarações dos campos do método Next_fit
  int i,j,k, numParticoes, processos, tamanho_particoes[50], atual;
  printf("Número de partições ? {coloque 3 para testar}");
  scanf("%d",&numParticoes);
  printf("Agora fale quanto é o processo que vai tentar ser inserido em uma das  partições \n");
 sleep(2);
 printf("Qual tamanho do processo a ser inserido? \n");
  scanf("%d",&processos);
 for(i=0;i<=numParticoes;i++)
  {
   printf("A partição do index %d cabe quantos bytes ? \n",i);
  scanf("%d",&tamanho_particoes[i]);
  }
   printf("\nEntão a tabela ficou assim: ");
 
 for(k = 0; k <=numParticoes; k++ ){
    printf("[%d]",tamanho_particoes[k]);    
 }
 sleep(5);
 
 printf("\nAgora diga qual é o index da partição atual,\n  O algoritmo então pegara o (index do atual)+ 1 para tentar encaixar, \n sempre pegando o proximo que cabe\n");	
 printf("\n Qual a posição atual ? {coloque 0, pegará o próximo que cabe}\n");
 scanf("%d",&atual);
 

 for(j=atual+1;j<=numParticoes;j++)
  {
   if(processos<=tamanho_particoes[j])
   {
    tamanho_particoes[j]=tamanho_particoes[j]-processos;
    printf("\n Processo ficou na %d° posição\n",j);
    printf("sobrou nessa partição %d bytes",tamanho_particoes[j]);
     printf("\nEntão a tabela ficou assim: ");
 
    for(k = 0; k <=numParticoes; k++){
        printf("[%d]",tamanho_particoes[k]);    
     }
   break;
   }
  }  
}

int main()
{   //método que pega o primeiro que cabe encaixa lá !
    //first_fit(); descomente para utilizar o método first_fit 
    //método que usa o próximo que cabe, atual+1
    //next_fit();    //descomente para utilizar o método next_fit 
}
