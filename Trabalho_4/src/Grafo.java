import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

    Scanner scan;
    private ArrayList<Vertice> grafo = new ArrayList<Vertice>();
    private ArrayList<Integer> caminho = new ArrayList<Integer>();
    int verticeExiste = -1;
    int vizinhoExiste = -1;

    public Grafo() throws FileNotFoundException {
        this.scan = new Scanner(new FileReader("Grafo.txt"));
    }

    public void criaGrafo() throws FileNotFoundException, IOException {
        int idVertice;
        int vizinho;

        idVertice = scan.nextInt();

        Vertice ver = new Vertice();
        ver.setId(idVertice);
        vizinho = scan.nextInt();
        this.vizinhoExiste = vizinhoExiste(vizinho);
        if (this.vizinhoExiste == -1) {
            Vertice ver3 = new Vertice();

            ver3.setId(vizinho);

            grafo.add(ver3);
        }
        ver.setVerticeVizinhos(vizinho);
        ver.setPeso(scan.nextInt());

        grafo.add(ver);

        while (scan.hasNext()) {
            idVertice = scan.nextInt();

            this.verticeExiste = verticeExiste(idVertice);
            if (this.verticeExiste != -1) {
                vizinho = scan.nextInt();
                vizinhoExiste = vizinhoExiste(vizinho);
                if (vizinhoExiste == -1) {
                    Vertice ver4 = new Vertice();

                    ver4.setId(vizinho);

                    grafo.add(ver4);
                }
                grafo.get(this.verticeExiste).setVerticeVizinhos(vizinho);
                grafo.get(this.verticeExiste).setPeso(scan.nextInt());
            } else {
                Vertice ver1 = new Vertice();
                ver1.setId(idVertice);
                vizinho = scan.nextInt();
                this.vizinhoExiste = vizinhoExiste(vizinho);
                if (this.vizinhoExiste == -1) {
                    Vertice ver5 = new Vertice();

                    ver5.setId(vizinho);

                    grafo.add(ver5);
                }
                ver1.setVerticeVizinhos(vizinho);
                ver1.setPeso(scan.nextInt());
                grafo.add(ver1);
            }
        }
    }

    public int verticeExiste(int id) {
        this.verticeExiste = -1;
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getId() == id) {
                this.verticeExiste = i;
                break;
            }
        }
        return this.verticeExiste;
    }
    
    public int vizinhoExiste(int id) {
        this.vizinhoExiste = -1;
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getId() == id) {
                this.vizinhoExiste = i;
                break;
            }
        }
        return this.vizinhoExiste;
    }

    public void zeraEtiquetaVerticeInicial(int from) {
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).getId() == from) {
                grafo.get(i).setEtiqueta(0);
                break;
            }
        }
    }

    public void Dijkstra() {
        int existeVerticeNaoVisitado;
        int menorEtiquetaNaoVisitada = Integer.MAX_VALUE;
        do {
            existeVerticeNaoVisitado = 0;

            for (int i = 0; i < grafo.size(); i++) {
                if (grafo.get(i).getEtiqueta() <= menorEtiquetaNaoVisitada && (grafo.get(i).isVisitado() == false)) {
                    menorEtiquetaNaoVisitada = grafo.get(i).getEtiqueta();
                }
            }

            for (int i = 0; i < grafo.size(); i++) {
                if (grafo.get(i).getEtiqueta() == menorEtiquetaNaoVisitada && (grafo.get(i).isVisitado() == false)) {
                    grafo.get(i).setVisitado(true);

                    for (int j = 0; j < grafo.get(i).getVerticeVizinhos().size(); j++) {
                        int id = grafo.get(i).getVerticeVizinhos().get(j);
                        
                        for(int k = 0; k < grafo.size(); k++){
                            if(grafo.get(k).getId() == id){
                                id = k;
                                break;
                            }
                        }
                        
                        int soma = grafo.get(i).getEtiqueta() + grafo.get(i).getPeso().get(j);
                        if(soma < 0){
                            soma = Integer.MAX_VALUE;
                        }
                        
                        if (grafo.get(id).getEtiqueta() > soma) {
                            grafo.get(id).setEtiqueta(grafo.get(i).getEtiqueta() + grafo.get(i).getPeso().get(j));
                            grafo.get(id).setPrecedente(grafo.get(i).getId());
                        }
                    }
                    menorEtiquetaNaoVisitada = Integer.MAX_VALUE;
                    break;
                }
            }

            for (int i = 0; i < grafo.size(); i++) {
                if (!grafo.get(i).isVisitado()) {
                    existeVerticeNaoVisitado++;
                }
            }

        } while (existeVerticeNaoVisitado != 0);
    }

    public String menorCaminho(int vInicial, int vFinal) {
        String menorCaminho = "";
        this.caminho.add(vFinal);

        for (int i = 0; i < this.grafo.size(); i++) {
            if (this.grafo.get(i).getId() == vFinal && vFinal != vInicial) {
                this.caminho.add(this.grafo.get(i).getPrecedente());
                vFinal = this.grafo.get(i).getPrecedente();
                i = 0;
            }
        }

        for (int i = caminho.size() - 1; i >= 0; i--) {
            menorCaminho = menorCaminho + this.caminho.get(i);
            if(i != 0){
                 menorCaminho = menorCaminho + " --> ";
            }
        }

        return menorCaminho;
    }
}