public class Carta {

	private char valor;
	private char naipe;

	public char getValor() {
		return valor;
	}

	public void setValor(int valor) {
		switch (valor) {
		case 1:
			this.valor = 'A';
			break;
		case 2:
			this.valor = '2';
			break;
		case 3:
			this.valor = '3';
			break;
		case 4:
			this.valor = '4';
			break;
		case 5:
			this.valor = '5';
			break;
		case 6:
			this.valor = '6';
			break;
		case 7:
			this.valor = '7';
			break;
		case 8:
			this.valor = '8';
			break;
		case 9:
			this.valor = '9';
			break;
		case 10:
			this.valor = 'X';
			break;
		case 11:
			this.valor = 'J';
			break;
		case 12:
			this.valor = 'Q';
			break;
		case 13:
			this.valor = 'K';
			break;
		}
	}

	public char getNaipe() {
		return naipe;
	}

	public void setNaipe(char naipe) {
		this.naipe = naipe;
	}

}
