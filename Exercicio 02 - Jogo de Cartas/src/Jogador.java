public class Jogador {
	private Carta[] mao;
	private String nome;
	private Jogador prox;

	public Carta[] getMao() {
		return mao;
	}

	public Jogador getProx() {
		return prox;
	}

	public void setProx(Jogador prox) {
		this.prox = prox;
	}

	public void setMao(Carta[] mao) {
		this.mao = mao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
