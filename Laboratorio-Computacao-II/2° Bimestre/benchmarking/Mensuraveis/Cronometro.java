package Mensuraveis;

/**
 * Write a description of class Cronometro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cronometro {
    /**
     * Construtor padrão da classe.
     */
    public Cronometro() {
        tempoInicial = 0;
        tempoAtual = 0;
    }
    
    /**
     * Inicia ou reinicia a contagem de tempo. Nunca zera o último estado do contador. Se o tempo já
     * estiver correndo, não faz nada.
     */
    public void iniciar() {
        if(tempoAtual == 0){
            tempoInicial = System.currentTimeMillis();
        }
    }
    
    
    /**
     * Para a contagem de tempo e retorna o tempo decorrido até o momento da parada.
     * 
     * @return Tempo decorrido até o momento da parada.
     */
    public double parar() {
        double tempoAteAqui = System.currentTimeMillis() - tempoInicial;
       return tempoAteAqui;
    }
    
    /**
     * Retorna o tempo decorrido contado até então, independente se está parado ou correndo. Não
     * altera o estado de contagem (parado/correndo).
     * 
     * return Tempo decorrido contado pelo cronômetro.
     */
    public double lerTempoEmMilissegundos() {
        tempoAtual = System.currentTimeMillis() - tempoInicial;
        return tempoAtual;
    }
    
    /**
     * Zera o contador de tempo do cronômetro. Se o cronômetro estava em estado de contagem, ele é
     * parado.
     */
    public void zerar() {
        if(tempoAtual > 0){
            tempoAtual = 0;
            tempoInicial = 0;
        }
    }
    
    // Atributos da classe são declarados aqui
    private double tempoInicial;
    private double tempoAtual;   
}
