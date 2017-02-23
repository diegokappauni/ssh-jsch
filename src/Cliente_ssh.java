import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * Created by kappauni on 2/22/17.
 */


class Cliente_ssh {

    Session sessao = null;


//Método que pede usuario, endereço do servidor e a porta de autenticação do SSH

    void dados_acesso(String usuario, String servidor, int porta, String senha) {

        //Inicio da instancia da classe JSch
        JSch ssh = new JSch();

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");


        //Tratando caso tenha algum erro no preenchimento dos dados
        try {
            sessao = ssh.getSession(usuario, servidor, porta);
            //Definindo senha do SSH
            sessao.setPassword(senha);


        } catch (JSchException e) {

            System.out.println(e.getMessage());

        }
        sessao.setConfig(config);

    }




    void conexao() {
        Channel canal = null;


        try {
            //Conectando a sessão
            sessao.connect(10000);

        } catch (JSchException e) {

            System.out.println(" Falha na autenticação. \n Isso pode acontecer caso tenha digitado usuario ou senha incorretamente.");
        }


        sessao.setInputStream(System.in);
        sessao.setOutputStream(System.out);


        try {

            canal = sessao.openChannel("shell");

        } catch (JSchException e) {
            e.printStackTrace();
        }


        try {
            canal.connect(10000);
        } catch (JSchException e) {
            e.printStackTrace();


        }
    }


}
