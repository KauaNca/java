package barraDeRolagem;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

//Scroll numa imagem grande que não cabe dentro do Frame
public class BarraDeRolagem_Imagem extends JFrame {
    JScrollPane barraImagem;
    JLabel imagem;
    
    public BarraDeRolagem_Imagem(){
        Label(); // Inicializa o JLabel e JScrollPane
        Frame(); // Configura o JFrame e o torna visível
    }
    // Scroll com Label
    public void Label(){
        imagem = new JLabel(new ImageIcon(getClass().getResource("animes.jpg")));
        barraImagem = new JScrollPane(imagem);
    }
    
    public void Frame(){
        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Usando BorderLayout para adicionar múltiplos componentes
        add(barraImagem, BorderLayout.SOUTH); // Adicionando JScrollPane do JLabel na parte inferior do JFrame
        setVisible(true); // Torna o JFrame visível
    }

    public static void main(String[] args){
        new BarraDeRolagem_Imagem(); // Cria o frame e inicializa tudo no construtor
    }
}
