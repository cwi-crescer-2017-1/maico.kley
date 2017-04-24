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
            this.golpeado.perderVida(golpeador.getProximoGolpe().getFatorDano() 
            * multiplicadorDano);
        } else {
            this.golpeado.perderVida(golpeador.getProximoGolpe().getFatorDano());
        }        
    }

	public boolean equals(Object outro) {
        Golpear outroGolpear = (Golpear)outro;
        return this.golpeador.equals(outroGolpear.golpeador)
            && this.golpeado.equals(outroGolpear.golpeado);
    }
}
