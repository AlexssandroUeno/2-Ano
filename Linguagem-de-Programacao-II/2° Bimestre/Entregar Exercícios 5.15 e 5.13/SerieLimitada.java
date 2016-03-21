/*
 * ATENCAO: Foi evitado qualquer tipo de acentuacao para na ter nenhuma confusao
 * com os diferentes Sistemas Operacionais.
 */

/**
 * @author Thelokys
 * @version 05/18/2015
 */
public class SerieLimitada {

    static final int maximoDeInstancia = 3;     // Maximo numero de instancia
    static int contador = 0;                    // Contador de instancias

    private static SerieLimitada instance;

    //Construtor privado
    private SerieLimitada() {
        //Inicializacao da classe
        SerieLimitada.incrementaContador();
    }

    /**
     *  Metodo SerieLimitada Eh o responsavel para controle de instancias
     */
    public static SerieLimitada getInstance () {
        if(contador < maximoDeInstancia){
           instance = new SerieLimitada(); 
           return instance;
        }
        return null;
    }

    private static void incrementaContador(){
        contador += 1;
    }
}