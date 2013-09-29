public class Circulo extends Shape {
	private Ponto centro = new Ponto();
	private Ponto ponto = new Ponto();
	private int raio;

	public Ponto getCentro() {
		return centro;
	}

	public void setCentro(Ponto centro) {
		this.centro = centro;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}
	
public void desenhaCirculo(Cor cor, Imagem imagem) {
		
		int x = 0;
		int y = raio;
		int u = 1;
		int v = 2 * raio - 1;
		int E = 0;
		
		while (x < y) {
			ponto.setX(centro.getX() + x);
			ponto.setY(centro.getY() + y);
			imagem.setPixel(ponto, cor);

			ponto.setX(centro.getX() + y);
			ponto.setY(centro.getY() - x);
			imagem.setPixel(ponto, cor);

			ponto.setX(centro.getX() - x);
			ponto.setY(centro.getY() - y);
			imagem.setPixel(ponto, cor);

			ponto.setX(centro.getX() - y);
			ponto.setY(centro.getY() + x);
			imagem.setPixel(ponto, cor);

		    x++; E += u; u += 2;

		    if (v < 2 * E){
		    	y--; 
		    	E -= v; 
		    	v -= 2;
		    }
		    if (x > y) 
		    	break;

			ponto.setX(centro.getX() + y);
			ponto.setY(centro.getY() + x);
			imagem.setPixel(ponto, cor);

			ponto.setX(centro.getX() + x);
			ponto.setY(centro.getY() - y);
			imagem.setPixel(ponto, cor);
		    
			ponto.setX(centro.getX() - y);
			ponto.setY(centro.getY() - x);
			imagem.setPixel(ponto, cor);

			ponto.setX(centro.getX() - x);
			ponto.setY(centro.getY() + y);
			imagem.setPixel(ponto, cor);
		}
	}


}
