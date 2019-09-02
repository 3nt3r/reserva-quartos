package reservadequartos;
public interface SistemaQuartos {
    
    public abstract void listarQuartos();
    
    public abstract void verificarReserva();
    
    public abstract void fazerReserva(int qua, String cp, String entr, String sai);
    
    public abstract void cancelarReserva(int quarto);
    
    public abstract void fecharConta(double dia, String quarto);
    
}
