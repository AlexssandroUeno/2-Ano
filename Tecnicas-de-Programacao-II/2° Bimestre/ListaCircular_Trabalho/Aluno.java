/**
 * Aluno.java
 * 
 * @author Thelokys 
 * @version 05/20/2015
 */
public class Aluno {
	private String nome;
	private int nota;
	private float media;

	public Aluno(String nome, int nota, float media) {
		this.nome = nome;
		this.nota = nota;
		this.media = media;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia() {
		this.media = media;
	}
}
