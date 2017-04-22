public class Golpear implements Movimento
{
    private Saint golpeador;
    private Saint golpeado;
    
    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    public void executar(){
        int multiplicadorDano;
        if(golpeador.getArmaduraVestida()){
            multiplicadorDano = golpeador.getArmadura().
            getCategoria().getValor() + 1;
            golpeado.perderVida(golpeador.getProximoGolpe().getFatorDano() 
            * multiplicadorDano);
        } else {
            golpeado.perderVida(golpeador.getProximoGolpe().getFatorDano());
        }
        
    }
}
