public class Nodo {
    
    private String chave;
    private String valor;
    private Nodo esq, dir, pai;
    private char cor; // p ou v
    
    public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Nodo getEsq() {
		return esq;
	}

	public void setEsq(Nodo esq) {
		this.esq = esq;
	}

	public Nodo getDir() {
		return dir;
	}

	public void setDir(Nodo dir) {
		this.dir = dir;
	}

	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo pai) {
		this.pai = pai;
	}

	public char getCor() {
		return cor;
	}

	public void setCor(char cor) {
		this.cor = cor;
	}

	public Nodo(String chave,String valor,char cor){
        this.chave = chave;
        this.valor = valor; 
        this.cor = cor; 
    }  
}