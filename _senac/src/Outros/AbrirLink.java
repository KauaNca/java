
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kauan
 */
public class AbrirLink extends JFrame{
    JButton link = new JButton("Abrir no navegador");
    public AbrirLink(){
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(link);
       
        
        link.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URI abrirLink = new URI("https://www.google.com/search?client=opera-gx&q=google+tradutor&sourceid=opera&ie=UTF-8&oe=UTF-8");
                    Desktop.getDesktop().browse(abrirLink);
                } catch (URISyntaxException | IOException ex) {
                    System.out.println("ERRO NO LINK");
                }
            }
            
        });
    }
    public static void main(String[] args){
        new AbrirLink();
    }
}
/*
    URI (INDETIFICADOR DE PESQUISA UNIFORME)
Um URI é uma string de caracteres usada para identificar um recurso na Internet. 
Pode ser um endereço de uma página da web (URL), mas também pode ser usado para identificar outros recursos, 
como arquivos, emails, ou fragmentos de dados.

    DESKTOP
A classe Desktop é parte da API Java e é usada para interagir com o ambiente de desktop do sistema operacional. 
Isso inclui abrir aplicativos padrões, como navegadores da web, 
editores de texto, etc. No seu exemplo, o método browse da classe Desktop está sendo usado para abrir o link no navegador padrão do sistema.

Outros Métodos da Classe Desktop
open(File file): Abre o arquivo especificado usando o aplicativo associado ao tipo de arquivo no sistema operacional.

edit(File file): Abre o arquivo especificado no modo de edição usando o aplicativo associado.

mail(): Abre o cliente de email padrão do sistema.

mail(URI mailtoURI): Abre o cliente de email padrão com uma nova mensagem composta, utilizando o URI especificado.

print(File file): Imprime o arquivo especificado usando a impressora padrão.
*/
