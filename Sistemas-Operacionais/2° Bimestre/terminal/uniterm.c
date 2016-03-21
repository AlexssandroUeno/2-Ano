#define TRUE 1
#include "uniterm.h"

#include <syscall.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <dirent.h>
#include <stdlib.h>
#include <time.h>
#include <sys/stat.h>
#include <errno.h>

#include <string.h>
#include <stdio.h>
#include <stdbool.h>

const int TAMANHO_COMANDO = 21;
const int TAMANHO_PARAMETROS = 201;
struct dirent **namelist;

void uniterm_laco_principal() {

	while (true) {
		char comando[TAMANHO_COMANDO], parametros[TAMANHO_PARAMETROS];

		digitar_prompt();
		ler_comando(comando, parametros);
		executar_comando(comando, parametros);
	}
}

void digitar_prompt() {
	long id;
	char*directory = NULL;
	char*user = getlogin();
	long size;
	char*buf;
	id = getuid();
	size = pathconf(".", _PC_PATH_MAX);

	if((buf = (char *) malloc((size_t)size))!= NULL) {
		directory = getcwd(buf,(size_t)size);
	}
	printf("%ld:%s@%s>", id, user, directory);
	free(buf);
}

void ler_comando(char * comando, char * parametros) {
	char buffer[222];
	fgets(buffer, 222, stdin);
	strtok(buffer, "\n");
	char *espaco;
	espaco = strchr(buffer, ' ');

	if(espaco){
		*espaco = '\0';
		strcpy(parametros, espaco+1);
	} else {
		parametros[0] = '\0';
	}

	strcpy(comando, buffer);
}

void executar_comando(char * comando, char * parametros) {
	int cod_erro = 0;

	if(strcmp(comando, "terminar") == 0) {
		exit(!0);
	}
	else if(strcmp(comando, "datahora") == 0) {
		cod_erro = comando_datahora();
	}
	else if(strcmp(comando, "arquivos") == 0) {
		cod_erro = comando_arquivos();
	}
	else if(strcmp(comando, "novodir") == 0) {
		cod_erro = comando_novodir(parametros);
		if(cod_erro) printf("O nome é inválido.\n");
	}
	else if(strcmp(comando, "apagadir") == 0) {
		cod_erro = comando_apagadir(parametros);
		if(cod_erro) printf("O diretório não existe.\n");
	}
	else if(strcmp(comando, "mudadir") == 0) {
		cod_erro = comando_mudadir(parametros);
		if(cod_erro) printf("O diretório não existe.\n");
	}
	else {
		cod_erro = lancar_programa(comando, parametros);
		if(cod_erro >= 1) printf("Erro: o programa indicou termino com falha.\n");
	}
}

int comando_datahora() {
	time_t result;

	result = time(NULL);
	printf("%s", asctime(localtime(&result)));
	return 0;
}

int comando_arquivos() {
	int i,n;
	n = scandir(".", &namelist, 0, alphasort);
	if (n < 0)
		perror("scandir");
	else {
		for (i = 0; i < n; i++) {
			printf("%s\n", namelist[i]->d_name);
			free(namelist[i]);
			}
		}
	free(namelist);
	return 0;
}

int comando_novodir(char * nome_dir) {
	return mkdir(nome_dir, S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH);
}

int comando_apagadir(char * nome_dir) {
	return rmdir(nome_dir);
}

int comando_mudadir(char * nome_dir) {
	return chdir(nome_dir);
}
int lancar_programa(char * nome_prog, char * parametros) {
	int n = 0, i;
	int bool_tem_mesmo_nome = 1;

	n = scandir(".", &namelist, 0, alphasort);
	if (n < 0)
		perror("scandir");
	else {
		for (i = 0; i < n; i++) {
				if( strcmp(namelist[i]->d_name, nome_prog) == 0)  {
					bool_tem_mesmo_nome = 0;
				}
			free(namelist[i]);
		}
	}
	free(namelist);

// Verifica se algum deles tem o mesmo nome do comando, se não:
	if(bool_tem_mesmo_nome != 0){
		printf("Comando ou programa não existe\n");
		return 0;
	} else {
// Se sim, verifica permissão de execucão
		int CheckIfFileExec = access (nome_prog, X_OK);
//(se nao tiver, printa "Sem permissao para executar")
		if ( CheckIfFileExec != 0 ) {
			printf("Sem permissao para executar\n");
			return 0;
		}else{
// Caso tenha, cria um novo processo (fork() ou clone())
			int child_pid = fork();
			int status;
			if(child_pid > 0 ){
// processo pai espera o termino do filho (waitpid())
				waitpid(child_pid,&status,0);
				return status;
			} else if(child_pid == 0) {
// o novo processo atualiza o programa em execucao com execv()
				return execv(nome_prog, &parametros);
			}
// se o filho retorna 0, terminal volta pro promt, se nao avisa erro
		}
	}
<<<<<<< HEAD
	return 0;
=======
	return 0; 
>>>>>>> origin/master
}
