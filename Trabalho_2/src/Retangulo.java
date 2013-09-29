public class Retangulo extends Shape {
	private Ponto p0 = new Ponto();
	private Ponto p1 = new Ponto();

	public Ponto getP0() {
		return p0;
	}

	public void setP0(Ponto p0) {
		this.p0 = p0;
	}

	public Ponto getP1() {
		return p1;
	}

	public void setP1(Ponto p1) {
		this.p1 = p1;
	}
	public void desenhaRetangulo(Cor cor, Imagem imagem) {
		Ponto ponto  = new Ponto();	
		
		imagem.setPixel(p0, cor);
		imagem.setPixel(p1, cor);

		for (int i = 0; i <= (p1.getX() - p0.getX()); i++ ){
			ponto.setX(p0.getX() + i);
			ponto.setY(p0.getY());
			imagem.setPixel(ponto, cor);
		}
		
		for ( int i = 0; i <= (p1.getY() - p0.getY()); i++ ){
			ponto.setX(p0.getX());
			ponto.setY(p0.getY() + i);
			imagem.setPixel(ponto, cor);
		}

		for ( int i = 0; i <= (p1.getX() - p0.getX()); i++ ){
			ponto.setX(p0.getX() + i);
			ponto.setY(p1.getY());
			imagem.setPixel(ponto, cor);
		}
		
		for ( int i = 0; i <= (p1.getY() - p0.getY()); i++ ){
			ponto.setX(p1.getX());
			ponto.setY(p0.getY() + i);
			imagem.setPixel(ponto, cor);
		}
	}


}
