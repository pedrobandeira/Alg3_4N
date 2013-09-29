
public class Reta {
	private Ponto p0 = new Ponto();
	private Ponto p1 = new Ponto();
	private Ponto ponto = new Ponto();

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
	
	public void desenhaReta(Cor cor, Imagem imagem) {
		imagem.setPixel(p0, cor);
		imagem.setPixel(p1, cor);

		int x, y, erro, deltaX, deltaY;
		erro = 0;
		x = p0.getX();
		y = p0.getY();
		deltaX = p1.getX() - p0.getX();
		deltaY = p1.getY() - p0.getY();
 
		if ((Math.abs(deltaY)>=Math.abs(deltaX) && p0.getY() > p1.getY()) || (Math.abs(deltaY)<Math.abs(deltaX) && deltaY<0)) {
			x = p1.getX();
			y = p1.getY();
			deltaX = p0.getX() - p1.getX();
			deltaY = p0.getY() - p1.getY();
		}
		if (deltaX >= 0) {
			if (Math.abs(deltaX) >= Math.abs(deltaY)){
				
				for (int i = 1; i < Math.abs(deltaX); i++){
					if (erro < 0){
						x++;
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);						
						erro += deltaY;
					} else {
						x++;
						y++;
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);
						erro += deltaY - deltaX;
					}
				}
			} else {
				
				for (int i = 1; i < Math.abs(deltaY); i++){
					if (erro < 0){
						x++;
						y++;
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);
						erro += deltaY - deltaX;						
					}else{
						y++;
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);
						erro -= deltaX;
					}
				}
			}
		} else { 
			if (Math.abs(deltaX) >= Math.abs(deltaY)){
				
				for(int i = 1; i < Math.abs(deltaX); i++){
					if(erro<0){
						x--;
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);
						erro += deltaY;
					}else{
						x--;
						y++;
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);
						erro += deltaY + deltaX;
					}
				}
			} else {
				
				for(int i=1; i < Math.abs(deltaY); i++){
					if (erro < 0){
						x--;
						y++;
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);
						erro += deltaY + deltaX;						
					} else {
						y++;						
						ponto.setX(x);
						ponto.setY(y);
						imagem.setPixel(ponto, cor);
						erro += deltaX;
					}
				}
			}
		}
	}

	

}
