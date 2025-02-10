package Email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSimples {
    public static void main(String[] args) {
        // Configurações do e-mail
        String meuEmail = "knunescaetano@gmail.com";
        String senha = "nvnj vycy iuut glhx";
        String destinatario = "kauanunes2003@gmail.com";
        
        // Configuração do servidor SMTP
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com"); // Servidor SMTP
        email.setSmtpPort(465); // Porta SSL
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, senha)); // Autenticação
        email.setSSLOnConnect(true); // Habilitar SSL

        try {
            // Configura o e-mail
            email.setFrom(meuEmail); // Remetente
            email.setSubject("Teste de E-mail com Apache Commons Email"); // Assunto
            email.setMsg("Este é um e-mail enviado usando Apache Commons Email em Java."); // Corpo do e-mail
            email.addTo(destinatario); // Destinatário

            // Envia o e-mail
            email.send();
            System.out.println("E-mail enviado com sucesso!");
        } catch (EmailException e) {
            System.err.println("Erro ao enviar o e-mail: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
