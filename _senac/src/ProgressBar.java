
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame{
    JProgressBar barra = new JProgressBar();
    
    public ProgressBar(){
        barra.setBounds(40, 40, 500, 80);
        barra.setStringPainted(true); //usada para exibir uma string, que normalmente representa a porcentagem de progresso, sobre a barra de progresso.
        barra.setValue(0);
        barra.setMaximum(100);
        barra.setForeground(Color.green);
        add(barra);
        Frame();
        new Tempo().start();
    }
    public void Frame() {
        setSize(600, 170); // Ajuste do tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); //assim consigo colocar a barra no meio com setBounds
        setVisible(true);
    }
    public class Tempo extends Thread{
        public void run(){
            while(barra.getValue()<100){
                try {
                    sleep(2000);
                    barra.setValue(barra.getValue() + 10);
                } catch (InterruptedException ex) {
                    
                }
            }
            JOptionPane.showMessageDialog(null,"Carregado");
            dispose();
        }
    }
    public static void main(String[] args){
        new ProgressBar();
    }
}
