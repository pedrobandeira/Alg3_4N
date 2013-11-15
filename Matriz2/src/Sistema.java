import java.io.IOException;
import java.util.Scanner;


public class Sistema {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		Imagem img = new Imagem(0, 0, "");
		Cor cor = new Cor(0);
		String cmd;
		
		do{
			
			System.out.println("Digitar comando:");
			cmd = ler.next();
			
			if(cmd.equalsIgnoreCase("imagem")){
				int p1 = ler.nextInt();
				int p2 = ler.nextInt();
				String p3 = ler.next();
				
				img = new Imagem(p1, p2, p3);
			}
			
			if(cmd.equalsIgnoreCase("cor")){
				if(img.getCor().equalsIgnoreCase("g")){
					
					int cinza = ler.nextInt();
					cor = new Cor(cinza);
					
				} if(img.getCor().equalsIgnoreCase("c")){
					
					int red = ler.nextInt();
					int green = ler.nextInt();
					int blue = ler.nextInt();
					cor = new Cor(red, green, blue);
				}
			}
			
			if(cmd.equalsIgnoreCase("salvar")){
				String nomeArq = ler.next();
				
				try {
					img.Salvar(nomeArq);
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
			
			if(cmd.equalsIgnoreCase("reta")){
				int x0 = ler.nextInt();
				int y0 = ler.nextInt();
				int x1 = ler.nextInt();
				int y1 = ler.nextInt();
				
				Reta reta = new Reta();
				reta.setVertices(x0, y0, x1, y1);
				reta.desenhaReta(cor, img);
			}
			
			if (cmd.equalsIgnoreCase("circulo")){
				int x = ler.nextInt();
				int y = ler.nextInt();
				int raio = ler.nextInt();
				
				Circulo circulo = new Circulo( );
				circulo.setCentro(x, y);
				circulo.setRaio(raio);
				circulo.desenhaCirculo(cor, img);
			}
			
			if (cmd.equalsIgnoreCase("retangulo")){
				int x0 = ler.nextInt();
				int y0 = ler.nextInt();
				int x1 = ler.nextInt();
				int y1 = ler.nextInt();
				
				Retangulo retangulo = new Retangulo();
				retangulo.setVertices(x0, y0, x1, y1);
				retangulo.desenhaRetangulo(cor, img);
			}
			
			if (cmd.equalsIgnoreCase("triangulo")){
				int x0 = ler.nextInt();
				int y0 = ler.nextInt();
				int x1 = ler.nextInt();
				int y1 = ler.nextInt();
				int x2 = ler.nextInt();
				int y2 = ler.nextInt();
				
				Triangulo triangulo = new Triangulo();
				triangulo.setVertices(x0, y0, x1, y1, x2, y2);
				triangulo.desenhaTriangulo(cor, img);
			}
			
		}while(!cmd.equalsIgnoreCase("fim"));

	}

}
