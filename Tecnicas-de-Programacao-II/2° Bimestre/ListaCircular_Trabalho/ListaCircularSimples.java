/*
 * ATENCAO: Foi evitado qualquer tipo de acentuacao para na ter nenhuma confusao
 * com os diferentes Sistemas Operacionais.
 */

import java.util.Arrays; //importação para manipulão de arranjos

/**
 * Na classe ListaCircularSimples temos uma representacao de uma listaCircular
 * de Alunos e somente os campos e metodos mais basicos são representados nessa
 * classe.
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 05/05/2015
 * @update 05/19/20015
 */
public class ListaCircularSimples {

	private Node inicio; // Node de referencia do primeiro Node da lista

	// Construtor para inicializarmos o Node
	public ListaCircularSimples() {
		this.inicio = null; // Inicializamos o Node inicio como Nulo
	}

	/**
	 * No metodo inserir colocamos dentro da lista de Nodes um novo Node. Nao
	 * podemos colocar um Node ja existente dentro dela.
	 * 
	 * @param _node
	 *            - Node para ser inserido
	 */
	public void inserir(Node _node) {
		Node aux = inicio;
		if (isExistNode(_node)) {
			System.out.println("Esse Node ja foi inserido <Insira outro Node>");
			return;
		}
		if (isEmpty()) {
			_node.setProximo(_node);
			inicio = _node;
		} else {
			while (aux.getProximo() != inicio) {
				aux = aux.getProximo();
			}
			aux.setProximo(_node);
			_node.setProximo(inicio);
		}
	}

	/**
	 * No metodo remover, retiramos um Node da lista.
	 * 
	 * @param _node
	 *            - Node para ser removido
	 */
	public void remover(Node _node) {
		if (!isExistNode(_node)) {
			System.out.println("Esse Node nao existe <Impossivel remover>");
			return;
		}
		if (getAnterior(_node) == _node) {
			_node.setProximo(null);
			inicio = null;
			return;
		}
		if (_node == inicio) {
			Node aux = inicio;
			Node anterior = getAnterior(inicio);
			anterior.setProximo(inicio.getProximo());
			inicio = aux.getProximo();
			return;
		}
		Node anterior;
		anterior = getAnterior(_node);
		anterior.setProximo(_node.getProximo());
	}

	/**
	 * No metodo mostrarTodosPorOrdemDeNota printamos na tela em ordem as notas
	 * dos alunos.
	 */
	public void mostrarTodosPorOrdemDeNota() {
		Node aux = inicio;
		Node nodes[] = new Node[getSize()]; // Arranjo auxiliar
		// preenche o arranjo de nodes, apartir dos nodes atuais.
		int k = 0;
		do {
			nodes[k++] = aux; // Jogamos o Node atual dentro do arranjo de nodes
			aux = aux.getProximo(); // incremento, para c ontinuidade dos Nodes
		} while (aux != inicio);

		// Aplicamos o metodo SelectionSort para ordenacao da notas
		for (int i = 0; i < nodes.length; i++) {
			int minimum = i;

			for (int j = i + 1; j < nodes.length; j++) {
				if (nodes[minimum].getAluno().getNota() > nodes[j].getAluno()
						.getNota()) {
					minimum = j;
				}
			}
			trocar(nodes, i, minimum);
		}

		// mostra elementos ordenado
		int i = 0;
		do {
			System.out.println(nodes[i].getAluno().getNome() + ": "
					+ nodes[i].getAluno().getNota());
			i += 1;
		} while (i < getSize());
	}

	/**
	 * No metodo MostrarTodosPorOrdemAlfabetica printamos na tela em ordem
	 * alfabetica
	 */
	public void MostrarTodosPorOrdemAlfabetica() {
		Node aux = inicio;
		boolean tudocerto = true;
		// verificamos se tem algum nome NuLL
		do {
			if (aux.getAluno().getNome() == null) {
				tudocerto = false;
				break;
			}
			aux = aux.getProximo();
		} while (aux != inicio);

		// se tiver algo errado paramos o programa e mostramos uma msg
		if (tudocerto == false) {
			System.out.println("Existe nomes nulos <Insira nomes do Nodes>");
			return;
		}

		aux = inicio;
		Node nodes[] = new Node[getSize()]; // Arranjo auxiliar

		// preenche o arranjo de nodes, apartir dos nodes atuais.
		int k = 0;
		do {
			nodes[k++] = aux; // Jogamos o Node atual dentro do arranjo de nodes
			aux = aux.getProximo(); // incremento, para continuidade dos Nodes
		} while (aux != inicio);

		// Aplicamos o metodo de bubbleSort para ordenacao de nomes
		boolean trocou;
		do {
			trocou = false;
			for (int i = 1; i < nodes.length; i++) {
				int index = 0; // variaivel de controle da letra atual
				// Veirificamos aqui se a letra da primeira palavra vem primeiro
				// na ordem alfabetica em relacao a segunda
				if (nodes[i - 1].getAluno().getNome().charAt(index) > nodes[i]
						.getAluno().getNome().charAt(index)) {
					trocar(nodes, i - 1, i);
					trocou = true;
				} else {
					// verificamos se as palavras nao sao iguais
					if (!nodes[i - 1].getAluno().getNome()
							.equals(nodes[i].getAluno().getNome())) {
						// caso positivo, fazemos um loop para verifica se a
						// letras sao iguais
						while (nodes[i - 1].getAluno().getNome().charAt(index) == nodes[i]
								.getAluno().getNome().charAt(index)) {
							// Caso positivo, se a letra for igual vamos para a
							// proxima letra
							index++; // incrementamos variavel que controla a
										// letra atual
							// e entao verificamos se esse controlador de letra
							// atual passou o tamanho das palavras
							if (nodes[i - 1].getAluno().getNome().length() == index
									|| nodes[i].getAluno().getNome().length() == index) {
								// caso o controlador da letra atual ultrapasse
								// fazemos que ele volte
								--index; // decrementando controlador da letra
											// atual
								break; // saindo do loop
							}
						}
						// Caso a letra nao seja igual verificamos a ordem
						// alfabetica de cada letra
						// se ela vem primeiro ou nao
						if (nodes[i - 1].getAluno().getNome().charAt(index) > nodes[i]
								.getAluno().getNome().charAt(index)) {
							trocar(nodes, i - 1, i); // trocamos de posicao os
														// nodes
							trocou = true; // setamos a variavel de continuo de
											// loop para true
						}
					}
				}
			}
		} while (trocou);

		// mostra elementos ordenado
		int i = 0;
		do {
			System.out.println(nodes[i].getAluno().getNome() + ":"
					+ nodes[i].getAluno().getNota());
			i += 1;
		} while (i < getSize());
	}

	/**
	 * Metodo trocar, nele dado dois inteiro trocamos de posicao no arrajo de
	 * nodes
	 * 
	 * @param ordenado
	 *            - arranjo de Node para fins de ordenacao
	 * @param int i - Integer para troca de posicao
	 * @param int j - Integer para troca de posicao
	 */
	private static void trocar(Node[] ordenado, int i, int j) {
		// trocamos de posicao
		Node seguro = ordenado[i]; // Guardamos o Node da posicao [i]
		ordenado[i] = ordenado[j]; // Aqui o Node da posicao[i] recebe o Node da
									// posicao [j]
		ordenado[j] = seguro; // Node da posicao [j] recebe o Node
								// guardado(posicao[i])
	}

	/**
	 * No metodo getSize retorna o total de elementos de Nodes contido na lista
	 *
	 * @return size, total de Nodes contido na lista
	 */
	private int getSize() {
		Node aux = inicio;
		int size = 0;
		if (isEmpty() || aux == null) {
			return size;
		}
		while (aux.getProximo() != inicio) {
			aux = aux.getProximo();
			size = size + 1;
		}
		size += 1;
		return size;
	}

	/**
	 * No metodo MostrarTodos mostra-se os Nodes da lista e suas as referencias
	 */
	public void MostrarTodos() {
		if (isEmpty()) {
			System.out.println("A lista esta vazia <SEM NODES> ");
		} else {
			Node aux = inicio;
			do {
				System.out.println(aux.getAluno().getNome() + ":"
						+ aux.getAluno().getNota());
				aux = aux.getProximo();
			} while (aux != inicio);
		}
	}

	/**
	 * No metodo isEmpty verificamos se a lista esta vazia ou nao
	 *
	 * @return boolean, retornamos true caso n tenha nenhum elemento se nao
	 *         retornamos false.
	 */
	private boolean isEmpty() {
		if (inicio == null) {
			return true;
		}
		return false;
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

	/**
	 * No metodo getAnterior, pegamos apartir de um determinado Node O Node que
	 * esta apontando para esse outro Node.
	 *
	 * @param _node
	 *            - Node de refencia para sabermos quem esta apontando para ele.
	 *
	 * @return aux, retornamos um Node
	 */
	private Node getAnterior(Node _node) {
		Node aux = inicio;
		while (aux.getProximo() != _node) {
			aux = aux.getProximo();
		}
		return aux;
	}
}
