######################################
#
#Makefile| make| make clear|
#
#
#@Author Thelokys
#@Version 10/03/2015
#
######################################

	#Variaveis#

#CC eh o complidador atual que estou usando
CC=clang

#CFLAGS eh a opcao que ira passar para o compilador
CFLAGS= -Wall#o -Wall ou melhor -W all, é para executar todos os comandos 'W', Warnings e etc.

#OBJS guarda todos os meus objcts .o
OBJS = atividade6.o atividade5.o atividade4.o atividade3.o atividade2.o atividade1.o

#BIN sao os meus executaveis
BIN = atividade6 atividade5 atividade4 atividade3 atividade2 atividade1

all: atividades

atividades: $(OBJS)

atividade6.o: atividade6.c
	$(CC) $(CFLAGS) -o atividade6 atividade6.c

atividade5.o: atividade5.c
	$(CC) $(CFLAGS) -o atividade5 atividade5.c

atividade4.o: atividade4.c
	$(CC) $(CFLAGS) -o atividade4 atividade4.c

atividade3.o: atividade3.c
	$(CC) $(CFLAGS) -o atividade3 atividade3.c

atividade2.o: atividade2.c
	$(CC) $(CFLAGS) -o atividade2 atividade2.c

atividade1.o: atividade1.c
	$(CC) $(CFLAGS) -o atividade1 atividade1.c

clear:
	rm $(BIN)
