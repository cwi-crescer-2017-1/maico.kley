public class Saint {    
    private String nome; 
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0f;
	protected int qtdSentidosDespertados;
    
    public Saint(String nome, Armadura armadura)throws Exception {
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }
    
    public Genero getGenero() {
        return this.genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public Status getStatus() {
        return this.status;
    }
           
    public void perderVida(double vidaPerdida){
        this.vida-=vidaPerdida;
    }
    
    public Armadura getArmadura(){
        return this.armadura;
    }
    
    public double getVida(){
        return this.vida;
    }

	public int getQtdSentidosDespertados(){
		return this.qtdSentidosDespertados;
	}
}