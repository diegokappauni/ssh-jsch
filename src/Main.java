import java.util.Scanner;

/**
 * Created by kappauni on 2/22/17.
 */
public class Main {


    public static void main(String[]args){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o nome do usuário: ");
        String usuario = teclado.next();

        System.out.println("Digite o nome do servidor: ");
        String servidor = teclado.next();

        System.out.println("Digite a porta de SSH");
        int porta = teclado.nextInt();

        System.out.println("Digite a senha: ");
        String senha = teclado.next();


        Cliente_ssh cliente = new Cliente_ssh();

        cliente.dados_acesso(usuario,servidor,porta,senha);


        cliente.conexao();


    }



}
