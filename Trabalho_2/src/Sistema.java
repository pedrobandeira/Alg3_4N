import java.io.IOException;
import java.util.Scanner;

public class Sistema {
	public static void main(String[] args) {
		String cmd = "";
		Scanner sc = new Scanner(System.in);
		Ponto p0 = new Ponto();
		Ponto p1 = new Ponto();
		Ponto p2 = new Ponto();
		Imagem imagem = new Imagem(0, 0, "");
		Cor cor = new Cor(0);


		while (!cmd.equals("fim")) {
			cmd = sc.next();
			if (cmd.equals("imagem")) {
				int height = sc.nextInt();
				int width = sc.nextInt();
				String color = sc.next();
				imagem = new Imagem(height, width, color);
				
			}
			if (cmd.equals("cor")) {
				if(imagem.getCor().equals("g")){
					int cinza = sc.nextInt();
					cor = new Cor(cinza);
				} if(imagem.getCor().equals("c")){
					int red = sc.nextInt();
					int green = sc.nextInt();
					int blue = sc.nextInt();
					cor = new Cor(red, green, blue);
				}
			}
			if (cmd.equals("reta")) {
				Reta reta = new Reta();
				p0.setX(sc.nextInt());
				p0.setY(sc.nextInt());
				reta.setP0(p0);
				p1.setX(sc.nextInt());
				p1.setY(sc.nextInt());
				reta.setP1(p1);
				reta.desenhaReta(cor, imagem);
			}
			if (cmd.equals("triangulo")) {
				Triangulo triangulo = new Triangulo();
				p0.setX(sc.nextInt());
				p0.setY(sc.nextInt());
				triangulo.setP0(p0);
				p1.setX(sc.nextInt());
				p1.setY(sc.nextInt());
				triangulo.setP1(p1);
				p2.setX(sc.nextInt());
				p2.setY(sc.nextInt());
				triangulo.setP2(p2);
				triangulo.desenhaTriangulo(cor, imagem);
			}
			if (cmd.equals("circulo")) {
				Circulo circulo = new Circulo();
				p0.setX(sc.nextInt());
				p0.setY(sc.nextInt());
				circulo.setCentro(p0);
				circulo.setRaio(sc.nextInt());
				circulo.desenhaCirculo(cor, imagem);
			}
			
			if (cmd.equals("retangulo")) {
				Retangulo retangulo = new Retangulo();
				p0.setX(sc.nextInt());
				p0.setY(sc.nextInt());
				retangulo.setP0(p0);
				p1.setX(sc.nextInt());
				p1.setY(sc.nextInt());
				retangulo.setP1(p1);
				retangulo.desenhaRetangulo(cor, imagem);
			}
			if(cmd.equals("salvar")){
				String nomeArquivo = sc.next();
				try {
					imagem.Salvar(nomeArquivo);
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
			
			
		/*	System.out.println(cmd);
			System.out.println(p0.getX());
			System.out.println(p0.getY());
			System.out.println(p1.getX());
			System.out.println(p1.getY());
			System.out.println(p2.getX());
			System.out.println(p2.getY());
		 */
		}

	}

}