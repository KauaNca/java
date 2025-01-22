package jogoHomemAranha;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kauan
 */
public class HomemAranha extends JFrame {

    //primeiro as imagens
    ImageIcon iconParede = new ImageIcon(getClass().getResource("parede.jpg"));
    ImageIcon iconAranhaGIF = new ImageIcon(getClass().getResource("aranha_subindo.gif"));
    ImageIcon iconAranhaPNG = new ImageIcon(getClass().getResource("aranha_parado.png"));
    
    //labels para as imagens
    JLabel imagemParede = new JLabel(iconParede);
    JLabel imagemAranha = new JLabel(iconAranhaPNG);

    //posições iniciais das labels junto com as imagens
    int posicaoX = 100;
    int posicaoY = 100;

    //construtor 
    public HomemAranha() {
        janela();
        movimento();
    }
    
    //método para definir o inicial do JFRAME
    public void janela() {
        setSize(626, 469);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(imagemAranha); //tem que ser primeiro, caso não a parede ficará na frente
        add(imagemParede);
        imagemParede.setBounds(0, 0, 626, 469); //(posicaoInicial X,posicaoInicialY,tamanho largura,tamanho altura)
        imagemAranha.setBounds(posicaoX, posicaoY, 103, 202);
    }

    public void movimento() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               //SEM USO
            }
            @Override
            public void keyPressed(KeyEvent e) {
                imagemAranha.setIcon(iconAranhaGIF); //trocar o ícone e dar o movimento
                if (e.getKeyCode() == 40) {
                    posicaoX += 10; // Para baixo, aumenta a posição X
                }
                if (e.getKeyCode() == 38) {
                    posicaoX -= 10; // Para cima, diminui a posição X
                }
                if (e.getKeyCode() == 37) {
                    posicaoY -= 10; // Para esquerda, diminui a posição Y
                }
                if (e.getKeyCode() == 39) {
                    posicaoY += 10; // Para direita, aumenta a posição Y
                }
                imagemAranha.setBounds(posicaoY, posicaoX, 103, 202);
            }

            @Override
            public void keyReleased(KeyEvent e) {
               imagemAranha.setIcon(iconAranhaPNG);
            }

           
        });
    }

    public static void main(String[] args) {
        new HomemAranha();
    }
}
