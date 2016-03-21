
/**
 * Write a description of class Node here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node {
	// instance variables - replace the example below with your own
	private Aluno aluno;
	private Node proximo;
	/**
	 * Constructor for objects of class Node
	 */
	public Node() {

	}

	public Node(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setProximo(Node _proximo) {
		this.proximo = _proximo;
	}

	public Node getProximo() {
		return this.proximo;
	}
}
