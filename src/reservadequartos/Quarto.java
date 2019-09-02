package reservadequartos;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Quarto implements SistemaQuartos{
    
    //=============A T R I B U T O S=============================//    
    
    private final String[] quarto = new String[40];
    protected final boolean[] vazio = new boolean[40];
    private final String[] hospede = new String[40];
    private String[] entrada = new String[40];
    private String[] saida = new String[40];
    ArrayList<String> verifica = new ArrayList<String>();
    private Hospede pessoa;    
    
    //=============C O N S T R U T O R=============================//
    
    public Quarto(){
        for (int cont = 0; cont <= 39; cont++){
            this.quarto[cont] = Integer.toString(cont + 1);
            vazio[cont] = true;
            this.entrada[cont] = "";
            this.saida[cont] = "";
            this.hospede[cont] = "";
            verifica.clear();
        }
    }
    
    //=============M E T O D O S=============================// 
    
    @Override
    public void listarQuartos() {
        System.out.println("-----------------------------------------");
        System.out.println("| " + this.quarto[39] + " | " + this.quarto[38] + " | " + this.quarto[37] + " | " + this.quarto[36] + " | " + this.quarto[35] + " | " + this.quarto[34] + " | " + this.quarto[33] + " | " + this.quarto[32] + " |");
        System.out.println("| " + this.quarto[31] + " | " + this.quarto[30] + " | " + this.quarto[29] + " | " + this.quarto[28] + " | " + this.quarto[27] + " | " + this.quarto[26] + " | " + this.quarto[25] + " | " + this.quarto[24] + " |");
        System.out.println("| " + this.quarto[23] + " | " + this.quarto[22] + " | " + this.quarto[21] + " | " + this.quarto[20] + " | " + this.quarto[19] + " | " + this.quarto[18] + " | " + this.quarto[17] + " | " + this.quarto[16] + " |");
        System.out.println("| " + this.quarto[15] + " | " + this.quarto[14] + " | " + this.quarto[13] + " | " + this.quarto[12] + " | " + this.quarto[11] + " | " + this.quarto[10] + " | " + this.quarto[9] + " |  " + this.quarto[8] + " |");
        System.out.println("|  " + this.quarto[7] + " |  " + this.quarto[6] + " |  " + this.quarto[5] + " |  " + this.quarto[4] + " |  " + this.quarto[3] + " |  " + this.quarto[2] + " |  " + this.quarto[1] + " |  " + this.quarto[0] + " |");
        System.out.println("-----------------------------------------");
    }

    @Override
    public void verificarReserva() {
        if (verifica.isEmpty()){
            System.out.println("Não há Nenhuma Reserva!");
        } else {
            System.out.println("-----------------------------------------");        
            for (int cont = 0; cont <= 39; cont++){
                System.out.println("Quarto: " + Integer.toString(cont+1) + " CPF do Hóspede: " + hospede[cont] + " Entrada: " + entrada[cont] + " Saída: " + saida[cont]);
            }
            System.out.println("-----------------------------------------");        
        }
    }

    @Override
    public void fazerReserva(int qua, String cpf, String entr, String sai) {
        try {
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date sistema = new Date();
            formato.format(sistema);
            Date hospedeEntrada = formato.parse(entr);
            Date hospedeSaida = formato.parse(sai);
                if (this.vazio[qua-1]){
                    if (sistema.before(hospedeEntrada) && sistema.before(hospedeSaida)){
                        if (entrada[qua-1].equals("")){
                            this.quarto[qua-1] = "x";
                            this.entrada[qua-1] = entr;
                            this.saida[qua-1] = sai;
                            this.hospede[qua-1] = cpf;
                            this.vazio[qua-1] = false;
                            this.verifica.add("1");
                            System.out.println("Reserva Realizada com Sucesso!");                            
                        } else {
                            Date entradaSistema = formato.parse(entrada[qua-1]);
                            Date saidaSistema = formato.parse(saida[qua-1]);                            
                            if (hospedeEntrada.after(saidaSistema)){
                                this.quarto[qua-1] = "x";
                                this.entrada[qua-1] = entr;
                                this.saida[qua-1] = sai;
                                this.hospede[qua-1] = cpf;
                                this.vazio[qua-1] = false;
                                this.verifica.add("1");
                                System.out.println("Reserva Realizada com Sucesso!");                            
                            } else {
                                System.out.println("O Quarto ainda Estará Ocupado nessa Data!");
                            }                               
                        }  
                    } else {
                        System.out.println("Data Inválida!");
                    }
                } else {
                    System.out.println("O Quarto Desejado já está Ocupado!");
                }       
        } catch (ParseException ex) {
            Logger.getLogger(Quarto.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void cancelarReserva(int quarto) {
        this.quarto[quarto-1] = Integer.toString(quarto);
        this.entrada[quarto-1] = "";
        this.saida[quarto-1] = "";
        this.hospede[quarto-1] = "";
        this.vazio[quarto-1] = true;
        System.out.println("Quarto Disponível Novamente!");
    }

    @Override
    public void fecharConta(double dia, String quarto) {
        
        DateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
        formato.setLenient(false);
        try {
            Date entradaCance = formato.parse(entrada[Integer.parseInt(quarto)-1]);
            Date saidaCance = formato.parse(saida[Integer.parseInt(quarto)-1]);
            long d = (saidaCance.getTime() - entradaCance.getTime()) + 3600000;
            double dias = (d/3600000)/24;
            System.out.println("Dias Hospedado: " + dias);
            System.out.println("Valor a Pagar: " + dia * dias);
            cancelarReserva(Integer.parseInt(quarto));
        } catch (ParseException ex) {
            Logger.getLogger(Quarto.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
    
    public boolean verificaQuarto(int quarto){
        return !vazio[quarto];
    }
   
}
    //====================================================================//
   
