import java.io.*;
import java.util.Scanner;

public class Principal {

    private static Arvore tree;
    private final static String ARQUIVO = "C:\\arquivo.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        tree = new Arvore();
        
        leArquivo();
        
        int opcao; 
        String chave;
        String valor;
        Scanner sc = new Scanner(System.in);
        
        while(true){

            System.out.println("(1) Adicionar um nó");        
            System.out.println("(2) Remover um nó");        
            System.out.println("(3) Consultar um nó");               
            System.out.println("(0) Sair");                
            System.out.println("Digite uma opção:"); 
            
            opcao = sc.nextInt();
            
            switch(opcao){
            case 0: 
            	System.out.println("Programa encerrado");
            	System.exit(0);
            	
            case 1:
                System.out.println("Digite uma chave:");
                chave = sc.next();
                
                System.out.println("Digite um valor:");
                valor = sc.next();
                
                adicionarNO(chave, valor);
                break;
                
            case 2:
                System.out.println("Informe a chave para remover:");
                chave = sc.next();
                removeNo(chave);
                break;
                
            case 3:
                System.out.println("Informe a chave para consultar:");
                chave = sc.next();
                consultar(chave);
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        }
        
    }
    
    public static void adicionarNO(String chave, String valor) {
        tree.inserir(chave, valor);
        System.out.println("Inserido com sucesso");
    }
    
    public static void removeNo(String chave){
        tree.removeNo(tree.raiz, chave);
        System.out.println("removido com sucesso");
    }
    
    public static void consultar(String chave){
        tree.busca(tree.raiz, chave);
    }
    
    public static void leArquivo() throws FileNotFoundException, IOException {
        
        FileInputStream fstream = new FileInputStream(ARQUIVO);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String linha;

        while ((linha = br.readLine()) != null) {
            String valor[];
            valor = linha.split("=");
            tree.inserir(valor[0], valor[1]);
        }
        
        br.close();
    }
            
}