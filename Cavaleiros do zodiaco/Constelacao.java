
public class Constelacao
{
   private String nome;
   private Golpe[] golpe = new Golpe[3];
   
   public Constelacao(String nome){
       this.nome=nome;
    }
   public String getNome(){
       return this.nome;
    }
}
