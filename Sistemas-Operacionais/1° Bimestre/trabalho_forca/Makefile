######################################
#
#Makefile|make|make clear|
#
#@Author José Ricardo Guidetti Junior
#
#@Version 14/04/2015
#
#####################################
#CC = Compilador atual, no caso o clang
CC     = clang
#CFLAGS, opcao que ira passar para o compilar
CFLAGS = -Wall -Werror
#OBJS, guarda todos os meus objects .o
OBJS   = main.o forca.o lista_palavras.o
#BIN, meus executaveis 
BIN    = forca

all: forca

forca: $(OBJS)
	$(CC) $(CFLAGS) -o forca main.c forca.c lista_palavras.c 

main.o: main.c forca.h lista_palavras.h
	$(CC) $(CFLAGS) -c main.c

forca.o: forca.c forca.h 
	$(CC) $(CLFAGS) -c forca.c
	
lista_palavras.o: lista_palavras.c lista_palavras.h 
	$(CC) $(CFLAGS) -c lista_palavras.c

clear:
	rm -f $(BIN) $(OBJS)	
