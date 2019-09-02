package reservadequartos;
import java.util.Scanner;
import static reservadequartos.Funcionalidades.menu;
public class ReservaDeQuartos {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Scanner usuario = new Scanner(System.in);
        Hospede cliente = new Hospede();
        Quarto hotel = new Quarto();
        int usu = 0;
        
        while (usu != 9){
            
            menu();
            System.out.print("Digite sua Opção: ");
            usu = teclado.nextInt();

//==============================================================================

            switch (usu) {
                case 1:
                    cliente.listarHospedes();
                    break;
                    
//==============================================================================                    
                    
                case 2:
                    System.out.print("Nome: ");
                    String a = usuario.next();
                    System.out.print("CPF: ");
                    String b = usuario.next();
                    System.out.print("Contato: ");
                    String c = usuario.next();
                    cliente.cadastrarHospede(a, b, c);
                    break;
                  
//==============================================================================                    
                    
                case 3:
                    System.out.print("CPF do Hóspede: ");
                    String d = teclado.next();
                    cliente.excluirHospede(d);
                    break;
                    
//==============================================================================
                    
                case 4:
                    hotel.listarQuartos();
                    break;
                    
//==============================================================================
                    
                case 5:
                    hotel.verificarReserva();
                    break;
                    
//==============================================================================
                    
                case 6:
                    System.out.print("Número do Quarto: ");
                    int e = usuario.nextInt();
                    System.out.print("Identificação (CPF): ");
                    String f = usuario.next();
                    if (cliente.verificaCPF(f)){
                        System.out.print("Entrada (dd/mm/aaaa) Sem Parêntese: ");
                        String g = usuario.next();
                        System.out.print("Saída (dd/mm/aaaa) Sem Parêntese: ");
                        String h = usuario.next();
                        hotel.fazerReserva(e, f, g, h); 
                    }
                    break;

//==============================================================================
                    
                case 7:
                    System.out.print("Número do Quarto: ");
                    int i = usuario.nextInt();
                    if (hotel.verificaQuarto(i-1)){
                        hotel.cancelarReserva(i);
                    } else {
                        System.out.println("Quarto Vazio ou Inválido!");
                    }                   
                    break;

//==============================================================================
                    
                case 8:
                    System.out.print("Número do Quarto: ");
                    int j = usuario.nextInt();
                    if (!hotel.verificaQuarto(j)){
                        System.out.print("Valor da Diária R$: ");
                        double k = usuario.nextDouble();
                        hotel.fecharConta(k, Integer.toString(j));
                    } else {
                        System.out.println("Quarto Vazio ou Inválido!");
                    }
                    break;
 
//==============================================================================                    
                    
                default:
                    System.out.println("Número Inválido!");
                    break;
            } 
        }       
    }  
}
