
public class Triangulo extends Shape {
	private Ponto p0 = new Ponto();
	private Ponto p1 = new Ponto();
	private Ponto p2 = new Ponto();

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

	public Ponto getP2() {
		return p2;
	}

	public void setP2(Ponto p2) {
		this.p2 = p2;
	}
	
	public void draw(Imagem imagem, Cor cor) {
		Reta reta1 = new Reta();
		Reta reta2 = new Reta();
		Reta reta3 = new Reta();
		Triangulo triangulo = new Triangulo();
		
		reta1.setP0(triangulo.getP0());
		reta1.setP1(triangulo.getP1());
		reta1.draw(imagem, cor);
		
		reta2.setP0(triangulo.getP0());
		reta2.setP1(triangulo.getP2());
		reta2.draw(imagem, cor);
		
		reta3.setP0(triangulo.getP1());
		reta3.setP1(triangulo.getP2());
		reta3.draw(imagem, cor);	
	}
	
}
