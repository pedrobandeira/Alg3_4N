import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Imagem {
	private int width;
	private int height;
	private String cor;
	private int[][] imagem;
	
	public int[][] getImagem() {
		return imagem;
	}

	public void setImagem(int[][] imagem) {
		this.imagem = imagem;
	}

	public Imagem(int height, int width, String color) {
		this.imagem = new int[height][width];
		this.cor = color;
		this.height = height;
		this.width = width;
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		if (cor.equalsIgnoreCase("c"))
		this.cor = "c";
		else this.cor = "g";
	}

	public void setPixel(Ponto p, Cor c) { //throws Exception {
		//if(p.getX() < 0 || p.getX() >= width) //throw new Exception("X out of range"); 
		//if(p.getY() < 0 || p.getY() >= height) //throw new Exception("y out of range"); 
		this.imagem[p.getX()][p.getY()] = c.getGrey(); 
	}
	
	public void addShape(Shape s, Cor c) {
		s.draw(this, c);
		
	}
	public void Salvar(String nomeArquivo) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(nomeArquivo + ".pnm"));

		if (this.cor.equals("g")){
			out.write(String.format("P2\n%d %d\n255\n", imagem[0].length, imagem[0].length));
		} else {
			out.write(String.format("P3\n%d %d\n255\n", imagem[0].length, imagem[0].length));
		}
	
		for (int[] linha : imagem) {
			for (int l : linha){
				out.write(String.format("%d ", l));
			}
		}	
		out.close();
	}

}
