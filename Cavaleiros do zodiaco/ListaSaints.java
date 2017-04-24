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
       //exemplo lambda
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
       boolean ascendente = ordenacao == TipoOrdenacao.ASCENDENTE;
        boolean posicoesSendoTrocadas;
        do {
            posicoesSendoTrocadas = false;
            for (int i = 0; i < this.listaSaints.size() - 1; i++) {
                Saint atual = this.listaSaints.get(i);
                Saint proximo = this.listaSaints.get(i + 1);
                boolean precisaTrocar = 
                    ascendente ? atual.getVida() > proximo.getVida() :
                    atual.getVida() < proximo.getVida();
                if (precisaTrocar) {
                    this.listaSaints.set(i, proximo);
                    this.listaSaints.set(i + 1, atual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas); 
    }
    
   public String getCSV(){
       if (this.listaSaints.isEmpty()) {
            return "";
        }

        String separador = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder(512);

        builder.append(this.listaSaints.get(0).getCSV());
        for (int i = 1; i < this.listaSaints.size(); i++) {
            Saint saint = this.listaSaints.get(i);            
            builder.append(separador);
            builder.append(saint.getCSV());
        }

        return builder.toString();
   }
   
   //verificar
       public ListaSaints unir (ListaSaints lista) {
        ArrayList<Saint> listaAtual = this.listaSaints;
        ArrayList<Saint> listaParaAdicionar = lista.todos();
        ListaSaints resultado = new ListaSaints();
        for (Saint saint : listaAtual) {
            resultado.adicionar (saint);
        }
        for (Saint saint : listaParaAdicionar) {
            resultado.adicionar (saint);
        }
        return resultado;
    }

    public ListaSaints diff (ListaSaints lista) {
        ListaSaints resultado = new ListaSaints();
        ArrayList<Saint> lista1 = this.listaSaints;
        ArrayList<Saint> lista2 = lista.todos();
        for (Saint saint1 : lista1) {  
            boolean duplicado = false;
            for (Saint saint2 : lista2) {
                if (saint1.equals(saint2)) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) { resultado.adicionar (saint1);}
        }
        return resultado;
    }

    public ListaSaints intersec (ListaSaints lista) {
        ListaSaints resultado = new ListaSaints();
        ArrayList<Saint> lista1 = this.listaSaints;
        ArrayList<Saint> lista2 = lista.todos();
        for (Saint saint1 : lista1) {  
            for (Saint saint2 : lista2) {
                if (saint1.equals(saint2)) {
                    resultado.adicionar (saint1);
                    break;
                }
            }
        }
        return resultado;
    }
}
