
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class moverImagem extends JFrame {

    boolean mousePressionado = false;
    ImageIcon imagem = new ImageIcon(getClass().getResource("naruto.png"));
    JLabel naruto = new JLabel(imagem);

    public moverImagem() {
        editarJanela();
        new Naruto().start();
    }

    public void mover() {

    }

    public class Naruto extends Thread {

        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    System.out.println(e);
                }
                if (mousePressionado) {
                    Point mouse = getMousePosition();
                    naruto.setBounds(mouse.x - 174, mouse.y - 250, 348, 500);
                }
            }

        }
    }

    public void editarJanela() {
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(naruto);
        naruto.setBounds(0, 0, 348, 500);
        naruto.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressionado = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressionado = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        new moverImagem();
    }
}
