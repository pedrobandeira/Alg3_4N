public class Arvore {
    
    public Nodo raiz;
    
    public Arvore() {
        this.raiz = null;
    }
    
    public void inserir(String chave, String val) {
        if (this.raiz == null) {
            this.raiz = new Nodo(chave,val,'p');
            this.raiz.setPai(null);
        } else {
            inserirValor(this.raiz,chave,val);
        }
    }
    
    private void inserirValor(Nodo no, String chave, String val) {
        if (val.compareToIgnoreCase(no.getValor()) < 0) {
           if (no.getEsq() == null) {
               no.setEsq(new Nodo(chave,val,'v'));
               no.getEsq().setPai(no);
               caso1(no);
           } else {
               inserirValor(no.getEsq(),chave,val);
           } 
        } else if (val.compareToIgnoreCase(no.getValor()) > 0) {
            if (no.getDir() == null) {
               no.setDir(new Nodo(chave,val,'v'));
               no.getDir().setPai(no);
               caso1(no);
           } else {
               inserirValor(no.getDir(),chave,val);
           }
        }
    }
    
    private Nodo getTio(Nodo no) {
        
        if (no.getPai() != null && no.getPai().getPai() == null) {
            if (no.getPai().getEsq() == no) {
            	return no.getDir();
            } else {
                return no.getEsq();
            }
        } else if (no.getPai() != null && no.getPai().getPai() != null) {
            if (no.getPai().getPai().getEsq() == no.getPai()) {
            	return no.getPai().getPai().getDir();
            } else return no.getPai().getPai().getEsq();
        } else return null; 
    }
    
    private void caso1(Nodo no) {
        if (no.getPai() == null) {
            no.setCor('p');
        } else caso2(no);
    }
    
    private void caso2(Nodo no) {
        if (no.getPai().getCor() == 'p') return;
        else caso3(no);
    }
    
    private void caso3(Nodo no) {
        if (getTio(no).getCor() == 'v') {
            no.getPai().setCor('p');
            getTio(no).setCor('p');
            if (no.getPai().getPai() != null) {
                no.getPai().getPai().setCor('v');
                caso1(no.getPai().getPai());
            } 
        } else caso4(no);
    }
    
    private void caso4(Nodo no) {
        if (no == no.getPai().getDir() && no.getPai() == no.getPai().getPai().getEsq()) {
            rotacionaEsq(no.getPai());
            no = no.getEsq();
        } else if (no == no.getPai().getEsq() && no.getPai() == no.getPai().getPai().getDir()) {
            rotacionaDir(no.getPai());
            no = no.getDir();
        }
        caso5(no);
    }
    
    private void caso5(Nodo no) {
        no.getPai().setCor('p');
        getTio(no).setCor('v');
        if (no == no.getPai().getEsq() && no.getPai() == no.getPai().getPai().getEsq()) {
            rotacionaDir(no.getPai().getPai());
        } else {
            assert no == no.getPai().getDir() && no.getPai() == no.getPai().getPai().getDir();
            rotacionaEsq(no.getPai().getPai());
        }
    }
    
    
    private void rotacionaEsq(Nodo no) {
        Nodo n = no.getDir();
        substituiNodo(no, n);
        no.setDir(n.getEsq());
        if(n.getEsq() != null){
            n.getEsq().setPai(no);
        }
        n.setEsq(no);
        no.setPai(n);
    }
    
    private void rotacionaDir(Nodo no) {
        Nodo n = no.getEsq();
        substituiNodo(no, n);
        no.setEsq(n.getDir());
        if(n.getDir() != null){
            n.getDir().setPai(no);
        }
        n.setDir(no);
        no.setPai(n);
    }
    
    private void substituiNodo(Nodo velho, Nodo novo) {
        if (velho.getPai() == null) {
            this.raiz = novo;
        } else {
            if (velho == velho.getPai().getEsq()) {
                velho.getPai().setEsq(novo);
            } else {
                velho.getPai().setDir(novo);
            }
        }
        if (novo != null) {
            novo.setPai(velho.getPai());
        }
    }
    
    public void busca(Nodo no, String cha) {
    	
        if (cha == this.raiz.getChave()) {
            System.out.println("O valor procurado é a raiz: "+no.getValor()+" para a chave "+no.getChave());
            return;
        } else {
            if (cha == no.getChave()) {
                System.out.println("Encontrou o valor "+no.getValor()+" para a chave "+no.getChave());
                return;
            } else {
                if (cha.compareToIgnoreCase(no.getChave()) > 0 ) {
                    busca(no.getDir(),cha);
                } else if (cha.compareToIgnoreCase(no.getChave()) > 0 ) {
                    busca(no.getEsq(),cha);
                }
        	}
        }
        System.out.println("Valor não encontrado.");
    }
         
     public Nodo removeNo(Nodo no, String val) {
         
         if (no != null) {
             if (val.compareToIgnoreCase(no.getValor()) > 0) {
                 no.setDir(removeNo(no.getDir(), val));
             } else if (val.compareToIgnoreCase(no.getValor()) < 0) {
                 no.setEsq(removeNo(no.getEsq(), val));
             } else {
                 if (no.getDir() != null && no.getEsq() != null) {
                     no.setValor(encontraMin(no.getDir()).getValor());
                     no.setDir(removeMin(no.getDir()));
                 } else {
                     no = (no.getEsq() != null) ? no.getEsq() : no.getDir();
                 }
             }
             return no;
         } else {
             return null;
         }
     }
     
     public Nodo removeMin(Nodo no) {
         if (no != null) {
             if (no.getEsq() != null) {
                 no.setEsq(removeMin(no.getEsq()));
                 return no;
             } else {
                 return no.getDir();
             }
         }
         return null;
     }
     
     public Nodo encontraMin(Nodo no) {
         if (no != null) {
             while (no.getEsq() != null) {
                 no = no.getEsq();
             }
         }
         return no;
     }

    
}