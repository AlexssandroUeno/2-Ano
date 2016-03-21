
/**
 * ListaOrdenada.java
 *
 * @author Jose Ricardo Guidetti Junior
 * @version 08/14/2015 11:47
 *
 * A classe ListaOrdenada, que possui operacoes similares as de Lista. A todo e
 * qualquer momento que ListaOrdenada possuir elementos, eles estarao ordenados.
 * Por causa disso, a operacao inserir nao pode escolher o indice do elemento a
 * ser armazenado, pois o proprio TAD eH quem define isso.
 */
public class ListaOrdenada { // declaração da classe 

    /**
     * O construtor para a classe ListaOrdenada, que recebe um argumento que
     * sera o numero de posicoes (ou valores do tipo Comparable) que a instancia
     * da classe sera capaz de armazenar.
     *
     * @param capacidade o numero de posicoes para valores do tipo Comparable a
     * serem alocadas
     */
    public ListaOrdenada(int capacidade) {
        arranjo = new Comparable[capacidade];
        numElementos = -1;
    }

    /**
     * Temos aqui um construtor padrao da classe ListaOrdenada que ao ser
     * chamada ele passa para o outro constutor dessa mesma classe, porem ja com
     * um numero de posicoes definido sendo esse numero igual a 5.
     */
    public ListaOrdenada() {
        this(5); // Chama o construtor
    }

    /**
     * No metodo inserir, colocamos um elemento dentro de uma lista, sendo esse
     * elemento a principio sendo coloca na posicao inicial como 0, porém toda
     * vez que inserimos chamamos o metodo para ordenacao da lista, fazendo com
     * que assim coloque em sua respectiva posicao correta e retornando sua
     * posicao de entrada ja ordenada.
     *
     * @param obj, Elemento para ser inserido na lista.
     * @return Integer, retorna indice do elemento inserido, caso de algum erro
     * retornamos -1.
     */
    public int inserir(Comparable obj) {
        int pos = 0;
        numElementos++;
        if (numElementos == arranjo.length) {
            System.out.println("Não tem como inserir mais elementos");
            return pos--;
        }
        // Deslocar elementos
        for (int i = numElementos; i > pos; i--) {
            arranjo[i] = arranjo[i - 1];
        }
        arranjo[pos] = obj;
        if (numElementos > 0) {
            ordenar();
        }
        pos = buscar(obj);
        return pos;
    }

    /**
     * No metodo remover, passamos como parametro um inteiro de referencia do
     * elemento a ser removido.
     *
     * @param pos, indice do elemento que foi removido no arranjo.
     * @return Comparable, elemento que foi removido.
     */
    public Comparable remover(int pos) {
        Comparable removido = elementoEm(pos);// Pegamos o elemento daquele possicao para ser removido
        arranjo[pos] = null; // Removemos o elemento daquele posicao
        Comparable[] auxiliar = arranjo; // Cria-se o um arranjo auxiliar
        // Move os elementos null para o final do arranjo.
        for (int i = 0; i < auxiliar.length - 1; i++) {
            if (arranjo[i] == null) {
                trocar(auxiliar, i, i + 1);
            }
        }
        arranjo = auxiliar; // Atualiza os valores do arranjo
        ordenar(); // Ordena o arranjo novamente.
        numElementos--; //  Pelo fato de ser removido devemos decrementar numero de elementos.
        return removido;
    }

    /**
     * No metodo buscar, passamos por parametro um elemento do tipo Comparable
     * para ser procurado no arranjo, e caso ache retorne o indice dele, e caso
     * nao ache retorn -1.
     *
     * @param obj, referencia do elemento para ser procurado no arranjo.
     * @return int, Indice do elemento encontrado.
     */
    public int buscar(Comparable obj) {
        int pos = -1;
        for (int i = 0; i < arranjo.length; i++) {
            if ((arranjo[i] != null) && (arranjo[i].compareTo(obj) == 0)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    /**
     * No metodo elementoEm, passamos por parametro a posicao de um elemento e
     * retornamos aquele elemento, caso nao tenha nenhum elemento entao retorna
     * null.
     *
     * @param pos, referencia de posicao do elemento.
     * @return Comparable, retornamos o elemento de acordo com aquele posicao.
     */
    public Comparable elementoEm(int pos) {
        return arranjo[pos];
    }

    /**
     * No metodo limpar, resetamos os valores deixando os campos do arranjo como
     * null e voltamos o contador de elementos para -1.
     */
    public void limpar() {
        for (int i = 0; i < arranjo.length; i++) {
            arranjo[i] = null;
        }
        numElementos = -1;
    }

    /**
     * No metodo ordenar, usa-se o o algoritmo bubble sort para fazer a
     * ordenacao do arranjo do tipo Comparable(utilizando para troca o metodo
     * trocar), esse metodo so executa quando temos mais que dois elementos,
     * assim podendo ser comparados.
     *
     * @see trocar(Comparable[] ordenado, int i, int j), metodo que ajuda na
     * troca de indices
     */
    private void ordenar() {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < arranjo.length; i++) {
                if ((arranjo[i] != null) && (arranjo[i - 1].compareTo(arranjo[i]) > 0)) {
                    trocar(arranjo, i - 1, i);
                    trocou = true;
                }
            }
        } while (trocou);

    }

    /**
     * No metodo trocar, recebe por parametro um arranjo, e dois inteiros, em
     * que nele basicamente trocamos os indices de um terminando elemento do
     * arranjo apartir de dois inteiro(i e j).
     *
     * @param Arranjo, referencia do arranjo a ser trabalhado na troca dos
     * indices dos elementos
     * @param Int i, indice do elemento para ser trocado com o indice j.
     * @param Int j, indice do elemento para ser trocado com o indice i.
     */
    private static void trocar(Comparable[] ordenado, int i, int j) {
        Comparable seguro = ordenado[i];
        ordenado[i] = ordenado[j];
        ordenado[j] = seguro;
    }

    /**
     * Declaração dos campos privados da classe ListaOrdenada
     */
    private Comparable[] arranjo;
    private int numElementos; // Contador de elementos nao nulos que estao dentro do arranjo.
}
