import java.util.ArrayList;
public class ListaSaints
{
    private ArrayList<Saint> listaSaints = new ArrayList<>();  
    
    public void adicionar(Saint saint){
       this.listaSaints.add(saint); 
   }
   
   public Saint get(int i){
       return this.listaSaints.get(i);
    }
    
   public ArrayList todos(){
       return this.listaSaints;
    }
       
   public void remover(Saint saint){
       this.listaSaints.remove(saint);
    }
    
   public Saint buscaPorNome(String nome){       
       for(int i=0;i<listaSaints.size();i++){
           if(nome.equals(listaSaints)){
               return this.listaSaints.get(i);               
            }
        }
        return null;
    }
    
   public ArrayList buscaPorCategoria(Categoria categoria){
       ArrayList<Saint> saintsCategoriaDesejada = new ArrayList<>();
       for(int i=0;i<listaSaints.size();i++){
           if(categoria.equals(listaSaints)){
               saintsCategoriaDesejada.add(listaSaints.get(i));               
            }
        }
        return saintsCategoriaDesejada;
    }
    
   public ArrayList buscaPorStatus(Status status){
       ArrayList<Saint> saintsStatusDesejado = new ArrayList<>();
       for(int i=0;i<listaSaints.size();i++){
           if(status.equals(listaSaints)){
               saintsStatusDesejado.add(listaSaints.get(i));               
            }
        }
        return saintsStatusDesejado;
    }
    
   public Saint getSaintMaiorVida(){
       Saint saintVida = null;
       double vida = 0.0;
       for (Saint saint : listaSaints){
            if (saint.getVida() > vida) {
                saintVida = saint;
                vida = saint.getVida();
            }
        }
        return saintVida;
    }
    
   public Saint getSaintMenorVida(){
       Saint saintVida = null;
       double vida = 100.0;
       for (Saint saint : listaSaints){
            if (saint.getVida() < vida) {
                saintVida = saint;
                vida = saint.getVida();
            }
        }
        return saintVida;
    }
    
   public void ordenar(){
       Saint ordenar = null;
       for(int i = 0;i<listaSaints.size()-1; i++){
           for(int j = 1; j<listaSaints.size(); j++){
               if(listaSaints.get(i).getVida()<listaSaints.get(j).getVida()){
                   ordenar = listaSaints.get(i);
                   listaSaints.add(listaSaints.indexOf(ordenar),listaSaints.get(j));
                   listaSaints.add(listaSaints.indexOf(listaSaints.get(j)),ordenar);
                }
            }
        }
    }
}
