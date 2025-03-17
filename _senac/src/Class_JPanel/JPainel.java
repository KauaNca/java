package Panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPainel extends JFrame {

    JPanel painel1;
    JPanel painel;

    public JPainel() {
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Só pode um método por vez, já que no momento que o FlowLayout setar um layout, vai vir o outro e colocar null e apagar o do FlowLayout
        FlowLayout();
        add(painel1); // Adiciona painel1 ao frame

        //LayoutNull();
        //add(painel); // Adiciona painel ao frame
        
        setVisible(true);
    }

    public void FlowLayout() {
        // Configurar um layout que respeite o tamanho preferido
        setLayout(new FlowLayout());
        painel1 = new JPanel();
        painel1.setPreferredSize(new Dimension(200, 300)); //Define o tamanho do painel no Frame
        painel1.setBackground(Color.green);
    }

    public void LayoutNull() {
        //Se usar setLayout(null), o painel teria que ser definido por setBounds();
        setLayout(null); // Alterar o layout do frame para nulo
        painel = new JPanel();
        painel.setBounds(0, 100, 200, 200); // Define a posição e o tamanho do painel
        painel.setBackground(Color.red);
    }

    public static void main(String[] args) {
        new JPainel();
    }
}

/*
    A classe Dimension em Java é usada para encapsular a largura e a altura (dimensões) 
    de um componente de um GUI. É amplamente utilizada em layouts para especificar o tamanho preferido, 
    mínimo ou máximo de componentes como JPanel, JFrame, entre outros.
 */
