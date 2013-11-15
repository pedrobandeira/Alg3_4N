
public class Retangulo {

	private Ponto p0 = new Ponto();
	private Ponto p1 = new Ponto();

	public void setVertices(int x0, int y0, int x1, int y1){

		this.p0.x = x0;
		this.p0.y = y0;
		this.p1.x = x1;
		this.p1.y = y1;
	}
	
	public void desenhaRetangulo(Cor cor, Imagem img) {
		Ponto ponto  = new Ponto();	
		
		img.SetPixel(p0, cor);
		img.SetPixel(p1, cor);

		for ( int i = 0; i <= (p1.x - p0.x); i++ ){
			ponto.x = p0.x + i;
			ponto.y = p0.y;
			img.SetPixel(ponto, cor);
		}
		
		for ( int i = 0; i <= (p1.y - p0.y); i++ ){
			ponto.x = p0.x;
			ponto.y = p0.y + i;
			img.SetPixel(ponto, cor);
		}

		for ( int i = 0; i <= (p1.x - p0.x); i++ ){
			ponto.x = p0.x + i;
			ponto.y = p1.y;
			img.SetPixel(ponto, cor);
		}
		
		for ( int i = 0; i <= (p1.y - p0.y); i++ ){
			ponto.x = p1.x;
			ponto.y = p0.y + i;
			img.SetPixel(ponto, cor);
		}
	}

}
