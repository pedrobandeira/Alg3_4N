public class Principal {

	public static void main(String[] args) {
		Jogo jogo = new Jogo();

		jogo.nomeiaJogador();
		jogo.criaCartas();
		jogo.mostraBaralho();
		jogo.embaralhaCartas();
		jogo.mostraBaralho();
		jogo.darCartas();
		jogo.mostraMao(jogo.getJogador());
		jogo.mostraBaralho();

	}

}