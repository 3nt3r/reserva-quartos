package reservadequartos;
public interface SistemaHospedes {
    
    public abstract void listarHospedes();
    
    public abstract void cadastrarHospede(String nom, String cp, String cont);
    
    public abstract void excluirHospede(String cp); 
    
}
