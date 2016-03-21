//
//  lista_palavras.c
//  forca
//
//  Created by Ricardo Inácio Álvares e Silva on 22/02/15.
//  Copyright (c) 2015 Ricardo Inácio Álvares e Silva. All rights reserved.
//

/*
*  Essa classe serve para ter o controle da lista de palavras do arquivo
*  Desde em pegar a palavra, inserir ou mesmo liberararmos memoria das alocacoes feitas partir da Struct de lista criadas.
* 
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "lista_palavras.h"

/* Gerenciamento das palavras dos arqvuios e da lista da mesma.
*
*@param Unsigned int capacidade -  total de palavras
*
*@return Struct nova - criacao de outra lista
*
*/

struct lista_palavras *
nova_lista(unsigned int capacidade) {
    struct lista_palavras * nova = (struct lista_palavras *) malloc(sizeof(struct lista_palavras));
    if (nova == NULL) {
        printf("Falta de memoria para alocar nova lista.\n");
        exit(!0);
    }
    
    nova->contador = 0;
    nova->capacidade = capacidade;
    nova->palavras = (char**) calloc(capacidade, sizeof(char*));
    if (nova->palavras == NULL) {
        printf("Falta de memoria para alocar palavras.\n");
        exit(!0);
    }
    
    return nova;
}

/* Pega a palavra secreta da forca
*
*@param Struct lista_palavras - referencia da lista aonde esta a palavra secreta 
*@param Unsigned int num - index da palavra contida na lista
*
*@return char*, retorna um ponteiro para a palavra que esta dentro da struct
*/
char *
get_palavra(struct lista_palavras * lista, unsigned int num) {
    return lista->palavras[num];
}

/* Totalizaor de palavras
*
*@param Struct lista_palavras, referencia da struct a ser totalizada
*
*@return Integer, retorna na struct  lista o totalizaor de palavras
*/
int
get_num_palavras(struct lista_palavras * lista) {
    return lista->contador;
}

/* Insira palavras na lista de struct
*
*@param Struct lista_palavras, referencia da struct a ser inserida
*@param palavra[], palavra a ser inserida na struct de lista de palavras
*/
void inserir_palavra(struct lista_palavras * lista, char palavra[]) {
    if (lista->contador == lista->capacidade) {
        printf("Lista de palavras esta cheia.\n");
        exit(!0);
    }
 
    unsigned long tam_string = strlen(palavra)+1;
    lista->palavras[lista->contador] = (char *) calloc(tam_string, sizeof(char));
    if (lista->palavras[lista->contador] == NULL) {
        printf("Falta de memória para inserir palavra.\n");
        exit(!0);
    }
    strcpy(lista->palavras[lista->contador], palavra);
    lista->contador++;
}

/* Liberacao de alocacoes de memoria
*
*@param Struct lista_palavras, referencia para desalocar/liberar
*
*/
void
liberar_lista_palavras(struct lista_palavras * lista) {
    for (int i = 0; i < lista->contador; i++) {
        free(lista->palavras[i]);
    }
    free(lista->palavras);
    free(lista);
}
