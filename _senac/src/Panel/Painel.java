package Panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Painel extends JFrame {
    JLabel nome = new JLabel("Kaua");
    ImageIcon imagem = new ImageIcon(getClass().getResource("ost_snk.jpg"));

    public Painel() {
        Frame();
    }

    public void Frame() {
        setSize(1500, 1474);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        nome.setFont(new Font("Arial", Font.BOLD, 75));
        Panel painel = new Panel();
        painel.setLayout(new BorderLayout());
        painel.add(nome, BorderLayout.EAST);
        JScrollPane rolagem = new JScrollPane(painel);
        add(rolagem);
        setVisible(true);
    }

    public class Panel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image img = imagem.getImage();
            g.drawImage(img, 0, 0, this);
        }
        
        @Override
        public Dimension getPreferredSize() {
            // Defina o tamanho preferido do painel para o tamanho da imagem
            return new Dimension(imagem.getIconWidth(), imagem.getIconHeight()); //pegando a largura e altura da imagem
        }
        /*
            Este método sera lido pelo JVM, mais especificamento o LayoutManager do Swing na hora de rodar o arquivo.
            O LayoutManager lerá o Dimension e ajustará o painel de acordo com a medida da imagem.
        
        a JVM quando rodar o arquivo verá o painel e olhará dentro dele os métodos, 
        então o LayoutManager reconhecerá o Dimension e ajustará o tamanho do painel de acordo com isso - a imagem.
            
        */
    }

    public static void main(String[] args) {
        new Painel();
    }
}

//EXPLICAÇÃO
/*
    Por que não fazer uma label para os dois?
JPanel: é um contêiner do Java Swing que serve para organizar componentes. 
Ele é um componente simples que não tem uma interface gráfica do usuário (GUI). 

super.paintComponent(g): Esta chamada garante que o comportamento padrão de pintura do componente seja executado. Isso inclui limpar a área de desenho, 
configurar as cores de fundo e realizar outras operações básicas de pintura. 
Sempre que você sobrescrever paintComponent, é uma boa prática chamar o método da superclasse para garantir que a pintura básica seja feita corretamente.

paintComponent() : método do JComponent, é responsável por desenhar um componente na tela. 
Ele é chamado automaticamente pelo sistema operacional quando é necessário atualizar a tela. 
Para desenhar um componente, é preciso colocar a lógica de desenho dentro do método paintComponent. 

Graphics : é um componente fundamental do pacote java.awt (Abstract Window Toolkit). Ela oferece os métodos necessários para desenhar formas, 
textos e imagens em componentes gráficos. Essencialmente, a Graphics é a classe que permite pintar (desenhar) em uma tela, como um JPanel, 
JFrame, ou qualquer outro componente que suporte desenhos.

O g.drawImage() faz a parte de "desenhar" a imagem dentro do JPanel



ENTENDIMENTO:

Método paintComponent é o responsável pelo padrão dos desenhos, 
ele recebe a pintura/desenho do graphics que é submetido ao padrão do paintComponent e faz
a função de preparar o componente


*/
