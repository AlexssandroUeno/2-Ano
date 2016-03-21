CC = clang
CFLAGS = -Wall -Werror -g -pg
OBJECTS = main.o uniterm.o
BIN = uniterm

all: uniterm

uniterm: $(OBJECTS)
	$(CC) $(CFLAGS) -o uniterm main.c uniterm.c

main.o: main.c uniterm.h
	$(CC) $(CFLAGS) -c main.c

uniterm.o: uniterm.c uniterm.h
	$(CC) $(CFLAGS) -c uniterm.c

clear:
	rm -f $(BIN) $(OBJECTS)
