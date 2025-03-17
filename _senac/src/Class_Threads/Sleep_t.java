

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Sleep_t extends JFrame {
    JLabel contador = new JLabel();

    public Sleep_t() {
        add(contador);
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void contagem() {
        new Thread(new Runnable() {
            public void run() {
                int numero = 0;
                while (numero < 10) {
                    contador.setText(String.valueOf(numero));
                    numero++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        System.out.println("ERRO NA THREAD");
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        Sleep_t obj = new Sleep_t();
        obj.contagem();
    }
}

