
public class Batalha
{
   private Saint saint1, saint2;   
   
   public Batalha(Saint saint1, Saint saint2){
       this.saint1 = saint1;
       this.saint2 = saint2;
    }
    
    public void iniciar(){
        final double dano = 10;
        
        if(saint1.getValCatArmadura()>=saint2.getValCatArmadura()){
            saint2.perderVida(dano);
        } else {
            saint1.perderVida(dano);
        }
    }
}
