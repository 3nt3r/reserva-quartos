package reservadequartos;
import java.util.ArrayList;
public class Hospede implements SistemaHospedes{
    
    ArrayList<String> hospedes = new ArrayList<String>();
    ArrayList<String> cpf = new ArrayList<String>();
    ArrayList<String> contato = new ArrayList<String>();
    

    public Hospede() {
        hospedes.clear();
        cpf.clear();
        contato.clear();
    }
    
    
    @Override
    public void listarHospedes() {
        if (hospedes.isEmpty()){
            System.out.println("A lista está vazia!");
        } else {
            for(int cont = 0; cont < hospedes.size(); cont++){
                System.out.println("| Nome: " + hospedes.get(cont) + " CPF: " + cpf.get(cont) + " Contato: " + contato.get(cont) + " |");;
            }
        }
    }

    @Override
    public void cadastrarHospede(String nom, String cp, String cont) {
        if (hospedes.contains(nom)){
            System.out.println("Você já está Cadastrado!");
        } else {
            hospedes.add(nom);
            cpf.add(cp);
            contato.add(cont);
            System.out.println("Hóspede Cadastrado com Sucesso!");
        }
    }

    @Override
    public void excluirHospede(String cp) {
        if (!cpf.contains(cp)){
            System.out.println("Hóspede não Encontrado!");
        } else {
            contato.remove(cpf.indexOf(cp));
            hospedes.remove(cpf.indexOf(cp));
            cpf.remove(cpf.indexOf(cp));
            System.out.println("Hóspede Excluido com Sucesso!");
        }
    }
    
    public boolean verificaCPF(String cp){
        if (cpf.contains(cp)){
            return true;
        } else {
            System.out.println("Hóspede Não Encontrado!");
            return false;
        }
    }
    
    //===========================================================//

    public ArrayList<String> getHospedes() {
        return hospedes;
    }

    public void setHospedes(ArrayList<String> hospedes) {
        this.hospedes = hospedes;
    }

    public ArrayList<String> getCpf() {
        return cpf;
    }

    public void setCpf(ArrayList<String> cpf) {
        this.cpf = cpf;
    }

    public ArrayList<String> getContato() {
        return contato;
    }

    public void setContato(ArrayList<String> contato) {
        this.contato = contato;
    }  
}
