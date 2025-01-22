import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

/*
import javazoom.jl.decoder.JavaLayerException;: Esta linha importa a classe JavaLayerException da biblioteca 
JLayer (ou JavaZoom). Esta classe representa uma exceção que pode ser lançada quando há um problema ao 
decodificar ou reproduzir arquivos MP3.

import javazoom.jl.player.Player;: Esta linha importa a classe Player da biblioteca JLayer. 
A classe Player é usada para reproduzir arquivos MP3.

import javax.swing.*;: Esta linha importa todas as classes da biblioteca Swing, que é uma parte do Java Foundation Classes (JFC) e é usada para criar interfaces gráficas de usuário (GUIs) em Java. 
O asterisco (*) significa que todas as classes dentro do pacote javax.swing estão sendo importadas.

*/

public class TocarSom extends JFrame {

    JButton tocar = new JButton("Tocar");

    public TocarSom() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(tocar);
        tocar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tocar("audio/Say Yes To Heaven");
            }
        });
    }

    public void tocar(String audio) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream("/" + audio + ".mp3");
            if (audioSrc == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: " + audio);
            }
            Player player = new Player(audioSrc);
            player.play();
        } catch (JavaLayerException ex) {
            ex.printStackTrace();
        }
    }
    /*O QUE É CADA UM?
        InputStream -> É como um tubo que você usa para pegar dados (bytes) de uma fonte. No seu caso, a fonte é o arquivo MP3.
        getClass() -> É como se você estivesse olhando para o rótulo da caixa onde você está. 
            Ele diz: "Esta é a caixa onde estou agora." Ou seja, ele está pegando o endereço de onde esta classe está para dar
            uma noção de onde procurar o arquivo.
        
        getResourceAsStream() -> método do getClass() - Procura um recurso com o nome especificado (como um arquivo) 
            no classpath da aplicação e retorna um InputStream para esse recurso.
    
        Player -> classe da biblioteca JLayer (ou JavaZoom), que é usada para reproduzir arquivos MP3 em Java. 
            Quando você cria um objeto Player com um InputStream que aponta para um arquivo MP3, ele lê os dados do arquivo 
            e os converte em som.

Aqui está uma explicação simples:

        Player: É como um tocador de música. Você dá a ele o arquivo de áudio (através do InputStream), e ele toca o 
    som para você.
    */

    public static void main(String[] args) {
        new TocarSom();
    }
}

