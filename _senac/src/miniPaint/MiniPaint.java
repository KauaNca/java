package miniPaint;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MiniPaint extends JFrame {

    public boolean mousePressionado = false;

    public MiniPaint() {
        addMouseListener(new MouseListener() {
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
                desenhos.clear(); // Removido para manter os desenhos na tela
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        new Tempo().start();
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        synchronized(desenhos) {
            for (int a = 1; a < desenhos.size(); a++) {
                int x1 = desenhos.get(a).x;
                int x2 = desenhos.get(a - 1).x;
                int y1 = desenhos.get(a).y;
                int y2 = desenhos.get(a - 1).y;
                g.drawLine(x2, y2, x1, y1);
            }
        }
    }

    public class Desenho {
        int x, y;
        public Desenho(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    ArrayList<Desenho> desenhos = new ArrayList<>();

    public class Tempo extends Thread {

        public void run() {
            while (true) {
                if (mousePressionado) {
                    try {
                        Point mouse = getMousePosition();
                        synchronized(desenhos) {
                            desenhos.add(new Desenho(mouse.x, mouse.y));
                        }
                    } catch (Exception e) {
                        System.out.println("MOUSE NÃO ENCONTRADO");
                    }
                }

                repaint();
                try {
                    Thread.sleep(10); // pausa por 10 milissegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new MiniPaint();
    }
}
