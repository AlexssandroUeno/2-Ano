import java.util.ListIterator;

/**
 * Write a description of class AlgoritmosAnimados here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class AlgoritmosAnimados {
	public static Gravador buscaSequencial(int[] arranjo, int chave) {
		Gravador anim = new Gravador();
		anim.gravarArranjo(arranjo, "Inicio de busca sequencial");
		int i = 0;
		anim.gravarIndiceDestacado(arranjo, i, "Busca sequencial");
		while (i < arranjo.length && arranjo[i] != chave) {
			i++;
			anim.gravarIndiceDestacado(arranjo, i, "Busca sequencial");
		}
		if (i < arranjo.length) {
			anim.gravarIndiceDestacado(arranjo, i, "Chave encontrada");
		} else {
			anim.gravarArranjo(arranjo, "Chave não encontrada");
		}
		return anim;
	}

	public static Gravador buscaBinária(int[] arranjo, int chave) {
		int num = chave;
		Gravador anim = new Gravador();
		anim.gravarArranjo(arranjo, "Disposição inicial");// Diposição Inicial
															// do arranjo
		int lim_i = 0, lim_s = arranjo.length;
		do {
			int meio = ((lim_s) + lim_i) / 2;
			anim.gravarComparacao(arranjo, lim_i, lim_s - 1, meio - 1);// Marcando
																		// o
																		// inicio
																		// do
																		// arranjo
																		// e o
																		// fim
																		// dele
			if (arranjo[meio] == num) {
				anim.gravarIndiceDestacado(arranjo, meio, "chave encontrada");// Marcando
																				// o
																				// inicio
																				// do
																				// arranjo
																				// e
																				// o
																				// fim
																				// dele
				return anim;
			} else if (arranjo[meio] < num) {
				lim_i = meio + 1;
			} else if (arranjo[meio] > num) {
				lim_s = meio;
			}
		} while ((lim_s - lim_i) > 0);
		anim.gravarArranjo(arranjo, "Disposição final");// disposição final do
														// arranjo
		return anim;
	}

	public static Gravador bolha(int[] arranjo) {
		Gravador anim = new Gravador();
		anim.gravarArranjo(arranjo, "Disposição inicial");// Diposição Inicial
															// do arranjo
		boolean trocou;
		do {
			trocou = false;
			for (int i = 1; i < arranjo.length; i++) {
				anim.gravarComparaçãoSimples(arranjo, i - 1, i); // dois
																	// elementos
																	// sendo
																	// comparado
				if (arranjo[i - 1] > arranjo[i]) {
					trocar(arranjo, i - 1, i);
					anim.gravarPosTrocas(arranjo, i - 1, i);// marcando arranjo
															// pós troca
					trocou = true;
				}
			}
		} while (trocou);
		anim.gravarArranjo(arranjo, "Disposição final");// disposição final do
														// arranjo
		return anim;
	}

	public static Gravador insercao(int[] arranjo) {
		Gravador anim = new Gravador();
		anim.gravarArranjo(arranjo, "Disposição inicial");// Diposição Inicial
															// do arranjo
		for (int i = 1; i < arranjo.length; i++) {
			int anterior = i - 1;
			int atual = i;
			while (anterior >= 0 && arranjo[anterior] > arranjo[atual]) {
				anim.gravarComparaçãoSimples(arranjo, anterior, atual); // dois
																		// elementos
																		// sendo
																		// comparado
				trocar(arranjo, anterior, atual);
				anterior--;
				atual--;
			}
			anim.gravarPosTrocas(arranjo, i - 1, i);// marcando arranjo pós
													// troca
		}
		anim.gravarArranjo(arranjo, "Disposição final");// disposição final do
														// arranjo
		return anim;
	}

	public static Gravador ordenarPorSelecao(int[] arranjo) {
		Gravador anim = new Gravador();
		anim.gravarArranjo(arranjo, "Disposição inicial");// Diposição Inicial
															// do arranjo
		for (int i = 0; i < arranjo.length; i++) {
			int minimum = i;
			int j = i + 1;
			while (j < arranjo.length) {
				anim.gravarComparacao(arranjo, i, j, minimum); // tres elementos
																// sendo
																// comparado,
																// sendo um fixo
																// e um menor
				if (arranjo[minimum] > arranjo[j]) {
					minimum = j;
					anim.gravarComparacao(arranjo, i, j, minimum); // tres
																	// elementos
																	// sendo
																	// comparado,
																	// sendo um
																	// fixo e um
																	// menor
				}
				j++;

			}
			trocar(arranjo, i, minimum);
			anim.gravarPosTrocas(arranjo, i, minimum);// marcando arranjo pós
														// troca
		}
		anim.gravarArranjo(arranjo, "Disposição final");// disposição final do
														// arranjo
		return anim;
	}

	public static Gravador merge(int[] arranjo) {
		Gravador anim = new Gravador();
		anim.gravarArranjo(arranjo, "Disposição inicial");// Diposição Inicial
															// do arranjo

		sort(arranjo, 0, arranjo.length - 1, anim);

		anim.gravarArranjo(arranjo, "Disposição final");// disposição final do
														// arranjo
		return anim;
	}

	public static void sort(int[] arranjo, int inicio, int fim, Gravador anim) {

		if (fim <= inicio) {
			return;
		}
		int meio = (inicio + fim) / 2;
		anim.gravarIndiceDestacado(arranjo, meio, "meio"); //marcando o meio dos arranjos
		sort(arranjo, inicio, meio, anim);
		sort(arranjo, meio + 1, fim, anim);
		//copias de arranjos
		int[] A = new int[meio - inicio + 1]; //arrajo metade
		int[] B = new int[fim - meio];        //outra metade
		//Preenchemos
		for (int i = 0; i <= meio - inicio; i++) {
			A[i] = arranjo[inicio + i];      
		}
		for (int i = 0; i <= fim - meio - 1; i++) {
			B[i] = arranjo[meio + 1 + i];
		}
		int i = 0;
		int j = 0;
		for (int k = inicio; k <= fim; k++) {
			if (i < A.length && j < B.length) {
				if (A[i] < B[j]) {
					arranjo[k] = A[i++];
				} else {
					arranjo[k] = B[j++];
				}
			} else if (i < A.length) {
				arranjo[k] = A[i++];
			} else if (j < B.length) {
				arranjo[k] = B[j++];
			}
			anim.gravarComparacao(arranjo,i, j,k);
		}
	}

	public static Gravador quicksort(int[] arranjo) {
		Gravador anim = new Gravador();
		anim.gravarArranjo(arranjo, "Disposição inicial");// Diposição Inicial
															// do arranjo

		ordenar(arranjo, 0, arranjo.length - 1, anim);

		anim.gravarArranjo(arranjo, "Disposição final");// disposição final do
														// arranjo
		return anim;
	}

	private static void ordenar(int[] arranjo, int i, int j, Gravador anim) {
		anim.gravarIndex(arranjo, i, j); // marcando pivo i e j
		if (i < j) {
			int pivo = separar(arranjo, i, j, anim); // quebrando
			ordenar(arranjo, i, pivo - 1, anim); // mudando o pivo para esquerda
			ordenar(arranjo, pivo + 1, j, anim); // mudando o pivo para direita
		}
	}

	private static int separar(int[] arranjo, int i, int j, Gravador anim) {
		int pivo = arranjo[i]; // referencia do pivo
		int s = 0; // start
		s += 1;
		int e = j; // end

		while (s <= e) {
			if (arranjo[s] <= pivo) {
				s++;
			} else if (pivo < arranjo[e]) {
				e--;
			} else {
				trocar(arranjo, s, e);
				s += 1;
				e -= 1;
			}
			anim.gravarPosTrocas(arranjo, s, e); // marcando como estao o inicio
													// e o fim do pivot
		}
		arranjo[i] = arranjo[e];
		arranjo[e] = pivo;
		anim.gravarIndex(arranjo, i, e);
		return e;
	}

	private static void trocar(int[] ordenado, int i, int j) {
		int seguro = ordenado[i];
		ordenado[i] = ordenado[j];
		ordenado[j] = seguro;
	}
}