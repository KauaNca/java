package JColorChooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painel extends JFrame {
    JPanel painel = new JPanel();
    public Painel(){
        setLayout(new FlowLayout());
        painel.setBackground(Color.red);
        painel.setPreferredSize(new Dimension(500,500));
        add(painel);
        Frame();
        new ColorChooser(painel);
    }
    public void Frame() {
        setSize(1000, 900); // Ajuste do tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new Painel();
    }
}
