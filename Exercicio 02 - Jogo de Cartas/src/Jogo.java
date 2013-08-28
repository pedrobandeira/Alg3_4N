import javax.swing.JOptionPane;
import java.util.Random;

public class Jogo {

	private Carta[] baralho = new Carta[52];
	Jogador jogador1 = new Jogador();
	Jogador jogador2 = new Jogador();
	Jogador jogador3 = new Jogador();
	Jogador jogador4 = new Jogador();

	public void nomeiaJogador() {
		jogador1.setNome(JOptionPane
				.showInputDialog("Digite o nome do jogador 1: "));
		jogador1.setProx(jogador2);
		jogador2.setNome(JOptionPane
				.showInputDialog("Digite o nome do jogador 2: "));
		jogador2.setProx(jogador3);
		jogador3.setNome(JOptionPane
				.showInputDialog("Digite o nome do jogador 3: "));
		jogador3.setProx(jogador4);
		jogador4.setNome(JOptionPane
				.showInputDialog("Digite o nome do jogador 4: "));
		jogador4.setProx(jogador1);
	}

	public void criaCartas() {

		int cont = 1;

		for (int i = 0; i < 13; i++) {
			baralho[i] = new Carta();
			baralho[i].setValor(cont);
			baralho[i].setNaipe('O');
			cont++;
		}
		cont = 1;
		for (int i = 13; i < 26; i++) {
			baralho[i] = new Carta();
			baralho[i].setValor(cont);
			baralho[i].setNaipe('P');
			cont++;
		}
		cont = 1;
		for (int i = 26; i < 39; i++) {
			baralho[i] = new Carta();
			baralho[i].setValor(cont);
			baralho[i].setNaipe('C');
			cont++;
		}
		cont = 1;
		for (int i = 39; i < 52; i++) {
			baralho[i] = new Carta();
			baralho[i].setValor(cont);
			baralho[i].setNaipe('E');
			cont++;
		}

		JOptionPane.showMessageDialog(null, "Baralho criado.");

	}

	public void embaralhaCartas() {

		for (int i = 0; i < 52; i++) {
			Carta auxiliar = new Carta();
			Random aleatorio = new Random();
			int indiceAleatorio = aleatorio.nextInt(52);
			auxiliar = baralho[i];
			baralho[i] = baralho[indiceAleatorio];
			baralho[indiceAleatorio] = auxiliar;
		}

		JOptionPane.showMessageDialog(null, "Cartas embaralhadas.");
	}

	public void darCartas() {
		Carta[] mao1 = new Carta[5];
		Carta[] mao2 = new Carta[5];
		Carta[] mao3 = new Carta[5];
		Carta[] mao4 = new Carta[5];
		int cont = 0;

		for (int i = 0; i < 5; i++) {
			mao1[i] = baralho[cont];
			baralho[cont] = null;
			cont++;
		}
		jogador1.setMao(mao1);

		for (int i = 0; i < 5; i++) {
			mao2[i] = baralho[cont];
			baralho[cont] = null;
			cont++;
		}
		jogador2.setMao(mao2);

		for (int i = 0; i < 5; i++) {
			mao3[i] = baralho[cont];
			baralho[cont] = null;
			cont++;
		}
		jogador3.setMao(mao3);

		for (int i = 0; i < 5; i++) {
			mao4[i] = baralho[cont];
			baralho[cont] = null;
			cont++;
		}
		jogador4.setMao(mao4);

	}

	public void mostraMao(Jogador jogador) {
		Carta[] mao = new Carta[5];
		String aux = "";

		mao = jogador.getMao();
		for (int i = 0; i < 5; i++) {
			aux = aux + mao[i].getNaipe() + mao[i].getValor() + "\n";
		}
		JOptionPane.showMessageDialog(null,
				"Mão do jogador " + jogador.getNome() + ":\n" + aux);

	}

	public void mostraBaralho() {
		String aux = "";
		for (int i = 0; i < 52; i++) {
			if (!(baralho[i] == null)) {
				aux = aux + baralho[i].getNaipe() + baralho[i].getValor() + " ";
			}
		}
		JOptionPane.showMessageDialog(null, "Baralho: \n" + aux);
	}

	public Jogador getJogador() {
		Jogador jogador = null;
		boolean opcaoValida = true;
		int opcao;
		String aux;

		do {
			opcaoValida = true;
			aux = JOptionPane
					.showInputDialog("Digite o número do jogador para ver suas cartas: ");
			opcao = Integer.parseInt(aux);
			switch (opcao) {
			case 1:
				jogador = jogador1;
				break;
			case 2:
				jogador = jogador2;
				break;
			case 3:
				jogador = jogador3;
				break;
			case 4:
				jogador = jogador4;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				opcaoValida = false;
				break;
			}
		} while (!opcaoValida);
		return jogador;
	}
}
