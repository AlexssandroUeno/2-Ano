package myFirstListIHaveToSendToOracleNow;
/*
 * ATENCAO: Foi evitado qualquer tipo de acentuacao para na ter nenhuma confusao
 * com os diferentes Sistemas Operacionais.
 */
/**
 * Na classe ListaDinamicaSimples temos uma representacao de uma lista e somente
 * os campos e metodos mais basicos sao representados nessa classe.
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 05/05/2015
 */

public class ListaDinamicaSimples {

    private Node inicio; // Node criado para representar o inicio

    /**
     * Constructor for objects of class ListaDinamicaSimples
     */
    public ListaDinamicaSimples() {
        this.inicio = null; // Inicilizamos o Node inicio como Nulo
    }

    /**
     * No metodo inserirInicio recebemos Node e verificamos para depois inserir.
     * Verificamos primeiro se ele Eh vazio, caso nao tenha nenhum Node na
     * lista, entao, colocamos o Node passado por parametro na posicao inicial,
     * caso nao esteja vazio ou seja tem ja algum Node la, entao , o no passado
     * por parametro aponta para o no do inicio. e colocamos a representação do
     * Node inicio no Node passado por parametro.
     * 
     * @param _node
     *            - Node para ser inserido no inicio da lista.
     * 
     */
    public void inserirInicio()
    {
        if (isEmpty()) {
            inicio = _node;
        } else 
        if (!isExistNode(_node)) {
            _node.setProximo(inicio);
            inicio = _node;
        }else{
            System.out.println("Node ja existe <Node ja se econtra na lista, insira um node diferente>");
        }
   }

    /**
     * No metodo inserirFinal recebemos um Node e verificamos para depois
     * inserir. Verificamos primeiro se ele Eh vazio, caso nao tenha nenhum Node
     * na lista, entao, colocamos o Node passado por parametro na posicao
     * inicial, caso nao esteja vazio ou seja tem ja algum Node la, entao ,
     * percorremos a lista ate chegar no ultimo Node da lista, ao se encontrar o
     * final da lista fazemos que o ultimo Node da lista encontrado aponte para
     * o Node passado.
     * 
     * @param _node
     *            - Node para ser inserido depois da ultima posicao.
     */
    public void inserirFinal(Node _node) {
        if (isEmpty()) {
            inicio = _node;
        } else 
        if (!isExistNode(_node)) {
            Node aux = inicio;
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.setProximo(_node);
        }else{
            System.out.println("Node ja existe <Node ja se econtra na lista, insira um node diferente>");
        }
    }
    
    /**
     * No metodo inserir, inserimos um node em um determinada posicao. Antes de
     * comeCar Primeiramente verificamos se o Node Eh vazio, caso sim mostramos
     * uma mensagem que a lista esta vazia caso nao, verificamos se a posicao Eh
     * igual a 1, ou seja Node inicio, e entao substituimos o Node recebido pelo
     * Node Inicio.
     * 
     * @param position
     *            - inteiro que representa a posicao do Node para ser inserido.
     * @param _node
     *            - Node para ser inserido na posicao indicada.
     * 
     */
    public void inserir(int position, Node _node) {
        if (isEmpty()) {
            System.out.println("Nao Eh possivel inserir: <Vazio>");
        } else 
        if (position == 1) {
            Node proximo = inicio.getProximo();
               remover(position); 
            _node.setProximo(proximo);
            inicio = _node;
        } else 
        if (position == getSize()) {
            Node anterior = getAnterior(position);
            anterior.setProximo(_node);
        } else 
        if (position > getSize()) {
            System.out.println("Nao Eh possivel inserir:"
                    + " <Posicao maior do que o tamanho da lista>");
        } else 
        if (!isExistNode(_node)) {
            Node aux = inicio;
            Node anterior;
            Node proximo;
            int i = 1;
            while (i != position) {
                aux = aux.getProximo();
                i += 1;
            }
            proximo  = aux.getProximo();     
            anterior = getAnterior(position);
            anterior.getProximo().setProximo(null);
            _node.setProximo(proximo);
            anterior.setProximo(_node);
        }else{
            System.out.println("Node ja existe <Node ja se econtra na lista, insira um node diferente>");
        }
    }

    /**
     * No metodo getAnterior recebe-se por parametro um indice, e atraves desse
     * numero retornamos o Node anterior daquele indice, caso o indice passado
     * nao exista retornamos Node nulo.
     * 
     * @param index
     *            - posicao do indice.
     * 
     * @return Node/null - retorna o Node anterior do indice dado.
     */
    private Node getAnterior(int index) {
        int i = 0;
        Node aux = inicio;
        if (isEmpty()) {
            return null;
        }
        if (index <= 1) {
            return null;
        }
        while (aux.getProximo() != null && i < (index - 2)) {
            aux = aux.getProximo();
            i += 1;
        }
        return aux;
    }

    /**
     * No metodo isEmpty verificamos se tem algo na lista, isso e feito atraves
     * do Node inicio, que nele e representado em ser o inicio da lista, caso
     * ele esteja com o valor Nulo sabemos que ele esta vazio.
     * 
     * @return true/false - Boolean que retorna o status da lista.
     */
    private boolean isEmpty() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * No metodo remover, removemos um _node que exista dentro da lista.
     * Primeiramente verificamos se a lista esta vazia, caso sim, mostramos uma
     * mensagem que a lista esta vazia, caso nao, verificamos se a posicao do
     * node Eh a primeira ou seja o Node recebido Eh o Node inicio, caso sim,
     * removemos suas/seus referencias/ponteiros, caso nao, verificamos se a
     * posicao do Node passado Eh o ultimo, caso sim, o penultimo sera agora o
     * ultimo, caso nao, verificamos se a posicao do Node Eh maior do que a
     * quantidade de elementos, caso sim, mostramos uma mensagem de posicao
     * ultrapassada, caso nao, basicamente percorremos a lista ate chegar na
     * posicao do Node, quando chegar la so tiramos as referencias daquele Node
     * e passamos para o novo Node.
     * 
     * @param _node
     *            - Node de referencia para ser removido.
     */
    public void remover(Node _node) {
        if (isEmpty()) {
            System.out.println("Nao existe Nodes para remover<Lista vazia>");
        }else 
        if (getNode(_node) == 1) {
            Node proximo = inicio.getProximo();     
            inicio.setProximo(null);                 
            inicio = proximo;
        } else 
        if (getNode(_node) == getSize()) {
            Node penultimo = getAnterior(getNode(_node));
            penultimo.setProximo(null);
        } else 
        if (getNode(_node) > getSize()) {
            System.out
                    .println("Posicao maior que o quantidade de elementos < Posicao MAIOR QntElementos >");
        } else 
        if (isExistNode(_node)) {
            Node aux = inicio;
            Node proximo = null;
            Node anterior = null;
            int i = 1;
            while (i < getNode(_node)) {
                aux = aux.getProximo();
                i += 1;
            }
            proximo = aux.getProximo();
            aux.setProximo(null);
            anterior = getAnterior(i);
            anterior.setProximo(proximo);
        }else{
            System.out
                    .println("Node nao encontrado < O Node nao esta na lista >");
        }
    }

    /**
     * No metodo remover, removemos um _node de acordo com a posicao.
     * Primeiramente verificamos se a lista esta vazia, caso sim, mostramos uma
     * mensagem que a lista esta vazia, caso nao, verificamos se a posicao do
     * node Eh a primeira ou seja o Node recebido Eh o Node inicio, caso sim,
     * removemos suas/seus referencias/ponteiros, caso nao, verificamos se a
     * posicao do Node passado Eh o ultimo, caso sim, o penultimo sera agora o
     * ultimo, caso nao, verificamos se a posicao do Node Eh maior do que a
     * quantidade de elementos, caso sim, mostramos uma mensagem de posicao
     * ultrapassada, caso nao, basicamente percorremos a lista ate chegar na
     * posicao do Node, quando chegar la so tiramos as referencias daquele Node
     * e passamos para o novo Node.
     * 
     * @param position
     *            - Inteiro que referencia o Node para ser removido.
     * 
     */
    public void remover(int position) {
        if (isEmpty()) {
            System.out.println("Nao existe Nodes para remover<Lista vazia>");
        }else
        if (position == 1) {
            Node proximo = inicio.getProximo();
            inicio.setProximo(null);
            inicio = proximo;
        } else
        if (position == getSize()) {
            Node penultimo = getAnterior(position);
            penultimo.setProximo(null);
        } else 
        if (position > getSize()) {
            System.out
                    .println("Posicao maior que o quantidade de elementos< Posicao MAIOR QntElementos >");
        } else {
            Node aux = inicio;
            Node proximo = null;
            Node anterior = null;
            int i = 1;
            while (i < position) {
                aux = aux.getProximo();
                i += 1;
            }
            proximo = aux.getProximo();
            aux.setProximo(null);
            anterior = getAnterior(i);
            anterior.setProximo(proximo);
        }
    }

    /**
     * No metodo getNode retorna o Node atraves da posicao recebida por
     * parametro.
     * 
     * @param position
     *            - Inteiro que referencia o indice.
     * 
     * @return Node - retornamos o Node atraves da indice passado por parametro.
     */
    public Node getNode(int position) {
        Node aux;
        int i = 1;
        if (isEmpty() || position < i) {
            return null;
        }else
        if (position > getSize()) {
            return null;
        }
        aux = inicio;
        if (aux.getProximo() == null) {
            return aux;
        }
        while (i < position) {
            aux = aux.getProximo();
            i += 1;
        }
        return aux;
    }

    /**
     * No metodo getNode retorna o indice atraves do Node recebido por
     * parametro.
     * 
     * @param _node
     *            - Node de referencia para encontrar o indice dele.
     * 
     * @return Indice - retornamos o Indice atraves da Node passado por
     *         parametro.
     */
    public int getNode(Node _node) {
        Node aux = inicio;
        int i = 1;
        if (isEmpty()) {
            return -1;
        }
        if (_node == inicio) {
            return 1;
        }
        while (i < getSize()) {
            aux = aux.getProximo();
            i += 1;
            if (aux == _node) {
                return i;
            }
        }
        return -1;
    }

    /* No metodo listAllNode mostra-se os Nodes da lista e suas referencias */
    public void listAllNodes() {
        Node aux = inicio;
        if (isEmpty()) {
            System.out.println("Lista vazia <Nao tem Nodes>");
        } else 
        if (aux.getProximo() == null) {
            System.out.println(aux.getX());
        } else {
            System.out.print(aux.getX());
            while (aux.getProximo() != null) {
                System.out.print(" ➡ " + aux.getProximo().getX());
                aux = aux.getProximo();
            }
            System.out.println();
        }
    }

    /**
     * No metodo getSize pegamos o total de elementos da lista e caso nao tenha
     * nenhum elemento retornamos 0.
     * 
     * @return size - Inteiro do total de Nodes da lista.
     */
    public int getSize() {
        Node aux = inicio;
        int size = 0;
        if (isEmpty() || aux == null) {
            return 0;
        }
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
            size = size + 1;
        }
        size += 1;
        return size;
    }

    /**
     * No metodo isExistNode percorremos se o Node passado por parametro esta na
     * lista ou nao. caso sim, retornamos true, caso nao, retornamos false.
     * 
     * @param _node
     *            - Node para averiguar sua existencia na lista.
     * 
     * @return true/false - Boolean retorna o status do Node.
     */
    private boolean isExistNode(Node _node) {
        Node aux = inicio;
        int i = 0;
        if (isEmpty()) {
            return false;
        }
        for (i = 0; i < getSize(); i++) {
            if (_node == aux) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }
}
