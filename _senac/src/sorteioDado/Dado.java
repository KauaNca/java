package sorteioDado;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dado extends JFrame {

    JButton sortear = new JButton("SORTEAR");
    JLabel dado = new JLabel(new ImageIcon(getClass().getResource("dado/dado.gif")));

    public Dado() {
        sortear.setPreferredSize(new Dimension(100, 50)); // Ajuste do tamanho do botão
        sortear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Sortear().start();
                    
                } catch (Exception erro) {
                    erro.printStackTrace();
                }
            }
        });
        add(BorderLayout.CENTER, dado);
        add(BorderLayout.SOUTH, sortear);
        Frame();
    }

    public void Frame() {
        setSize(300, 300); // Ajuste do tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mudarImagem(int x) {
        dado.setIcon(new ImageIcon(getClass().getResource("dado/" + x + ".png")));
    }

    public class Sortear extends Thread {
        public void run() {
            try {
                sleep(3000); // Pausa de 3 segundos
                int x = (int) (Math.random() * 6) + 1;
                mudarImagem(x);
                sleep(5000);
                dado.setIcon(new ImageIcon(getClass().getResource("dado/dado.gif")));
            } catch (InterruptedException ex) {
                System.out.println("ERRO");
            }
        }
    }

    public static void main(String[] args) {
        new Dado();
    }
}

