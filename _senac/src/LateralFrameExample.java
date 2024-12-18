
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LateralFrameExample {
 
    public static void main(String[] args) {
        // Configura o JFrame principal
        JFrame mainFrame = new JFrame("Janela Principal");
        mainFrame.setSize(1000, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Botão para abrir o novo frame lateral
        JButton showButton = new JButton("Abrir Frame Lateral");
        mainFrame.add(showButton, BorderLayout.CENTER);

        // Configura o novo frame lateral (inicialmente invisível)
        final JFrame lateralFrame = new JFrame("Frame Lateral");
        lateralFrame.setSize(300, 400);  // Largura menor para dar o efeito lateral
        lateralFrame.setUndecorated(true);  // Sem bordas para um efeito mais suave
        lateralFrame.setOpacity(0.9f);  // Tornar um pouco transparente para o efeito

        // Coloca o lateralFrame fora da tela à esquerda inicialmente
        lateralFrame.setLocation(-lateralFrame.getWidth(), mainFrame.getY()); //-lateralFrame.getWidth = 300, mainFrame.getY() = 500

        // Função de animação para mover o frame lateral
        Timer timer = new Timer(10, new ActionListener() {
            private int xPosition = -lateralFrame.getWidth();  // Posição inicial = -300
       
         
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xPosition <= mainFrame.getX()) {
                    System.out.println("FOI PARA O IF");
                     System.out.println(xPosition + " - " + mainFrame.getX());
                    xPosition += 10;  // Move o frame a cada 10 pixels
                    lateralFrame.setLocation(xPosition, mainFrame.getY());
                    
                } else if (xPosition == 0 ) {
                    xPosition = -lateralFrame.getWidth();  // Reinicia a posição
                    System.out.println("FOI PARA O IF 2");
                    lateralFrame.setLocation(xPosition, mainFrame.getY());
                } else {
                    System.out.println("Cancelado");
               
                    ((Timer) e.getSource()).stop();  // Para a animação quando o frame estiver na posição
                    
                    
                }
                
            }
        });

        // Ação ao clicar no botão
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lateralFrame.setVisible(true);
                timer.start();  // Inicia a animação do movimento lateral
            }
        });

        // Tornando a janela principal visível
        mainFrame.setVisible(true);
    }
}
