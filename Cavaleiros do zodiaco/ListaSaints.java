import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaSaints
{
    private ArrayList<Saint> listaSaints = new ArrayList<>();  
    
    public void adicionar(Saint saint){
       this.listaSaints.add(saint); 
   }
   
   public Saint get(int i){
       return this.listaSaints.get(i);
    }
    
   public ArrayList<Saint> todos(){
       return this.listaSaints;
    }
       
   public void remover(Saint saint){
       this.listaSaints.remove(saint);
    }
    
   public Saint buscarPorNome(String nome){          
        for(Saint saint : this.listaSaints){
            if (saint.getNome().equals(nome)){
                return saint;
            }
        }
        return null;
    }
    
   public ArrayList<Saint> buscaPorCategoria(Categoria categoria){       
        ArrayList<Saint> subLista = new ArrayList<Saint>();
        
        for (Saint saint : this.listaSaints) {
            if (saint.getArmadura().getCategoria().equals(categoria)) {
                subLista.add(saint);
            }
        }
        return subLista;
    }
    
   public ArrayList buscaPorStatus(Status status){
       return (ArrayList<Saint>)this.listaSaints.stream()
            .filter(s -> s.getStatus().equals(status))
            .collect(Collectors.toList());
    }
    
   public Saint getSaintMaiorVida(){
       if (listaSaints.isEmpty()) {
            return null;
        }
        
        Saint maiorVida = this.listaSaints.get(0);
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            boolean encontreiMaior = saint.getVida() > maiorVida.getVida();
            if (encontreiMaior) {
                maiorVida = saint;
            }
        }
        
        return maiorVida;
    }
    
   public Saint getSaintMenorVida(){
       if (listaSaints.isEmpty()) {
            return null;
        }
        
        Saint menorVida = this.listaSaints.get(0);
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);
            boolean encontreiMenor = saint.getVida() < menorVida.getVida();
            if (encontreiMenor) {
                menorVida = saint;
            }
        }
        
        return menorVida;
    }
    
   public void ordenar(){
       boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas); 
    }
    
   public void ordenar(TipoOrdenacao ordenacao){ 
       if(ordenacao.equals(TipoOrdenacao.ASCENDENTE)){
           boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
       } else if (ordenacao.equals(TipoOrdenacao.DESCENDENTE)){
            boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = atual.getVida() < proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);
       }        
    }
    
   public String getCSV(Saint saint){
       String retorno = "";
       String saintsCSV = "";
       for(int i = 0; i<this.listaSaints.size();i++){
            saint = this.listaSaints.get(i);
            saintsCSV = (saint.getNome()+","+saint.getVida()+","+saint.getConstelacao()+","+saint.getArmadura().getCategoria()+","+saint.getStatus()
            +","+saint.getGenero()+","+saint.getArmaduraVestida()+System.getProperty("line.separator"));
       }
       retorno = retorno + saintsCSV;
       return retorno;
   }
}
