
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

#include "forca.h"


enum tentado {
    TENTADO,
    NAO_TENTADO
};

const int MAX_TENTATIVAS = 5;
const int LETRAS_ALFABETO = 26;


struct dados_forca {
    char * oculta;
    unsigned long qtde_letras;
    int acertos;
    int tentativas_restantes;
    enum tentado letras_tentadas[LETRAS_ALFABETO];
};

/* funcao que mostra as letras ja tentadas
*
*@param Struct dados_forca - Informacoes do status atual do jogo 
*
*/
void
informa_dados(struct dados_forca * dados) {
    printf("Voce tem %d tentativas. Letras ja tentadas:", dados->tentativas_restantes);
    for (int i = 0; i < LETRAS_ALFABETO; i++) {
        if (dados->letras_tentadas[i] == TENTADO) {
            printf(" %c ", 'a' + i);
        }
    }
    putchar('\n');
    
    printf("Letras descobertas:");
    for (int i = 0; i < dados->qtde_letras; i++) {
       	   printf(" %c", dados->oculta[i]);

    }
    putchar('\n');
}

/* Inicilize os dados da Struct dados_forca
*
*@param Struct dados_forca, referencia para inicilizar
*@param Char const, palavra secreta do jogo da forca
*
*/
void
inicializar_dados(struct dados_forca * dados, char const * palavra) {
    dados->qtde_letras = strlen(palavra);
    dados->oculta = (char *) calloc(dados->qtde_letras + 1, sizeof(char));
    memset(dados->oculta, '_', dados->qtde_letras);
    dados->oculta[dados->qtde_letras+1] = '\0';
    
    dados->acertos = 0;
    dados->tentativas_restantes = MAX_TENTATIVAS;
    memset(dados->letras_tentadas, NAO_TENTADO, sizeof(dados->letras_tentadas));
}

/* Metodo de tela do usuario e possiveis verificacoes
*	  
*@param Char const, palavra sorteada do arquivo .txt
*
*Verificamos se o usuario tem mais tentativas, e se a letra é valida ou nao.
*/
void
jogar_forca(char const * palavra) {
    struct dados_forca dados;
    inicializar_dados(&dados, palavra);

/*adicionado exercicio 4*/

	int i;
	for(i = 0; i< strlen(palavra);i+=1)
	{
		if(palavra[i] == ' '){
			dados.oculta[i] = ' ';			
			dados.acertos++;
		}
	}
/*exercicio 4 */
	
    while (dados.tentativas_restantes > 0 && dados.acertos < dados.qtde_letras) {
        informa_dados(&dados);
	
        printf("Digite uma letra: ");
        char tentativa = getchar();
        while (getchar() != '\n');
        //verifica se a letra chutada nao existe no alfabeto
        if (!isalpha(tentativa)) {
            printf("Caractere digitado inválido!\n");
            continue;
        }
        tentativa = tolower(tentativa);
        
        // Verificar se tentativa ja foi feita
        int idx_letra = tentativa - 'a';
        if (dados.letras_tentadas[idx_letra] == TENTADO) {
            printf("Letra escolhida já havia sido tentada anteriormente.\n");
            continue;
        }
        dados.letras_tentadas[idx_letra] = TENTADO;
       
        // Verificar se a tentativa existe na palavra
        if (strchr(palavra, tentativa) != NULL) {
            for (int i = 0; palavra[i] != '\0' && dados.oculta[i] != '\0'; i++) {
                if (palavra[i] == tentativa) {
                    dados.oculta[i] = tentativa;
                    dados.acertos++;
                }
	    }
        } else {
            dados.tentativas_restantes--;
        }
    }
    
    // Fim de jogo
    if (dados.tentativas_restantes > 0) {
        printf("Parabens, voce descobriu a palavra \"%s\"!\n", palavra);
    } else {
        printf("Infelizmente você perdeu... A palavra era \"%s\".\n", palavra);
    }
}
