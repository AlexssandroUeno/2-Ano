//
//  main.c
//  forca
//
//  Created by Ricardo Inácio Álvares e Silva on 21/02/15.
//  Copyright (c) 2015 Ricardo Inácio Álvares e Silva. All rights reserved.
//

/*
* Classe principal
*
* Geramos aqui o numero do index de acordo com o arquivo .txt a palavra secreta
* Verificamos possiveis erros de abrir, ou nao achar palavras  no arquivo .txt
* 
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "lista_palavras.h"
#include "forca.h"

/* Sortea numero de acordo com a quantidade de palavras do arquivo
*
*@param int - inferior, recebe como zero por ser a primeira linha do arquivo
*@param int - superior, basicamente recebe o total de palavras do arquivo .txt
*
*@return Integer, retorna um numero random para ser usado de index da palavra 
*
*/
int sortear_entre(int inferior, int superior) {
    srand((unsigned int) time(NULL));
    return rand() % superior + inferior;
}

/* ler, gravar os dados do arquivo a uma lista de palavras
*
*@param Char const *nome_arq -  referencia do arquivo a ser lido
*
*@return Struct Lista_palavras - retorna uma  nova lista de palavras 
*/
struct lista_palavras *
carregar_palavras(char const * nome_arq) {
    // Abre um arquivo para leitura
    FILE * arq = fopen(nome_arq, "r");
    if (arq == NULL) {
        printf("O arquivo indicado não pode ser aberto.\n");
        exit(!0);
    }
    
    // Le quantas palavras há no arquivo aberto
    unsigned int num_palavras;
    if (fscanf(arq, "%u\n", &num_palavras) == 0) {
        printf("Erro ao ler quantidade de palavras no arquivo.\n");
        exit(!0);
    }
    
    // Cria uma nova lista de palavras
    struct lista_palavras * lista = nova_lista(num_palavras);
    
    for (int i = 0; i < num_palavras && feof(arq) == 0; i++) {
        const int tam_max_palavra = 100;
        char palavra[tam_max_palavra];

/*exercicio 4 ->adicionado */
	char *palavras;	

        palavras = fgets(palavra,tam_max_palavra,arq);
	palavras[strlen(palavra) -1] = '\0';
/*exercico4 */

       /* if(fscanf(arq, "%s\n",palavra) == 0) {
            printf("Erro ao ler a proxima palavra do arquivo %s.\n",palavra);
            liberar_lista_palavras(lista);
            exit(!0);
        }*/
        inserir_palavra(lista,palavra);
    }
  
    return lista;
}

/* Metodo main o primeiro a ser executado
*
*  Aqui verificamos algumas regras como modo de uso do arquivo
*  Deve ser passado argumentos na execucao do arquivo 
*
*@param Int argc, contador de argumento 
*@param Const char *argv[], argumentos a  ser passados em tempo de execucao
*
*@return 0, termina o program 
*/
int
main(int argc, const char * argv[]) {
    if (argc < 2) {
        printf("Modo de uso: forca <arquivo_palavras>\n");
        exit(!0);
    }
    char const * nome_arq = argv[1];
    
    struct lista_palavras * palavras;
    palavras = carregar_palavras(nome_arq);
    
    int sorteada = sortear_entre(0, get_num_palavras(palavras));
    char * palavra = get_palavra(palavras, sorteada);
    
    jogar_forca(palavra);
    
    liberar_lista_palavras(palavras);
    return 0;
}
