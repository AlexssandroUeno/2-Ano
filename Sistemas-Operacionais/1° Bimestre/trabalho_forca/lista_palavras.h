//
//  lista_palavras.h
//  forca
//
//  Created by Ricardo Inácio Álvares e Silva on 22/02/15.
//  Copyright (c) 2015 Ricardo Inácio Álvares e Silva. All rights reserved.
//

#ifndef forca_lista_palavras_h
#define forca_lista_palavras_h

struct lista_palavras {
    unsigned int capacidade;
    unsigned int contador;
    char ** palavras;
};

struct lista_palavras * nova_lista(unsigned int capacidade);
void inserir_palavra(struct lista_palavras * lista, char palavra[]);
char * get_palavra(struct lista_palavras * lista, unsigned int num);
int get_num_palavras(struct lista_palavras * lista);
void liberar_lista_palavras(struct lista_palavras * lista);

#endif
